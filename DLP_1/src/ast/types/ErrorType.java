package ast.types;

import ast.ConcreteASTNode;
import ast.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends ConcreteASTNode implements Type {
	
	private String message;
	
	public ErrorType(int row, int column,String message) {
		super(row, column);
		this.message = message;
		ErrorHandler.getInstance().addError(this);
	}

	public String getMessage() {
		return message;
	}
	
	public String toString() {
		return message;
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}
}
