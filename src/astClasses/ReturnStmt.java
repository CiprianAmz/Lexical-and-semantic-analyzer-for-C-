package astClasses;

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

}