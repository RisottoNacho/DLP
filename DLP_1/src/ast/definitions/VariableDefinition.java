package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

public class VariableDefinition extends ConcreteDefinition implements Definition, Statement {

    public Type type;

    public VariableDefinition(int row, int column, String name) {
        super(row, column, name);
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }
}
