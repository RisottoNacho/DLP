package ast.definitions;

import java.util.List;

import ast.statements.Statement;
import ast.types.Function;

public class FunctionDefinition extends ConcreteDefinition implements Definition {

	public List<Field> Fields;
	public List<VariableDefinition> lsVariables;
	public List<Statement> lsStatement;
	public Function functionType;
	
	public FunctionDefinition(int row, int column, String name, List<Field> lsFIeld,
			List<VariableDefinition> lsVariables, List<Statement> lsStatement, Function t) {
		super(row,column,name);
		this.Fields = lsFIeld;
		this.lsVariables = lsVariables;
		this.lsStatement = lsStatement;
		this.functionType = t;
	}
}
