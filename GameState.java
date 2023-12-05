import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {
    private List<Character> characters;
    private List<Event> events;
    private List<Observer> observers = new ArrayList<>();

    private double resourceMultiplier;
    private double invasionChance;
    private double famineChance;
    private double plagueChance;

    public GameState() {
        characters = new ArrayList<>();
        events = new ArrayList<>();
        // Default difficulty settings
        setResourceMultiplier(1.0); // Normal resources
        setInvasionChance(0.3); // Normal chance of invasion
        setFamineChance(0.3); // Normal chance of famine
        setPlagueChance(0.2); // Normal chance of plague
    }

    // Observer pattern methods
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Event processing methods
    public void processEvent(String eventType, Character character) {
        Event event = EventFactory.createEvent(eventType);
        character.interactWithEvent(event);
        notifyObservers(); // Assuming observers need to be notified of state changes.
    }

    // Difficulty setting methods
    public void setResourceMultiplier(double multiplier) {
        this.resourceMultiplier = multiplier;
    }

    public void setInvasionChance(double chance) {
        this.invasionChance = chance;
    }

    public void setFamineChance(double chance) {
        this.famineChance = chance;
    }

    public void setPlagueChance(double chance) {
        this.plagueChance = chance;
    }

    // Random event triggering based on current difficulty settings
    public void triggerRandomEvent() {
        Random random = new Random();
        double roll = random.nextDouble();

        if (roll < invasionChance) {
            processEvent("Invasion", getRandomCharacter());
        } else if (roll < invasionChance + famineChance) {
            processEvent("Famine", getRandomCharacter());
        } else if (roll < invasionChance + famineChance + plagueChance) {
            processEvent("Plague", getRandomCharacter());
        }
        // No event occurs if none of the above conditions are met
    }

    private Character getRandomCharacter() {
        if (characters.size() > 0) {
            int index = new Random().nextInt(characters.size());
            return characters.get(index);
        }
        return null; // Or handle the case where there are no characters
    }

    // Getters and setters for other attributes and methods
}
