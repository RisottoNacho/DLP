package ast;

import visitor.Visitor;

public interface ASTNode {
	int getRow();
	int getColumn();
	Object accept(Visitor V,Object params);
}
