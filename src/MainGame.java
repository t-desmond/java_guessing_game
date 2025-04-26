import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class MainGame {
    public static String play(int MAX_ATTEMPTS, Scanner scanner) {
        Random random = new Random();

        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        int numberOfAttemptsMade = 0;
        for (int i = 0; i <= MAX_ATTEMPTS; i++) {
            System.out.print(Colors.BLUE + "Enter the number:  " + Colors.RESET);
            int userInput = GetValidInput.getValidNumber(scanner);
            if (userInput == randomNumber) {
                System.out.println(Colors.GREEN + "you win" + Colors.RESET);
                break;
            } else {
                if (i < MAX_ATTEMPTS) {
                    if (userInput > randomNumber) {
                        System.out.println(
                                Colors.RED + "Too big, " + Colors.BOLD + (MAX_ATTEMPTS - i) + Colors.RESET + Colors.RED
                                        + " tries left" + Colors.RESET);
                    } else {
                        System.out
                                .println(Colors.RED + "Too small, " + Colors.BOLD + (MAX_ATTEMPTS - i) + Colors.RESET
                                        + Colors.RED
                                        + " tries left" + Colors.RESET);
                    }
                } else {
                    System.out.println(Colors.RED + "you loose, correct guess was: " + Colors.BOLD + randomNumber
                            + Colors.RESET + Colors.RESET);
                }
            }
            numberOfAttemptsMade = i;
        }
        String gameResult = String.format("Succeeded in %d attempts", numberOfAttemptsMade + 1);
        System.out.println(gameResult);
        return gameResult;
    }

    public static Path playAndSave(int MAX_ATTEMPTS, Scanner scanner) {
        String gameResults = MainGame.play(MAX_ATTEMPTS, scanner);
        return saveToFile(gameResults);
    }

    private static Path saveToFile(String result) {
        try {
            Path path = Files.createTempFile("gameResults", ".log");
            Files.write(path, result.getBytes());
            path.toFile().deleteOnExit();
            return path;
        } catch (IOException e) {
            System.out.println("Failed to save game result.");
            e.printStackTrace();
            return null;
        }

    }
    
    public static void readResults(Path result) {

        System.out.println();
        if (result != null) {
            try {
                String contents = Files.readString(result);
                System.out.println("=== Game Results ===");
                System.out.println(contents);
            } catch (IOException e) {
                System.out.println("Could not read from file.");
                e.printStackTrace();
            }
        }
    }
}
