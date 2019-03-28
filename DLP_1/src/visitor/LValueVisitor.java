package visitor;

import ast.expressions.*;
import ast.statements.Assignment;
import ast.types.ErrorType;

public class LValueVisitor extends ConcreteVisitor{


    @Override
    public Object visit(Cast cast, Object params) {
        cast.setLvalue(false);
        cast.expression.accept(this, params);
        return null;
    }
    @Override
    public Object visit(Variable variable, Object params) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object params) {
        assignment.left.accept(this, params);
        assignment.right.accept(this, params);
        if(!assignment.left.getLvalue())
            assignment.left.setType(new ErrorType(assignment.getRow(),assignment.getColumn(),"El elemento de la izquierda no es asignable "));
        return null;
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        unaryNot.setLvalue(false);
        unaryNot.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object params) {
        unaryMinus.setLvalue(false);
        unaryMinus.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        structAccess.setLvalue(true);
        structAccess.left.accept(this, params);
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object params) {
        realLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        intLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object params) {
        charLiteral.setLvalue(false);
        return null;
    }
}
