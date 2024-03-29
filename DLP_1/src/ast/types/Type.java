package ast.types;

import ast.ASTNode;
import ast.definitions.Field;
import ast.definitions.VariableDefinition;

import java.util.List;

public interface Type extends ASTNode {

    boolean isLogical();
    Type arithmetic(Type type);
    Type arithmetic();
    Type logical(Type type);
    Type logical();
    Type comparison(Type type);
    boolean isBuiltInType();
    Type cast(Type type);
    Type dot(String s);
    Type squareBrackets(Type type);
    Type promotesTo(Type type);
    Type parenthesis(List<Type> typeList);
    Type getReturnType();
    List<VariableDefinition> getParams();
    Field getField(String s);
    char subFix();
    int getSize();
}
