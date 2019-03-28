package ast.definitions;


import ast.types.Type;
import visitor.Visitor;

public class Field extends ConcreteDefinition {

    public Type type;

    public Field(int row, int column, String name) {
        super(row, column, name);
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object f) {
        if (this.getName().compareTo(((Field) f).getName()) == 0)
            return true;
        return false;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }
}
