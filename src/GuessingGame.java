import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static final int MAX_ATTEMPS = 3;

    public static void main(String[] args) {

        System.out.println(Colors.YELLOW + Colors.BOLD + "WELCOME TO GUESSING GAME" + Colors.RESET);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        for (int i = 0; i <= MAX_ATTEMPS; i++) {
            System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
            int userInput = GetValidInput.getValidNumber(scanner);
            if (userInput == randomNumber) {
                System.out.println(Colors.GREEN + "you win" + Colors.RESET);
                break;
            } else {
                if (i < MAX_ATTEMPS) {
                    if (userInput > randomNumber) {
                        System.out.println(Colors.RED + "Too big, " + Colors.BOLD + (MAX_ATTEMPS - i) + Colors.RESET + Colors.RED
                                + " tries left" + Colors.RESET);
                    } else {
                        System.out
                                .println(Colors.RED + "Too small, " + Colors.BOLD + (MAX_ATTEMPS - i) + Colors.RESET + Colors.RED
                                        + " tries left" + Colors.RESET);
                    }
                } else {
                    System.out.println(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber
                            + Colors.RESET + Colors.RESET);
                }
            }
        }
        scanner.close();
    }
}
