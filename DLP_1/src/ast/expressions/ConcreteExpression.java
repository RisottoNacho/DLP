package ast.expressions;

import ast.ConcreteASTNode;
import ast.types.Type;
import visitor.Visitor;

import java.util.List;

public class ConcreteExpression extends ConcreteASTNode implements Expression{
    public ConcreteExpression(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean getLvalue() {
        return false;
    }

    @Override
    public void setLvalue(boolean value) {

    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type arithmetic(Type type) {
        return null;
    }

    @Override
    public Type arithmetic() {
        return null;
    }

    @Override
    public Type logical(Type type) {
        return null;
    }

    @Override
    public Type logical() {
        return null;
    }

    @Override
    public Type comparison(Type type) {
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return false;
    }

    @Override
    public Type cast(Type type) {
        return null;
    }

    @Override
    public Type dot(Type type) {
        return null;
    }

    @Override
    public Type squareBrackets(Type type) {
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        return null;
    }

    @Override
    public Type parenthesis(List<Type> typeList) {
        return null;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return null;
    }
}
