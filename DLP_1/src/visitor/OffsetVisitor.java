package visitor;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Statement;
import ast.types.Function;

public class OffsetVisitor extends ConcreteVisitor {

    private int currentGlobalSize = 0;

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        for (Statement s : functionDefinition.lsStatement) {
            s.accept(this, params);
        }
        functionDefinition.type.accept(this, params);
        for (VariableDefinition v : functionDefinition.lsVariables) {
            v.accept(this, params);
        }
        return null;
    }

    @Override
    public Object visit(Function functionType, Object params) {
        int size = 4;
        for (int i = functionType.lsParams.size() - 1; i > -1; i--) {
            functionType.lsParams.get(i).setOffSet(size);
            size += functionType.lsParams.get(i).getOffSet();
        }
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        if (variableDefinition.getScope() == 0) {
            variableDefinition.setOffSet(currentGlobalSize);
            currentGlobalSize += variableDefinition.getType().getSize();
        } else if (variableDefinition.getScope() == 1)){

        }
        return null;
    }
}
