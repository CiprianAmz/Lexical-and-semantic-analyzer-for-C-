package astClasses;

import symbolTable.Symbol;

public class ReturnStmt extends AbstractSyntaxTreeNode {
	Expression e;
	
	public ReturnStmt(){
		this.e = null;
	}
	
	public ReturnStmt(Expression e){
		this.e = e;
		
		this.addNode(e);
	}
	
	public void print(){
		System.out.println("ReturnStmt");
		
		e.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "ReturnStmt";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		if(e != null) {
			if(e.checkSemantic(context) == false) {
				semanticErrors.add("Error: Invalid RETURN value."); 
			}
		}
		
		return false;
	}

}