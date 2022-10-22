package mru.tsc.model;

public class BoardGame extends Toy {
	
	// The Number of players allowed for the Board Game
	private String numOfPlayers;
	
	// The maker of the Board Game
	private String designer; 
	
	// The Type of the Object
	private String type = "Board Game";
	
	/**
	 * Board Game constructor
	 * @param SN Serial Number
	 * @param name Name of the Board Game
	 * @param brand Brand of Board Game
	 * @param price Price of Board Game
	 * @param availableCount Available count of Board Game
	 * @param ageAppropriate Appropriate age for Animal
	 * @param numOfPlayers Number of players allowed for the Board Game
	 * @param designer The designer of the Board Game
	 */
	public BoardGame(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String numOfPlayers, String designer ) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.numOfPlayers = numOfPlayers;
		this.designer = designer;
	}
	
	/**
	 * Sets the number of players of the Board Game
	 * @param numOfPlayers The number of players of the Board Game
	 */
	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	/**
	 * Gets the number of players of the Board Game
	 * @return the number of players of the Board Game
	 */
	public String getNumOfPlayers() {
		return numOfPlayers;
	}
	
	/**
	 * Sets the name of the designer 
	 * @param designer The designer of the Board Game
	 */
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	
	/**
	 * Gets the designer of the Board Game
	 * @return the designer of the Board Game
	 */
	public String getDesigner() {
		return designer;
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
		return  "Category: " + type + ", Serial Number: " + getSN() + ", Name: " + getName() 
				+ ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " 
				+ getAvailableCount() + ", Age Appropriate: " + getAgeAppropriate() + ", Number Of Players: " 
				+ numOfPlayers + ", Designer: " + designer;
	}

	/**
	 * Formats the Animal into the text file
	 * @return formatted string 
	 */
	public String format() {
		return getSN() + ";" + getName() 
		+ ";" + getBrand() + ";" + getPrice() + ";" 
		+ getAvailableCount() + ";" + getAgeAppropriate() + ";" + numOfPlayers + ";" + designer;
	}
}
