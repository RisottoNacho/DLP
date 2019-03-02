package ast.types;

import java.util.List;

import ast.ConcreteASTNode;
import ast.definitions.Field;

public class Struct extends ConcreteASTNode implements Type {

	public Struct(int row, int column,List<Field> ls) {
		super(row, column);
	}

}
