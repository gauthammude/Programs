import java.util.Scanner;

public class BasicExpressionEvaluator {
    private static int index;
    private static String input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a mathematical expression:");
        String rawInput = scanner.nextLine().replaceAll(" ", ""); // remove spaces
        input = insertImplicitMultiplication(rawInput);
        index = 0;

        try {
            int result = parseExpression();
            if (index != input.length()) {
                throw new RuntimeException("Unexpected character at position " + index);
            }
            System.out.println("Result: " + result);
        } catch (RuntimeException e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }

        scanner.close();
    }

    // Insert '*' between digit and '(' for implicit multiplication
    private static String insertImplicitMultiplication(String expr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);
            sb.append(current);
            if (i < expr.length() - 1) {
                char next = expr.charAt(i + 1);
                // if current is digit or ')' and next is '(' then insert '*'
                if ((Character.isDigit(current) || current == ')') && next == '(') {
                    sb.append('*');
                }
            }
        }
        return sb.toString();
    }

    // Handles '+' and '-'
    private static int parseExpression() {
        int value = parseTerm();
        while (index < input.length()) {
            char op = input.charAt(index);
            if (op == '+') {
                index++;
                value += parseTerm();
            } else if (op == '-') {
                index++;
                value -= parseTerm();
            } else {
                break;
            }
        }
        return value;
    }

    // Handles '*', '/', '%'
    private static int parseTerm() {
        int value = parseFactor();
        while (index < input.length()) {
            char op = input.charAt(index);
            if (op == '*') {
                index++;
                value *= parseFactor();
            } else if (op == '/') {
                index++;
                int divisor = parseFactor();
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                value /= divisor;
            } else if (op == '%') {
                index++;
                int divisor = parseFactor();
                if (divisor == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                value %= divisor;
            } else {
                break;
            }
        }
        return value;
    }

    // Handles numbers, negative signs, and parentheses
    private static int parseFactor() {
        if (index >= input.length()) {
            throw new RuntimeException("Unexpected end of expression");
        }

        char ch = input.charAt(index);

        // Handle negative numbers
        if (ch == '-') {
            index++;
            return -parseFactor();
        }

        // Handle parentheses
        if (ch == '(') {
            index++;
            int value = parseExpression();
            if (index >= input.length() || input.charAt(index) != ')') {
                throw new RuntimeException("Missing closing parenthesis");
            }
            index++; // Consume ')'
            return value;
        }

        // Handle numeric values
        int start = index;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }

        if (start == index) {
            throw new RuntimeException("Expected number at position " + index);
        }

        return Integer.parseInt(input.substring(start, index));
    }
}
