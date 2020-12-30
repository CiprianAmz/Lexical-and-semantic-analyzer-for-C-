package astClasses;

import symbolTable.Symbol;

public class Factor extends AbstractSyntaxTreeNode {
	Expression e = null;
	Var v = null;
	Call c = null;
	Integer NUM = null;
	
	public Factor(Expression e){
		this.e = e;
		
		this.addNode(e);
	}
	public Factor(Var v){
		this.v = v;
		
		this.addNode(v);
	}
	public Factor(Call c){
		this.c = c;
		
		this.addNode(c);
	}
	public Factor(Integer NUM){
		this.NUM = NUM;
	}
	
	public void print(){
		System.out.println("ReturnStmt");
		
		if(e != null){
			e.print();
		}else if(v != null){
			v.print();
		}else if(c != null){
			c.print();
		}else{
			
		}
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		
		if(NUM != null) {			
			return "Factor: " + NUM.toString();
		}
		else {
			return "Factor";
		}
	}
	@Override
	public boolean checkSemantic(Symbol context) {
		if(e != null) {
			return e.checkSemantic(context);
		}
		else if(v != null) {
			return v.checkSemantic(context);
		}
		else if(c != null) {
			return c.checkSemantic(context);
		}
		
		return true;
	}

}