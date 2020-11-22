package astClasses;

public class Statement extends AbstractSyntaxTreeNode {
	ExpressionStmt es;
	CompoundStmt cs; 
	SelectionStmt ss;
	IterationStmt is;
	ReturnStmt rs;
	
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
}
