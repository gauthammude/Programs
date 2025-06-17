import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with brackets:");
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        boolean isBalanced = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) isBalanced = false;

        if (isBalanced)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        sc.close();
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
