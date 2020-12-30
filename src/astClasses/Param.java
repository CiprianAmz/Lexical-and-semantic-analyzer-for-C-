package astClasses;

import symbolTable.ESymbolType;
import symbolTable.Symbol;

public class Param extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	String ID;
	Symbol currentSymbol;
	boolean array = false;
	
	public Param(TypeSpecifier ts, String ID, boolean array) {
		this.ts = ts;
		this.ID = ID;
		this.array = array;
		
		if(this.array) {			
			this.currentSymbol = new Symbol(this.ID, ESymbolType.INTarray);
		}
		else {
			this.currentSymbol = new Symbol(this.ID, ESymbolType.INT);
		}
		
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

	@Override
	public boolean checkSemantic(Symbol context) {
		if(context.addSymbol(this.currentSymbol)) {
		}
		else {
			semanticErrors.add("Error: Multiple declarations for symbol " + this.currentSymbol.getName());
		}

		return false;
	}
}
