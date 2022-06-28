import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Coins getUserInputChoice(){
        int userInputChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println (
                "\n1.Dollars to Shekels" +
                "\n2.Shekels to Dollars" +
                "\nPlease choose an option (1/2): ");
        try {
            userInputChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Choice, please try again");
            return getUserInputChoice();
        }
        switch (userInputChoice){
            case 1:
                return Coins.ILS;
            case 2:
                return  Coins.USD;
            default:
                System.out.println("Invalid Choice, please try again");
                return  getUserInputChoice();
        }
    }
    private static double getUserInputValue(){
        double userInputValue;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an amount to convert: ");
        try {
            userInputValue = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Choice, please try again");
            return getUserInputValue();
        }
        if (userInputValue >= 0) {
            System.out.println("selected choice: " + userInputValue);
            return userInputValue;
        }else{
            System.out.println("Invalid Choice, please try again");
            return getUserInputValue();
        }
        }

    private static UserFinalChoice getUserInputFinalChoiceValue() {
        String userInputChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Do you want to start over? (Y/N)");
        try {
            userInputChoice = scanner.next().toUpperCase();
        }catch (Exception e){
            System.out.println("Invalid Choice, please try again");
            return getUserInputFinalChoiceValue();
        }

        switch (userInputChoice){
            case "Y":
                return UserFinalChoice.Y;
            case "N":
                return UserFinalChoice.N;
            default:
                System.out.println("Invalid Choice, please try again");
                return  getUserInputFinalChoiceValue();

        }
    }






    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to currency converter");

        ArrayList<Coin> coins = new ArrayList<>();
        Coins userInputChoiceValue;
        double userInputValue;
        Coin tempCoin;
        final DecimalFormat df = new DecimalFormat("0.00");
        double tempResult;
        UserFinalChoice userFinalChoiceValue = UserFinalChoice.Y;

        while (userFinalChoiceValue == UserFinalChoice.Y){
             userInputChoiceValue  = getUserInputChoice();
             userInputValue = getUserInputValue();
             tempCoin = CoinsFactory.getCoinInstance(userInputChoiceValue);
            assert tempCoin != null;
            tempResult = tempCoin.calculate(userInputValue);
             coins.add(tempCoin);
             System.out.println("Result: " + df.format(tempResult));
            userFinalChoiceValue = getUserInputFinalChoiceValue();

        }

        System.out.println("Thanks for using our currency converter");
        StringBuilder textResult = new StringBuilder();
        for (Coin coin: coins
             ) {

            textResult.append(coin.getConversionResult()).append("\n");
        }
        System.out.println(textResult);
        String filePath = ".results.txt";
        Files.writeString(Paths.get(filePath), textResult.toString());
        System.out.println("Results are saved in: "+ filePath);
    }
}
