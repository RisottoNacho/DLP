package ast.types;

import ast.ConcreteASTNode;

public class Int extends ConcreteASTNode implements Type {

	
	public Int(int row, int column) {
		super(row, column);
	}

}
