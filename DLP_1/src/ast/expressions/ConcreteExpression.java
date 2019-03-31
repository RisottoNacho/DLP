package ast.expressions;

import ast.ConcreteASTNode;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;

public class ConcreteExpression extends ConcreteASTNode implements Expression{
    public Type type;

    public ConcreteExpression(int row, int column) {
        super(row, column);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean getLvalue() {
        return false;
    }

    @Override
    public void setLvalue(boolean value) {

    }

    @Override
    public Object accept(Visitor V, Object params) {
        return null;
    }
}
