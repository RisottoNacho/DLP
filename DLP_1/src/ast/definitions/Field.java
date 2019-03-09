package ast.definitions;


import ast.types.Type;

public class Field extends ConcreteDefinition {

	public Type tipo;
	
	public Field(int row,int column,String name) {
		super(row,column,name);
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}
	
	public boolean isEqual(String f) {
		if(this.getName().compareTo(f) == 0)
			return true;
		return false;
	}
}
