import calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum("xyz", "abc"));
        System.out.println(calculator.subtraction("abcxyzd", "xyz"));
        System.out.println(calculator.multiply("abc", "xyzps"));

    }
}
