package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Expression;
import ast.statements.Input;

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
    public Object visit(Input input, Object params) {
        for (Expression ex : input.expressionList)
            ex.accept(this, params);
        return null;
    }
}





















