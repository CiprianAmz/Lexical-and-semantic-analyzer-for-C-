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
		currentSymbol.addSymbol(cs.currentSymbolTable);
		
		if(p.pl != null) {
			currentSymbol.setArgumentsNumber(p.pl.pList.size());
			//append the function parameters to the compound statement scope
			for(Param param:p.pl.pList) {
				if(cs.currentSymbolTable.addSymbol(param.currentSymbol)) {
				}
				else {
					semanticErrors.add("Error: Multiple declarations for symbol " + param.currentSymbol.getName());
				}
			}
		}
		
		cs.checkSemantic(null);
		
		// TODO Auto-generated method stub
		return false;
	}
}
