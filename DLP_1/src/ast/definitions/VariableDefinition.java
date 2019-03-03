package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

public class VariableDefinition extends ConcreteDefinition implements Definition, Statement {

	public Type type;

	public VariableDefinition(int row, int column, String name) {
		super(row, column, name);
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
