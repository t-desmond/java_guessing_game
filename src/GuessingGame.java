import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        MainGame.initSessionFile();
        System.out.println(Colors.YELLOW + Colors.BOLD + "\nWELCOME TO GUESSING GAME" + Colors.RESET);

        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println();
            Menu.printMenu();
            Menu.menuChoice(MAX_ATTEMPTS, scanner);

            keepPlaying = GetValidInput.getValidContinueResponse(scanner);
            if (!keepPlaying) {
                System.out.println(Colors.RED + "\nExited the game. Goodbye!" + Colors.RESET);
            }
        }

        scanner.close();
    }
}
