# Toy Store - Anmol Verma

## Description

The Toy Store application is a simple console-based Java program that simulates the operations of a toy store. The program allows users to purchase, add, and remove toys. The changes are then applied to a text file, creating a persistent store of data.

The main functionality of the program is handled by the `AppManager` class, which uses the `AppMenu` class and the `Model` package. The data from a `toys.txt` file is loaded into an ArrayList of type `Toy`.

Each `Toy` object in the program has the following properties:

- Serial Number (SN)
- Name
- Brand
- Price
- Available Count
- Age Appropriate

Each of these properties has associated getter and setter methods. Additionally, there's an abstract method `getType()` that returns the type of the toy.

The `Toy` class is abstract, which suggests that it's meant to be extended by other classes that represent specific types of toys. The specific type of each toy is determined by the `getType()` method.

Please refer to the codebase for more detailed information about how each class and method operates.

## Running the Program

To run the program, simply navigate to the directory where the code is stored and run the `AppDriver` class, which contains the main method. Ensure that the `toys.txt` file is in the appropriate location as per the path specified in the `AppManager` class.

## Note

This is a basic version of the application and is not meant for commercial use. It is primarily intended as a learning tool for understanding object-oriented programming and file handling in Java.
