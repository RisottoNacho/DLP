package ast.types;

import java.util.List;

import ast.ConcreteASTNode;
import ast.definitions.Field;
import visitor.Visitor;

public class Struct extends ConcreteASTNode implements Type {

	public List<Field> lsFields;

	public Struct(int row, int column, List<Field> ls) {
		super(row, column);
		lsFields = ls;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
