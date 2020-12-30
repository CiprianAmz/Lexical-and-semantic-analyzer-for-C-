package astClasses;

import symbolTable.ESymbolType;
import symbolTable.Symbol;

public class Var extends AbstractSyntaxTreeNode {
	Expression e;
	String ID;
	
	public Var(Expression e, String ID){
		this.e = e;
		this.ID = ID;
		
		this.addNode(e);
	}
	public Var(String ID){
		this.ID = ID;
	}
	
	public void print(){
		System.out.println("Var");
		
		if( e != null){
			e.print();
		}
		
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Var: " + ID;
	}
	@Override
	public boolean checkSemantic(Symbol context) {
		Symbol sym = context.searchSymbol(this.ID);
		
		if(this.e != null) {
			if(sym != null) {
				if(sym.getType() != ESymbolType.INTarray) {
					semanticErrors.add("Error: " + this.ID + " expected to be used as INT array, but it is not an array.");
				}
			}
			else {
				semanticErrors.add("Error: " + this.ID + " is used, but not declared.");
			}
		}
		else {
			if(sym != null) {
				if(sym.getType() != ESymbolType.INT) {
					semanticErrors.add("Error: " + this.ID + " expected to be used as an INT, but it is not an INT variable.");
				}
			}
			else {
				semanticErrors.add("Error: " + this.ID + " is used, but not declared.");
			}
		}

		return true;
	}

}