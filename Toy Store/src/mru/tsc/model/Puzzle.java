package mru.tsc.model;

public class Puzzle extends Toy {

	// The Type of Puzzle of the puzzle
	private String puzzleType;
	
	// The Type of of Object
	private String type = "Puzzle";
	
	/**
	 * Puzzle constructor
	 * @param SN Serial Number
	 * @param name Name of Puzzle
	 * @param brand Brand of Puzzle
	 * @param price Price of Puzzle
	 * @param availableCount Available count of Puzzle 
	 * @param ageAppropriate Appropriate age for Puzzle
	 * @param puzzleType Type of Puzzle of Puzzle
	 */
	public Puzzle(String SN, String name, String brand, double price, int availableCount, int ageAppropriate , String puzzleType) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.puzzleType = puzzleType;
	}
	
	/**
	 * Sets the type of puzzle of the Puzzle
	 * @param puzzleType The PuzzleType of the Puzzle
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	/**
	 * Gets the PuzzleType
	 * @return the PuzzleType of the puzzle
	 */
	public String getPuzzleType() {
		return puzzleType;
	}
	
	/**
	 * Gets the type of the object
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Converts the object into a readable format
	 */
	@Override
	public String toString() {
		return   "Category: " + type + ", Serial Number: " + getSN() + ", Name: " + getName() + ", Brand: " 
				+ getBrand() + ", Price: " + getPrice() + ", Available Count: " + getAvailableCount() 
				+ ", Age Appropriate: " + getAgeAppropriate() + ", Puzzle Type: " + puzzleType;
	}

	/**
	 * Formats the Figure into the text file
	 * @return formatted string 
	 */
	public String format() {
		return getSN() + ";" + getName() 
		+ ";" + getBrand() + ";" + getPrice() + ";" 
		+ getAvailableCount() + ";" + getAgeAppropriate() + ";" + puzzleType;
	}
}
