package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

public class ParamList extends AbstractSyntaxTreeNode {
	ParamList pl;
	ArrayList <Param> pList = new ArrayList<>();
	
	public ParamList(Param p) {
		pList.add(p);
		
		this.addNode(p);
	}
	
	public ParamList(ParamList pl, Param p) {
		this.pl = pl;
		pList.add(p);

		this.addNode(pl);
		this.addNode(p);
	}
	
	public void addParam(Param p) {
		pList.add(p);
		
		this.addNode(p);
	}
	
	public void print() {
		System.out.println("ParamList");
		
		if(pl != null) {			
			pl.print();
		}
		
		for(Param p:pList) {			
			p.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "ParamList";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		// TODO Auto-generated method stub
		return false;
	}
}
