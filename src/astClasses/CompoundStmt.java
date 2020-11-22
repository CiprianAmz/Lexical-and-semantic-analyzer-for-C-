package astClasses;

public class CompoundStmt extends AbstractSyntaxTreeNode {
	LocalDeclarations ld;
	StatementList sl;
	
	public CompoundStmt(LocalDeclarations ld, StatementList sl) {
		this.ld = ld;
		this.sl = sl;
		
		this.addNode(ld);
		this.addNode(sl);
	}
	
	public void print() {
		System.out.println("CompoundStmt");
		
		ld.print();
		sl.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "CompoundStmt";
	}
}
