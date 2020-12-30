package astClasses;

import symbolTable.Symbol;

public class Addop extends AbstractSyntaxTreeNode {
	String type;
	
	public Addop(String type){
		this.type = type;
	}
	
	public void print(){
		System.out.println("Addop: "+ type);
		
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