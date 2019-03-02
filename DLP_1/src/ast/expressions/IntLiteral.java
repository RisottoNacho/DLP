package ast.expressions;

import ast.ConcreteASTNode;

public class IntLiteral extends ConcreteASTNode implements Expression {

	public int value;

	public IntLiteral(int row, int column, int v) {
		super(row, column);
		value = v;
	}

}
