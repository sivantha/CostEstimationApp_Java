package app;

import java.util.Scanner;

public class Subscription{
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;

    public Subscription(int subscriptionNumber) {
        this.setName(subscriptionNumber);
        this.setCost(subscriptionNumber);
    }

    public void setName(int subscriptionNumber) {
        System.out.println("Enter a name for the " + subscriptionNumber + "server:");
        this.name = keyboard.nextLine();
    }

    public void setCost(int subscriptionNumber) {
        System.out.println("Select the payment scheme for the subscription no. " + subscriptionNumber);
        System.out.println("1 - Yearly");
        System.out.println("2 - Monthly");
        System.out.println("3 - Daily");
        final int scheme = keyboard.nextInt();
        switch (scheme) {
            case 1:
                System.out.println("Enter the yearly cost for the subscription no. " + subscriptionNumber);
                double costYear = keyboard.nextDouble();
                this.cost = getPerHourCostFromYear(costYear);
                break;
                
            case 2:
                System.out.println("Enter the monthly cost for the subscription no. " + subscriptionNumber);
                double costMonth = keyboard.nextDouble();
                this.cost = getPerHourCostFromMonth(costMonth);
                break;

            case 3:
                System.out.println("Enter the daily cost for the subscription no. " + subscriptionNumber);
                double costDay = keyboard.nextDouble();
                this.cost = getPerHourCostFromDay(costDay);
                break;
        
            default:
                System.out.println("Invalid entry. Try again..");
                this.setCost(subscriptionNumber);
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

    private double getPerHourCostFromDay(double costDay){
        double cost;
        cost = costDay/8.0;
        return cost;
    }

    public String getName(){
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}