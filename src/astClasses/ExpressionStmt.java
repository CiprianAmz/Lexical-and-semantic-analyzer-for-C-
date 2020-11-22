package astClasses;

public class ExpressionStmt extends AbstractSyntaxTreeNode {
	Expression e;
	
	public ExpressionStmt() {
		
	}
	
	public ExpressionStmt(Expression e) {
		this.e = e;
		
		this.addNode(e);
	}	
	
	public void print() {
		System.out.println("ExpressionStmt");
		
		if(e != null) {
			e.print();
		}
		else {
			System.out.println("empty");
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "ExpressionStmt";
	}
}
