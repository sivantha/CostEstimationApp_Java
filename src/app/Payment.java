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

    public void setName(int gatewayNumber) {
        System.out.println("\nEnter a name for the Payment gateway number " + gatewayNumber);
        this.name = keyboard.nextLine();
    }

    public void setCost(int gatewayNumber) {
        System.out.println("\nSelect the payment scheme for the Payment gateway number " + gatewayNumber);
        System.out.println("1 - Yearly");
        System.out.println("2 - Monthly");
        final int scheme = keyboard.nextInt();
        switch (scheme) {
            case 1:
                System.out.println("\nEnter the yearly cost for the Payment gateway number " + gatewayNumber);
                final double costYear = keyboard.nextDouble();
                this.cost = getPerHourCostFromYear(costYear);
                break;
                
            case 2:
                System.out.println("\nEnter the monthly cost for the Payment gateway number " + gatewayNumber);
                final double costMonth = keyboard.nextDouble();
                this.cost = getPerHourCostFromMonth(costMonth);
                break;
        
            default:
                System.out.println("\nInvalid entry. Try again..");
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