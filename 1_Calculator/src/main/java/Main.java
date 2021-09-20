import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your Expression: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String expressionWithoutSpaces = expression.replaceAll("\\s+", "");


        System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRpn(expressionWithoutSpaces)));
    }
}
