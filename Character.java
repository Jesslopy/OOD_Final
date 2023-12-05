public class Character {
    private String name;
    private int health;
    private int strength;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    // New attribute to keep track of the current location of the character.
    private Component currentLocation;


    // Method that moves the character to a different sector
    public void moveTo(Component newLocation) {
        this.currentLocation = newLocation;
        System.out.println(this.name + " has moved to " + newLocation.display());
    }

    // Method that allows the character to interact with an event
    public void interactWithEvent(Event event) {
        event.triggerEvent(this);
    }









    // Getters, setters, and other methods
}