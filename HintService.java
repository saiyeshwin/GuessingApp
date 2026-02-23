//Use Case 3: Hint Generation
//This class is responsible for generating contolled hints based on no of incorrect attempts by player
//It reveals partial information without revealing exact number
class HintService{
	public static String generateHint(int target, int hintCount){
		if(hintCount == 1){
			return (target%2 == 0)
				? "Hint: Number is Even"
				: "Hint: Number is ODD";
		}
		else if (hintCount == 2){
			return (target > 50)
				? "Hint: Number is greater than 50"
				: "Hint: Number is 50 or less";
		}
		
		return "No more hints available";
	}
}