package app;

import java.util.Scanner;

public class Payment{
    //name
    //scheme monthly yearly
    //cost - per hour
    //time dependent

    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;

    public Payment(int gatewayNumber) {
        this.setName(gatewayNumber);
        this.setCost(gatewayNumber);
    }

    public void setName(int serverNumber) {
        System.out.println("Enter a name for the " + serverNumber + "server:");
        this.name = keyboard.nextLine();
    }

    public void setCost(int gatewayNumber) {
        System.out.println("Select the payment scheme for the " + gatewayNumber + "gateway");
        System.out.println("1 - Yearly");
        System.out.println("2 - Monthly");
        final int scheme = keyboard.nextInt();
        switch (scheme) {
            case 1:
                System.out.println("Enter the yearly cost for the gateway:");
                final double costYear = keyboard.nextDouble();
                this.cost = getPerHourCostFromYear(costYear);
                break;
                
            case 2:
                System.out.println("Enter the monthly cost for this gateway:");
                final double costMonth = keyboard.nextDouble();
                this.cost = getPerHourCostFromMonth(costMonth);
                break;
        
            default:
                System.out.println("Invalid entry. Try again..");
                this.setCost(gatewayNumber);
                break;
        }
    }

    private double getPerHourCostFromYear(final double costYear){
        double cost;
        cost = (costYear/240)/8.0;
        return cost;
    }
    
    private double getPerHourCostFromMonth(final double costMonth){
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