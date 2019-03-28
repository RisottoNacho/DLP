package visitor;

import ast.expressions.*;
import ast.statements.IfElse;
import ast.statements.Statement;
import ast.statements.While;
import ast.types.ErrorType;

public class TypeCheckingVisitor extends ConcreteVisitor{


    @Override
    public Object visit(Variable variable, Object params) {
        if(variable.definition != null){
            variable.type = variable.definition.getType();
        }
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        whileStatement.condition.accept(this,params);
        if(!whileStatement.condition.getType().isLogical())
            whileStatement.condition.setType(new ErrorType(whileStatement.condition.getRow(),whileStatement.condition.getColumn(),"La condición del bucle no es una expresión lógica"));
        whileStatement.body.forEach(s -> s.accept(this, params));
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        ifElse.condition.accept(this,params);
        if(!ifElse.condition.getType().isLogical())
            ifElse.condition.setType(new ErrorType(ifElse.condition.getRow(),ifElse.condition.getColumn(),"La condición del bucle no es una expresión lógica"));
        ifElse.IfBody.forEach(s -> s.accept(this, params));
        ifElse.ElseBody.forEach(s -> s.accept(this, params));
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        arithmetic.left.accept(this,params);
        arithmetic.right.accept(this,params);
        arithmetic.type= arithmetic.left.getType().arithmetic(arithmetic.right.getType());
    }
}
