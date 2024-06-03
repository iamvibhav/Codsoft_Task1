import java.util.Random;
import java.util.Scanner;

public class GuessNo {
    private static final int max_at = 10;
    private static final int lo_bo = 1;
    private static final int up_bo = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean play_again;

        do {
            int target = random.nextInt(up_bo - lo_bo + 1) + lo_bo;
            int attempts = 0;
            boolean guess = false;

            System.out.println("Guess the number between " + lo_bo + " and " + up_bo);

            while (attempts < max_at) {
                System.out.print("Enter your guess (" + (max_at - attempts) + " attempts remaining): ");
                int user_guess = scanner.nextInt();
                attempts++;

                if (user_guess == target) {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    guess = true;
                    break;
                } else if (user_guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guess) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + target + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            play_again = scanner.next().equalsIgnoreCase("yes");

        } while (play_again);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}
