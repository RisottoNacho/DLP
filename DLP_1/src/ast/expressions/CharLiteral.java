package ast.expressions;

import ast.ConcreteASTNode;

public class CharLiteral extends ConcreteASTNode implements Expression {

	public char value;

	public CharLiteral(int row, int column, char v) {
		super(row, column);
		value = v;
	}

}
