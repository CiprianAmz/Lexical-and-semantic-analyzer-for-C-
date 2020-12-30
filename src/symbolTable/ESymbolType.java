package symbolTable;

public enum ESymbolType {
	Scope(0),
	VOIDfunc(1),
	INT(2),
	INTarray(3),
	INTfunc(4),
	Error(5);
	
    private final int value;
    private ESymbolType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
