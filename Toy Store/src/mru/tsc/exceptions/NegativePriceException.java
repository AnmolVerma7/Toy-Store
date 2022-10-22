package mru.tsc.exceptions;

/**
 * This is custom exception class for when the user enters a negative price
 * @author Anmol Verma
 */
public class NegativePriceException extends Exception {
	
	// Message to be displayed when the exception is thrown
	private String message;
	
	/**
	 * Constructor for the exception
	 */
	public NegativePriceException(){
		super();
		this.message = "\nThe toy price cannot be negative. Please enter a valid price in the form (##.##).";
	}
	  
	// The toString method is overridden to display the message  
	public String toString(){
		return this.message;
	}
}
