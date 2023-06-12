import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("\n" + "Введите выражение: ");
            String expression = scanner.nextLine();
            System.out.println("\n" + Calculator.calculator(Token.toListAndExamination(expression)).get(0));
        }

    }
}
