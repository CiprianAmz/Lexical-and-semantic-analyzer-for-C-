package astClasses;

import symbolTable.Symbol;

public class SimpleExpression extends AbstractSyntaxTreeNode {
    AdditiveExpression ae1;
    Relop r;
    AdditiveExpression ae2;


    public SimpleExpression(AdditiveExpression ae1, Relop r , AdditiveExpression ae2){
        this.ae1 = ae1;
        this.r = r;
        this.ae2 = ae2;
        
		this.addNode(ae1);
		this.addNode(r);
		this.addNode(ae2);
    }
    public SimpleExpression(AdditiveExpression ae1){
        this.ae1 = ae1;

		this.addNode(ae1);
    }

    public void print(){
        System.out.println("SimpleExpression");

        ae1.print();
        if( ae2 != null){
            r.print();
            ae2.print();

        }
    }
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "SimpleExpression";
	}
	@Override
	public boolean checkSemantic(Symbol context) {
		boolean returnINT = false;
		
		returnINT = ae1.checkSemantic(context);
		if(ae2 != null) {			
			if(ae2.checkSemantic(context)) {				
				if(returnINT) {					
					return true;
				}
				else {
					semanticErrors.add("Error: Incompatible expression result.");
					return true;
				}
			}
			else {
				semanticErrors.add("Error: Incompatible expression result.");
				return true;
			}	
		}
		
		return returnINT;
	}

}