package ast.expressions;

public class Comparison extends BinaryExpression implements Expression {

	public Comparison(int row, int column, Expression iz, String op, Expression de) {
		super(row, column, iz, op, de);
	}

}
