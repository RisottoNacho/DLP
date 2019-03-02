package ast.types;

import ast.ConcreteASTNode;

public class String extends ConcreteASTNode implements Type {

	public String(int row, int column) {
		super(row, column);
	}

}
