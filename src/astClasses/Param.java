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
			if(ts.type.equals("INT")) {			
				this.currentSymbol = new Symbol(this.ID, ESymbolType.INTarray);
			}
			else if(ts.type.equals("VOID")) {			
				this.currentSymbol = new Symbol(this.ID, ESymbolType.VOID);
			}
			else {
				this.currentSymbol = new Symbol(this.ID, ESymbolType.Error);
			}
		}
		else {
			if(ts.type.equals("INT")) {			
				this.currentSymbol = new Symbol(this.ID, ESymbolType.INT);
			}
			else if(ts.type.equals("VOID")) {			
				this.currentSymbol = new Symbol(this.ID, ESymbolType.VOID);
			}
			else {
				this.currentSymbol = new Symbol(this.ID, ESymbolType.Error);
			}
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
		if(this.currentSymbol.getType() != ESymbolType.INT 
		&& this.currentSymbol.getType() != ESymbolType.INTarray) {
			semanticErrors.add("Error: Incompatible type for symbol " + currentSymbol.getName());
		}
		
		if(context.addSymbol(this.currentSymbol)) {
		}
		else {
			semanticErrors.add("Error: Multiple declarations for symbol " + this.currentSymbol.getName());
		}

		return false;
	}
}
