package ast.expressions;

public class Logic extends BinaryExpression implements Expression {

	public Logic(int row, int column, Expression iz, String op, Expression de) {
		super(row, column, iz, op, de);
	}

}
