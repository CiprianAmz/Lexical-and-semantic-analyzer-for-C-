package symbolTable;

import java.util.ArrayList;

public class Symbol {
	// in case of generic symbol
	private String name = null;
	private ESymbolType type = ESymbolType.INT;
	Symbol ref = null;

	private int argumentsNumber = 0;//in case of a func

	// in case of a scope object in table
	private ArrayList<Symbol> symbolTable = new ArrayList<>();
	
	public Symbol(ESymbolType type) {
		this.setType(type);
	}
	
	public Symbol(String name, ESymbolType type) {
		this.setName(name);
		this.setType(type);
	}
	
	public Symbol(String name, ESymbolType type, int argumentsNumber) {
		this.setName(name);
		this.setType(type);
		this.setArgumentsNumber(argumentsNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ESymbolType getType() {
		return type;
	}

	public void setType(ESymbolType type) {
		this.type = type;
	}
	
	public int getArgumentsNumber() {
		return argumentsNumber;
	}

	public void setArgumentsNumber(int argumentsNumber) {
		this.argumentsNumber = argumentsNumber;
	}

	public Symbol getRef() {
		return ref;
	}

	public void setRef(Symbol ref) {
		this.ref = ref;
	}
	
	public Symbol SearchSymbol(String SymbolName) {
		Symbol current_refSym = this;
		while(current_refSym != null) {
			if(current_refSym.getName() != null) {
				if(current_refSym.getName().equals(SymbolName)) {
					return current_refSym;
				}
			}
			
			for(Symbol symbol:current_refSym.symbolTable) {
				if(symbol.getName() != null) {
					if(symbol.getName().equals(SymbolName)) {
						return symbol;
					}
				}
			}
			
			current_refSym = current_refSym.ref;
		}
		
		return null; //returns null if the symbol does not exist in the current scope
	}
	
	public ESymbolType getCurrentScopeFunctionType() {
		Symbol current_refSym = this;
		while(current_refSym != null) {
			if(current_refSym.getType().getValue() == ESymbolType.INTfunc.getValue() 
			|| current_refSym.getType().getValue() == ESymbolType.VOIDfunc.getValue() ) {
				return current_refSym.getType();
			}
			
			current_refSym = current_refSym.ref;
		}
		
		return null;
	}
	
	public boolean addSymbol(Symbol symbol) {
		if(symbol.type == ESymbolType.Scope
		|| this.SearchSymbol(symbol.getName()) == null) {			
			this.symbolTable.add(symbol);
			symbol.setRef(this);
			return true;
		}
		else {
			return false;//symbol already exists
		}
	}
	
	public boolean checkOperation(String operation, String SymbolName) {
		Symbol sym = SearchSymbol(SymbolName);
		
		switch(operation) {
			case "addop":
			case "mulop":
			case "relop":
				if(sym.getType().getValue() != ESymbolType.VOIDfunc.getValue() 
				&& sym.getType().getValue() != ESymbolType.Scope.getValue()) {
					return true;
				}
				else {
					return false;
				}
			case "assign":
				if(sym.getType().getValue() != ESymbolType.VOIDfunc.getValue()
				&& sym.getType().getValue() != ESymbolType.INTfunc.getValue()
				&& sym.getType().getValue() != ESymbolType.Scope.getValue()) {
					return true;
				}
				else {
					return false;
				} 
			default:
				if(sym.getType().getValue() != ESymbolType.VOIDfunc.getValue()
				&& sym.getType().getValue() != ESymbolType.Scope.getValue()) {
					return true;
				}
				else {
					return false;
				} 	
		}
	}
}
