package astClasses;

import symbolTable.*;

public class Program extends AbstractSyntaxTreeNode {
	DeclarationList dl;
	Symbol currentSymbolTable;
	
	
	public Program(DeclarationList dl) {
		this.dl = dl;
		this.currentSymbolTable = new Symbol(ESymbolType.Scope);
		
		this.addNode(dl);
	}
	
	public void print() {
		System.out.println("Program");
		
		dl.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Program";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		currentSymbolTable = context;
		
		dl.checkSemantic(currentSymbolTable);
		
		for(String error:semanticErrors) {
			System.out.println(error);
		}
		
		return false;
	}
}
