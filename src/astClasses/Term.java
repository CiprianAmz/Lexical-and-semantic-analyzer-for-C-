package astClasses;

import java.util.ArrayList;

import symbolTable.Symbol;

class PairFactor {
	Mulop m;
	Factor f;
	
	PairFactor(Mulop m, Factor f){
		this.m = m;
		this.f = f;
	}
}

public class Term extends AbstractSyntaxTreeNode {
	Term t;
	ArrayList<PairFactor> opList = new ArrayList<PairFactor>();
	Factor f;
	
	public Term(Term t, Mulop m, Factor f){
		this.t = t;
		this.opList.add(new PairFactor(m, f));
		this.f = f;
		
		this.addNode(t);
		this.addNode(m);
		this.addNode(f);
	}
	
	public Term(Factor f){
		this.f = f;

		this.addNode(f);
	}
	
	public void addOperator(Mulop m, Factor f){
		this.opList.add(new PairFactor(m, f));
		this.f = f;
		
		this.addNode(m);
		this.addNode(f);
	}
	
	public void print(){
		System.out.println("Term");
		
		if( t!= null){
			t.print();
			
			for(PairFactor op:opList) {				
				op.m.print();
				op.f.print();
			}
		}
		else {
			f.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Term";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		boolean returnINT = true;
		
		if(t != null) {
			if(t.checkSemantic(context) == false) {
				returnINT = false;
				
				semanticErrors.add("Error: Incompatible expression result.");
			}
		}
		
		for(PairFactor factor:this.opList) {
			if(factor.f.checkSemantic(context) == false && returnINT == true) {
				returnINT = false;
				
				semanticErrors.add("Error: Incompatible expression result.");
			}
		}
		
		if(this.f != null) {
			return f.checkSemantic(context);
		}
		
		return returnINT;
	}

}