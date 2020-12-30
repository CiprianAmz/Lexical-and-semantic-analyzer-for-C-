package astClasses;

import symbolTable.*;

public class VarDeclaration extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	String ID;
	Integer NUM;
	Symbol currentSymbol;
	
	
	public VarDeclaration(TypeSpecifier ts, String ID) {
		this.ts = ts;
		this.ID = ID;
		this.NUM = null;
		
		this.currentSymbol = new Symbol(this.ID, ESymbolType.INT);
		
		this.addNode(ts);
	}
	
	public VarDeclaration(TypeSpecifier ts, String ID, Integer NUM) {
		this.ts = ts;
		this.ID = ID;
		this.NUM = NUM;
		
		this.currentSymbol = new Symbol(this.ID, ESymbolType.INTarray);
		
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

	@Override
	public boolean checkSemantic(Symbol context) {
		if(context.addSymbol(this.currentSymbol)) {
		}
		else {
			semanticErrors.add("Error: Multiple declarations for symbol " + currentSymbol.getName());
		}
	
		return false;
	}
	
}
