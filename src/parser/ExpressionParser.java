package parser;

import calculator.Calculator;

public class ExpressionParser {
    private String expression;
    private Calculator calculator;
    private String[] operandsAndOperations;

    public ExpressionParser(String expression) {
        this.calculator = new Calculator();
        this.expression = expression;
    }

    public String parser(){
        String result = "";
        operandsAndOperations = expression.split(" ");

        for (int i = 0; i < operandsAndOperations.length; i++){
            if(isOperator(operandsAndOperations[i])) {
                result += calculate(operandsAndOperations[i], i);
            }
        }
        return result;
    }

    public boolean isOperator(String symbol){
        return (isPlus(symbol) ||
                isMinus(symbol) ||
                isMultiply(symbol) ||
                isDiv(symbol));
    }

    public boolean isOperator(String symbol, String operator){
        return symbol.equals(operator);
    }

    public String calculate(String operator, int operatorIndex){
        String result = "";
        String leftOperand = operandsAndOperations[operatorIndex - 1];
        String rightOperand = operandsAndOperations[operatorIndex + 1];

        if( isPlus(operator) ){
            result += calculator.sum(leftOperand, rightOperand);
        }
        if( isMinus(operator) ){
            result += calculator.subtraction(leftOperand, rightOperand);
        }
        if( isMultiply(operator) ){
            result += calculator.multiply(leftOperand,rightOperand);
        }
        if( isDiv(operator) ){
           result  += calculator.divide(leftOperand,rightOperand);
        }
        return result;
    }

    public boolean isPlus(String symbol){
        return isOperator(symbol, "+");
    }

    public boolean isMinus(String symbol){
        return isOperator(symbol, "-");
    }

    public boolean isMultiply(String symbol){
        return isOperator(symbol, "*");
    }

    public boolean isDiv(String symbol){
        return isOperator(symbol, "/");
    }

    public boolean isOpenedBracket(String symbol){
        return symbol.equals("(");
    }

    public boolean isClosedBracket(String symbol){
        return symbol.equals(")");
    }
}
