package ast.expressions;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Variable extends ConcreteASTNode implements Expression {

    private boolean lValue;
    public String value;

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
