package app;

//Import the Scanner class to read user inputs from the keyboard
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class App{
    public static void main(final String[] args) {
        DecimalFormat decimal = new DecimalFormat("#.##");
        Scanner keyboard = new Scanner(System.in);
        boolean shouldLoop = true;
        ArrayList<Phase> phaseArray = new ArrayList<Phase>();
        System.out.println("===============================================");
        System.out.println("");
        System.out.println("Cost Estimation and Optimization                       ");
        System.out.println("");
        System.out.println("===============================================");
        System.out.println("");

        // Select the phase
        while (shouldLoop) {
            System.out.println("\nEnter the name of the phase you want to add");
            String userInput = keyboard.nextLine();
            phaseArray.add(new Phase(userInput));
            System.out.println("\nPhase added successfully.");
            System.out.println("\nDo you want to add more phases(Y/N)?");
            String userResponse = keyboard.nextLine();
            //Duplicated to avoid a exception error
            if (userResponse.charAt(0)=='y' || userResponse.charAt(0)=='Y') {
                shouldLoop = true;
            }
            else{
                shouldLoop = false;
                int totalPhases = phaseArray.size();
                for( int i=0; i<totalPhases; i++){
                    Phase phase = phaseArray.get(i);
                    int maxTime = phase.getMaxTime();
                    int minTime = phase.getMinTime();
                    String name = phase.getName();
                    int numEmployee = phase.getNoOfTypes();
                    int numServer = phase.serverArrayList.size();
                    int numSms = phase.smsArrayList.size();
                    int numPayment = phase.paymentArrayList.size();
                    int numSubscription = phase.subscriptionArrayList.size();
                    int numEquipment = phase.equipmentArrayList.size();
                    int numConsumable = phase.consumableArrayList.size();

                    System.out.println("\n\nPhase " + (i+1) + " - " + name);
                    System.out.println("----------------------------------------\n");
                    System.out.println("Objective Function");
                    String phaseString = "Cost = ";
                    //human
                    for(int j=0; j<numEmployee; j++){
                        phaseString = phaseString + "+" + decimal.format(phase.ratesOfTypes[j])  + "(E" + (j+1) + ")(T" + (i+1) + ") ";
                    }
                    //server
                    for(int k=0; k<numServer; k++){
                        phaseString = phaseString + "+" + decimal.format(phase.serverArrayList.get(k).getCost()) + "(T" + (i+1) + ") ";
                    }
                    //sms
                    for(int l=0; l<numSms; l++){
                        phaseString = phaseString + "+" + decimal.format(phase.smsArrayList.get(l).getCost())  + " ";
                    }
                    //payment
                    for(int m=0; m<numPayment; m++){
                        phaseString = phaseString + "+" + decimal.format(phase.paymentArrayList.get(m).getCost()) + "(T" + (i+1) + ") ";
                    }
                    //subscription
                    for(int n=0; n<numSubscription; n++){
                        phaseString = phaseString + "+" + decimal.format(phase.subscriptionArrayList.get(n).getCost()) + "(T" + (i+1) + ") ";
                    }
                    //equipments
                    for(int o=0; o<numEquipment; o++){
                        phaseString = phaseString  + "+" + decimal.format(phase.equipmentArrayList.get(o).getCost()*phase.equipmentArrayList.get(o).getUnits())  + "(T" + (i+1) + ") ";
                    }
                    //consumables
                    for(int p=0; p<numConsumable; p++){
                        phaseString = phaseString + "+" + decimal.format(phase.consumableArrayList.get(p).getCost())  + " ";
                    }

                    System.out.println(phaseString);
                    System.out.println("\nConstraints");
                    for(int q=0; q<numEmployee; q++){
                        System.out.printf("%5d  <=   E%d  <=  %-5d\n", phase.minEmp[q], (q+1), phase.maxEmp[q]); 
                    }
                    System.out.printf("%5d  <=   T%d   <=  %-5d\n", minTime, i, maxTime);
                }
            }
        }
        keyboard.close();
    }
}