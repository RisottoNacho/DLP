package ast.types;

import ast.ConcreteASTNode;

public class Void extends ConcreteASTNode implements Type {

	public Void(int row, int column) {
		super(row, column);
	}

}
