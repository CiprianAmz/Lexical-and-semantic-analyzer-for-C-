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
	
	Symbol getSymbol() {
		if(this.fd != null) {
			return this.fd.currentSymbol;
		}
		else if (this.vd != null) {
			return this.vd.currentSymbol;
		}
		
		return null;
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
		if(fd != null) {
			fd.checkSemantic(null);
		}
		return false;
	}
}
