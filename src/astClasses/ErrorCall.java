package astClasses;

public class ErrorCall extends Call {
	String errorType;
	
	public ErrorCall(String errorType) {
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
