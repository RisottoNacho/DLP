package ast.expressions;

import ast.ConcreteASTNode;
import ast.types.Type;
import visitor.Visitor;

public class Cast extends ConcreteExpression implements Expression {

    public Expression expression;
    private boolean lValue;

    public Cast(int row, int column, Expression e, Type t) {
        super(row, column);
        expression = e;
        type = t;
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
