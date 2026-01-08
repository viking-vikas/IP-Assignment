import java.util.Random;
import java.util.Scanner;

public class JackPot {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    System.out.println("JACKPOT NUMBER GUESSING GAME");
    System.out.println("Choose Difficulty Level:");
    System.out.println("1. Easy (20 attempts)");
    System.out.println("2. Medium (10 attempts)");
    System.out.println("3. Difficult (5 attempts)");
    System.out.print("Enter your choice: ");

    int choice = sc.nextInt();
    int attempts = 0;

    switch (choice) {
    case 1:
      attempts = 20;
      System.out.println("You chose EASY mode.");
      break;
    case 2:
      attempts = 10;
      System.out.println("You chose MEDIUM mode.");
      break;
    case 3:
      attempts = 5;
      System.out.println("You chose DIFFICULT mode.");
      break;
    default:
      System.out.println("Invalid choice! Defaulting to EASY mode.");
      attempts = 20;
    }

    int secretNumber = rand.nextInt(100) + 1;

    System.out.println("Guess the number between 1 and 100!");

    boolean won = false;

    for (int i = 1; i <= attempts; i++) {
      System.out.print("Attempt " + i + "/" + attempts +
                       " → Enter your guess: ");
      int guess = sc.nextInt();

      if (guess == secretNumber) {
        System.out.println("Congratulations You guessed the correct number");
        System.out.println("You won in " + i + " attempts!");
        won = true;
        break;
      } else if (guess > secretNumber) {
        System.out.println("Too high!");
      } else {
        System.out.println("Too low!");
      }
    }

    if (!won) {
      System.out.println("You ran out of attempts!");
      System.out.println("The correct number was: " + secretNumber);
    }

    System.out.println("Thanks for playing the Jackpot Game!");
    sc.close();
  }
}
