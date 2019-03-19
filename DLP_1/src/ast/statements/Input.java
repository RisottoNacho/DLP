package ast.statements;

import java.util.List;

import ast.ConcreteASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class Input extends ConcreteASTNode implements Statement {

	public List<Expression> expressionList;

	public Input(int row, int column, List<Expression> expr) {
		super(row, column);
		expressionList = expr;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
