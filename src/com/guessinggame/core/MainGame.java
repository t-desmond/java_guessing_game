package com.guessinggame.core;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.guessinggame.ui.GetValidInput;
import com.guessinggame.util.Colors;
import com.guessinggame.model.DifficultyProfile;

public class MainGame {
    /**
     * the path to the temporary file used to store the results of the current game
     * session
     */
    private static Path sessionTempFile;

    /**
     * Main game function where a user is allowed to guess a number for a limmited
     * number of times
     * 
     * 
     * @param MAX_ATTEMPTS the maximum number of attempts allowed
     * @param scanner      scanner object used to read user input from standard
     *                     input
     * @return the result of each game session played by user
     */
    public static String play(Scanner scanner) {
        Random random = new Random();

        
        int numberOfAttemptsMade = 0;
        boolean gameSessionStatusSuccess = false;
        StringBuilder gameResult = new StringBuilder();
        
        DifficultyProfile difficulty = GetValidInput.selectDifficultyLevel(scanner);
        int randomNumber = random.nextInt(difficulty.getMaxNumber()) + 1;
        System.out.println(randomNumber);
        
        for (int i = 1; i <= difficulty.getMaxAttempts(); i++) {
            System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
            int userInput = GetValidInput.getValidNumber(scanner);
            if (userInput == randomNumber) {
                String result = String.format(Colors.GREEN + "you win" + Colors.RESET);
                System.out.println(result);
                gameResult.append(String.format(result + "; "));
                gameSessionStatusSuccess = true;
                break;
            } else {
                if (i < difficulty.getMaxAttempts()) {
                    if (userInput > randomNumber) {
                        String result = String.format(
                                Colors.RED + "Too big, " + Colors.BOLD + (difficulty.getMaxAttempts() - i) + Colors.RESET + Colors.RED
                                        + " tries left" + Colors.RESET);
                        System.out.println(result);
                        gameResult.append(String.format(result + "; "));
                    } else {
                        String result = String
                                .format(Colors.RED + "Too small, " + Colors.BOLD + (difficulty.getMaxAttempts() - i) + Colors.RESET
                                        + Colors.RED
                                        + " tries left" + Colors.RESET);
                        System.out
                                .println(result);
                        gameResult.append(String.format(result + "; "));
                    }
                } else {
                    String result = String
                            .format(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber
                                    + Colors.RESET + Colors.RESET);
                    System.out.println(result);
                    gameResult.append(String.format(result + "; "));
                }
            }
            numberOfAttemptsMade = i;
        }
        if (gameSessionStatusSuccess){
            gameResult.append(String.format(Colors.BOLD + "Succeeded in %d attempts" + Colors.RESET, numberOfAttemptsMade + 1));
        } else {
            gameResult.append("FAILED TO GUESS!!");
        }
        return gameResult.toString();
    }

    /**
     * Plays a game round and saves the result to a temporary file.
     * 
     * @param MAX_ATTEMPTS the maximum number of attempts allowed
     * @param scanner      scanner object used to read user input from standard
     *                     input
     * @return the result of each game session played by user
     */
    public static Path playAndSave(Scanner scanner) {
        String gameResults = MainGame.play(scanner);
        return saveToFile(gameResults);
    }

    /**
     * Initializes a temporary file in memory for the current game session
     * The file is automatically deleted when the game is exited
     * 
     * @return void
     */
    public static void initSessionFile() {
        try {
            sessionTempFile = Files.createTempFile("game_results", ".log");
            sessionTempFile.toFile().deleteOnExit();
        } catch (IOException e) {
            System.out.println("Could not initialize session file.");
            e.printStackTrace();
        }
    }

    /**
     * Saves the result of a game round played by a user to
     * a temporary file in memory
     * 
     * @param result the result of a game round played by the user
     * @return the path to the saved
     */
    private static Path saveToFile(String result) {
        if (sessionTempFile == null) {
            System.out.println("Session file not initialized.");
            return null;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sessionTempFile.toFile(), true))) {
            writer.write(result);
            writer.newLine();
            return sessionTempFile;
        } catch (IOException e) {
            System.out.println("Error writing to session file.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the results of the current game session
     * 
     * @param filePath the path to the file storing the result of the current game
     *                 session
     * @return void
     */
    public static void readResults(Path filePath) {
        if (filePath != null && Files.exists(filePath)) {

            try {

                List<String> lines = Files.readAllLines(filePath);
                System.out.println(Colors.YELLOW + "\n=== Game Results ===" + Colors.RESET);
                
                for (int line = 0; line < lines.size(); line++) {
                    System.out.printf(Colors.PURPLE + "Game %d: " + Colors.RESET + "%s\n", line + 1, lines.get(line));
                }
            } catch (IOException e) {
                System.out.println(Colors.RED + "Error reading the game results." + Colors.RESET);
                e.printStackTrace();
            }
        } else {
            System.out.println(Colors.RED + "No results found or file does not exist." + Colors.RESET);
        }
    }

}
