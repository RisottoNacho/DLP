package ast.expressions;

import ast.ConcreteASTNode;

public class RealLiteral extends ConcreteASTNode implements Expression {

	public double real;

	public RealLiteral(int row, int column, double l) {
		super(row, column);
		real = l;
	}

}
