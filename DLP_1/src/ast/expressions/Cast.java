package ast.expressions;

import ast.ConcreteASTNode;
import ast.types.Type;

public class Cast extends ConcreteASTNode implements Expression {

	public Expression expression;
	public Type type;
	
	public Cast(int row, int column,Expression e,Type t) {
		super(row, column);
		expression = e;
		type = t;
	}

}
