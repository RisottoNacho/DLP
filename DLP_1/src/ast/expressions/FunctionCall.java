package ast.expressions;

import java.util.List;

import ast.ConcreteASTNode;

public class FunctionCall extends ConcreteASTNode implements Expression {

	public List<Expression> params;
	public String name;

	public FunctionCall(int row, int column, String name, List<Expression> ls) {
		super(row, column);
		this.name = name;
		params = ls;
	}

}
