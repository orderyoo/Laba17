import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();
        try {
            double result = calculate(expression);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
    public static double calculate(String expression) {
        double result = 0;
        char operator = '+';
        int currentIndex = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                double operand = Double.parseDouble(expression.substring(currentIndex, i));
                result = performOperation(result, operand, operator);
                operator = ch;
                currentIndex = i + 1;
            }
        }

        double lastOperand = Double.parseDouble(expression.substring(currentIndex));
        result = performOperation(result, lastOperand, operator);

        return result;
    }
    public static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Недопустимый оператор");
        }
    }
}
