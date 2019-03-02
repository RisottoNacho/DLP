package ast.expressions;

import ast.ConcreteASTNode;

public class UnaryNot extends ConcreteASTNode implements Expression{

	public Expression expression;
	
	public UnaryNot(int row, int column,Expression e) {
		super(row, column);
		expression = e;
	}

}
