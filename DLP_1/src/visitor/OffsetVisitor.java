package visitor;

import ast.definitions.Field;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Statement;
import ast.types.Function;
import ast.types.Struct;

public class OffsetVisitor extends ConcreteVisitor {

    private int currentGlobalSize = 0;
    private int currentLocalSize;

    @SuppressWarnings("all")
    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        functionDefinition.type.accept(this, params);
        currentLocalSize = 0;
        functionDefinition.lsVariables.forEach(v -> v.accept(this, params));
        functionDefinition.lsStatement.forEach(s -> s.accept(this, params));
        return null;
    }

    @Override
    public Object visit(Struct struct, Object params) {
        int size = 0;
        for (Field f : struct.lsFields) {
            f.setOffSet(size);
            size += f.type.getSize();
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
        } else if (variableDefinition.getScope() == 1) {
            currentLocalSize += variableDefinition.getType().getSize();
            variableDefinition.setOffSet(currentLocalSize);
        }
        return null;
    }
}
