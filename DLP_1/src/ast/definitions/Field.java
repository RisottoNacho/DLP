package ast.definitions;


import visitor.Visitor;

public class Field extends ConcreteDefinition {

    private int offSet;

    public Field(int row, int column, String name) {
        super(row, column, name);
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

    @Override
    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }
}
