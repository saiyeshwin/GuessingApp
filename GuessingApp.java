// Guessing App Use Case 6 - Game Restart and Exit
// This class coordinates the complete game lifecycle , allowing player to replay or exit gracefully
// Responsibilities: Start a new game, execute the guessing flow, persist game results, restart or exit based on user choice
// @author Developer
// @version 6.0

import java.util.*;
public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to guessing app");
        GameConfig game = new GameConfig();
        game.showRules();
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;
        System.out.print("Enter player name:");
        String player = sc.nextLine();
        boolean win = false;
		boolean restart;
        // Game loop runs until max attempts are reached
		do{
        	while (attempts < game.getMaxAttempts()) {
            	System.out.print("Enter your guess: ");
            	String input = sc.nextLine();
            	int guess;
            	// User input is validated before being used in the game logic.
            	try {
                	guess = ValidationService.validateInput(input);
            	} 
				catch (InvalidInputException e) {
                	// Do not count invalid input as an attempt, just inform and continue
                	System.out.println(e.getMessage());
                	System.out.println(); // blank line for readability
                	continue;
            	}
            	attempts++;
            	String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
            	// A hint is generated only after an incorrect guess and within the allowed hint limit.
            	if (!"CORRECT".equals(result) && hintsUsed < game.getMaxHints()) {
                	hintsUsed++;
                	System.out.println(HintService.generateHint(game.getTargetNumber(), hintsUsed));
            	}
            	System.out.println(result);
            	if ("CORRECT".equals(result)) {
                	win = true;
                	break;
            	}
        	}
        	// Final result is persisted after completion
        	StorageService.saveResult(player, attempts, win);
			restart=GameController.restartGame(sc);
		}while(restart);
    }
}