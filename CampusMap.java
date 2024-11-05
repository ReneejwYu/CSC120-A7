import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Ziskind House", "1 Henshaw Ave, Northampton, MA 01063", 3,true,true));
        myMap.addBuilding(new Building("Cutter House", "10 Prospect St, Northampton, MA 01060", 3));
        myMap.addBuilding(new Building("Northrop House", "49 Elm St, Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Smith College Museum of Art", "20 Elm St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "44 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Anisworth Gym and Oline Fitness Center", "102 Lower College Ln, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Campus Center", "100 Elm St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Mendenhall Center for the Performing Arts", "122 Green St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true)); 
        myMap.addBuilding(new Cafe("Campus Cafe", "Smith College Campus Center", 1, 100, 50, 30, 20,false));
        
        System.out.println(myMap);
    }
    
}
