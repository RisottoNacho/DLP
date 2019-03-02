package ast.types;

import ast.ConcreteASTNode;

public class Array extends ConcreteASTNode implements Type {

	public Type type;
	public int size;

	public Array(int row, int column, int size, Type t) {
		super(row, column);
		type = t;
		this.size = size;
	}

}
