package astClasses;

import java.util.ArrayList;

public class LocalDeclarations extends AbstractSyntaxTreeNode {
	LocalDeclarations ld; 
	ArrayList<VarDeclaration> vdList = new ArrayList<>();
	
	public LocalDeclarations() {
		this.ld = null;
	}
	
	public LocalDeclarations(LocalDeclarations ld, VarDeclaration vd) {
		this.ld = ld;
		vdList.add(vd);
		
		this.addNode(ld);
		this.addNode(vd);
	}
	
	public void addDeclaration(VarDeclaration vd) {
		vdList.add(vd);
		
		this.addNode(vd);
	}
	
	public void print() {
		System.out.println("LocalDeclarations");
		
		if(ld != null) {
			ld.print();
			
			for(VarDeclaration vd:vdList) {				
				vd.print();
			}
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "LocalDeclarations";
	}
	
}
