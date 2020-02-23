package app;

import java.util.Scanner;

public class Server{
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;

    public Server(int serverNumber) {
        this.setName(serverNumber);
        this.setCost(serverNumber);
    }

    public void setName(int serverNumber) {
        System.out.println("\nEnter a name for the server number " + serverNumber);
        this.name = keyboard.nextLine();
    }

    public void setCost(int serverNumber) {
        System.out.println("\nSelect the payment scheme for the server number " + serverNumber);
        System.out.println("1 - Yearly");
        System.out.println("2 - Monthly");
        final int scheme = keyboard.nextInt();
        switch (scheme) {
            case 1:
                System.out.println("\nEnter the yearly cost for the server number " + serverNumber);
                double costYear = keyboard.nextDouble();
                this.cost = getPerHourCostFromYear(costYear);
                break;
                
            case 2:
                System.out.println("\nEnter the monthly cost for the server number " + serverNumber);
                double costMonth = keyboard.nextDouble();
                this.cost = getPerHourCostFromMonth(costMonth);
                break;
        
            default:
                System.out.println("\nInvalid entry. Try again..");
                this.setCost(serverNumber);
                break;
        }
    }

    private double getPerHourCostFromYear(double costYear){
        double cost;
        cost = (costYear/240)/8.0;
        return cost;
    }
    
    private double getPerHourCostFromMonth(double costMonth){
        double cost;
        cost = (costMonth/20)/8.0;
        return cost;
    }

    public String getName(){
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}