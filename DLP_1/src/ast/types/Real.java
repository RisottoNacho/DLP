package ast.types;

import visitor.Visitor;

public class Real extends ConcreteType implements Type {

	public Real(int row, int column) {
		super(row, column);
	}

	@Override
	public Object accept(Visitor V, Object params) {
		return V.visit(this, params);
	}

	@Override
	public Type arithmetic(Type type){
		if(type instanceof Int || type instanceof Real)
			return this;
		return null;
	}

	@Override
	public Type arithmetic() {
		return this;
	}

	@Override
	public boolean isBuiltInType(){
		return true;
	}

	@Override
	public Type promotesTo(Type type){
		if (type instanceof Real)
			return this;
		if(type instanceof Int)
			return type;
		return null;
	}

	@Override
	public String toString(){
		return "Double";
	}
}
