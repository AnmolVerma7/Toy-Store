package mru.tsc.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Figure;
import mru.tsc.model.Animal;
import mru.tsc.model.Puzzle;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Toy;
import mru.tsc.view.AppMenu;

/**
 * The AppManager class handles the main functionality of the program by using the AppMenu class and Model package.
 * @author Anmol Verma
 *
 */
public class AppManager {
	
	// File Path to the text file
	private final String FILE_PATH = "res/toys.txt";
	
	// App Menu object
	private AppMenu display;
	
	// ArrayList object of object Toy
	public ArrayList<Toy> toys;
	
	// Scanner object for some input
	private Scanner input = new Scanner(System.in);
	
	/**
	 * Primary constructor for App Manager class
	 * @throws Exception If file is not found
	 */
	public AppManager() throws Exception {
		toys = new ArrayList<Toy>();
		loadData();
		display = new AppMenu();
		launchApplication();
	}
	
	/**
	 * Loads data into ArrayList type Toy from toys.txt file
	 * @throws Exception If file is not found
	 */
    public void loadData() throws Exception {
		File file = new File(FILE_PATH);
		String[] splittedLine;
		String currentLine;
		char serial;
		
		if (file.exists()) {
			Scanner fileReader = new Scanner(file);
			
			while (fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				serial = splittedLine[0].charAt(0);
				
				if (serial == '0' || serial == '1') {
					  Figure f = new Figure(splittedLine[0], splittedLine[1], 
							  splittedLine[2] , Double.parseDouble(splittedLine[3]), 
								   Integer.parseInt(splittedLine[4]) , Integer.parseInt(splittedLine[5]) , splittedLine[6]);
					  toys.add(f);
				}
				
				else if (serial == '2' || serial == '3') {
					  Animal a = new Animal(splittedLine[0], splittedLine[1], 
							  splittedLine[2] , Double.parseDouble(splittedLine[3]), 
							   Integer.parseInt(splittedLine[4]) , Integer.parseInt(splittedLine[5]) , splittedLine[6], splittedLine[7]);
					  toys.add(a);
				}
				
				else if (serial == '4' || serial == '5' || serial == '6') {
					  Puzzle p = new Puzzle(splittedLine[0], splittedLine[1], 
							  splittedLine[2] , Double.parseDouble(splittedLine[3]), 
							   Integer.parseInt(splittedLine[4]) , Integer.parseInt(splittedLine[5]) , splittedLine[6]);
					  toys.add(p);
				}
				
				else if (serial == '7' || serial == '8' || serial == '9') {
					  BoardGame bg = new BoardGame(splittedLine[0], splittedLine[1], 
							  splittedLine[2] , Double.parseDouble(splittedLine[3]), 
							   Integer.parseInt(splittedLine[4]) , Integer.parseInt(splittedLine[5]) , splittedLine[6], splittedLine[7]);
					  toys.add(bg); 
				}
				
			}
			fileReader.close();
		}		
	}
    
