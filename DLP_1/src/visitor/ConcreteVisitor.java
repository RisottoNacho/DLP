package visitor;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.lang.Void;

public abstract class ConcreteVisitor implements Visitor {

    @Override
    public Object visit(Program program, Object params) {
        for (Definition definition : program.getListDef()) {
            definition.accept(this, params);
        }
        return null;
    }

    @Override
    public Object visit(Field field, Object params) {
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        for (Statement s : functionDefinition.lsStatement) {
            s.accept(this, params);
        }
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        arithmetic.setLvalue(false);
        arithmetic.left.accept(this, params);
        arithmetic.right.accept(this, params);
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        arrayAccess.setLvalue(true);
        arrayAccess.expAccess.accept(this, params);
        arrayAccess.expArray.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Cast cast, Object params) {
        cast.setLvalue(false);
        cast.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(Comparison comparison, Object params) {
        comparison.setLvalue(false);
        comparison.left.accept(this, params);
        comparison.right.accept(this, params);
        return null;
    }

    @Override
    public Object visit(FunctionProcedure functionProcedure, Object params) {
        functionProcedure.setLvalue(false);
        for (Expression param : functionProcedure.params)
            param.accept(this, params);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(Logic logic, Object params) {
        logic.setLvalue(false);
        logic.left.accept(this, null);
        logic.right.accept(this, null);
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        structAccess.left.accept(this, params);
        structAccess.right.accept(this, params);
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object params) {
        unaryMinus.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        unaryNot.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object params) {
        assignment.left.accept(this, params);
        assignment.right.accept(this, params);
        return null;
    }

    @Override
    public Object visit(FunctionCall functionCall, Object params) {
        for (Expression param : functionCall.params)
            param.accept(this, params);
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        ifElse.condition.accept(this, params);
        for (Statement est : ifElse.IfBody)
            est.accept(this, params);
        for (Statement est : ifElse.ElseBody)
            est.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Input input, Object params) {
        for (Expression ex : input.expressionList)
            ex.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Print print, Object params) {
        for (Expression ex : print.expressionList)
            ex.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Return returnStatement, Object params) {
        returnStatement.expression.accept(this, params);
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        whileStatement.condition.accept(this, params);
        for (Statement est : whileStatement.body)
            est.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Array array, Object params) {
        return null;
    }

    @Override
    public Object visit(Char aChar, Object params) {
        return null;
    }

    @Override
    public Object visit(Function functionType, Object params) {
        for (VariableDefinition def : functionType.lsParams)
            def.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Int anInt, Object params) {
        return null;
    }

    @Override
    public Object visit(StringType stringType, Object params) {
        return null;
    }

    @Override
    public Object visit(Struct struct, Object params) {
        for (Field f : struct.lsFields)
            f.accept(this, params);
        return null;
    }

    @Override
    public Object visit(Void aVoid, Object params) {
        return null;
    }

    @Override
    public Object visit(Real real, Object params) {
        return null;
    }

    @Override
    public Object visit(ast.types.Void aVoid, Object params) {
        return null;
    }


    @Override
    public Object visit(ErrorType errorType, Object params) {
        return null;
    }

}
