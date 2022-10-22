package mru.tsc.model;

public abstract class Toy {
	
	// The Serial Number of the Toy
	private String SN;
	
	// The Name of the Toy
	private String name;
	
	// The Brand of the Toy
	private String brand;
	
	// The price of the Toy
	private double price;
	
	// The Available Count of the Toy
	private int availableCount;
	
	// The Appropriate Age for the Toy
	private int ageAppropriate;
	
	/*
	 * This is the constructor for the Toy class
	 */
	public Toy(String SN, String name, String brand, double price, int availableCount, int ageAppropriate) {
		this.SN = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	}
	
	/**
	 * Gets the type of the toy
	 * @return The type of the toy
	 */
	public abstract String getType();
	
	/**
	 * This method sets the serial number for the toy
	 * @param SN The Serial Number of the Toy
	 */
	public void setSN(String SN) {
		this.SN = SN;
	}
	
	/**
	 * This method gets the serial number of the toy
	 * @return the Serial Number of the Toy
	 */
	public String getSN() {
		return SN; 
	}
	
	/**
	 * This method sets the name of the toy
	 * @param name The name of the toy
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets the name of the toy
	 * @return The name of the toy
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * This method sets the brand of the toy
	 * @param brand The brand of the toy
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * This method gets the brand of the toy
	 * @return The brand of the toy
	 */
	public String getBrand() {
		return brand; 
	}
	
	/**
	 * This method sets the price of the toy
	 * @param price The price of the toy
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 *This method gets the price of the toy 
	 * @return The price of the toy
	 */
	public double getPrice() {
		return price; 
	}
	
	/**
	 * This method sets the available count for the toy
	 * @param availableCount The available count for the toy
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	
	/**
	 * This method gets the available count of the toy 
	 * @return The available count of the toy
	 */
	public int getAvailableCount() {
		return availableCount;
	}
	
	/**
	 * This method sets the age appropriate of the toy
	 * @param ageAppropriate The age appropriate for the toy
	 */
	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
	
	/**
	 * This method gets the age appropriate of the toy
	 * @return The age appropriate of the toy
	 */
	public int getAgeAppropriate() {
		return ageAppropriate;
	}
	
	/**
	 * This method overrides the regular toString method
	 */
	@Override
	public String toString() {
		return  SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate;
	}
	
}
