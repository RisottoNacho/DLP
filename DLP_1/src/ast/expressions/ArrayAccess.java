package ast.expressions;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class ArrayAccess extends ConcreteASTNode implements Expression {

    public Expression expArray;
    public Expression expAccess;
    private boolean lValue;

    public ArrayAccess(int row, int column, Expression a, Expression b) {
        super(row, column);
        expArray = a;
        expAccess = b;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return null;
    }

    @Override
    public boolean getLvalue() {
        return lValue;
    }

    @Override
    public void setLvalue(boolean value) {
        this.lValue = value;
    }
}
