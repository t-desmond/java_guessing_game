import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int randomNumber = random.nextInt(10);
    System.out.println(randomNumber);

    for (int i = 0; i <= 3; i++) {
      System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
      int userInput = scanner.nextInt();
      if (userInput == randomNumber) {
        System.out.println(Colors.GREEN + "you win" + Colors.RESET);
        break;
      } else {
        if (i < 3) {
          System.out.println(Colors.RED + "wrong guess, "+ Colors.BOLD + (3 - i) + Colors.RESET + Colors.RED + " tries left" + Colors.RESET);
        } else {
          System.out.println(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber + Colors.RESET + Colors.RESET);
        }
      }
    }
    scanner.close();
  }
}
