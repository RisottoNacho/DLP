package ast.expressions;

import ast.definitions.Definition;
import ast.types.Type;
import visitor.Visitor;

public class Variable extends ConcreteExpression implements Expression {

    private boolean lValue;
    public String value;
    public Definition definition;

    public Variable(int row, int column, String value) {
        super(row, column);
        this.value = value;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public boolean getLvalue() {
        return lValue;
    }

    @Override
    public void setLvalue(boolean value) {
        lValue = value;
    }
}
