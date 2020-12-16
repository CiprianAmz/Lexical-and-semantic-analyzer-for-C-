package astClasses;

public class ErrorExpressionStmt extends Expression {
	String errorType;
	
	public ErrorExpressionStmt(String errorType) {
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
