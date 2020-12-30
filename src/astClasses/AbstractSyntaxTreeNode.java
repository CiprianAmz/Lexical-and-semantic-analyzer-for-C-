package astClasses;

import java.util.ArrayList;
import symbolTable.*;

public abstract class AbstractSyntaxTreeNode {
	ArrayList<AbstractSyntaxTreeNode> subNodes = new ArrayList<>();
	static ArrayList<String> semanticErrors = new ArrayList<>();
	
	public void addNode(AbstractSyntaxTreeNode node) {
		subNodes.add(node);
	}
	
	public void printTree(int level) {
		for(int i = 0; i < level; i++) {
			System.out.print("-");
		}
		
		System.out.print(" " + this.getNodeType() + "\n");
		
		for(AbstractSyntaxTreeNode i : subNodes) {
			if(i == null) {
				continue;
			}
			
			i.printTree(level + 1);
		}
	}
	
	public abstract String getNodeType();
	
	//returns false if there is no type for expression (void) or 1 if there is type (0)
	public abstract boolean checkSemantic(Symbol context);
}
