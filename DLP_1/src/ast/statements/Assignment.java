package ast.statements;

import ast.ConcreteASTNode;
import ast.expressions.Expression;

public class Assignment extends ConcreteASTNode implements Statement{

	public Expression left;
	public Expression right;
	
	public Assignment(int row, int column,Expression iz, Expression de) {
		super(row, column);
		left = iz;
		right = de;
	}

}
