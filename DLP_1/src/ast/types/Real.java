package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Real extends ConcreteASTNode implements Type {

	public Real(int row, int column) {
		super(row, column);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
