package ast.expressions;

import visitor.Visitor;

public class Arithmetic extends BinaryExpression implements Expression {

    private boolean lValue;

    public Arithmetic(int row, int column, Expression iz, String op, Expression de) {
        super(row, column, iz, op, de);
        lValue = false;
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
