package ast.expressions;

public class Arithmetic extends BinaryExpression implements Expression {

	public Arithmetic(int row, int column, Expression iz, String op, Expression de) {
		super(row, column, iz, op, de);
	}

}
