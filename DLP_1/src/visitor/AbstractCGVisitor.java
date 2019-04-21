package visitor;

import ast.Program;
import ast.definitions.Field;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.lang.Void;

public abstract class AbstractCGVisitor implements Visitor {
    @Override
    public Object visit(Field field, Object params) {
        throw new IllegalStateException("Code generation template \"" + field.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        throw new IllegalStateException("Code generation template \"" + functionDefinition.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        throw new IllegalStateException("Code generation template \"" + variableDefinition.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        throw new IllegalStateException("Code generation template \"" + arithmetic.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        throw new IllegalStateException("Code generation template \"" + arrayAccess.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Cast cast, Object params) {
        throw new IllegalStateException("Code generation template \"" + cast.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object params) {
        throw new IllegalStateException("Code generation template \"" + charLiteral.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Comparison comparison, Object params) {
        throw new IllegalStateException("Code generation template \"" + comparison.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctionProcedure functionProcedure, Object params) {
        throw new IllegalStateException("Code generation template \"" + functionProcedure.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        throw new IllegalStateException("Code generation template \"" + intLiteral.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Logic logic, Object params) {
        throw new IllegalStateException("Code generation template \"" + logic.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object params) {
        throw new IllegalStateException("Code generation template \"" + realLiteral.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        throw new IllegalStateException("Code generation template \"" + structAccess.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object params) {
        throw new IllegalStateException("Code generation template \"" + unaryMinus.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        throw new IllegalStateException("Code generation template \"" + unaryNot.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Variable variable, Object params) {
        throw new IllegalStateException("Code generation template \"" + variable.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Assignment assignment, Object params) {
        throw new IllegalStateException("Code generation template \"" + assignment.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctionCall functionCall, Object params) {
        throw new IllegalStateException("Code generation template \"" + functionCall.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        throw new IllegalStateException("Code generation template \"" + ifElse.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Input input, Object params) {
        throw new IllegalStateException("Code generation template \"" + input.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Print print, Object params) {
        throw new IllegalStateException("Code generation template \"" + print.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Return returnStatement, Object params) {
        throw new IllegalStateException("Code generation template \"" + returnStatement.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(While whileStatement, Object params) {
        throw new IllegalStateException("Code generation template \"" + whileStatement.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Array array, Object params) {
        throw new IllegalStateException("Code generation template \"" + array.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Char aChar, Object params) {
        throw new IllegalStateException("Code generation template \"" + aChar.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Function functionType, Object params) {
        throw new IllegalStateException("Code generation template \"" + functionType.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Int anInt, Object params) {
        throw new IllegalStateException("Code generation template \"" + anInt.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Struct struct, Object params) {
        throw new IllegalStateException("Code generation template \"" + struct.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Void aVoid, Object params) {
        throw new IllegalStateException("Code generation template \"" + aVoid.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ErrorType errorType, Object params) {
        throw new IllegalStateException("Code generation template \"" + errorType.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Real real, Object params) {
        throw new IllegalStateException("Code generation template \"" + real.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ast.types.Void aVoid, Object params) {
        throw new IllegalStateException("Code generation template \"" + aVoid.toString() + "\" not defined for " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Program program, Object params) {
        throw new IllegalStateException("Code generation template \"" + program.toString() + "\" not defined for " +
                this.getClass().getName());
    }
}
