import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    public static String play(int MAX_ATTEMPTS, Scanner scanner) {
        Random random = new Random();

        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        int numberOfAttemptsMade = 0;
        String gameResult = "";

        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
            int userInput = GetValidInput.getValidNumber(scanner);
            if (userInput == randomNumber) {
                String result = String.format(Colors.GREEN + "you win" + Colors.RESET);
                System.out.println(result);
                gameResult += result;
                break;
            } else {
                if (i < MAX_ATTEMPTS) {
                    if (userInput > randomNumber) {
                        String result = String.format(
                                Colors.RED + "Too big, " + Colors.BOLD + (MAX_ATTEMPTS - i) + Colors.RESET + Colors.RED
                                        + " tries left" + Colors.RESET);
                        System.out.println(result);
                        gameResult += result;
                    } else {
                        String result = String
                                .format(Colors.RED + "Too small, " + Colors.BOLD + (MAX_ATTEMPTS - i) + Colors.RESET
                                        + Colors.RED
                                        + " tries left" + Colors.RESET);
                        System.out
                                .println(result);
                        gameResult += result;
                    }
                } else {
                    String result = String
                            .format(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber
                                    + Colors.RESET + Colors.RESET);
                    System.out.println(result);
                    gameResult += result;
                }
            }
            numberOfAttemptsMade = i;
        }
        gameResult.concat(String.format("Succeeded in %d attempts", numberOfAttemptsMade + 1));
        return gameResult;
    }

    /**
     * Plays a game round and saves the result to a temporary file.
     * 
     * @param MAX_ATTEMPTS the maximum number of attempts allowed
     * @param scanner      scanner object used to read user input from standard
     *                     input
     * @return the result of each game session played by user
     */
    public static Path playAndSave(int MAX_ATTEMPTS, Scanner scanner) {
        String gameResults = MainGame.play(MAX_ATTEMPTS, scanner);
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
