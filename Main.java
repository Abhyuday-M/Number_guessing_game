import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Rules:");
        System.out.println("1. The computer will randomly select a number between 1 and 100.");
        System.out.println("2. You have to guess the correct number.");
        System.out.println("3. You will select a difficulty level which determines how many chances you have.");
        System.out.println("Let's begin!");

        // Select difficulty level
        int numberOfChances = 0;
        while (true) {
            System.out.println("\nSelect difficulty level (type 1, 2, or 3):");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (7 chances)");
            System.out.println("3. Hard (5 chances)");
            int difficulty = scanner.nextInt();

            if (difficulty == 1) {
                numberOfChances = 10;
                break;
            } else if (difficulty == 2) {
                numberOfChances = 7;
                break;
            } else if (difficulty == 3) {
                numberOfChances = 5;
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid difficulty level.");
            }
        }

        // Generate random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("\nI have selected a number between 1 and 100. Try to guess it!");

        // Loop for the number of chances
        for (int i = 1; i <= numberOfChances; i++) {
            System.out.print("Attempt " + i + ": ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                hasWon = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is greater than " + userGuess + ".");
            } else {
                System.out.println("The number is less than " + userGuess + ".");
            }

            if (i == numberOfChances) {
                System.out.println("Sorry! You've run out of chances.");
            }
        }

        // Game result
        if (hasWon) {
            System.out.println("\nCongratulations! You've guessed the correct number.");
            System.out.println("It took you " + attempts + " attempts to guess the number.");
        } else {
            System.out.println("The correct number was " + numberToGuess + ". Better luck next time!");
        }

        scanner.close();
    }
}
