package astClasses;

public class Program extends AbstractSyntaxTreeNode {
	DeclarationList dl;
	
	public Program(DeclarationList dl) {
		this.dl = dl;
		
		this.addNode(dl);
	}
	
	public void print() {
		System.out.println("Program");
		
		dl.print();
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "Program";
	}
}
