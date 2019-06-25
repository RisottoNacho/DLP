package ast.types;

import ast.ASTNode;
import ast.definitions.Field;

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
    Field getField(String s);
    char subFix();
    Type getTypeArray();
    int getSize();
}
