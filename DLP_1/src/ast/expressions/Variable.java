package ast.expressions;

import ast.ConcreteASTNode;

public class Variable extends ConcreteASTNode implements Expression {

	public String value;
	
	public Variable(int row, int column,String value) {
		super(row, column);
		this.value = value;
	}

}
