package ast.expressions;

import visitor.Visitor;

public class UnaryNot extends ConcreteExpression implements Expression {

    private boolean lValue;
    public Expression expression;

    public UnaryNot(int row, int column, Expression e) {
        super(row, column);
        expression = e;
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
