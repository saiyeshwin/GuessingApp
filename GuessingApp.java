// Guessing App Use Case 4- Exception Handling
// This class coordinates game execution while ensuring all user inputs are safely validated before processing
// @author Developer
// @version 4.0

import java.util.*;
public class GuessingApp {
	public static void main(String[] args) throws InvalidInputException{
		System.out.println("Welcome to guessing app");
		GameConfig game = new GameConfig();
		game.showRules();
		
		Scanner sc = new Scanner(System.in);
		int attempts = 0;
		
		while(attempts < game.getMaxAttempts()){
			System.out.print("Enter your guess");
			//int guess = ValidationService.validateInput(sc.nextLine());
			
			String input = sc.nextLine();

            int guess;
            try {
                guess = ValidationService.validateInput(input);
            } catch (InvalidInputException e) {
                // Do not count invalid input as an attempt; just inform and continue
                System.out.println(e.getMessage());
                System.out.println(); // blank line for readability
                continue;
            }

			attempts++;
			
			
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			String hint = HintService.generateHint(game.getTargetNumber(), attempts);
			System.out.println(hint);
			System.out.println(result);
			
			if("correct".equals(result)){
				break;
			}
		}
		
	}
}