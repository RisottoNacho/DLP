package ast.types;

import java.util.List;

import ast.ConcreteASTNode;
import ast.definitions.VariableDefinition;
import visitor.Visitor;

public class Function extends ConcreteASTNode implements Type {

	public Type type;
	public List<VariableDefinition> lsParams;

	public Function(int row, int column,List<VariableDefinition> params, Type t) {
		super(row, column);
		if (t == null)
			type = new Void(row, column);
		else
			this.type = t;
		lsParams = params;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
