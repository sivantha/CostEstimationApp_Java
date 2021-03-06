package app;

import java.util.Scanner;

public class Consumable{
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;

    public Consumable(int consumableNumber) {
        this.setName(consumableNumber);
        this.setCost(consumableNumber);
    }

    public void setName(int consumableNumber) {
        System.out.println("\nEnter a name for the Consumable number " + consumableNumber);
        this.name = keyboard.nextLine();
    }

    public void setCost(int consumableNumber) {
        System.out.println("\nEnter the monthly cost for the Consumable number " + consumableNumber);
        this.cost = getPerHourCostFromMonth(keyboard.nextDouble());
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
    // Type -  WiFi
    // Subtype - Dialog
    // Monthly cost
    // Monthly capacity
    // Per hour cost - 20X8
    // Time dependent and Employee Dependent
}