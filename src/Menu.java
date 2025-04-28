import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private static Path lastGameResult = null;

    /**
     * Prints menu for user to make choice
     */
    public static void printMenu() {
        System.out.println(Colors.CYAN + "\n======== MENU ========" + Colors.RESET);
        System.out.println(Colors.GREEN + "1." + Colors.RESET + " Play game");
        System.out.println(Colors.GREEN + "2." + Colors.RESET + " Print result");
        System.out.println(Colors.CYAN + "=======================" + Colors.RESET);
    }

    /**
     * Handles user input
     * 
     * @param MAX_ATTEMPTS the maximum number of attempts allowed
     * @param scanner      scanner object used to read user input from standard
     *                     input
     */
    public static void menuChoice(int MAX_ATTEMPTS, Scanner scanner) {
        System.out.print(Colors.BLUE + "Enter your choice: " + Colors.RESET);
        int choice = GetValidInput.getValidNumber(scanner);

        switch (choice) {
            case 1:
                lastGameResult = MainGame.playAndSave(MAX_ATTEMPTS, scanner);
                break;
            case 2:
                if (lastGameResult == null) {
                    System.out
                            .println(Colors.RED + "\nNo game results found. Please play a game first." + Colors.RESET);
                } else {
                    MainGame.readResults(lastGameResult);
                }
                break;
            default:
                System.out.println(Colors.RED + "Invalid choice. Please select 1 or 2." + Colors.RESET);
        }
    }
}
