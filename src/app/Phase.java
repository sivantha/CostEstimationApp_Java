package app;

import java.util.Scanner;

public class Phase {
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private int minTime;
    private int maxTime;
    private int noOfTypes;
    private int[] ratesOfTypes;
    private int[] minEmp;
    private int[] maxEmp;
    public Server[] serverArray;
    public Sms[] smsArray;
    public Payment[] paymentArray;
    public Subscription[] subscriptionArray;
    public Consumable[] consumableArray;
    public Equipment[] equipmentArray;

    public Phase(String name) {
        this.name = name;
        this.setMinTime();
        this.setMaxTime();
        this.setTypesEmp();
        this.setParams();
    }

    public void setMinTime() {
        System.out.println("\nEnter the minimum time (in hours) need for the project in working hours:");
        System.out.println("(Consider there is only 8 working hours per day)");
        this.minTime = keyboard.nextInt();
    }

    public void setMaxTime() {
        System.out.println("\nEnter the maximum time (in hours) need for the project in working hours:");
        System.out.println("(Consider there is only 8 working hours per day)");
        this.maxTime = keyboard.nextInt();
    }

    public void setTypesEmp(){
        System.out.println("\nHow many types of employees you have?");
        System.out.println("(According to the paying rate)");
        this.noOfTypes = keyboard.nextInt();
        this.ratesOfTypes = new int[this.noOfTypes];
        this.maxEmp = new int[this.noOfTypes];
        this.minEmp = new int[this.noOfTypes];
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("Enter the rate (Rupees per hour) of the type " + (i+1) + " employee");
            this.ratesOfTypes[i] = keyboard.nextInt();
        }
        this.setMaxEmp();
        this.setMinEmp();
    }

    public void setMaxEmp() {
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("Enter the maximum number of employees can be allocated for this phase, of type " + (i+1) + " with the rate of " + this.ratesOfTypes[i] + " rupees per hour");
            this.maxEmp[i] = keyboard.nextInt();
        }
    }

    public void setMinEmp() {
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("Enter the minimum number of employees can be allocated to this phase, of type " + (i+1) + " with the rate of " + this.ratesOfTypes[i] + " rupees per hour");
            this.minEmp[i] = keyboard.nextInt();
        }
    }

    public void setParams() {
        boolean shouldLoop = true;
        while(shouldLoop){
            System.out.println("Select the type you want to add");
            System.out.println("1 - Servers");
            System.out.println("2 - SMS Gateways");
            System.out.println("3 - Payment Gateways");
            System.out.println("4 - Subscriptions");
            System.out.println("5 - Equipments");
            System.out.println("6 - Consumables");

            int type = keyboard.nextInt();

            switch (type) {
                case 1:
                    System.out.println("Server");
                    System.out.println("===============================================");
                    System.out.println("No. of servers needed:");
                    int numServers = keyboard.nextInt();
                    this.serverArray = new Server[numServers];
                    for(int i=0; i<numServers; i++){
                        serverArray[i] = new Server(i+1);
                    }
                    break;

                case 2:
                    System.out.println("SMS");
                    System.out.println("===============================================");
                    System.out.println("No. of servers needed:");
                    break;

                case 3:
                    System.out.println("Payment");
                    System.out.println("===============================================");
                    System.out.println("No. of servers needed:");
                    break;
                    
                case 4:
                    //Subs
                    break;

                case 5:
                    //Equip
                    break;

                case 6:
                    //Cons
                    break;
            
                default:
                    //Error
                    break;
            }

            System.out.println("Do you want to add more(Y/N)?");
            String userInput = keyboard.nextLine();
            if (userInput.charAt(0)=='y' || userInput.charAt(0)=='Y') {
                shouldLoop = true;
            }
            else{
                shouldLoop = false;
            }
        }
    }

    public String getName(){
        return this.name;
    }

    public int getNoOfTypes(){
        return this.noOfTypes;
    }

    public int getMinTime(){
        return (this.minTime);
    }
 
    public int getMaxTime(){
        return (this.maxTime);
    }
}