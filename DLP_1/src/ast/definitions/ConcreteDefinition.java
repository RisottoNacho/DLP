package ast.definitions;

import ast.*;
import ast.types.Type;

public abstract class ConcreteDefinition extends ConcreteASTNode implements Definition{

	private String name;
	public int scope;
	public Type type;
	
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

	@Override
	public void setType(Type type) {
		this.type=type;
	}

	@Override
	public Type getType(){
		return type;
	}
}
