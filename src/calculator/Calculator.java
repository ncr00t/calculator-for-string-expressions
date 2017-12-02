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
            result += getLastPartOperand(firstOperand, secondOperand);
        }

        return result;
    }

    public String divide(String firstOperand, String secondOperand){
        String divResult = "";
        char[] symbolsFirstOperand = firstOperand.toCharArray();
        char[] symbolsSecondOperand = secondOperand.toCharArray();

        if( isDivider(symbolsFirstOperand, symbolsSecondOperand) ){
            divResult = getDivResult(symbolsFirstOperand, symbolsSecondOperand);
        }else {
            divResult = firstOperand;
        }
        return divResult;
    }

    private String getDivResult(char[] symbolsFirstOperand, char[] symbolsSecondOperand){
        int prevPosition;
        String divResult = "";
        String firstOperand = String.valueOf(symbolsFirstOperand);

        for(int i = 0; i < symbolsFirstOperand.length; i++){
            for(int j = 0 ; j < symbolsSecondOperand.length; j++){
                if(symbolsFirstOperand[i] == symbolsSecondOperand[j]){
                    prevPosition = i - 1;
                    divResult +=  firstOperand.charAt(prevPosition);
                }
            }
        }
        return divResult;
    }

    private String getLastPartOperand(String firstOperand, String secondOperand){
        String result = "";
        operandsLengthChecker = new OperandsLengthChecker(firstOperand.length(),
                                                          secondOperand.length());
        if(operandsLengthChecker.isLengthFirstOperandGreater()){
            result += firstOperand.substring(secondOperand.length());
        } else {
            result += secondOperand.substring(firstOperand.length());
        }
        return result;
    }

    private boolean isDivider(char[] symbolsFirstOperand, char[] symbolsSecondOperand){
        String divider = "";
        String secondOperand = String.valueOf(symbolsSecondOperand);
        for(int i = 0; i < symbolsFirstOperand.length; i++){
            for(int j = 0; j < symbolsSecondOperand.length; j++){
                if(j != i) {
                    if(symbolsFirstOperand[i] == symbolsSecondOperand[j]) {
                        divider += symbolsFirstOperand[i] + "";
                    }
                }
            }
        }
        return divider.equals(secondOperand);
    }
}
