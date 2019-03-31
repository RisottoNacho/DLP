package ast.expressions;

import java.util.List;

import visitor.Visitor;

public class FunctionProcedure extends ConcreteExpression implements Expression {

    public List<Expression> params;
    public Variable name;
    private boolean lValue;

    public FunctionProcedure(int row, int column, Variable name, List<Expression> ls) {
        super(row, column);
        this.name = name;
        params = ls;
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
