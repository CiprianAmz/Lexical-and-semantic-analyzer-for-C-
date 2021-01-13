package astClasses;

import symbolTable.ESymbolType;
import symbolTable.Symbol;

public class FunDeclaration extends AbstractSyntaxTreeNode {
	TypeSpecifier ts;
	Params p;
	CompoundStmt cs;
	String ID;
	Symbol currentSymbol;
	
	public FunDeclaration(TypeSpecifier ts, String ID, Params p, CompoundStmt cs) {
		this.ts = ts;
		this.p = p;
		this.cs = cs;
		this.ID = ID;
		
		if(ts.type.equals("INT")) {
			this.currentSymbol = new Symbol(this.ID, ESymbolType.INTfunc);
		}		
		else {
			this.currentSymbol = new Symbol(this.ID, ESymbolType.VOIDfunc);
		}
				
		this.addNode(ts);
		this.addNode(p);
		this.addNode(cs);
	}
	
	void print() {
		System.out.println("funDeclaration");
		
		ts.print();
		p.print();
		cs.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "FunDeclaration: " + ID;
	}

	@Override
	public boolean checkSemantic(Symbol context) {
//		Symbol newScope = new Symbol(ESymbolType.Scope);
//		currentSymbol.addSymbol(newScope);
		
		if(context.addSymbol(this.currentSymbol)) {
		}
		else {
			semanticErrors.add("Error: Multiple declarations for symbol " + currentSymbol.getName());
		}
		
		if(this.p.pl != null) {			
			currentSymbol.setArgumentsNumber(p.pl.pList.size());
		}
		
		p.checkSemantic(currentSymbol);
		cs.checkSemantic(currentSymbol);
		
		// TODO Auto-generated method stub
		return false;
	}
}
