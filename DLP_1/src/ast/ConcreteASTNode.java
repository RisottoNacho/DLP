package ast;

public abstract class ConcreteASTNode implements ASTNode {

	private int row;
	private int column;
	
	public ConcreteASTNode(int row,int column) {
		setRow(row);
		setColumn(column);
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}

	private void setRow(int row) {
		this.row = row;
	}

	private void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString(){
		return this.getClass().toString();
	}
	
}
