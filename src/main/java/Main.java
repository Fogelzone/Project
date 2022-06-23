import java.io.InputStream;
import java.security.spec.ECField;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static double getUserInputValue() {
        System.out.println("Welcome to currency converter");
        String userInputValue = "";
        int userInputChoice = 0;
        double inputValue = -1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option (1/2): "
                               + "\n1.Dollars to Shekels"
                               + "\n2.Shekels to Dollars");

            userInputChoice = scanner.nextInt();
            try {
                if (1 <= userInputChoice && userInputChoice <= 2) {
                    System.out.print("Please enter an amount to convert: ");
                } else {
                    System.out.println("Please choose 1 or 2");
                  return userInputChoice;
                 }
                } catch (InputMismatchException e){
            }



            userInputValue = scanner.next();
            try {
                if (Double.parseDouble(userInputValue) > 0) {
                    inputValue = Double.parseDouble(userInputValue);
                    return inputValue;
                } else {
                    System.out.println("Please insert a positive number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Don't be a smart ass");
            } catch (Exception e) {
                System.out.println("No idea what has just happened, need to debug\nError:" + e);
            }
        }
    }

    public static void main(String[] args) {
        ILS ils = new ILS();
        double inputValue = getUserInputValue();
        double resultIls = ils.calculate(inputValue);
        double resultPrintIls = Math.round(resultIls * 100.0) / 100.0;
        System.out.println("result = " + resultPrintIls);
    }

}
