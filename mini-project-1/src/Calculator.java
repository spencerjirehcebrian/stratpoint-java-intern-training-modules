import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static int addition(int first_num, int second_num) {
        return first_num + second_num;
    }

    public static int subtraction(int first_num, int second_num) {
        return first_num - second_num;
    }

    public static int multiplication(int first_num, int second_num) {
        return first_num * second_num;
    }

    public static int division(int first_num, int second_num) {

        return first_num / second_num;
    }

    public static int calculate(int first_num, int second_num, String operator) throws Exception {
        return switch (operator) {
            case "+" -> addition(first_num, second_num);
            case "-" -> subtraction(first_num, second_num);
            case "/" -> division(first_num, second_num);
            case "*" -> multiplication(first_num, second_num);
            default -> throw new Exception("Invalid Operator");
        };
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.print("Enter first number: ");
                int first_num = Integer.parseInt(myScanner.nextLine());

                System.out.print("Enter second number: ");
                int second_num = Integer.parseInt(myScanner.nextLine());

                System.out.print("Enter Calculation: (+-/*): ");
                String operation = myScanner.nextLine();

                int answer = calculate(first_num, second_num, operation);
                System.out.println("Answer: " + answer);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

            System.out.print("Do you want to restart? (Y/n)");
            String continueQuery = myScanner.nextLine();
            if (Objects.equals(continueQuery, "n")) {
                break;
            }

        }


    }
}
