package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Expression;
import ast.statements.*;
import ast.types.Function;
import ast.types.Void;

public class ExecuteCodeGeneratorVisitor extends AbstractCGVisitor {

    private ValueCodeGeneratorVisitor valueCodeGeneratorVisitor;
    private AdressCodeGeneratorVisitor adressCodeGeneratorVisitor;
    private CodeGenerator codeGenerator;

    public ExecuteCodeGeneratorVisitor(CodeGenerator codeGenerator) {
        valueCodeGeneratorVisitor = new ValueCodeGeneratorVisitor(codeGenerator);
        adressCodeGeneratorVisitor = new AdressCodeGeneratorVisitor(codeGenerator);
        this.codeGenerator = codeGenerator;
        valueCodeGeneratorVisitor.setAdressCodeGeneratorVisitor(adressCodeGeneratorVisitor);
        adressCodeGeneratorVisitor.setValueCodeGenerator(valueCodeGeneratorVisitor);
    }


    @Override
    public Object visit(Program program, Object params) {

        //VISIT VARIABLEDEFINITION NEEDS TO BE CHECKED

        /*
        for (Definition definition : program.getListDef()) {
            if (definition instanceof VariableDefinition)
                definition.accept(this, params);
        }
*/
        codeGenerator.source((String) params);
        codeGenerator.mainInvocation();
        codeGenerator.halt();

        for (Definition definition : program.getListDef()) {
            if (definition instanceof FunctionDefinition)
                definition.accept(this, params);
        }
        return null;
    }

    @Override
    public Object visit(Print print, Object params) {
        codeGenerator.row(print.getRow());
        for (Expression ex : print.expressionList) {
            ex.accept(this.valueCodeGeneratorVisitor, params);
            codeGenerator.out(ex.getType());
        }
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        int label = codeGenerator.getLabels(2);
        codeGenerator.row(ifElse.getRow());
        ifElse.condition.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.jz("label" + label);
        for (Statement est : ifElse.IfBody)
            est.accept(this, params);
        codeGenerator.jmp("label" + (label + 1));
        codeGenerator.labelFor("label" + label);
        for (Statement est : ifElse.ElseBody)
            est.accept(this, params);
        codeGenerator.labelFor("label" + (label + 1));
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        codeGenerator.row(whileStatement.getRow());
        int label = codeGenerator.getLabels(2);
        codeGenerator.labelFor("label" + label);
        whileStatement.condition.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.jz("label" + (label + 1));
        for (Statement est : whileStatement.body)
            est.accept(this, params);
        codeGenerator.jmp("label" + label);
        codeGenerator.labelFor("label" + (label + 1));
        return null;
    }

    @Override
    public Object visit(Input input, Object params) {
        codeGenerator.row(input.getRow());
        for (Expression ex : input.expressionList) {
            ex.accept(this.adressCodeGeneratorVisitor, params);
            codeGenerator.in(ex.getType());
            codeGenerator.store(ex.getType());
        }
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object params) {
        codeGenerator.row(assignment.getRow());
        assignment.left.accept(this.adressCodeGeneratorVisitor, params);
        assignment.right.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.store(assignment.left.getType());
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        codeGenerator.row(functionDefinition.getRow());
        codeGenerator.labelFor(functionDefinition.getName());
        int size = 0;
        for (VariableDefinition v : functionDefinition.lsVariables)
            size += v.getType().getSize();
        codeGenerator.enter(size);
        functionDefinition.lsStatement.forEach(s -> s.accept(this, params));
        if (functionDefinition.type instanceof Void)
            codeGenerator.ret(0, size, functionDefinition.type.getSize());
        else
            functionDefinition.type.accept(this, size);
        return null;
    }

    @Override
    public Object visit(Function functionType, Object params) {
        int tam = 0;
        for (VariableDefinition par : functionType.lsParams) {
            tam += par.getType().getSize();
        }
        codeGenerator.ret(functionType.returnType.getSize(), (int) params, tam);
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        //codeGenerator.row(variableDefinition.getRow());

        return null;
    }
}















