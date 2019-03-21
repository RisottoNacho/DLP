package ast.definitions;

import ast.*;

public abstract class ConcreteDefinition extends ConcreteASTNode implements Definition{

	private String name;
	public int scope;
	
	public ConcreteDefinition(int row,int column,String name) {
		super(row,column);
		setName(name);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	
}
