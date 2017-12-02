package length_checking;

public class OperandsLengthChecker {
    private int firstOperandLength;
    private int secondOperandLength;

    public OperandsLengthChecker(int firstOperandLength, int secondOperandLength) {
        this.firstOperandLength = firstOperandLength;
        this.secondOperandLength = secondOperandLength;
    }

    public void setFirstOperandLength(int firstOperandLength) {
        this.firstOperandLength = firstOperandLength;
    }

    public void setSecondOperandLength(int secondOperandLength) {
        this.secondOperandLength = secondOperandLength;
    }

    public boolean isLengthFirstOperandGreater(){
        return firstOperandLength > secondOperandLength;
    }

    public boolean isLengthsOperandsEqual(){
        return firstOperandLength == secondOperandLength;
    }
}
