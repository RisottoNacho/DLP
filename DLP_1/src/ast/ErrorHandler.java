package ast;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

public class ErrorHandler {

	private List<ErrorType> lsErrors;
	private static ErrorHandler eh;

	private ErrorHandler() {
		lsErrors = new ArrayList<ErrorType>();
	}

	public void addError(ErrorType err) {
		lsErrors.add(err);
	}
	
	public static ErrorHandler getInstance() {
		if(eh == null)
			eh = new ErrorHandler();
		return eh;
	}

	public void showErrors(PrintStream s) {
		System.out.println(s);
	}

	public boolean anyError() {
		return true;
	}
}
