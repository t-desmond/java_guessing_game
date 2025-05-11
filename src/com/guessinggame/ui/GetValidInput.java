package com.guessinggame.ui;

import java.util.Scanner;

import com.guessinggame.util.Colors;
import com.guessinggame.model.DifficultyProfile;

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
  
  public static DifficultyProfile selectDifficultyLevel(Scanner scanner) {
      String easy = Colors.GREEN + Colors.BOLD + "1. Easy   " + Colors.RESET + "(unlimited tries) [1-10]";
      String medium = Colors.YELLOW + Colors.BOLD + "2. Medium " + Colors.RESET + "(5 tries)         [1-50]";
      String hard = Colors.RED + Colors.BOLD + "3. Hard   " + Colors.RESET + "(3 tries)         [1-100]";
  
      System.out.println("\n" + easy + "\n" + medium + "\n" + hard);
  
      while (true) {
          System.out.print("Select difficulty level: ");
          int choice = getValidNumber(scanner);
          switch (choice) {
              case 1 -> {
                  System.out.println(Colors.GREEN + "You selected: EASY\n" + Colors.RESET);
                  return new DifficultyProfile("Easy", 10, Integer.MAX_VALUE);
              }
              case 2 -> {
                  System.out.println(Colors.YELLOW + "You selected: MEDIUM\n" + Colors.RESET);
                  return new DifficultyProfile("Medium", 50, 5);
              }
              case 3 -> {
                  System.out.println(Colors.RED + "You selected: HARD\n" + Colors.RESET);
                  return new DifficultyProfile("Hard", 100, 3);
              }
              default -> System.out.println(Colors.PURPLE + "Select a valid difficulty level (1-3)." + Colors.RESET);
          }
      }
  }
  

}
