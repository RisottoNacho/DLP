package ast.definitions;

import java.util.List;

import ast.statements.Statement;
import ast.types.Function;
import visitor.Visitor;

public class FunctionDefinition extends ConcreteDefinition implements Definition {

    public List<VariableDefinition> lsVariables;
    public List<Statement> lsStatement;

    public FunctionDefinition(int row, int column, String name,
                              List<VariableDefinition> lsVariables, List<Statement> lsStatement, Function t) {
        super(row, column, name);
        this.lsVariables = lsVariables;
        this.lsStatement = lsStatement;
        type = t;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getLocalVarSize() {
        int size = 0;
        for (VariableDefinition v : lsVariables)
            size += v.getType().getSize();
        return size;
    }
}
