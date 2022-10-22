package mru.tsc.model;

public class Animal extends Toy {

	// The Material of the Animal
	private String material;
	
	// The Size of the Animal
	private String size;
	
	// The Type of the Object
	private String type = "Animal";
	
	/**
	 * Animal constructor 
	 * @param SN Serial Number
	 * @param name Name of Animal
	 * @param brand Brand of Animal
	 * @param price Price of Animal
	 * @param availableCount Available count of Animal 
	 * @param ageAppropriate Appropriate age for Animal
	 * @param material Material of the Animal
	 * @param size Size of the Animal 
	 */
	public Animal(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String material, String size) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.material = material;
		this.size = size;
	}
	
	/**
	 * Sets the material of the Animal
	 * @param material The material of the animal
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Gets the material of the Animal
	 * @return the material of the Animal
	 */
	public String getMaterial() {
		return material;
	}
	
	/**
	 * Sets the size of the Animal
	 * @param size The size of the Animal
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * Gets the size of the Animal
	 * @return the size of the Animal
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Gets the type of the object
	 */
	@Override
	public String getType() {
		return type;
	}
	
	/**
	 * Converts the object into a readable format
	 */
	@Override
	public String toString() {
		return  "Category: " + type + ", Serial Number: " + getSN() + ", Name: " + getName() 
				+ ", Brand:" + getBrand() + ", Price: " + getPrice() + ", Available Count: " 
				+ getAvailableCount() + ", Age Appropriate: " + getAgeAppropriate() + ", Material: " 
				+ material + ", Size: " + size;
	}

	/**
	 * Formats the Animal into the text file
	 * @return formatted string 
	 */
	public String format() {
		return getSN() + ";" + getName() 
		+ ";" + getBrand() + ";" + getPrice() + ";" 
		+ getAvailableCount() + ";" + getAgeAppropriate() + ";" + material + ";" + size;
	}
}

