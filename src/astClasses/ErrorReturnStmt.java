package astClasses;

public class ErrorReturnStmt extends ReturnStmt {
	String errorType;
	
	public ErrorReturnStmt(String errorType) {
		super();
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
