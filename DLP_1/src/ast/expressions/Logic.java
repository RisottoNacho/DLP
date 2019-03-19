package ast.expressions;

import visitor.Visitor;

public class Logic extends BinaryExpression implements Expression {

	private boolean lValue;

	public Logic(int row, int column, Expression iz, String op, Expression de) {
		super(row, column, iz, op, de);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}

	@Override
	public boolean getLvalue() {
		return false;
	}

	@Override
	public void setLvalue(boolean value) {

	}
}
