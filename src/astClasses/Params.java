package astClasses;

import symbolTable.Symbol;

public class Params extends AbstractSyntaxTreeNode {
	ParamList pl;
	
	public Params() {
		this.pl = null;
	}
	
	public Params(ParamList pl) {
		this.pl = pl;

		this.addNode(pl);
	}
	
	public void print() {
		if(pl == null) {
			System.out.println("Params: VOID");
		}
		else {			
			System.out.println("Params");
			
			pl.print();
		}
		
		
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		
		if(pl == null) {			
			return "Params: VOID";
		}
		else {
			return "Params";
		}
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		if( pl!= null)
		{
			pl.checkSemantic(context);
		}
		
		return false;
	}
}
