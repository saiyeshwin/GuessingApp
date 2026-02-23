//Custom exception when user input fails
// This allows game to fail gracefully with a meaningful message

class InvalidInputException extends Exception{
	public InvalidInputException(String message){
		super(message);
	}
}