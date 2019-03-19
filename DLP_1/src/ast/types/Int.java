package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Int extends ConcreteASTNode implements Type {

	
	public Int(int row, int column) {
		super(row, column);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
