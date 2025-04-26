import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    System.out.println(randomNumber);

    for (int i = 0; i <= 3; i++) {
      System.out.print("Enter the number:  " );
      int userInput = scanner.nextInt();
      if (userInput == randomNumber) {
        System.out.println("you win");
        break;
      } else {
        if (i < 3) {
          System.out.println("wrong guess, " + (3 - i) + " tries left");
        } else {
          System.out.println("you loose, correct guess was: " + randomNumber);
        }
      }
    }
    scanner.close();
  }
}
