package astClasses;

import java.util.ArrayList;

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

}