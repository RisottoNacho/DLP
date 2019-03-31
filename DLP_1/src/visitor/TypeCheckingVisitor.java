package visitor;

import ast.expressions.*;
import ast.statements.IfElse;
import ast.statements.While;
import ast.types.ErrorType;

public class TypeCheckingVisitor extends ConcreteVisitor {


    @Override
    public Object visit(Variable variable, Object params) {
        if (variable.definition != null) {
            variable.type = variable.definition.getType();
        }
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        whileStatement.condition.accept(this, params);
        if (!whileStatement.condition.getType().isLogical())
            whileStatement.condition.setType(new ErrorType(whileStatement.condition.getRow(), whileStatement.condition.getColumn(), "La condición del bucle no es una expresión lógica"));
        whileStatement.body.forEach(s -> s.accept(this, params));
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        ifElse.condition.accept(this, params);
        if (!ifElse.condition.getType().isLogical())
            ifElse.condition.setType(new ErrorType(ifElse.condition.getRow(), ifElse.condition.getColumn(), "La condición del bucle no es una expresión lógica"));
        ifElse.IfBody.forEach(s -> s.accept(this, params));
        ifElse.ElseBody.forEach(s -> s.accept(this, params));
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        arithmetic.left.accept(this, params);
        arithmetic.right.accept(this, params);
        arithmetic.type = arithmetic.left.getType().arithmetic(arithmetic.right.getType());
        if (arithmetic.type == null)
            arithmetic.type = new ErrorType(arithmetic.getRow(), arithmetic.getColumn(), "Operación aritmética con tipos inválidos");
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object params) {
        unaryMinus.expression.accept(this, params);
        unaryMinus.expression.getType().arithmetic();
        if (unaryMinus.type == null)
            unaryMinus.type = new ErrorType(unaryMinus.getRow(), unaryMinus.getColumn(), "Menos unario con tipo inválido");
        return null;
    }

    @Override
    public Object visit(Logic logic, Object params) {
        logic.left.accept(this, null);
        logic.right.accept(this, null);
        logic.type = logic.left.getType().logical(logic.right.getType());
        if (logic.getType() == null)
            logic.type = new ErrorType(logic.getRow(), logic.getColumn(), "Operacion lógica con tipos inválidos");
        return null;
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        unaryNot.expression.accept(this, params);
        unaryNot.type = unaryNot.expression.getType().logical();
        if (unaryNot.getType() == null)
            unaryNot.type = new ErrorType(unaryNot.getRow(), unaryNot.getColumn(), "Operacion lógica con tipos inválidos");
        return null;
    }

    @Override
    public Object visit(Comparison comparison, Object params) {
        comparison.left.accept(this, params);
        comparison.right.accept(this, params);
        comparison.type = comparison.left.getType().comparison(comparison.right.getType());
        if (comparison.type == null)
            comparison.type = new ErrorType(comparison.getRow(), comparison.getColumn(), "Comparacion de tipos inválidos");
        return null;
    }
}
