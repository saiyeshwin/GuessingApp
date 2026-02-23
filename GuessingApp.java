// Guessing App Use Case 1-Game Initialization
// This class is the entry point
// It initialzes game configuration and displays the rules of game
// No user input or game logic is implemented as of now
// @author Developer
// @version 1.0
import java.util.Random;
public class GuessingApp{
	public static void main(String[] args){
			System.out.println("Welcome to guessing app");
			GameConfig gameConfig=new GameConfig();
			gameConfig.showRules();
		}
}
