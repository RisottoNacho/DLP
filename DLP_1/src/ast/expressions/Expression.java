package ast.expressions;

import ast.ASTNode;

public interface Expression extends ASTNode {

	public boolean getLvalue();
	public void setLvalue(boolean value);
}
