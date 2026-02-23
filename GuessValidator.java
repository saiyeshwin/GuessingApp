// Guessing App Use Case 2-User Guess Submission
//This class is responsible for validating the guess of user
class GuessValidator{
	public static String validateGuess(int guess, int target){
		if(guess == target){
			return "correct";
		}
		else if(guess < target){
			return "Its Low";
		}
		else return "Its High";
	}
}