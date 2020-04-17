public class Character {
    String name;
    String characterRace;
    String characterClass;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int strengthMod;
    int dexterityMod;
    int constitutionMod;
    int intelligenceMod;
    int wisdomMod;
    int charismaMod;
    int proficiencyMod = 2;
    int passivePerception;
    int armorClass;
    int health;


    Character(String inputName, String inputRace, String inputClass)
    {
        name = inputName;
        characterRace = inputRace;
        characterClass = inputClass;
    }

    Character(String inputName, String inputRace, String inputClass, int inputArmorClass, int[] characterValues)
    {
        name = inputName;
        characterRace = inputRace;
        characterClass = inputClass;
        armorClass = inputArmorClass;
        strength = characterValues[0];
        strengthMod = setCharacterModValue(strength);
        dexterity = characterValues[1];
        dexterityMod = setCharacterModValue(dexterity);
        constitution = characterValues[2];
        constitutionMod = setCharacterModValue(constitution);
        intelligence = characterValues[3];
        intelligenceMod = setCharacterModValue(intelligence);
        wisdom = characterValues[4];
        wisdomMod = setCharacterModValue(wisdom);
        charisma = characterValues[5];
        charismaMod = setCharacterModValue(charisma);
    }

    private static int setCharacterModValue(int characterIntValue)
    {
        int characterModValue;
        characterModValue = (characterIntValue/2) - 5;
        return characterModValue;
    }

    public void printCharacterTraits()
    {
        System.out.println("Character Attributes for " + name + ":");
        System.out.println("Race - " + characterRace + ". Class - " + characterClass + ".");
        System.out.println("Armor Class - " + armorClass);
        System.out.println("Strength - " + strength);
        System.out.println("Dexterity - " + dexterity);
        System.out.println("Constitution - " + constitution);
        System.out.println("Intelligence - " + intelligence);
        System.out.println("Wisdom - " + wisdom);
        System.out.println("Charisma - " + charisma);
    }
}
