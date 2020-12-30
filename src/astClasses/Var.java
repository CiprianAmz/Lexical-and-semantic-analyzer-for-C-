package astClasses;

import symbolTable.Symbol;

public class Var extends AbstractSyntaxTreeNode {
	Expression e;
	String ID;
	
	public Var(Expression e, String ID){
		this.e = e;
		this.ID = ID;
		
		this.addNode(e);
	}
	public Var(String ID){
		this.ID = ID;
	}
	
	public void print(){
		System.out.println("Var");
		
		if( e != null){
			e.print();
		}
		
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Var: " + ID;
	}
	@Override
	public boolean checkSemantic(Symbol context) {
		// TODO Auto-generated method stub
		return false;
	}

}