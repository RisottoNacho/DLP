package ast.expressions;

import ast.ConcreteASTNode;

public class AbstractExpression extends ConcreteASTNode implements Expression {

	public AbstractExpression(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getLvalue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLvalue(boolean value) {
		// TODO Auto-generated method stub

	}

}
