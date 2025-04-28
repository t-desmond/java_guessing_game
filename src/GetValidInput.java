import java.util.Scanner;

public class GetValidInput {
  /**
   * Repeatedly prompts the user for input until a valid integer is entered
   * 
   * @param scanner scanner object used to read user input from standard
   *                input
   * @return a valid integer entered by the user
   */
  public static int getValidNumber(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      System.out.print(Colors.PURPLE + "\nEnter a valid integer: " + Colors.RESET);
      scanner.next();
    }
    return scanner.nextInt();
  }

  /**
   * Prompts the user at the end of a session to decide whether to continue or
   * exit.
   * Continues looping until the user enters a valid response ("yes" or "no").
   * 
   * @param scanner scanner object used to read user input from standard
   *                input
   * @return
   */
  public static boolean getValidContinueResponse(Scanner scanner) {
    String boldYes = Colors.BOLD + "yes";
    String boldNo = Colors.BOLD + "no";

    System.out.printf(
        Colors.CYAN + "\nDo you want to continue: [%s|%s" + Colors.RESET + Colors.CYAN + "]: " + Colors.RESET, boldYes,
        boldNo);
    String response = scanner.next().toLowerCase();

    while (!response.equals("yes") && !response.equals("no")) {
      System.out.printf(
          Colors.PURPLE + "\nEnter a valid response: [%s|%s" + Colors.RESET + Colors.PURPLE + "]: " + Colors.RESET,
          boldYes, boldNo);
      response = scanner.next().toLowerCase();
    }

    return response.equals("yes");
  }

}
