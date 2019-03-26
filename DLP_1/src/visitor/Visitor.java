package visitor;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import java.lang.Void;

public interface Visitor {

	Object visit(Field field, Object params);
	Object visit(FunctionDefinition functionDefinition, Object params);
	Object visit(VariableDefinition variableDefinition, Object params);
	Object visit(Arithmetic arithmetic, Object params);
	Object visit(ArrayAccess arrayAccess, Object params);
	Object visit(Cast cast, Object params);
	Object visit(CharLiteral charLiteral, Object params);
	Object visit(Comparison comparison, Object params);
	Object visit(FunctionProcedure functionProcedure, Object params);
	Object visit(IntLiteral intLiteral, Object params);
	Object visit(Logic logic, Object params);
	Object visit(RealLiteral realLiteral, Object params);
	Object visit(StructAccess structAccess, Object params);
	Object visit(UnaryMinus unaryMinus, Object params);
	Object visit(UnaryNot unaryNot, Object params);
	Object visit(Variable variable, Object params);
	Object visit(Assignment assignment, Object params);
	Object visit(FunctionCall functionCall, Object params);
	Object visit(IfElse ifElse, Object params);
	Object visit(Input input, Object params);
	Object visit(Print print, Object params);
	Object visit(Return returnStatement, Object params);
	Object visit(While whileStatement, Object params);
	Object visit(Array array, Object params);
	Object visit(Char aChar, Object params);
	Object visit(Function functionType, Object params);
	Object visit(Int anInt, Object params);
	Object visit(Struct struct, Object params);
	Object visit(Void aVoid, Object params);
	Object visit(ErrorType errorType, Object params);

	Object visit(Real real, Object params);

	Object visit(ast.types.Void aVoid, Object params);

	Object visit(Program program, Object params);
}
