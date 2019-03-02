package ast.statements;

import java.util.List;

import ast.ConcreteASTNode;
import ast.expressions.Expression;

public class While extends ConcreteASTNode implements Statement{

	public Expression condition;
	public List<Statement> body;
	
	public While(int row, int column,Expression condition,List<Statement> body) {
		super(row, column);
		this.body = body;
		this.condition = condition;
	}

}
