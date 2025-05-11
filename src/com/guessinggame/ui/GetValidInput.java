package com.guessinggame.ui;

import java.util.Scanner;

import com.guessinggame.util.Colors;

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
   * @return the valid response
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

  public static int selectDifficultyLevel(Scanner scanner) {

    System.out.println("""
        1. easy: (unlimited tries)[1-10]
        2. medium: (5 tries)(1-50)
        3. hard: (3 tries)(1-100)
        """);
        
    int difficultyLevel;
    while (true) {
      System.out.print("Select difficulty level: ");
      difficultyLevel = getValidNumber(scanner);
      switch (difficultyLevel) {
        case 1 -> {
          return 1;
        }
        case 2 -> {
          return 2;
        }
        case 3 -> {
          return 3;
        }
        default -> System.out.println("Select valid difficulty level");
      }
    }
  }
}
