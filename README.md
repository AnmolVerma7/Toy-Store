/*
# Toy Store - Anmol Verma

## Description

The Toy Store application is a simple console-based Java program that simulates the operations of a toy store. The program allows users to purchase, add, and remove toys&#8203;``oaicite:{"number":1,"metadata":{"title":"Toy-Store/Toy Store/src/mru/tsc/application/AppDriver.java at master · AnmolVerma7/Toy-Store · GitHub","url":"https://github.com/AnmolVerma7/Toy-Store/blob/master/Toy%20Store/src/mru/tsc/application/AppDriver.java","text":"This program lets the user purchase, add, and remove Toys. The changes are then applied to the text file","pub_date":null}}``&#8203;. The changes are then applied to a text file, creating a persistent store of data.

The main functionality of the program is handled by the `AppManager` class, which uses the `AppMenu` class and the `Model` package. The data from a `toys.txt` file is loaded into an ArrayList of type `Toy`&#8203;``oaicite:{"number":2,"metadata":{"title":"Toy-Store/Toy Store/src/mru/tsc/controller/AppManager.java at master · AnmolVerma7/Toy-Store · GitHub","url":"https://github.com/AnmolVerma7/Toy-Store/blob/master/Toy%20Store/src/mru/tsc/controller/AppManager.java","text":"The AppManager class handles the main functionality of the program by using the AppMenu class and Model package","pub_date":null}}``&#8203;.

Each `Toy` object in the program has the following properties:

- Serial Number (SN)
- Name
- Brand
- Price
- Available Count
- Age Appropriate

Each of these properties has associated getter and setter methods. Additionally, there's an abstract method `getType()` that returns the type of the toy&#8203;``oaicite:{"number":3,"metadata":{"title":"Toy-Store/Toy Store/src/mru/tsc/model/Toy.java at master · AnmolVerma7/Toy-Store · GitHub","url":"https://github.com/AnmolVerma7/Toy-Store/blob/master/Toy%20Store/src/mru/tsc/model/Toy.java","text":"public abstract class Toy {  \n\n  // The Serial Number of the Toy  \n  private String SN;  \n\n  // The Name of the Toy  \n  private String name;  \n\n  // The Brand of the Toy  \n  private String brand;  \n\n  // The price of the Toy  \n  private double price;  \n\n  // The Available Count of the Toy  \n  private int availableCount;  \n\n  // The Appropriate Age for the Toy  \n  private int ageAppropriate;  \n\n  /*  \n  * This is the constructor for the Toy class  \n  */  \n  public Toy(String SN, String name, String brand, double price, int availableCount, int ageAppropriate) {  \n  this.SN = SN;  \n  this.name = name;  \n  this.brand = brand;  \n  this.price = price;  \n  this.availableCount = availableCount;  \n  this.ageAppropriate = ageAppropriate;  \n  }  \n\n  /**  \n  * Gets the type of the toy  \n  * @return The type of the toy  \n  */  \n  public abstract String getType();  \n\n  /**  \n  * This method sets the serial number for the toy  \n  * @param SN The Serial Number of the Toy  \n  */  \n  public void setSN(String SN) {  \n  this.SN = SN;  \n  }  \n\n  /**  \n  * This method gets the serial number of the toy  \n  * @return the Serial Number of the Toy  \n  */  \n  public String getSN() {  \n  return SN;   \n  }  \n\n  /**  \n  * This method sets the name of the toy  \n  * @param name The name of the toy  \n  */  \n  public void setName(String name) {  \n  this.name = name;  \n  }  \n\n  /**  \n  * This method gets the name of the toy  \n  * @return The name of the toy  \n  */  \n  public String getName() {  \n  return name;   \n  }  \n\n  /**  \n  * This method sets the brand of the toy  \n  * @param brand The brand of the toy  \n  */  \n  public void setBrand(String brand) {  \n  this.brand = brand;  \n  }  \n\n  /**  \n  * This method gets the brand of the toy  \n  * @return The brand of the toy  \n  */  \n  public String getBrand() {  \n  return brand;   \n  }  \n\n  /**  \n  * This method sets the price of the toy  \n  * @param price The price of the toy  \n  */  \n  public void setPrice(double price) {  \n  this.price = price;  \n  }  \n\n  /**  \n  *This method gets the price of the toy   \n  * @return The price of the toy  \n  */  \n  public double getPrice() {  \n  return price;   \n  }  \n\n  /**  \n  * This method sets the available count for the toy  \n  * @param availableCount The available count for the toy  \n  */  \n  public void setAvailableCount(int availableCount) {  \n  this.availableCount = availableCount;  \n  }  \n\n  /**  \n  * This method gets the available count of the toy   \n  * @return The available count of the toy  \n  */  \n  public int getAvailableCount","pub_date":null}}``&#8203;.

The `Toy` class is abstract, which suggests that it's meant to be extended by other classes that represent specific types of toys. The specific type of each toy is determined by the `getType()` method.

Please refer to the codebase for more detailed information about how each class and method operates.

## Running the Program

To run the program, simply navigate to the directory where the code is stored and run the `AppDriver` class, which contains the main method. Ensure that the `toys.txt` file is in the appropriate location as per the path specified in the `AppManager` class.

## Note

This is a basic version of the application and is not meant for commercial use. It is primarily intended as a learning tool for understanding object-oriented programming and file handling in Java.
*/
