import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 1;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            System.out.println("\nRound " + rounds + ":");
            int randomNumber = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attempts = 0;
            int maxAttempts = 5;
            int score = 100;
            boolean guessed = false;
            
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    guessed = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("The number is higher than " + guess + ".");
                } else {
                    System.out.println("The number is lower than " + guess + ".");
                }
                
                score -= 20; // Reduce score by 20 points for each wrong attempt
            }
            
            if (!guessed) {
                System.out.println("Sorry! You've used all attempts. The correct number was: " + randomNumber);
                score = 0; // No score if not guessed within max attempts
            }
            
            System.out.println("Your score for this round: " + score);
            totalScore += score;
            rounds++;
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        System.out.println("\nGame Over! Total rounds played: " + (rounds - 1));
        System.out.println("Your total score: " + totalScore);
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
}