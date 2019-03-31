package ast.statements;

import java.util.List;

import ast.ConcreteASTNode;
import ast.expressions.Expression;
import ast.expressions.Variable;
import visitor.Visitor;

public class FunctionCall extends ConcreteASTNode implements Statement{
	
	public Variable name;
	public List<Expression> params;

	public FunctionCall(int row, int column, Variable name, List<Expression> params) {
		super(row, column);
		this.name = name;
		this.params = params;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
