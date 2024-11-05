import java.util.Hashtable;
import java.util.List;
/**
 * Represents a Library, a specialized type of Building that maintains a collection of books.
 * Each book in the collection is tracked for its availability status.
 *
 * Inherits common building properties from the Building superclass, such as
 * name, address, and number of floors.
 *
 * Provides methods to add and remove books, check books in and out, and
 * view the collection or check the availability of specific titles.
 */

public class Library extends Building {
    private Hashtable<String, Boolean> collection; 
    private boolean hasElevator;
    /**
     * Constructs a Library with the specified name, address, and number of floors.
     * Initializes an empty collection of books.
     *
     * @param name    The name of the library.
     * @param address The address of the library.
     * @param nFloors The number of floors in the library.
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
        System.out.println("You have built a library: 📖");
    }

    /**
     * Overrides the showOptions method to display options available in the library,
     * including general Building options and library-specific ones.
     */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title)\n + printCollection()");
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
     * Adds a book title to the library's collection if it is not already present.
     *
     * @param title The title of the book to add.
     */
    public void addTitle(String title) {
        if (!collection.containsKey(title)) {
            collection.put(title, true);
        } else {
            System.out.println(title + " is already in the collection");
        }
    }

    /**
     * Overloaded method: Adds multiple titles to the library collection at once.
     *
     * @param titles A list of titles to be added to the collection.
     */
    public void addTitle(List<String> titles) {
        for (String title : titles) {
            addTitle(title);
        }
    }

    /**
     * Removes a book title from the library's collection if it is present.
     *
     * @param title The title of the book to remove.
     * @return The title of the removed book, or null if it was not in the collection.
     */
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title);
            return title;
        } else {
            System.out.println(title + " is not in the collection");
            return null;
        }
    }

    /**
     * Checks out a book from the library, setting its availability to false if it is available.
     *
     * @param title The title of the book to check out.
     */
    public void checkOut(String title) {
        if (collection.containsKey(title) && collection.get(title)) {
            collection.put(title, false);
        } else {
            System.out.println(title + " is not in the collection or already checked out.");
        }
    }

    /**
     * Overloaded method: Checks out multiple books from the library at once.
     *
     * @param titles A list of book titles to check out.
     */
    public void checkOut(List<String> titles) {
        for (String title : titles) {
            checkOut(title);
        }
    }

    /**
     * Returns a book to the library, setting its availability to true if it is checked out.
     *
     * @param title The title of the book to return.
     */
    public void returnBook(String title) {
        if (collection.containsKey(title) && !collection.get(title)) {
            collection.put(title, true);
        } else {
            System.out.println(title + " is not in the collection or already available.");
        }
    }

    /**
     * Checks if a specified title is in the library's collection.
     *
     * @param title The title to check for.
     * @return True if the title is in the collection, false otherwise.
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if a specified title is available in the library.
     *
     * @param title The title to check for.
     * @return True if the title is available, false otherwise.
     */
    public boolean isAvailable(String title) {
        return collection.containsKey(title) && collection.get(title);
    }

    /**
     * Prints the entire library collection with each book's availability status.
     */
    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : collection.keySet()) {
            String status = collection.get(title) ? "Available" : "Checked Out";
            System.out.println("- " + title + " (" + status + ")");
        }
    }

    /**
     * Main method to demonstrate the functionality of the Library class by creating
     * a Library instance with specified parameters.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Library myLibrary = new Library("Neilson Library", "1 Chapin Way", 4,true);
    }
}
