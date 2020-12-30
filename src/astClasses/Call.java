package astClasses;

import symbolTable.ESymbolType;
import symbolTable.Symbol;

public class Call extends AbstractSyntaxTreeNode {
	Args a;
	String ID;
	
	public Call(Args a, String ID){
		this.a = a;
		this.ID = ID;
		
		this.addNode(a);
	}
	
	public void print(){
		System.out.println("Call");
		
		a.print();
	}

	@Override
	public String getNodeType() {
		return "Call: " + ID;
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		boolean returnINT = true;
		Symbol func = context.searchSymbol(ID);
		
		if(func == null) {
			semanticErrors.add("Error: Function not found - " + ID);
			return true;
		}
		else if(func.getType().getValue() == ESymbolType.INTfunc.getValue()){
			returnINT = true;
		}
		else if(func.getType().getValue() == ESymbolType.VOIDfunc.getValue()){
			returnINT = false;
		}	
		
		if(this.a.al == null && func.getArgumentsNumber() > 0) {
			semanticErrors.add("Error: Invalid arguments for function " + ID); 
		}
		else if(this.a.al != null){
			if(this.a.al.eList.size() != func.getArgumentsNumber()) {
				semanticErrors.add("Error: Invalid arguments for function " + ID); 
			}
		}
		
		this.a.checkSemantic(context);
		
		return returnINT;
	}

}