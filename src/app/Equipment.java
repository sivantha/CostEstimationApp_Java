package app;

import java.util.Scanner;

public class Equipment{
    Scanner keyboard = new Scanner(System.in);
    private String name;
    private double cost;
    private int units;

    public Equipment(int equipmentNumber) {
        this.setName(equipmentNumber);
        this.setCost(equipmentNumber);
    }

    public void setName(int equipmentNumber) {
        System.out.println("Enter a name for the " + equipmentNumber + "equipment:");
        this.name = keyboard.nextLine();
    }

    public void setCost(int equipmentNumber) {
        System.out.println("Enter the cost for the " + equipmentNumber + "equipment:");
        this.cost = keyboard.nextDouble();
    }

    public void setUnits(int equipmentNumber) {
        System.out.println("Enter no. of units of equipment no." + equipmentNumber);
        this.cost = keyboard.nextDouble();
    }

    public String getName(){
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public int getUnits(){
        return this.units;
    }
    //Type -  Laptop
    //SubType
    //Cost per hour of the subtype
    //How many units
    //Time dependent
}