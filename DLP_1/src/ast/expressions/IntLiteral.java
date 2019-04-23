package ast.expressions;

import visitor.Visitor;

public class IntLiteral extends ConcreteExpression implements Expression {

    public int value;
    private boolean lValue;

    public IntLiteral(int row, int column, int v) {
        super(row, column);
        value = v;
        lValue = false;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public Object getValue(){
        return value;
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
