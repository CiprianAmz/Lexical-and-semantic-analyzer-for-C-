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
		for(VarDeclaration var:ld.vdList) {
			if(currentSymbolTable.addSymbol(var.currentSymbol)) {
			}
			else {
				semanticErrors.add("Error: Multiple declarations for symbol " + var.currentSymbol.getName());
			}
		}
		
		for(Statement statement:sl.sList) {
			if(statement.cs != null) {
				currentSymbolTable.addSymbol(statement.cs.currentSymbolTable);
				statement.cs.checkSemantic(context);
			}
		}
		
		sl.checkSemantic(null);
		
		return false;
	}
}
