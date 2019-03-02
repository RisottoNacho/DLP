package ast.expressions;

import ast.ConcreteASTNode;

public class ArrayAccess extends ConcreteASTNode implements Expression {

	public Expression expArray;
	public Expression expAccess;
	
	public ArrayAccess(int row, int column,Expression a,Expression b) {
		super(row, column);
		expArray = a;
		expAccess = b;
	}

}
