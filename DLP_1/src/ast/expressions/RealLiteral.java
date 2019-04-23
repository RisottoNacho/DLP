package ast.expressions;

import visitor.Visitor;

public class RealLiteral extends ConcreteExpression implements Expression {

    private boolean lValue;
    public double real;

    public RealLiteral(int row, int column, double l) {
        super(row, column);
        real = l;
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
    public Object getValue(){
        return real;
    }

    @Override
    public void setLvalue(boolean value) {
        lValue = value;
    }
}
