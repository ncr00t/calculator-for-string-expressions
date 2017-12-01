package length_checking;

public class OperandsLengthChecker {
    private int firstOperandLength;
    private int secondOperandLength;

    public OperandsLengthChecker(int firstOperandLength, int secondOperandLength) {
        this.firstOperandLength = firstOperandLength;
        this.secondOperandLength = secondOperandLength;
    }

    public int getFirstOperandLength() {
        return firstOperandLength;
    }

    public int getSecondOperandLength() {
        return secondOperandLength;
    }

    public boolean isLengthFirstOperandGreater(){
        return firstOperandLength > secondOperandLength;
    }

    public boolean isLengthsOperandsEqual(){
        return firstOperandLength == secondOperandLength;
    }
}
