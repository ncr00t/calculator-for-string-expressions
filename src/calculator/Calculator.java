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
            result = firstOperand.replace(secondOperand, "");
        } else
            result = firstOperand;
        return result;
    }

    public String multiply(String firstOperand, String secondOperand){
        String result = "";
        char[] lettersOfFirstOperand = firstOperand.toCharArray();
        char[] lettersOfSecondOperand = secondOperand.toCharArray();
        operandsLengthChecker = new OperandsLengthChecker(firstOperand.length(),
                                                          secondOperand.length());

        for(int i = 0; i < lettersOfFirstOperand.length; i++){
            for(int j = 0; j < lettersOfSecondOperand.length; j++){
                if(j == i) {
                    result += lettersOfFirstOperand[i] + "" +
                              lettersOfSecondOperand[j];
                }
            }
        }

        if( !operandsLengthChecker.isLengthsOperandsEqual() ){
            result += getLastLettersOperand(firstOperand, secondOperand);
        }

        return result;
    }

    public String divide(String firstOperand, String secondOperand){
        String divResult = "";
        char[] lettersOfFirstOperand = firstOperand.toCharArray();
        char[] lettersOfSecondOperand = secondOperand.toCharArray();

        if( isDivider(lettersOfFirstOperand, lettersOfSecondOperand) ){
            divResult = getDivResult(lettersOfFirstOperand,
                                     lettersOfSecondOperand);
            int lengthOfResultWithDivider = divResult.length() +
                                            secondOperand.length();

            if(firstOperand.length() > lengthOfResultWithDivider){
                divResult += getLastLettersOperand(firstOperand, lengthOfResultWithDivider);
            }

        }else {
            divResult = firstOperand;
        }
        return divResult;
    }

    private String getDivResult(char[] lettersOfFirstOperand, char[] lettersOfSecondOperand){
        int prevPosition;
        String divResult = "";
        String firstOperand = String.valueOf(lettersOfFirstOperand);

        for(int i = 0; i < lettersOfFirstOperand.length; i++){
            for(int j = 0 ; j < lettersOfSecondOperand.length; j++){
                if(lettersOfFirstOperand[i] == lettersOfSecondOperand[j]){
                    prevPosition = i - 1;
                    divResult +=  firstOperand.charAt(prevPosition);
                }
            }
        }
        return divResult;
    }

    private String getLastLettersOperand(String firstOperand, String secondOperand){
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

    private String getLastLettersOperand(String firstOperand, int lengthOfResultWithDivider){
        return firstOperand.substring(lengthOfResultWithDivider);
    }

    private boolean isDivider(char[] symbolsFirstOperand, char[] symbolsSecondOperand){
        String divider = "";
        String secondOperand = String.valueOf(symbolsSecondOperand);
        for(int i = 0; i < symbolsFirstOperand.length; i++){
            for(int j = 0; j < symbolsSecondOperand.length; j++){
                if(j != i) {
                    if(symbolsFirstOperand[i] == symbolsSecondOperand[j]) {
                        divider += symbolsFirstOperand[i];
                    }
                }
            }
        }
        return divider.equals(secondOperand);
    }
}
