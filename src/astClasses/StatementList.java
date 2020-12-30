package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

public class StatementList extends AbstractSyntaxTreeNode {
	StatementList sl;
	ArrayList<Statement> sList = new ArrayList<>();
	
	public StatementList() {
		this.sl = null;
	}
	
	public StatementList(StatementList sl, Statement s) {
		this.sl = sl;
		sList.add(s);
		
		this.addNode(sl);
		this.addNode(s);
	}
	
	public void addStatement(Statement s) {
		sList.add(s);
		
		this.addNode(s);
	}
	
	public void print() {
		System.out.println("StatementList");
		
		if(sl == null) {
			System.out.println("Empty");
		}
		else {
			sl.print();
			
			for(Statement s:sList) {
				s.print();
			}
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "StatementList";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		for(Statement statement:sList) {
			statement.checkSemantic(context);
		}
		
		return false;
	}
}
