package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.ConcreteASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class IfElse extends ConcreteASTNode implements Statement {

	public Expression condition;
	public List<Statement> IfBody;
	public List<Statement> ElseBody;

	public IfElse(int row, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
		super(row, column);
		this.condition = condition;
		if (elseBody == null)
			this.ElseBody = new ArrayList<Statement>();
		else
			this.ElseBody = elseBody;
		this.IfBody = ifBody;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
