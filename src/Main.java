import calculator.Calculator;
import parser.ExpressionParser;
import wrapper.Wrapper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ведите выражение, разделяя пробелом(например,  abc + xyz ): ");
        Scanner scanner = new Scanner(System.in);
        String  expression = scanner.nextLine();
        ExpressionParser expressionParser = new ExpressionParser(expression);

        System.out.println("Результат: "+ expression + " = " + expressionParser.parser());

    }


}
