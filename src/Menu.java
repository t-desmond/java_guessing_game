import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
  private static Path lastGameResult = null; // store path here

  public static void printMenu() {
      System.out.println("1. Play game");
      System.out.println("2. Print result");
  }

  public static void menuChoice(int MAX_ATTEMPTS, Scanner scanner) {
      System.out.print("Enter your choice: ");
      int choice = GetValidInput.getValidNumber(scanner);

      switch (choice) {
          case 1:
              lastGameResult = MainGame.playAndSave(MAX_ATTEMPTS, scanner);
              break;
          case 2:
              MainGame.readResults(lastGameResult);
              break;
          default:
              System.out.println("Invalid choice. Please select 1 or 2.");
      }
  }
}
