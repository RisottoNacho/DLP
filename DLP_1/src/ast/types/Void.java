package ast.types;

import ast.ConcreteASTNode;
import visitor.Visitor;

public class Void extends ConcreteType implements Type {

	public Void(int row, int column) {
		super(row, column);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}

	@Override
	public String toString(){
		return "Void";
	}
}
