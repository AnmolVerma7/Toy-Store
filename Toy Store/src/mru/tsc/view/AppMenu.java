package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.exceptions.MinMaxPlayersException;
import mru.tsc.exceptions.NegativePriceException;

/**
 * This class will be used to show the menus and sub menus to the user
 * In addition, it also validates user input; in some cases using exceptions. 
 * @author Anmol Verma
 *
 */
public class AppMenu {
	
	//Instance variable of scanner that takes input
	private Scanner scanner;
	
	//This is the constructor for the AppMenu object 
	public AppMenu() {
		this.scanner = new Scanner(System.in);
		
	}
	
	/**
	 * This is what is shown when the application starts up
	 */
	public void StoreLogo() {
		System.out.println("************************************************************");
		System.out.println("* \t\tWELCOME TO TOY STORE COMPANY\t\t   *");
		System.out.println("************************************************************\n");
	}
	
	/**
	 * This method serves as the introduction to the app, giving options to the user
	 * @return The option the user makes
	 */
	public int MainMenu() {
		System.out.println("\nHow May We Help You? \n");
		System.out.println("(1)\t Search Inventory and Purchase Toy ");
		System.out.println("(2)\t Add a new toy ");
		System.out.println("(3)\t Remove a toy ");
		System.out.println("(4)\t Save & Exit \n");
		System.out.print("Enter Option: ");
		
		int option = 0;
		while(true) {
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				if(option < 1 || option > 4) {
					System.out.print("\nThat is not a valid option! Try again. \n");
					System.out.print("\nEnter Option: ");
					scanner.nextLine();
				}
				else {
					break;
				}
			}
			else {
				System.out.print("\nThat is NOT an integer number! Try again. \n");
				System.out.print("\nEnter Option: ");
				scanner.nextLine();
			}
		}
		return option;
	}
	
	/**
	 * This method shows the search and buy menu
	 * @return The choice the user makes for the search and and buy menu.
	 */
	public int SearchAndBuyMenu() {
		System.out.println("\nFind Toys With:\n ");
		System.out.println("(1)\t Serial Number(SN) ");
		System.out.println("(2)\t Toy Name ");
		System.out.println("(3)\t Type ");
		System.out.println("(4)\t Back To Main Menu \n");
		System.out.print("Enter Option: ");
		
		int option = 0;
		
		while(true) {
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
				if(option < 1 || option > 4) {
					System.out.print("\nThat is not a valid option! Try again. \n");
					System.out.print("\nEnter Option: ");
					scanner.nextLine();
				}
				else {
					break;
				}
			}
			else {
				System.out.print("\nThat is NOT an integer number! Try again. \n");
				System.out.print("\nEnter Option: ");
				scanner.next();
			}
		}
		return option;
	}
	
	/**
	 * Asks the user to enter the serial number and validates length and digits
	 * @return Validated Serial Number
	 */
	public String EnterSerialNum() {
		System.out.print("\nEnter Serial Number: ");
		String toySerial = scanner.next();
		boolean start = true;
		
		while (start) {
			if (!toySerial.equals("")) {
				if (toySerial.length() != 10) {
					System.out.print("\nThe Serial Number's length MUST be 10 digits! Try again. \n");
					System.out.print("\nEnter Serial Number: ");
					toySerial = scanner.next();
				}
				else {
					for (int i = 0 ; i < toySerial.length(); i++) {
						if (!Character.isDigit(toySerial.charAt(i))) {
							System.out.print("\nThe Serial Number should only contain digits! Try again. \n");
							System.out.print("\nEnter Serial Number: ");
							toySerial = scanner.next();
						}
						else {
							start = false;
						}
					}	
				}
			}
		}
		return toySerial;
	}
	
	/**
	 * Asks the user to enter the name of the Toy
	 * @return Name of Toy
	 */
	public String EnterName() {
		System.out.print("\nEnter Toy Name: ");
		scanner.nextLine();
		String toyName = scanner.nextLine();
		return toyName;
	}
	  
	/**
	 * Asks the user to enter the type of the Toy
	 * @return Validated type for object Toy
	 */
	public String EnterType() {
		System.out.print("\nEnter Toy Type: ");
		scanner.nextLine();
		String toyType = "";
		
		boolean start = true;
		while (start) {
			toyType = scanner.nextLine();
			if ((toyType.toLowerCase().equals("figure")) || (toyType.toLowerCase().equals("animal")) 
					   || (toyType.toLowerCase().equals("puzzle")) || (toyType.toLowerCase().equals("board game"))) {
				start = false;
				return toyType;
			}
			else {
				System.out.print("\nThat is not a valid Type of Toy! Try again. \n");
				System.out.print("\nEnter Toy Type: ");
			}
		}
		return toyType;
	}
	
	/**
	 * Asks the user to enter the brand of the Toy
	 * @return Brand of Toy
	 */
	public String EnterBrand() {
		System.out.print("\nEnter Toy Brand: ");
		String brand = scanner.nextLine();
		return brand;
	}
	
	/**
	 * Asks user to enter the price of the toy, validates that it is a double
	 * and catches exception if price is negative
	 * @return Validated Toy price
	 */
	public double EnterPrice() {
		
		double price = 0;
		boolean start = true;
		
		while (start) {
			System.out.print("\nEnter Toy Price: ");
			if(scanner.hasNextDouble()) {
				price = scanner.nextDouble();
				try {
					boolean result = isPositive(price); 
					
					if(result) {
						start = false;
						return (double) Math.round(price * 100) / 100;
					}

				} catch (NegativePriceException e) {
					System.out.println(e);
					scanner.nextLine();
				}
				
			}
				
			else {
				System.out.print("\nPlease enter a valid price in the form (##.##). \n");
				scanner.nextLine();
			}
		}
		return (double) Math.round(price * 100) / 100;
		
	}
	
	/**
	 * Checks to see if the entered price is negative 
	 * @param price The price to be checked 
	 * @return True if the price entered is positive
	 * @throws NegativePriceException Throws exception if the price that is being checked is negative
	 */
	public static boolean isPositive(double price) throws NegativePriceException {
		
		if (price < 0) {
			throw new NegativePriceException();
		}
		return true;
	}
	
	/**
	 * Asks user to enter the starting count of the Toy
	 * @return Validated count(inventory) of toy
	 */
	public int EnterCount() {
		System.out.print("\nEnter Available Count: ");
		int count = 0;
		
		boolean start = true;
		while (start) {
			if(scanner.hasNextInt()) {
				count = scanner.nextInt();
				if (count >= 0) {
					start = false;
					return count;
				}
				else {
					System.out.print("\nThe count must be either be 0 or a positive value. \n");
					System.out.print("\nEnter Available Count: ");
					scanner.nextLine();
				}
				
			}
				
			else {
				System.out.print("\nThe available count is a numeric value. Try again. \n");
				System.out.print("\nEnter Available Count: ");
				scanner.next();
			}
		}
		return count;
		
	}
	
	/**
	 * Asks user to enter the appropriate age for the Toy
	 * @return Validated Appropriate Age of Toy
	 */
	public int EnterAge() {
		System.out.print("\nEnter Appropriate Age: ");
		int age = 0;
		
		boolean start = true;
		while (start) {
			if(scanner.hasNextInt()) {
				age = scanner.nextInt();
				if (age >= 0) {
					start = false;
					return age;
				}
				else {
					System.out.print("\nThe age must be either be 0 or a positive value. \n");
					System.out.print("\nEnter Available Count: ");
					scanner.nextLine();
				}
				
			}
				
			else {
				System.out.print("\nThe age is a numeric value. Try again. \n");
				System.out.print("\nEnter Appropriate Age: ");
				scanner.next();
			}
		}
		return age;
		
	}
	
	/**
	 * Asks user to enter the classification of the figure type Toy
	 * @return Classification of Figure
	 */
	public String EnterClassification() {
		System.out.print("\nEnter classification for figure: ");
		scanner.nextLine();
		String classification = scanner.nextLine();
		return classification;
	}
	
	/**
	 * Asks user to enter the material of the animal type Toy 
	 * @return Material of Animal
	 */
	public String EnterMaterial() {
		System.out.print("\nEnter Material of Animal: ");
		scanner.nextLine();
		String material = scanner.nextLine();
		return material;
	}
	
	/**
	 * Asks user to enter the size of the animal type Toy
	 * @return Size of Animal
	 */
	public String EnterSize() {
		System.out.print("\nEnter the size of the Animal: ");
		String size = scanner.nextLine();
		return size;
	}
	
	/**
	 * Asks user to enter the type of puzzle
	 * @return Puzzle type
	 */
	public String EnterPuzzleType() {
		System.out.print("\nEnter the type of puzzle: ");
		scanner.nextLine();
		String puzzleType = scanner.nextLine();
		return puzzleType;
	}
	
	/**
	 * Asks the user to enter the min and max number of players
	 * Exception is caught if the min # of players is greater than max # of players (when adding a new board game)
	 * @return The number of players concatenated with a dash
	 */
	public String EnterNumOfPlayers() {
		int minPlayers = 0;
		int maxPlayers = 0;
		boolean start = true;
		
		while (start) {
			System.out.print("\nEnter Minimum number of players: ");
			if(scanner.hasNextInt()) {
				minPlayers = scanner.nextInt();
				System.out.print("\nEnter Maximum number of players: ");
				if (scanner.hasNextInt()) {
					maxPlayers = scanner.nextInt();
					try {
						boolean result = checkNumOfPlayer(minPlayers , maxPlayers); 
						
						if(result) {
							start = false;
							return minPlayers + "-" + maxPlayers;
						}
					} catch (MinMaxPlayersException e) {
						System.out.println(e);
						scanner.nextLine();
					}
				}
				else {
					System.out.print("\nPlease enter an integer value for the maximum amount of players. \n");
					System.out.print("\nEnter maximum number of players: ");
					scanner.nextLine();
				}
			}
				
			else {
				System.out.print("\nPlease enter an integer value for the minimum amount of players. \n");
				System.out.print("\nEnter Minimum number of players: ");
				scanner.nextLine();
			}
		}
		return minPlayers + "-" + maxPlayers;
	}
	
	/**
	 * Checks to see if the min number of players does not exceed the max number of players
	 * @param min Minimum number of players
	 * @param max Maximum number of players
	 * @return True if min players is less than max players
	 * @throws MinMaxPlayersException Throws exception if min players is greater than max players
	 */
	public static boolean checkNumOfPlayer(int min , int max) throws MinMaxPlayersException{
		
		if (min > max) {
			throw new MinMaxPlayersException();
		}
		
		return true;
	}
	
	/**
	 * Asks the user to enter the designer of the puzzle
	 * @return Name of the designer of the puzzle 
	 */
	public String EnterDesigner() {
		System.out.print("\nEnter Designer Names(use ',' to separate the names if there is more than one name): ");
		scanner.nextLine();
		String designer = scanner.nextLine();
		return designer;
	}
	
	/**
	 * Output that is displayed when the application is closed
	 */
	public void AppExit() {
		System.out.println("\nSaving Data into Database...\n");
		System.out.println("\n***************** THANKS FOR VISITING US! *****************");
	}
	
	/**
	 * Asks the user if they want to remove the toy and validates input
	 * @return Answer the user has chosen
	 */
	public String YesOrNo() {
		System.out.print("Do you want to remove this Toy? (Y/N) ");
		scanner.nextLine();
		String answer = scanner.nextLine();
		boolean flag = true;
		
		while(flag) {
			if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
				flag = false;
				return answer;
			}
			else {
				System.out.print("\nPlease enter (Y) for Yes or (N) for No. \n");
				System.out.print("\nDo you want to remove this Toy? (Y/N) \n");
				answer = scanner.nextLine();
			}
		}
		return answer;
	}
}
