package astClasses;

public class FunDeclaration extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	Params p;
	CompoundStmt cs;
	String ID;
	
	public FunDeclaration(TypeSpecifier ts, String ID, Params p, CompoundStmt cs) {
		this.ts = ts;
		this.p = p;
		this.cs = cs;
		this.ID = ID;
		
		this.addNode(ts);
		this.addNode(p);
		this.addNode(cs);
	}
	
	void print() {
		System.out.println("funDeclaration");
		
		ts.print();
		p.print();
		cs.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "FunDeclaration: " + ID;
	}
}
