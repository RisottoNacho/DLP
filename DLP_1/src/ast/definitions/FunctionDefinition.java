package ast.definitions;

import java.util.List;

import ast.statements.Statement;
import ast.types.Function;
import visitor.Visitor;

public class FunctionDefinition extends ConcreteDefinition implements Definition {

	public List<VariableDefinition> lsVariables;
	public List<Statement> lsStatement;
	public Function functionType;
	
	public FunctionDefinition(int row, int column, String name,
			List<VariableDefinition> lsVariables, List<Statement> lsStatement, Function t) {
		super(row,column,name);
		this.lsVariables = lsVariables;
		this.lsStatement = lsStatement;
		this.functionType = t;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}

	@Override
	public void setScope(int scope) {
		this.scope = scope;
	}
}
