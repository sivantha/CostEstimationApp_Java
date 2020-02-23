package app;

import java.util.Scanner;
import java.util.ArrayList;

public class Phase {
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private int minTime;
    private int maxTime;
    private int noOfTypes;
    public int[] ratesOfTypes;
    public int[] minEmp;
    public int[] maxEmp;
    public ArrayList<Server> serverArrayList = new ArrayList<Server>();
    public ArrayList<Sms> smsArrayList = new ArrayList<Sms>();
    public ArrayList<Payment> paymentArrayList = new ArrayList<Payment>();
    public ArrayList<Subscription> subscriptionArrayList = new ArrayList<Subscription>();
    public ArrayList<Consumable> consumableArrayList = new ArrayList<Consumable>();
    public ArrayList<Equipment> equipmentArrayList = new ArrayList<Equipment>();

    public Phase(String name) {
        this.name = name;
        this.setMinTime();
        this.setMaxTime();
        this.setTypesEmp();
        this.setParams();
    }

    public void setMinTime() {
        System.out.println("\nEnter the minimum time (in hours) need for this phase in working hours:");
        System.out.println("(Consider there is only 8 working hours per day)");
        this.minTime = keyboard.nextInt();
    }

    public void setMaxTime() {
        System.out.println("\nEnter the maximum time (in hours) need for this phase in working hours:");
        System.out.println("(Consider there is only 8 working hours per day)");
        this.maxTime = keyboard.nextInt();
    }

    public void setTypesEmp(){
        System.out.println("\nHow many types of employees do you have?");
        System.out.println("(According to the paying rate)");
        this.noOfTypes = keyboard.nextInt();
        this.ratesOfTypes = new int[this.noOfTypes];
        this.maxEmp = new int[this.noOfTypes];
        this.minEmp = new int[this.noOfTypes];
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("\nEnter the rate (Rupees per hour) of the type " + (i+1) + " employee");
            this.ratesOfTypes[i] = keyboard.nextInt();
        }
        this.setMaxEmp();
        this.setMinEmp();
    }

    public void setMaxEmp() {
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("\nEnter the maximum number of employees that can be allocated for this phase, \n(of type " + (i+1) + " with the rate of " + this.ratesOfTypes[i] + " rupees per hour)");
            this.maxEmp[i] = keyboard.nextInt();
        }
    }

    public void setMinEmp() {
        for(int i=0; i<this.noOfTypes; i++) {
            System.out.println("\nEnter the minimum number of employees can be allocated to this phase, \n(of type " + (i+1) + " with the rate of " + this.ratesOfTypes[i] + " rupees per hour)");
            this.minEmp[i] = keyboard.nextInt();
        }
    }

    public void setParams() {
        boolean shouldLoop = true;
        while(shouldLoop){
            System.out.println("\nSelect the service you want to add for this phase: " + this.name);
            System.out.println("1 - Servers");
            System.out.println("2 - SMS Gateways");
            System.out.println("3 - Payment Gateways");
            System.out.println("4 - Subscriptions");
            System.out.println("5 - Equipments");
            System.out.println("6 - Consumables");

            int type = keyboard.nextInt();

            switch (type) {
                case 1:
                    System.out.print("\nNo. of SERVERS you need:");
                    int numServers = keyboard.nextInt();
                    for(int i=0; i<numServers; i++){
                        serverArrayList.add(new Server(i+1));
                    }
                    break;

                case 2:
                    System.out.print("\nNo. of SMS GATEWAYS you need:");
                    int numSms = keyboard.nextInt();
                    for(int i=0; i<numSms; i++){
                        smsArrayList.add(new Sms(i+1));
                    }
                    break;

                case 3:
                    System.out.print("\nNo. of PAYMENT GATEWAYS you need:");
                    int numPayments = keyboard.nextInt();
                    for(int i=0; i<numPayments; i++){
                        paymentArrayList.add(new Payment(i+1));
                    }
                    break;
                    
                case 4:
                    System.out.print("\nNo. of SUBSCRIPTIONS you need:");
                    int numSubscriptions = keyboard.nextInt();
                    for(int i=0; i<numSubscriptions; i++){
                        subscriptionArrayList.add(new Subscription(i+1));
                    }
                    break;

                case 5:
                    System.out.print("\nNo. of types of EQUIPMENTS you need:");
                    int numEquipments = keyboard.nextInt();
                    for(int i=0; i<numEquipments; i++){
                        equipmentArrayList.add(new Equipment(i+1));
                    }
                    break;

                case 6:
                    System.out.print("\nNo. of types of CONSUMABLES you need:");
                    int numConsumables = keyboard.nextInt();
                    for(int i=0; i<numConsumables; i++){
                        consumableArrayList.add(new Consumable(i+1));
                    }
                    break;
            
                default:
                    System.out.println("\nYou have entered an invalid number..");
                    break;
            }

            System.out.println("\nDo you want to add more services for this phase: " + this.name + " (Y/N)?");
            String userInput = keyboard.nextLine();
            //Duplicated to avoid a exception error
            userInput = keyboard.nextLine();
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