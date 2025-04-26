import java.util.Scanner;

public class MainGame {
  public static void play(int MAX_ATTEMPS, int randomNumber, Scanner scanner) {
    for (int i = 0; i <= MAX_ATTEMPS; i++) {
      System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
      int userInput = GetValidInput.getValidNumber(scanner);
      if (userInput == randomNumber) {
          System.out.println(Colors.GREEN + "you win" + Colors.RESET);
          break;
      } else {
          if (i < MAX_ATTEMPS) {
              if (userInput > randomNumber) {
                  System.out.println(
                          Colors.RED + "Too big, " + Colors.BOLD + (MAX_ATTEMPS - i) + Colors.RESET + Colors.RED
                                  + " tries left" + Colors.RESET);
              } else {
                  System.out
                          .println(Colors.RED + "Too small, " + Colors.BOLD + (MAX_ATTEMPS - i) + Colors.RESET
                                  + Colors.RED
                                  + " tries left" + Colors.RESET);
              }
          } else {
              System.out.println(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber
                      + Colors.RESET + Colors.RESET);
          }
      }
  }
  }
}