    /**
     * When program is closed, this method saves changed data into the toys.txt file
     */
    public void saveData() {
        File file = new File(FILE_PATH);
        try {
        	FileWriter fw = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fw);
            for (Toy toy : toys) {
            	char firstNum = toy.getSN().charAt(0);
            	
            	if (firstNum == '0' || firstNum == '1') {
            		Figure fig = (Figure) toy;
					printWriter.println(fig.format());
				}
				
				else if (firstNum == '2' || firstNum == '3') {
					Animal an = (Animal) toy;
					printWriter.println(an.format());
				}
				
				else if (firstNum == '4' || firstNum == '5' || firstNum == '6') {
					Puzzle puz = (Puzzle) toy;
					printWriter.println(puz.format());
				}
				
				else if (firstNum == '7' || firstNum == '8' || firstNum == '9') {
					BoardGame borga = (BoardGame) toy;
					printWriter.println(borga.format());
				}
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Stars the program, starting point of output
     */
	public void launchApplication() {
		display.StoreLogo();
		boolean flag = true;
		int choice;
		while(flag) {
			choice = display.MainMenu();
			
			switch (choice) {
			case 1:
				SearchAndBuy();
				break;
			case 2:
				AddNewToy();
				break;
			case 3:
				RemoveToy();
				break;
			case 4:
				display.AppExit();
				saveData();
				flag = false;
			}
		}
	}
	
	/**
	 * Depending on user's choice from AppMenu method the corresponding arguments are run
	 * Case 1 Search By Serial Number
	 * Case 2 Search By Name
	 * Case 3 Search By Type
	 */
	public void SearchAndBuy() {
		boolean flag = true;
		int choice = 0;	
		int num;
		
		ArrayList<Toy> matchingToy = new ArrayList<Toy>();
		while(flag) {
			choice = display.SearchAndBuyMenu();
			
			switch (choice) {
			case 1:
				String serial = display.EnterSerialNum();
				matchingToy = findAllBySN(serial);
				
				
				System.out.println("\nSearch Results: \n");
				num = 1;
				
				for (Toy t: matchingToy) {
					System.out.print("(" + num + ") " + t + "\n");
					num++;
				}
				System.out.print("(" + num + ") " + "Back to Search Menu \n");
				System.out.print("\nEnter option number to purchase: ");
				
				choice = input.nextInt();
				
				if (choice == num) {
					break;
				}
				else {
					purchase(matchingToy,choice);
					matchingToy.clear();
					break;
				}
			
			case 2:
				String name = display.EnterName();
				matchingToy = findAllByName(name);
				
				System.out.println("\nSearch Results: \n");
				num = 1;
				for (Toy t: matchingToy) {
					System.out.print("(" + num + ") " + t + "\n");
					num++;
				}
				System.out.print("(" + num + ") " + "Back to Search Menu \n");
				System.out.print("\nEnter option number to purchase: ");
				
				choice = input.nextInt();
				
				if (choice == num) {
					break;
				}
				else {
					purchase(matchingToy , choice);
					matchingToy.clear();
					break;
				}
				
			case 3:
				String type = display.EnterType();
				matchingToy = findAllByType(type);
				
				System.out.println("\nSearch Results: \n");
				num = 1;
				for (Toy t: matchingToy) {
					System.out.print("(" + num + ") " + t + "\n");
					num++;
					
				}
				System.out.print("(" + num + ") " + "Back to Search Menu \n");
				System.out.print("\nEnter option number to purchase: ");
				
				choice = input.nextInt();
				
				if (choice == num) {
					break;
				}
				else {
					purchase(matchingToy , choice);
					matchingToy.clear();
					break;
				}
				
			case 4:
				flag = false;
				break;
			}
			
		}
	}
	
	/**
	 * Finds all toys by serial number
	 * @param serialNum The serial number that the user has entered
	 * @return A temporary ArrayList containing toys with the search result the user has entered
	 */
	public ArrayList<Toy> findAllBySN(String serialNum) {
		
		ArrayList<Toy> matchingToys = new ArrayList<Toy>();
		
		for (Toy currToy : toys) {
			if (serialNum.equals(currToy.getSN())) {
				char firstNum = currToy.getSN().charAt(0);
				addToList(matchingToys , firstNum , currToy);
			}
		}
		return matchingToys;
	}
	
	/**
	 * Finds all toys by name containing the input the user has entered
	 * @param name The name that the user has entered
	 * @return A temporary ArrayList containing toys with the search result the user has entered
	 */
	public ArrayList<Toy> findAllByName(String name) {
		
		ArrayList<Toy> matchingToys = new ArrayList<Toy>(); 
		
		for (Toy currToy : toys) {
			if (currToy.getName().toLowerCase().contains(name)) {
				char firstNum = currToy.getSN().charAt(0);
				addToList(matchingToys , firstNum , currToy);
			}
		}
		return matchingToys;
	}
	
	/**
	 * Finds all toys by Type
	 * @param type The type that the user has entered
	 * @return A temporary ArrayList containing toys with the search result the user has entered
	 */
	public ArrayList<Toy> findAllByType(String type) {
		
		ArrayList<Toy> matchingToys = new ArrayList<Toy>(); 
		
		for (Toy currToy : toys) {
			if (type.toLowerCase().equals(currToy.getType().toLowerCase())) {
				char firstNum = currToy.getSN().charAt(0);
				addToList(matchingToys , firstNum , currToy);
			}
		}
		return matchingToys;
	}
	
	/**
	 * Adds Toy objects into ArrayList based off of the first digit of the serial number.
	 * @param list The ArrayList that the Toy objects are being added to
	 * @param firstNum The first of the serial number, based off of that the Toys are added to the ArrayList
	 * @param toy The casted object that is being added to the ArrayList
	 */
	public void addToList (ArrayList<Toy> list, char firstNum , Toy toy ) {
		if (firstNum == '0' || firstNum == '1') {
    		Figure fig = (Figure) toy;
    		list.add(fig);
		}
			
		else if (firstNum == '2' || firstNum == '3') {
			Animal an = (Animal) toy;
			list.add(an);
		}
		
		else if (firstNum == '4' || firstNum == '5' || firstNum == '6') {
			Puzzle puz = (Puzzle) toy;
			list.add(puz);
		}
		
		else if (firstNum == '7' || firstNum == '8' || firstNum == '9') {
			BoardGame borga = (BoardGame) toy;
			list.add(borga);
		}
	}
		
	/**
	 * Performs the purchase operation based on the selection the user makes
	 * @param list The temporary ArrayList to be chosen from that was returned from a findAllBy method 
	 * @param selection The toy to be purchased in the referenced ArrayList
	 */
	public void purchase(ArrayList<Toy> list, int selection) {
		selection = selection - 1;
		Toy selectedToy = list.get(selection);
		int purchase = selectedToy.getAvailableCount() - 1;
			
			if (selectedToy.getAvailableCount() > 0) {
				selectedToy.setAvailableCount(purchase);
				System.out.print("\nThe transaction successfully terminated \n\nPress Enter to Continue...");
				input.nextLine();
			}

			else {
				System.out.print("\nThis toy is currently out of stock. Please search again \n");
			}
			input.nextLine();
	}

	/**
	 * Adds toy based on the serial number the user has entered
	 * When the toy is added the user is notified 
	 */
	public void AddNewToy() {
		String toyName;
		String brand;
		double price;
		int availCount;
		int ageAppropriate;
		String classification;
		String material;
		String size;
		String puzzleType;
		String numOfPlayers;
		String designer;
		
		boolean flag = true;
		while (flag) {
			String serialNum = display.EnterSerialNum();
			for (Toy t: toys) {
				while (t.getSN().equals(serialNum)) {
					System.out.print("\nA Toy with this Serial Number ALREADY EXISTS! Try again. \n");
					serialNum = display.EnterSerialNum();
				}
				
			}
			char firstNum = serialNum.charAt(0);
			
			toyName = display.EnterName();
			brand = display.EnterBrand();
			price = display.EnterPrice();
			availCount = display.EnterCount();
			ageAppropriate = display.EnterAge();
			
			if (firstNum == '0' || firstNum == '1') {

				classification = display.EnterClassification();
				
				Figure figure = new Figure(serialNum, toyName, brand, price, availCount, ageAppropriate, classification);
				
				toys.add(figure);
				flag = false;
			}
			
			else if (firstNum == '2' || firstNum == '3') {
				
				material = display.EnterMaterial();
				size = display.EnterSize();
				
				Animal animal = new Animal(serialNum, toyName, brand, price, availCount, ageAppropriate, material, size);
				
				toys.add(animal);
				flag = false;
			}
			
			else if (firstNum == '4' || firstNum == '5' || firstNum == '6') {
				puzzleType = display.EnterPuzzleType();
				
				Puzzle puzzle = new Puzzle(serialNum, toyName, brand, price, availCount, ageAppropriate, puzzleType);
  				
				toys.add(puzzle);
				flag = false;
			}
			
			else if (firstNum == '7' || firstNum == '8' || firstNum == '9') {	
				
				numOfPlayers = display.EnterNumOfPlayers();
				designer = display.EnterDesigner();
				
				BoardGame boardGame = new BoardGame(serialNum, toyName, brand, price, availCount, ageAppropriate, numOfPlayers, designer);
				
				toys.add(boardGame);
				flag = false;
			}
		}
		System.out.print("\nNew Toy Added! \n");
		System.out.print("\nPress Enter to Continue...");
		input.nextLine();
	}
	
	/**
	 * Removes toy from database based on what serial number the user has entered
	 * When the toy is added the user is notified
	 */
	public void RemoveToy() {
		String serialNum = display.EnterSerialNum();
		Toy toyToRemove = null;
		System.out.println("\nThis Item Found: \n");
		
		for (Toy t: toys) {
			if(t.getSN().equals(serialNum)) {
				System.out.println("\t" + t + "\n");
				toyToRemove = t;
			}
		}
		
		while (true) {
			String choice = display.YesOrNo();
			if (choice.toUpperCase().equals("Y")) {
				toys.remove(toyToRemove);
				System.out.println("\nItem Removed! ");
				System.out.println("\nPress Enter to Continue...");
				input.nextLine();
				break;
			}
			else if(choice.toUpperCase().equals("N")) {
				break;
			}
		}
	}
}
