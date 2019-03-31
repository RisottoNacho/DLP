package ast.types;

import java.util.List;

import ast.definitions.VariableDefinition;
import visitor.Visitor;

public class Function extends ConcreteType implements Type {

    public Type returnType;
    public List<VariableDefinition> lsParams;

    public Function(int row, int column, List<VariableDefinition> params, Type t) {
        super(row, column);
        if (t == null)
            returnType = new Void(row, column);
        else
            this.returnType = t;
        lsParams = params;
    }

    @Override
    public Object accept(Visitor V, Object params) {
        return V.visit(this, params);
    }

    @Override
    public Type parenthesis(List<Type> ls) {
        if (ls.size() != lsParams.size())
            return null;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).promotesTo(lsParams.get(i).type) == null)
                return null;
        }
        return this;
    }

    @Override
    public String toString() {
        return "Función";
    }


}
