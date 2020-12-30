package astClasses;

import symbolTable.Symbol;

public class Mulop extends AbstractSyntaxTreeNode {
	String type;
	
	public Mulop(String type){
		this.type = type;
	}
	
	public void print(){
		System.out.println("Mulop: " + type);

	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		// TODO Auto-generated method stub
		return false;
	}
}