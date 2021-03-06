package astClasses;

public class ErrorIterationStmt extends IterationStmt {
	String errorType;
	
	public ErrorIterationStmt(String errorType) {
		super(null, null);
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
