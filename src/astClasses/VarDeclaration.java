package astClasses;

public class VarDeclaration extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	String ID;
	Integer NUM;
	
	public VarDeclaration(TypeSpecifier ts, String ID) {
		this.ts = ts;
		this.ID = ID;
		this.NUM = null;
		
		this.addNode(ts);
	}
	
	public VarDeclaration(TypeSpecifier ts, String ID, Integer NUM) {
		this.ts = ts;
		this.ID = ID;
		this.NUM = NUM;
		
		this.addNode(ts);
	}
	
	public void print() {
		System.out.println("Var declaration");
		
		ts.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		
		if(NUM != null) {			
			return "VarDeclaration: " + ID + "[" + NUM.toString() + "]";
		}
		else {
			return "VarDeclaration: " + ID;
		}
	}
	
}
