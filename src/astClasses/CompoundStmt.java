package astClasses;

import symbolTable.*;

public class CompoundStmt extends AbstractSyntaxTreeNode {
	LocalDeclarations ld;
	StatementList sl;
	Symbol currentSymbolTable;
	
	public CompoundStmt(LocalDeclarations ld, StatementList sl) {
		this.ld = ld;
		this.sl = sl;
		
		this.currentSymbolTable = new Symbol(ESymbolType.Scope);
		
		this.addNode(ld);
		this.addNode(sl);
	}
	
	public void print() {
		System.out.println("CompoundStmt");
		
		ld.print();
		sl.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "CompoundStmt";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		ld.checkSemantic(context);
		sl.checkSemantic(context);
		
		return false;
	}
}
