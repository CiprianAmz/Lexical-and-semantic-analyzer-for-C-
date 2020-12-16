package astClasses;

public class ErrorTypeSpecifier extends TypeSpecifier {
	String errorType;
	
	public ErrorTypeSpecifier(String errorType) {
		super("");
		this.errorType = errorType;
	}
	
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "! Error: " + errorType;
	}
	
	public void print(){
		System.out.println("! Error: " + errorType);
	}
}
