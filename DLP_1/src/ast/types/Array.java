package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Array extends ConcreteType implements Type {

	public Type type;
	public int size;

	public Array(int row, int column, int size, Type t) {
		super(row, column);
		type = t;
		this.size = size;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
