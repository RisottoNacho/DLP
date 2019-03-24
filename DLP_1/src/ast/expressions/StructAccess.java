package ast.expressions;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class StructAccess extends ConcreteASTNode implements Expression {

    private boolean lValue;
    public Expression left;
    public String right;

    public StructAccess(int row, int column, Expression iz, String de) {
        super(row, column);
        right = de;
        left = iz;
        lValue = true;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);    }

    @Override
    public boolean getLvalue() {
        return lValue;
    }

    @Override
    public void setLvalue(boolean value) {
        lValue = value;
    }
}
