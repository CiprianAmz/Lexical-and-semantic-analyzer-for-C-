package symbolTable;

public enum ESymbolType {
	Scope(0),
	VOIDfunc(1),
	VOID(2),
	INT(3),
	INTarray(4),
	INTfunc(5),
	Error(6);
	
    private final int value;
    private ESymbolType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
