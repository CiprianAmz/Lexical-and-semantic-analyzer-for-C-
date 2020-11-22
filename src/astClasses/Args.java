package astClasses;

public class Args extends AbstractSyntaxTreeNode {
	ArgList al;
	
	public Args(ArgList al){
		this.al = al;
		
		this.addNode(al);
	}
	public Args() {
	
	}
	
	public void print(){
		System.out.println("Call");
		
		if( al != null){
			al.print();
		}
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Args";
	}

}