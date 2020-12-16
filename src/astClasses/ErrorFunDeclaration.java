package astClasses;

public class ErrorFunDeclaration extends FunDeclaration {
	String errorType;
	
	public ErrorFunDeclaration(String errorType) {
		super(null, "", null, null); 
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
