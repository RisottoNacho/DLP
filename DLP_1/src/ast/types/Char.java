package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Char extends ConcreteType implements Type {

    public Char(int row, int column) {
        super(row, column);
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
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
        if (type instanceof Char)
            return this;
        return null;
    }

    @Override
    public String toString() {
        return "Char";
    }
}
