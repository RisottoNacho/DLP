package ast.definitions;

import ast.ASTNode;

public interface Definition extends ASTNode {

	String getName();
	void setScope(int scope);
}
