package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

import java.util.List;

public class ConcreteType extends ConcreteASTNode implements Type{

    public ConcreteType(int row, int column) {
        super(row, column);
    }

    @Override
    public int getSize(){
        return 0;
    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type arithmetic(Type type) {
        if(type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type arithmetic() {
        return null;
    }

    @Override
    public Type logical(Type type) {
        if(type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type logical() {
        return null;
    }

    @Override
    public Type comparison(Type type) {
        if(type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return false;
    }

    @Override
    public Type cast(Type type) {
        if(type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type dot(String s) {
        return null;
    }

    @Override
    public Type squareBrackets(Type type) {
        if(type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if(type instanceof ErrorType)
            return type;
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
