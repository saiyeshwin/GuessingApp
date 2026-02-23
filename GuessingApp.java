// Guessing App Use Case 2-User Guess Submission
// It  takes user input for the guess and validates it
// @author Developer
// @version 2.0

import java.util.Scanner;
public class GuessingApp{
	public static void main(String[] args){
		System.out.println("Welcome to guessing app");
		GameConfig game = new GameConfig();
		game.showRules();
		
		Scanner sc = new Scanner(System.in);
		int attempts = 0;
		
		while(attempts < game.getMaxAttempts()){
			System.out.print("Enter your guess");
			int guess = sc.nextInt();
			attempts++;
			
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			System.out.println(result);
			
			if("correct".equals(result)){
				break;
			}
		}
}
