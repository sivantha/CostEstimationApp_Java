package app;

//Import the Scanner class to read user inputs from the keyboard
import java.util.Scanner;

import java.util.ArrayList;

public class App{
    public static void main(final String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean shouldLoop = true;
        ArrayList<Phase> phaseArray = new ArrayList<Phase>();

        System.out.println("===============================================");
        System.out.println("Echon Labs Ltd.");
        System.out.println("===============================================");
        System.out.println("");
        System.out.println("Cost Estimation and Optimization                       ");
        System.out.println("");
        System.out.println("===============================================");
        System.out.println("");

        // Select the phase
        while (shouldLoop) {
            System.out.println("Enter the number of the phase");
            System.out.println("1 - System Planning");
            System.out.println("2 - System Design");
            System.out.println("3 - Development and Implementation");
            System.out.println("4 - Testing and Integration");
            System.out.println("5 - System Maintenance");
            int userInput = keyboard.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Phase 1 -  System Planning");
                    System.out.println("===============================================");
                    phaseArray.add(new Phase("System Planning"));
                    System.out.println("Phase added successfully.");
                    // Optimize the phase
                    // Show the results
                    break;

                case 2:
                    System.out.println("Phase 2 -  System Design");
                    System.out.println("===============================================");
                    phaseArray.add(new Phase("System Design"));
                    System.out.println("Phase added successfully.");
                    break;

                case 3:
                    System.out.println("Phase 3 -  Development and Implementation");
                    System.out.println("===============================================");
                    phaseArray.add(new Phase("Development and Implementation"));
                    System.out.println("Phase added successfully.");
                    break;
    
                case 4:
                    System.out.println("Phase 4 -  Testing and Integration");
                    System.out.println("===============================================");
                    phaseArray.add(new Phase("Testing"));
                    System.out.println("Phase added successfully.");
                    break;

                case 5:
                    System.out.println("Phase 5 -  System Maintenance");
                    System.out.println("===============================================");
                    phaseArray.add(new Phase("Maintenance"));
                    System.out.println("Phase added successfully.");
                    break;
                
                default:
                    System.out.println("You entered a wrong number! Please try again.");
                    break;
            }
            System.out.println("Do you want to add more phases(Y/N)?");
            String userRes = keyboard.nextLine();
            if (userRes.charAt(0)=='y' || userRes.charAt(0)=='Y') {
                shouldLoop = true;
            }
            else{
                shouldLoop = false;
            }
        }
        keyboard.close();
    }
}
