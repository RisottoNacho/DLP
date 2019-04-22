package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Expression;
import ast.statements.Assignment;
import ast.statements.Input;
import ast.statements.Print;
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
    }


    @Override
    public Object visit(Program program, Object params) {
        for (Definition definition : program.getListDef()) {
            if (definition instanceof VariableDefinition)
                definition.accept(this, params);
        }

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
        for (Expression ex : print.expressionList)
            ex.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.out(print.expressionList.get(0).getType());   //NEEDS TO BE CHECKED OUT
        return null;
    }
    @Override
    public Object visit(Input input, Object params) {
        codeGenerator.row(input.getRow());
        for (Expression ex : input.expressionList)
            ex.accept(this.valueCodeGeneratorVisitor, params);
        codeGenerator.in(input.expressionList.get(0).getType());   //NEEDS TO BE CHECKED OUT
        codeGenerator.store(input.expressionList.get(0).getType());
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
        codeGenerator.labelFor(functionDefinition.getName());
        int size=0;
        for(VariableDefinition v : functionDefinition.lsVariables)
            size+=v.getOffSet();
        codeGenerator.enter(size);
        functionDefinition.lsStatement.forEach(s -> s.accept(this, params));
        if(functionDefinition.type instanceof Void)

        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        codeGenerator.row(variableDefinition.getRow());

        return null;
    }
}














