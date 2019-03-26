package ast.expressions;

import ast.types.Type;

public interface Expression extends Type {

	boolean getLvalue();
	void setLvalue(boolean value);
}
