package ast.expressions;

import ast.ConcreteASTNode;

public class UnaryMinus extends ConcreteASTNode implements Expression {

	public Expression expression;
	
	public UnaryMinus(int row, int column,Expression e) {
		super(row, column);
		expression = e;
	}

}
