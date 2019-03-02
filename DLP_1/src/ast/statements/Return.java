package ast.statements;


import ast.ConcreteASTNode;
import ast.expressions.Expression;

public class Return extends ConcreteASTNode implements Statement {

	public Expression expression;

	public Return(int row, int column, Expression expr) {
		super(row, column);
		expression = expr;
	}
}
