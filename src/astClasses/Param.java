package astClasses;

public class Param extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	String ID;
	
	public Param(TypeSpecifier ts, String ID) {
		this.ts = ts;
		this.ID = ID;
		
		this.addNode(ts);
	}
	
	public void print() {
		System.out.println("Param");
		
		ts.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Param: " + ID;
	}
}
