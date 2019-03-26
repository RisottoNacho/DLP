package ast.expressions;

import visitor.Visitor;

public class CharLiteral extends ConcreteExpression implements Expression {

    public char value;
    private boolean lValue;

    public CharLiteral(int row, int column, char v) {
        super(row, column);
        value = v;
        lValue = true;
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
