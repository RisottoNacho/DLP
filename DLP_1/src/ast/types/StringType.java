package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class StringType extends ConcreteType implements Type {

	public StringType(int row, int column) {
		super(row, column);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
