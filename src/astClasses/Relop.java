package astClasses;

public class Relop extends AbstractSyntaxTreeNode {
	String type;
	
	public Relop (String type){
		this.type = type;
	}
	
	public void print(){
		System.out.println("Relop :" + type);
	
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return type;
	}

}