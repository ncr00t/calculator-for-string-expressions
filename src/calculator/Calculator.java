package calculator;

import length_checking.OperandsLengthChecker;

public class Calculator {
    private OperandsLengthChecker operandsLengthChecker;

    public String sum(String firstOperand, String secondOperand){
        return firstOperand + secondOperand;
    }

    public String subtraction(String firstOperand, String secondOperand){
        String result = "";
        if(firstOperand.endsWith(secondOperand)){
            result = firstOperand.replace(secondOperand, " ");
        } else
            result = firstOperand;
        return result;
    }

    public String multiply(String firstOperand, String secondOperand){
        String result = "";
        char[] symbolsFirstOperand = firstOperand.toCharArray();
        char[] symbolsSecondOperand = secondOperand.toCharArray();
        operandsLengthChecker = new OperandsLengthChecker(firstOperand.length(),
                                                          secondOperand.length());

        for(int i = 0; i < symbolsFirstOperand.length; i++){
            for(int j = 0; j < symbolsSecondOperand.length; j++){
                if(j == i) {
                    result += symbolsFirstOperand[i] + "" +
                              symbolsSecondOperand[j];
                }
            }
        }

        if( !operandsLengthChecker.isLengthsOperandsEqual() ){
            result += getLastPartLine(firstOperand, secondOperand);
        }

        return result;
    }

    public String getLastPartLine(String firstOperand, String secondOperand){
        String result = "";
        if(operandsLengthChecker.isLengthFirstOperandGreater()){
            result += firstOperand.substring(secondOperand.length());
        } else {
            result += secondOperand.substring(firstOperand.length());
        }
        return result;
    }
}
