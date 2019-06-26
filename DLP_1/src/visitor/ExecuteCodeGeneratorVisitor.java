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
        codeGenerator.debug("Global variables");
        for (Definition definition : program.getListDef()) {
            if (definition instanceof VariableDefinition) {
                codeGenerator.debug(definition.getType().toString() + " " + definition.getName() + " (offset " + definition.getOffSet() + ")");
            }
        }
        codeGenerator.ln();
        codeGenerator.comment("Invocation to the main function\n");
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
        codeGenerator.debug("Print");
        for (Expression ex : print.expressionList) {
            ex.accept(this.valueCodeGeneratorVisitor, params);
            codeGenerator.out(ex.getType());
        }
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        codeGenerator.debug("If");
        int label = codeGenerator.getLabels(2);
        codeGenerator.row(ifElse.getRow());
        ifElse.condition.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.jz("label" + label);
        codeGenerator.debug("If body");
        for (Statement est : ifElse.IfBody)
            est.accept(this, params);
        codeGenerator.jmp("label" + (label + 1));
        codeGenerator.labelFor("label" + label);
        codeGenerator.debug("else body");
        for (Statement est : ifElse.ElseBody)
            est.accept(this, params);
        codeGenerator.labelFor("label" + (label + 1));
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        codeGenerator.debug("While");
        codeGenerator.row(whileStatement.getRow());
        int label = codeGenerator.getLabels(2);
        codeGenerator.labelFor("label" + label);
        whileStatement.condition.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.jz("label" + (label + 1));
        codeGenerator.debug("While body");
        for (Statement est : whileStatement.body)
            est.accept(this, params);
        codeGenerator.jmp("label" + label);
        codeGenerator.labelFor("label" + (label + 1));
        return null;
    }

    @Override
    public Object visit(Input input, Object params) {
        codeGenerator.row(input.getRow());
        codeGenerator.debug("Input");
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
        codeGenerator.debug("Assignment");
        assignment.left.accept(this.adressCodeGeneratorVisitor, params);
        assignment.right.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.store(assignment.left.getType());
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        codeGenerator.row(functionDefinition.getRow());
        codeGenerator.labelFor(functionDefinition.getName());
        codeGenerator.debug("Parameters");
        for (VariableDefinition par : functionDefinition.type.getParams()) {
            codeGenerator.debug(par.type.toString() + " " + par.getName() + " (offset " + par.getOffSet() + ")");
        }
        codeGenerator.ln();
        codeGenerator.debug("Local variables");
        for (VariableDefinition var : functionDefinition.lsVariables) {
            codeGenerator.debug(var.type.toString() + " " + var.getName() + " (offset " + var.getOffSet() + ")");
        }
        codeGenerator.ln();
        codeGenerator.enter(functionDefinition.getLocalVarSize());
        functionDefinition.lsStatement.forEach(s -> s.accept(this, functionDefinition));
        if (functionDefinition.type.getReturnType() instanceof Void) {
            int tam = 0;
            for (VariableDefinition par : functionDefinition.type.getParams()) {
                tam += par.getType().getSize();
            }
            codeGenerator.ret(0, functionDefinition.getLocalVarSize(), tam);
        }
        return null;
    }

    @Override
    public Object visit(FunctionCall functionCall, Object params) {
        for (Expression param : functionCall.params)
            param.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.call(functionCall.name.value);
        if (!(functionCall.name.definition.getType().getReturnType() instanceof Void))
            codeGenerator.pop(functionCall.name.definition.getType().getReturnType());
        return null;
    }


    @Override
    public Object visit(Return returnStatement, Object params) {
        codeGenerator.row(returnStatement.getRow());
        codeGenerator.debug("Return");
        returnStatement.expression.accept(this.valueCodeGeneratorVisitor, params);
        FunctionDefinition functionDefinition = (FunctionDefinition) params;
        int tam = 0;
        for (VariableDefinition par : functionDefinition.type.getParams()) {
            tam += par.getType().getSize();
        }
        codeGenerator.ret(functionDefinition.type.getReturnType().getSize(), functionDefinition.getLocalVarSize(), tam);
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        //codeGenerator.row(variableDefinition.getRow());

        return null;
    }
}















