package ast.types;

import ast.ConcreteASTNode;
import ast.ErrorHandler;

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
}
