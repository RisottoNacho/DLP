package visitor;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.Variable;
import ast.statements.Statement;

public class IdentificationVisitor extends ConcreteVisitor {

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        for (Statement s : functionDefinition.lsStatement) {
            s.accept(this, params);
        }
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        return null;
    }
}
