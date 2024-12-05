/**
 * Represents a Cafe, which is a specific type of Building that sells coffee
 * and maintains an inventory of coffee ounces, sugar packets, cream, and cups.
 * The Cafe can sell coffee based on specified requirements of size and ingredient
 * preferences. If ingredients run low, the Cafe will automatically restock.
 *
 * Inherits common building properties from the Building superclass, including
 * name, address, and number of floors.
 *
 * Provides methods for selling coffee and restocking ingredients.
 */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private Boolean hasElevator;

    /**
     * Constructs a Cafe with the specified name, address, number of floors, and
     * initial inventory levels for coffee ounces, sugar packets, creams, and cups.
     *
     * @param name           The name of the cafe.
     * @param address        The address of the cafe.
     * @param nFloors        The number of floors in the cafe.
     * @param nCoffeeOunces  The initial ounces of coffee in stock.
     * @param nSugarPackets  The initial number of sugar packets in stock.
     * @param nCreams        The initial number of cream portions in stock.
     * @param nCups          The initial number of cups in stock.
     * @param hasElevator    Whether the cafe has elevator
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, Boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Overrides the showOptions method to display options available in the library,
     * including general Building options and library-specific ones.
     */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()");
    }


    /**
     * Overrides the goToFloor method to allow moving to any floor directly if the library
     * has an elevator; otherwise, only allows movement to adjacent floors.
     *
     * @param floorNum The floor to navigate to.
     */
    public void goToFloor(int floorNum) {
        if (this.hasElevator) {
            super.goToFloor(floorNum);
        } else {
            throw new RuntimeException("This building doesn't have an elevator. You can only take the stairs.");
        }
    }  

    /**
     * Sells a cup of coffee with the specified size, number of sugar packets, and
     * cream portions. If the inventory is insufficient, the Cafe will automatically
     * restock the necessary ingredients.
     *
     * @param size           The size of the coffee in ounces.
     * @param nSugarPackets  The number of sugar packets to add.
     * @param nCreams        The number of cream portions to add.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCoffeeOunces < size || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || nCups == 0) {
            System.out.println("Not enough ingredients. Restocking...");
            restock(size - nCoffeeOunces, nSugarPackets - this.nSugarPackets, nCreams - this.nCreams, 1 - nCups);
        }
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups -= 1;

        System.out.println("Sold a coffee with " + size + " ounces, " + nSugarPackets + " sugar packets, and " + nCreams + " cream.");
    }

    /**
    * Sells a standard coffee with default size, sugar packets, and cream portions.
    * Useful for customers who want a quick, default option.
    */
    public void sellCoffee() {
        int standardSize = 4;        // Default size for standard coffee
        int standardSugar = 2;       // Default sugar packets for standard coffee
        int standardCreams = 1;      // Default cream portions for standard coffee
        sellCoffee(standardSize, standardSugar, standardCreams);
    }

    /**
     * Restocks the cafe's inventory of coffee, sugar packets, cream, and cups.
     * Only restocks quantities that are below required levels, so only positive
     * values are added to current inventory levels.
     *
     * @param nCoffeeOunces  The ounces of coffee to restock.
     * @param nSugarPackets  The sugar packets to restock.
     * @param nCreams        The cream portions to restock.
     * @param nCups          The cups to restock.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if (nCoffeeOunces > 0) {
            this.nCoffeeOunces += nCoffeeOunces;
        } if (nSugarPackets > 0) {
            this.nSugarPackets += nSugarPackets;
        } if (nCreams > 0) {
            this.nCreams += nCreams;
        } if (nCups > 0) { this.nCups += nCups;
        }

        System.out.println("Restocked: " + nCoffeeOunces + " ounces of coffee, " + nSugarPackets +
                           " sugar packets, " + nCreams + " creams, and " + nCups + " cups.");
    }

    /**
     * Restocks only the specified number of cups.
     * This method allows targeted restocking of cups when only cups are needed.
     * @param nCups The number of cups to restock.
     */
    private void restock(int nCups) {
        if (nCups > 0) {
            this.nCups += nCups; 
        }
        System.out.println("Restocked: " + nCups + " cups.");
    }
    
    /**
     * Main method to demonstrate the Cafe class functionality by creating a Cafe
     * instance with specified parameters.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "Smith College Campus Center", 1, 100, 50, 30, 20,false);
    }
}
