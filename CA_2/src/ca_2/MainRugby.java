/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nayaradimalopes
 */
public class MainRugby {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaring variable that will be use in this scope
        String fileName;
        boolean fileFound = false;

        List<Player> playersFromFile = new ArrayList<>();

        // Iniciatializing the Scanner to get input from the user
        Scanner myKb = new Scanner(System.in);

        // Treating the file found and giving to the user an option to exit the program!
        // While the file found is true (is found) we ask the user what is the file name
        // Also, giving to the user the exit option in case they have forgotten the file's name
        // Then applying non-sensitive case to be dynamic to the user
        while (!fileFound) {
            System.out.println("Please, enter a file name or 'exit' to exit the program: \n");
            fileName = myKb.nextLine().trim();

            if (fileName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }
            // If the file is found, then execute the following
            // Using the buffered reader to read something from the file
            try (BufferedReader userInputFile = new BufferedReader(new FileReader(fileName))) {
                // Storing the content in a variable 
                String readLine = userInputFile.readLine();

                // If the file contains something -> display sucessufully
                if (readLine != null) {
                    System.out.println("\nFile read sucessfully!");
                    // This means that the file was found and read, then the value is true
                    fileFound = true;

                    while (readLine != null) {
                        // Now we split the line into smaller parts than we can manipulate by separating them by the (,) (comma)
                        String[] parts = readLine.split(",");

                        if (parts.length >= 3) {
                            // Add the extracted data array to the list
                            playersFromFile.add(new Player(parts[1].trim() + " " + parts[2].trim()));
                        }
                        // Read the next line
                        readLine = userInputFile.readLine();
                    }
                }

                if (!playersFromFile.isEmpty()) {
                    System.out.println("\nData extracted successfully!");

//                      When I wanna testing if the names are displaying!
//                        // Print full names
//                        System.out.println("Unsorted Full Names: \n");
//
//                        for (Player player : playersFromFile) {
//                            System.out.println(player.getName());
//                        }
                } else {
                    System.out.println("File is empty!");
                }
            } catch (IOException e) {
                System.out.println("File not Found. Please, make sure you have the correct file name!");
            }
        }
    }
}
