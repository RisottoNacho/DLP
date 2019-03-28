package visitor;

import ast.expressions.*;

public class TypeCheckingVisitor extends ConcreteVisitor{


    @Override
    public Object visit(Variable variable, Object params) {
        if(variable.definition != null){
            variable.type = variable.definition.getType();
        }
        return null;
    }
}
