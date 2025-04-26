import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        System.out.println(Colors.YELLOW + Colors.BOLD + "WELCOME TO GUESSING GAME" + Colors.RESET);

        Scanner scanner = new Scanner(System.in);
        
        MainGame.playAndSave(MAX_ATTEMPTS, scanner);

        boolean continueResponse = GetValidInput.getValidContinueResponse(scanner);

        if (continueResponse) {
            MainGame.playAndSave(MAX_ATTEMPTS, scanner);
        } else {
            System.out.println("Exited");
        }
        scanner.close();
    }
}
