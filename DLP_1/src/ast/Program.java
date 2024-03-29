package ast;

import java.util.List;

import ast.definitions.Definition;
import visitor.Visitor;

public class Program extends ConcreteASTNode {

	private List<Definition> listDef;
	
	public Program (int row,int column,List<Definition> ls) {
		super(row,column);
		setListDef(ls);
	}

	public List<Definition> getListDef() {
		return listDef;
	}

	private void setListDef(List<Definition> listDef) {
		this.listDef = listDef;
	}


	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
