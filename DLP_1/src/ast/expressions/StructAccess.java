package ast.expressions;

import ast.ConcreteASTNode;

public class StructAccess extends ConcreteASTNode implements Expression {

	public Expression left;
	public Expression right;
	
	public StructAccess(int row, int column,Expression iz, Expression de) {
		super(row, column);
		right = de;
		left = iz;
	}

}
