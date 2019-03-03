package ast.types;

import ast.ConcreteASTNode;

public class StringType extends ConcreteASTNode implements Type {

	public StringType(int row, int column) {
		super(row, column);
	}

}
