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
		
		if(ts.type.equals("INT")) {			
			this.currentSymbol = new Symbol(this.ID, ESymbolType.INT);
		}
		else if(ts.type.equals("VOID")) {			
			this.currentSymbol = new Symbol(this.ID, ESymbolType.VOID);
		}
		else {
			this.currentSymbol = new Symbol(this.ID, ESymbolType.Error);
		}
		
		this.addNode(ts);
	}
	
	public VarDeclaration(TypeSpecifier ts, String ID, Integer NUM) {
		this.ts = ts;
		this.ID = ID;
		this.NUM = NUM;
		
		if(ts.type.equals("INT")) {			
			this.currentSymbol = new Symbol(this.ID, ESymbolType.INTarray);
		}
		else if(ts.type.equals("VOID")) {			
			this.currentSymbol = new Symbol(this.ID, ESymbolType.VOID);
		}
		else {
			this.currentSymbol = new Symbol(this.ID, ESymbolType.Error);
		}
		
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
		if(this.currentSymbol.getType() != ESymbolType.INT 
		&& this.currentSymbol.getType() != ESymbolType.INTarray) {
			semanticErrors.add("Error: Incompatible type for symbol " + currentSymbol.getName());
		}
		
		if(context.addSymbol(this.currentSymbol)) {
		}
		else {
			semanticErrors.add("Error: Multiple declarations for symbol " + currentSymbol.getName());
		}
	
		return false;
	}
	
}
