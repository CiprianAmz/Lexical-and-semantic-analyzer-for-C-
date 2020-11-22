package astClasses;

public class Expression extends AbstractSyntaxTreeNode {
	Var v;
	Expression e;
	SimpleExpression se;
	
	public Expression(){
		this.e = null;
		this.se = null;
		this.v = null;
		
		this.addNode(e);
		this.addNode(se);
		this.addNode(v);
	}
	
	public Expression(Var v, Expression e){
		this.v = v;
		this.e = e;
		
		this.addNode(v);
		this.addNode(e);
	}
	
	public Expression(SimpleExpression se){
		this.se = se;
		
		this.addNode(se);
	}
	
	
	public void print(){
		System.out.println("Expression");
		
		if(v != null && e != null){
			v.print();
			e.print();
		}
		else {			
			se.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Extression";
	}

}