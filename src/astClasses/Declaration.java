package astClasses;

import symbolTable.*;

public class Declaration extends AbstractSyntaxTreeNode {
	VarDeclaration vd; 
	FunDeclaration fd;
	
	public Declaration(VarDeclaration vd) {
		this.vd = vd;
		this.fd = null;
		
		this.addNode(vd);
	}
	
	public Declaration(FunDeclaration fd) {
		this.fd = fd;
		this.vd = null;
		
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

	@Override
	public boolean checkSemantic(Symbol context) {
		if(vd != null) {
			vd.checkSemantic(context);
		}
		else if(fd != null) {
			fd.checkSemantic(context);
		}
		
		return false;
	}
}
