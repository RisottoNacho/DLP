package ast.types;

import visitor.Visitor;

public class Int extends ConcreteType implements Type {


    public Int(int row, int column) {
        super(row, column);
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public boolean isLogical() {
        return true;
    }

    @Override
    public Type arithmetic(Type type) {
        if (type instanceof Int || type instanceof Real)
            return this;
        return null;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type logical(Type type) {
        if (type instanceof Int)
            return this;
        return null;
    }

    @Override
    public Type logical() {
        return this;
    }

    @Override
    public Type comparison(Type type) {
        if (type instanceof Int)
            return this;
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public Type cast(Type type) {
        if (type.isBuiltInType())
            return type;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if (type instanceof Int)
            return this;
        return null;
    }

    @Override
    public String toString() {
        return "Int";
    }
}

