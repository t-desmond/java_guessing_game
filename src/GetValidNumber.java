import java.util.Scanner;

public class GetValidNumber {
  public static int getValidNumber(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      System.out.println("enter a valid integer");
      scanner.next();
    }
    return scanner.nextInt();
  }
}
