import java.util.ArrayList;
import java.util.List;
/**
 * Represents a House, a specific type of Building where people can reside.
 * The House keeps track of its residents and whether it has a dining room.
 *
 * Inherits common building properties from the Building superclass, such as
 * name, address, and number of floors.
 *
 * Provides methods for moving residents in and out, checking if a person is
 * a resident, and determining the number of residents and whether the house
 * has a dining room.
 */

public class House extends Building {
    private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store in the ArrayList
    private Boolean hasDiningRoom;
    private Boolean hasElevator;

    /**
     * Constructs a House with the specified name, address, number of floors, and
     * whether it has a dining room.
     *
     * @param name          The name of the house.
     * @param address       The address of the house.
     * @param nFloors       The number of floors in the house.
     * @param hasDiningRoom True if the house has a dining room, false otherwise.
     */
    public House(String name, String address, int nFloors, Boolean hasDiningRoom, Boolean hasElevator) {
        super(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Overrides the showOptions method to display options available in the library,
     * including general Building options and library-specific ones.
     */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn(String name) \n + moveOut(String name)\n + isResident(String person)");
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
            throw new RuntimeException("This house doesn't have an elevator. You can only take the stairs.");
        }
    }

    /**
     * Checks if the house has a dining room.
     *
     * @return True if the house has a dining room, false otherwise.
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Returns the number of residents currently in the house.
     *
     * @return The number of residents.
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Adds a resident to the house if they are not already present.
     *
     * @param name The name of the person moving in.
     */
    public void moveIn(String name) {
        if (!residents.contains(name)) {
            residents.add(name);
        } else {
            System.out.println(name + " is already a resident of the house");
        }
    }

    public void moveIn(List<String> names) {
        for (String name : names) {
            moveIn(name);
        }
    }

    /**
     * Removes a resident from the house if they are present.
     *
     * @param name The name of the person moving out.
     * @return The name of the person who moved out, or null if they were not a resident.
     */
    public String moveOut(String name) {
        if (residents.contains(name)) {
            residents.remove(name);
            return name;
        } else {
            System.out.println(name + " is not a resident of the house yet");
            return null;
        }
    }

    public void moveOut(List<String> names) {
        for (String name : names) {
            moveOut(name);
        }
    }

    /**
     * Checks if a specified person is a resident of the house.
     *
     * @param person The name of the person to check.
     * @return True if the person is a resident, false otherwise.
     */
    public boolean isResident(String person) {
        return residents.contains(person);
    }

    /**
     * Main method to demonstrate the functionality of the House class by creating
     * a House instance with specified parameters.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        House myHouse = new House("Ziskind House", "Henshaw", 3, true,true);
        System.out.println(myHouse);
    }
}
