package mru.tsc.exceptions;

/**
 * This is custom exception class for when the minimum players entered exceeds the maximum players entered
 * @author Anmol Verma
 */
public class MinMaxPlayersException extends Exception{

	// Message to be displayed when the exception is thrown
	private String message;
	
	/**
	 * Constructor for the exception
	 */
	public MinMaxPlayersException() {
		super();
		this.message = "\nThe miniumum number of players cannot be greater than the maximum number of players. Try again.";
	}
	
	// The toString method is overridden to display the message 
	public String toString() {
		return this.message;
	}
}
