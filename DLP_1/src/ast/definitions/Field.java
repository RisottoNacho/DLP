package ast.definitions;


import ast.types.Type;

public class Field extends ConcreteDefinition {

	public Type tipo;
	
	public Field(int row,int column,String name,Type tipo) {
		super(row,column,name);
		this.tipo = tipo;
	}
}
