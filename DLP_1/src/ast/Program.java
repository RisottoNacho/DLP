package ast;

import java.util.List;

import ast.definitions.Definition;

public class Program extends ConcreteASTNode {

	private List<Definition> listDef; PENDIENTE SEGUIR CON ESTO
	
	public Program (int row,int column,List<Definition> ls) {
		super(row,column);
	}

	public List<Definition> getListDef() {
		return listDef;
	}

	private void setListDef(List<Definition> listDef) {
		this.listDef = listDef;
	}
	
	
}
