package ast.expressions;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class AbstractExpression extends ConcreteASTNode implements Expression {

	public AbstractExpression(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
}
