public class WarEvent implements Event {

    @Override
    public void triggerEvent(Character character) {
        System.out.println("War has broken out in " + character.getCurrentLocation().display());
        // War affects all characters in the location
        List<Character> affectedCharacters = character.getCurrentLocation().getCharacters();
        for (Character affectedCharacter : affectedCharacters) {
            affectedCharacter.decreaseHealth(30); // Assuming a method to decrease health exists.
            // Potentially trigger other events as a result of war
            Event refugeeEvent = new RefugeeEvent();
            refugeeEvent.triggerEvent(affectedCharacter);
        }
    }
}