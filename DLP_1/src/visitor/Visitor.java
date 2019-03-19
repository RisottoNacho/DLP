package visitor;

import ast.definitions.Field;

public interface Visitor {

	Object Visit();

	Object visit(Field field, Object params);
}
