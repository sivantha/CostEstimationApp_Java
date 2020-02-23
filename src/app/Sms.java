package app;

import java.util.Scanner;

public class Sms{
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;

    public Sms(int gatewayNumber) {
        this.setName(gatewayNumber);
        this.setCost(gatewayNumber);
    }

    public void setName(int gatewayNumber) {
        System.out.println("Enter a name for the " + gatewayNumber + "gateway:");
        this.name = keyboard.nextLine();
    }

    public void setCost(int gatewayNumber) {
        System.out.println("Enter the cost for the " + gatewayNumber + "gateway:");
        this.cost = keyboard.nextDouble();
    }
    
    public String getName(){
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}