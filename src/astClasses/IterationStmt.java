package astClasses;

public class IterationStmt extends AbstractSyntaxTreeNode {
	Expression e;
	Statement s;
	
	public IterationStmt(Expression e, Statement s){
		this.e = e;
		this.s = s;
		
		this.addNode(e);
		this.addNode(s);
	}
	
	public void print(){
		System.out.println("IterationStmt");
		
		e.print();
		s.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "IterationStmt";
	}
		
}