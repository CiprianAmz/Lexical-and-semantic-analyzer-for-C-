package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

public class DeclarationList extends AbstractSyntaxTreeNode {
	DeclarationList dl;
	ArrayList<Declaration> dList = new ArrayList<>();
	
	public DeclarationList(DeclarationList dl, Declaration d) {
		this.dl = dl;
		dList.add(d);
		
		this.addNode(dl);
		this.addNode(d);
	}
	
	public DeclarationList(Declaration d) {
		dList.add(d);
		
		this.addNode(d);
	}
	
	public void addDeclaration(Declaration d) {
		dList.add(d);
		
		this.addNode(d);
	}
	
	public void print() {
		System.out.println("Declaration list");
		
		if(dl != null) {
			dl.print();
		}
		
		for(Declaration d:dList) {			
			d.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "DeclarationList";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		for(Declaration decl:this.dList) {
			decl.checkSemantic(null);
		}

		return false;
	}
}
