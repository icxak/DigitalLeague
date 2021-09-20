import java.util.Stack;

public class Calculator {
    // RPN - Reverse Polish Notation
    public static String ExpressionToRpn(String Expr) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < Expr.length(); i++) {
            priority = getP(Expr.charAt(i));
            if (priority == 0) current += Expr.charAt(i);
            if (priority == 1) stack.push(Expr.charAt(i));

            if (priority > 1) {
                current += ' '; // for splitting numbers on the stack
                while (!stack.empty()) {
                    if (getP(stack.peek()) >= priority) current += stack.pop();
                    else break;

                }
                stack.push(Expr.charAt(i));
            }

        }
        while (!stack.empty()) {
            current += stack.pop();
        }
        return current;
    }

    public static double RPNtoAnswer(String rpn) {
        String operand = "";
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') continue;

            if (getP(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getP(rpn.charAt(i)) == 0) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length())
                        break;
                }
                stack.push(Double.parseDouble(operand));
                operand = "";


            }
            if ((getP(rpn.charAt(i)) > 1)) {
                double a = stack.pop();
                double b = stack.pop();

                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();
    }
    // Operator and operand prioritization
    private static int getP(char token) {
        if (token == '*' || token == '/') {
            return 3;
        } else if (token == '+' || token == '-') {
            return 2;
        } else return 0;

    }
}
