package astClasses;

public class Declaration extends AbstractSyntaxTreeNode {
	VarDeclaration vd; 
	FunDeclaration fd;
	
	public Declaration(VarDeclaration vd) {
		this.vd = vd;
		
		this.addNode(vd);
	}
	
	public Declaration(FunDeclaration fd) {
		this.fd = fd;
		
		this.addNode(fd);
	}
	
	public void print() {
		System.out.println("Declaration");
		
		if(vd != null) {
			vd.print();
		}
		else if(fd != null) {
			fd.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Declaration";
	}
}
