package ast.statements;


import ast.ConcreteASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Return extends ConcreteASTNode implements Statement {

	public Expression expression;

	public Return(int row, int column, Expression expr) {
		super(row, column);
		expression = expr;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
