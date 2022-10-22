package mru.tsc.model;

/**
 * This is the class for the figure object of the type Toy
 * @author Anmol Verma
 *
 */
public class Figure extends Toy {
	
	// The Classification of the figure
	private String classification;
	
	// The Type of Object
	private String type = "Figure";
	
	/**
	 * Figure constructor
	 * @param SN Serial Number
	 * @param name Name of Figure
	 * @param brand Brand of Figure
	 * @param price Price of Figure
	 * @param availableCount Available count of Figure 
	 * @param ageAppropriate Appropriate age for Figure
	 * @param classification Classification of Figure
	 */
	public Figure(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String classification ) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.classification = classification;
	}
	
	/**
	 * Sets the classification of the figure
	 * @param classification The classification of the figure
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/**
	 * Gets the classification of the Figure
	 * @return the classification of the figure
	 */
	public String getClassification() {
		return classification;
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
		return   "Category: " + type + ", Serial Number: " + getSN() + ", Name: " + getName() 
				+ ", Brand: " + getBrand() + ", Price: " + getPrice() + ", Available Count: " 
				+ getAvailableCount() + ", Age Appropriate: " + getAgeAppropriate() + ", Classification: " + classification;
	}

	/**
	 * Formats the Figure into the text file
	 * @return formatted string 
	 */
	public String format() {
		return getSN() + ";" + getName() 
		+ ";" + getBrand() + ";" + getPrice() + ";" 
		+ getAvailableCount() + ";" + getAgeAppropriate() + ";" + classification;
	}

	

}
