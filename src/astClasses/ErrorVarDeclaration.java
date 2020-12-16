package astClasses;

public class ErrorVarDeclaration extends VarDeclaration {

	String errorType;
	
	public ErrorVarDeclaration(String errorType) {
		super(null, "");
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
