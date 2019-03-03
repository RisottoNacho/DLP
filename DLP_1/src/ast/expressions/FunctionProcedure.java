package ast.expressions;

import java.util.List;

import ast.ConcreteASTNode;

public class FunctionProcedure extends ConcreteASTNode implements Expression {

	public List<Expression> params;
	public String name;

	public FunctionProcedure(int row, int column, String name, List<Expression> ls) {
		super(row, column);
		this.name = name;
		params = ls;
	}

}
