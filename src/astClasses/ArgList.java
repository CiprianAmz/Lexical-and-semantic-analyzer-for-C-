package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

public class ArgList extends AbstractSyntaxTreeNode {
	ArgList al;
	ArrayList<Expression> eList = new ArrayList<>();
	
	public ArgList(ArgList al, Expression e) {
		this.al = al;
		eList.add(e);
		
		this.addNode(al);
		this.addNode(e);
	}
	
	public ArgList(Expression e) {
		eList.add(e);
		
		this.addNode(e);
	}
	
	public void addArg(Expression e) {
		eList.add(e);
		
		this.addNode(e);
	}
	
	public void print() {
		System.out.println("Call");
		
		if( al != null) {
			al.print();
		}
		
		for(Expression e:eList) {			
			e.print();
		}
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "ArgList";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		boolean errorChecked = false;
		
		if(al != null) {
			al.checkSemantic(context);
		}
		for(Expression exp:eList) {
			if(exp.checkSemantic(context) == false && errorChecked == false) {
				errorChecked = false;
				semanticErrors.add("Error: Invalid expression"); 
			}
		}
		
		return false;
	}

}