package astClasses;

import symbolTable.ESymbolType;
import symbolTable.Symbol;

public class Statement extends AbstractSyntaxTreeNode {
	ExpressionStmt es = null;
	CompoundStmt cs = null; 
	SelectionStmt ss = null;
	IterationStmt is = null;
	ReturnStmt rs = null;
	
	public Statement(ExpressionStmt es) {
		this.es = es;

		this.addNode(es);
	}
	
	public Statement(CompoundStmt cs) {
		this.cs = cs;
		
		this.addNode(cs);
	}
	
	public Statement(SelectionStmt ss) {
		this.ss = ss;
		
		this.addNode(ss);
	}
	
	public Statement(IterationStmt is) {
		this.is = is;
		
		this.addNode(is);
	}
	
	public Statement(ReturnStmt rs) {
		this.rs = rs;
		
		this.addNode(rs);
	}
	
	public void print() {
		System.out.println("Statement");
		
		if(es != null) {
			es.print();
		}
		else if(cs != null){
			cs.print();
		}
		else if(ss != null){
			ss.print();
		}
		else if(is != null){
			is.print();
		}
		else if(rs != null){
			rs.print();
		}
		
		
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Statement";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		if(cs != null) {
			Symbol newScope = new Symbol(ESymbolType.Scope);
			context.addSymbol(newScope);
			cs.checkSemantic(newScope);
		}
		else if(es != null) {
			es.checkSemantic(context);
		}
		else if(cs != null) {
			cs.checkSemantic(context);
		}
		else if(ss != null) {
			ss.checkSemantic(context);
		}
		else if(is != null) {
			is.checkSemantic(context);
		}
		else if(rs != null) {
			rs.checkSemantic(context);
		}

		return false;
	}
}
