package astClasses;

public class TypeSpecifier extends AbstractSyntaxTreeNode {
	String type;
	
	public TypeSpecifier(String type) {
		this.type = type;
	}
	
	public void print() {
		System.out.println("Type: " + type);
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return type;
	}
}
