import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static final int MAX_ATTEMPS = 3;

    public static void main(String[] args) {

        System.out.println(Colors.YELLOW + Colors.BOLD + "WELCOME TO GUESSING GAME" + Colors.RESET);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(10);
        System.out.println(randomNumber);

        MainGame.play(MAX_ATTEMPS, randomNumber, scanner);
        scanner.close();
    }
}
