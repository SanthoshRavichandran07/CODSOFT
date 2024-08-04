import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static int totalScore = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }

    private static void playRound() {
        Random random = new Random();
        int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        int attemptsLeft = MAX_ATTEMPTS;
        boolean guessedCorrectly = false;

        System.out.println("A number between " + LOWER_BOUND + " and " + UPPER_BOUND + " has been generated.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

        while (attemptsLeft > 0 && !guessedCorrectly) {
            System.out.println("Enter your guess:");
            int userGuess = scanner.nextInt();

            if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
                System.out.println("Your guess is out of range. Please guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                continue;
            }

            if (userGuess == numberToGuess) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number correctly.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attemptsLeft--;

            if (!guessedCorrectly) {
                System.out.println("Attempts left: " + attemptsLeft);
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
        } else {
            int score = MAX_ATTEMPTS - attemptsLeft;
            totalScore += score;
            System.out.println("Your score for this round is: " + score);
        }
    }
}
