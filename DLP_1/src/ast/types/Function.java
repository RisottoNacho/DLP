package ast.types;

import ast.ConcreteASTNode;

public class Function extends ConcreteASTNode implements Type {

	public Type type;

	public Function(int row, int column, Type t) {
		super(row, column);
		if (t == null)
			type = new Void(row, column);
		else
			this.type = t;
	}

}
