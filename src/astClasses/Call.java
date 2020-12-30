package astClasses;

import symbolTable.Symbol;

public class Call extends AbstractSyntaxTreeNode {
	Args a;
	String ID;
	
	public Call(Args a, String ID){
		this.a = a;
		this.ID = ID;
		
		this.addNode(a);
	}
	
	public void print(){
		System.out.println("Call");
		
		a.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Call: " + ID;
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		// TODO Auto-generated method stub
		return false;
	}

}