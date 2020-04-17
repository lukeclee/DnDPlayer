import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class DnDPlayer
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner userScan = new Scanner(System.in);
        String userInput = "";
        userInput = userScan.nextLine();
        if ((userInput.substring(0, 4)).equals("roll")) {

            System.out.println("You rolled a " + roll(userInput.substring(5)) + "!");

        } else if ((userInput.substring(0, 6)).equals("create")) {

            String characterName;
            String characterRace;
            String characterClass;
            int armorClass = 0;
            System.out.println("Please enter your characters name, race, and class.");
            System.out.print("Name: ");
            characterName = userScan.nextLine();
            System.out.println();
            System.out.print("Race: ");
            characterRace = userScan.nextLine();
            System.out.println();
            System.out.print("Class: ");
            characterClass = userScan.nextLine();
            System.out.println();
            System.out.print("Armor class: ");
            armorClass = userScan.nextInt();
            System.out.println();
            int[] characterValues = new int[6];
            userScan.nextLine();
            System.out.println("Would you like to automatically roll character attributes (Y) or have you already rolled numbers (N)?");
            System.out.println("Press any other key if you don't want to set character attributes yet.");
            userInput = userScan.nextLine();
            if (userInput.equals("Y") || userInput.equals("y")) {
                for(int i = 0; i < 6; i++) {
                    characterValues[i] = setCharacterValue();
                }
                //eventually, the user should be able to pick which rolls go to which attributes
            } else if (userInput.equals("N") || userInput.equals("n")){
                System.out.println("Please enter each attribute followed by enter.");
                System.out.println("(Attributes in order are: strength, dexterity, constitution, intelligence, wisdom, charisma.)");
                for(int i = 0; i < characterValues.length; i++) {
                    characterValues[i] = userScan.nextInt();
                }
            } else {
                //I don't know if I really need more logic to catch anything here.
            }
            Character playerCharacter = new Character(characterName, characterRace, characterClass, armorClass, characterValues);
            playerCharacter.printCharacterTraits();
        } else if ((userInput.substring(0, 10)).equals("initiative")) {

        } else {

            System.out.println("Please make sure you type the command correctly.");

        }
        userScan.close();
    }

    public static int roll(String dice)
    {
        dice = dice.replaceAll("[^\\d]", "");
        int diceValue = Integer.parseInt(dice);
        return (int)((Math.random() * ((diceValue - 1) +1 )) + 1);

    }

    public static int setCharacterValue()
    {
        Integer[] rolls = new Integer[4];
        int characterValue;
        for(int i = 0; i < rolls.length; i++)
        {
            rolls[i] = roll("d6");
        }
        Arrays.sort(rolls, Collections.reverseOrder());
        characterValue = rolls[0] + rolls[1] + rolls[3];
        return characterValue;
    }
}
