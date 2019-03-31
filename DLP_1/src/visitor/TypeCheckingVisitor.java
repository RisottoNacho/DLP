package visitor;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.FunctionCall;
import ast.statements.IfElse;
import ast.statements.Statement;
import ast.statements.While;
import ast.types.ErrorType;
import ast.types.Function;
import ast.types.Type;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Object visit(Cast cast, Object params) {
        cast.expression.accept(this, params);
        String tipoOld = cast.type.toString();
        cast.type = cast.expression.getType().promotesTo(cast.type);
        if (cast.type == null)
            cast.type = new ErrorType(cast.getRow(), cast.getColumn(), "No se puede hacer cast de " + cast.expression.getType().toString() + "a " + tipoOld);
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        structAccess.left.accept(this, params);
        structAccess.type = structAccess.left.getType().dot(structAccess.right);
        if (structAccess.type == null)
            structAccess.type = new ErrorType(structAccess.getRow(), structAccess.getColumn(), "Acceso a struct incorrecto");
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        arrayAccess.expAccess.accept(this, params);
        arrayAccess.expArray.accept(this, params);
        arrayAccess.type = arrayAccess.expArray.getType().squareBrackets(arrayAccess.expAccess.getType());
        if (arrayAccess.type == null)
            arrayAccess.type = new ErrorType(arrayAccess.getRow(), arrayAccess.getColumn(), "Acceso a array incorrecto");
        return null;
    }

    @Override
    public Object visit(Function functionType, Object params) {
        List<Type> ls = new ArrayList<>();
        for (VariableDefinition def : functionType.lsParams) {
            def.accept(this, params);
            if (!def.type.isBuiltInType())
                def.type = new ErrorType(def.getRow(), def.getColumn(), "Las funciones sólo pueden recibir parámetros de tipos simples");
            ls.add(def.type);
        }
        if (functionType.parenthesis(ls) == null)
            new ErrorType(functionType.getRow(), functionType.getColumn(), "Los parámetros no coinciden con los esperados para la fución");
        return null;
    }

    @SuppressWarnings("all")
    @Override
    public Object visit(FunctionCall functionCall, Object params) {
        List<Type> ls = new ArrayList<>();
        for (Expression param : functionCall.params) {
            param.accept(this, params);
            if (!param.getType().isBuiltInType())
                param.setType(new ErrorType(param.getRow(), param.getColumn(), "Las funciones sólo pueden recibir parámetros de tipos simples"));
            ls.add(param.getType());
        }
        functionCall.name.definition.getType().parenthesis(ls);
        return null;
    }


    @SuppressWarnings("all")
    @Override
    public Object visit(FunctionProcedure functionProcedure, Object params) {
        List<Type> ls = new ArrayList<>();
        for (Expression param : functionProcedure.params) {
            param.accept(this, params);
            if (!param.getType().isBuiltInType())
                param.setType(new ErrorType(param.getRow(), param.getColumn(), "Las funciones sólo pueden recibir parámetros de tipos simples"));
            ls.add(param.getType());
        }
        functionProcedure.name.definition.getType().parenthesis(ls);
        return null;
    }

}


















