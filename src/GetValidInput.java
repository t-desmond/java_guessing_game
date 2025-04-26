import java.util.Scanner;

public class GetValidInput {
  public static int getValidNumber(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      System.out.println("enter a valid integer");
      scanner.next();
    }
    return scanner.nextInt();
  }

  public static boolean getValidContinueResponse(Scanner scanner) {

    System.out.print("Do you want to continue: [yes|no] ");
    String response = scanner.next().toLowerCase();

    while (!response.equals("yes") && !response.equals("no")) {
      System.out.println("enter a valid response: [yes|no]");
      scanner.next();
    }
    
    return response.equals("yes");
  }
}
