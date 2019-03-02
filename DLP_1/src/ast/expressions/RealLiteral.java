package ast.expressions;

import ast.ConcreteASTNode;

public class RealLiteral extends ConcreteASTNode implements Expression {

	public long real;

	public RealLiteral(int row, int column, long l) {
		super(row, column);
		real = l;
	}

}
