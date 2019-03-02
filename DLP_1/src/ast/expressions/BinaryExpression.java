package ast.expressions;

import ast.ConcreteASTNode;

public abstract class BinaryExpression extends ConcreteASTNode implements Expression {

	public Expression left;
	public Expression right;
	public String operator;

	public BinaryExpression(int row, int column, Expression iz, String op, Expression de) {
		super(row, column);
		right = de;
		left = iz;
		operator = op;
	}

}
