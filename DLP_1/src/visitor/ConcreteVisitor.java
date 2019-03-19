package visitor;

import ast.Program;
import ast.definitions.Field;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.lang.Void;

public abstract class ConcreteVisitor implements Visitor{

    @Override
    public Object visit(Field field, Object params) {
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object params) {
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object params) {
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object params) {
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object params) {
        return null;
    }

    @Override
    public Object visit(Cast cast, Object params) {
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(Comparison comparison, Object params) {
        return null;
    }

    @Override
    public Object visit(FunctionProcedure functionProcedure, Object params) {
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(Logic logic, Object params) {
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object params) {
        return null;
    }

    @Override
    public Object visit(StructAccess structAccess, Object params) {
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object params) {
        return null;
    }

    @Override
    public Object visit(UnaryNot unaryNot, Object params) {
        return null;
    }

    @Override
    public Object visit(Variable variable, Object params) {
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object params) {
        return null;
    }

    @Override
    public Object visit(FunctionCall functionCall, Object params) {
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object params) {
        return null;
    }

    @Override
    public Object visit(Input input, Object params) {
        return null;
    }

    @Override
    public Object visit(Print print, Object params) {
        return null;
    }

    @Override
    public Object visit(Return returnStatement, Object params) {
        return null;
    }

    @Override
    public Object visit(While whileStatement, Object params) {
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
    public Object visit(Program program, Object params) {
        return null;
    }

    @Override
    public Object visit(ErrorType errorType, Object params){
        return null;
    }

}
