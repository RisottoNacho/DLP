package ast.expressions;

import java.util.List;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class FunctionProcedure extends ConcreteASTNode implements Expression {

    public List<Expression> params;
    public String name;
    private boolean lValue;

    public FunctionProcedure(int row, int column, String name, List<Expression> ls) {
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
