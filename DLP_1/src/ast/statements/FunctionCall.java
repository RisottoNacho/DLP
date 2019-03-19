package ast.statements;

import java.util.List;

import ast.ConcreteASTNode;
import ast.expressions.Expression;
import visitor.Visitor;

public class FunctionCall extends ConcreteASTNode implements Statement{
	
	public String name;
	public List<Expression> params;

	public FunctionCall(int row, int column,String name,List<Expression> params) {
		super(row, column);
		this.name = name;
		this.params = params;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
