package ast.types;

import ast.ErrorHandler;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends ConcreteType implements Type {

    private String message;

    public ErrorType(int row, int column, String message) {
        super(row, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message + "(línea: " + getRow() + ", columna: " + getColumn() + ")\n";
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type arithmetic(Type type) {
        return this;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type logical(Type type) {
        return this;
    }

    @Override
    public Type logical() {
        return this;
    }

    @Override
    public Type comparison(Type type) {
        return this;
    }

    @Override
    public boolean isBuiltInType() {
        return false;
    }

    @Override
    public Type cast(Type type) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type) {
        return this;
    }

    @Override
    public Type promotesTo(Type type) {
        return this;
    }

    @Override
    public Type parenthesis(List<Type> typeList) {
        return this;
    }
}
