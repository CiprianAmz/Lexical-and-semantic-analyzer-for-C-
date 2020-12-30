package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

class Pair {
	Addop a;
	Term t;
	
	Pair(Addop a, Term t){
		this.a = a;
		this.t = t;
	}
}

public class AdditiveExpression extends AbstractSyntaxTreeNode{
	AdditiveExpression ae;
	ArrayList<Pair> opList = new ArrayList<Pair>();
	
	Term t;
	
	public AdditiveExpression(AdditiveExpression ae, Addop a, Term t){
		this.t = null;
		this.ae = ae;
		opList.add(new Pair(a, t));
		
		this.addNode(ae);
		this.addNode(a);
		this.addNode(t);
	}
	
	public AdditiveExpression(Term t){
		this.t = t;
		
		this.addNode(t);
	}
	
	public void addOperation(Addop a, Term t){
		opList.add(new Pair(a, t));
		
		this.addNode(a);
		this.addNode(t);
	}
	
	public void print(){
		System.out.println("AdditiveExpression");
		
		if( ae != null){
			ae.print();
			
			for(Pair op:opList) {				
				op.a.print();
				op.t.print();
			}
		}
		else {
			t.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "AdditiveExpression";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		boolean returnINT = true;
		
		if(ae != null) {
			if(ae.checkSemantic(context) == false) {
				returnINT = false;
				
				semanticErrors.add("Error: Incompatible expression result.");
			};
		}
		
		for(Pair op:opList) {
			if(op.t.checkSemantic(context) == false && returnINT == true) {
				returnINT = false;
				
				semanticErrors.add("Error: Incompatible expression result.");
			}
			
		}

		if(opList.size() == 0) {
			return t.checkSemantic(context);
		}
		
		return returnINT;
	}

}