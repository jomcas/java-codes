import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author castanedajl
 */
public class RegexFileReading {

    /**
     * Note: All method implementation should be able to handle exceptions.
     */
    /**
     * Basic encryption algorithm
     *
     * @param character the character to be encrypted
     *
     * @return encrypted character
     */
    public char encrypt(char character) {
        char encryptedChar;
        if (Character.isUpperCase(character)) {
            encryptedChar = (char) (((int) character
                    + 13 - 65) % 26 + 65);
        } else {
            encryptedChar = (char) (((int) character
                    + 13 - 97) % 26 + 97);
        }

        return encryptedChar;
    }

    /**
     * Method for getting user input from user.
     *
     * @return input of user.
     */
    public String getUserInput() {

        Scanner input = new Scanner(System.in);
        System.out.println("Get user input: ");
        String inp = input.nextLine();

        return inp;
    }

    /**
     * Pokemon dialog once upon a time.
     *
     * @return collection of string that will be used as data.
     */
    public String[] getAllDialog() {
        String[] pokemonDialog = {"pikachu: Five more days until y1ou can bring Pokémon that you’ve caught in #PokemonGO over to #PokemonLetsGo! Which Pokémon will you transfer over? http://bit.ly/2RK0ABe",
            "charmander: H1ope you don’t scare easily, Tra195iners—facing off against Agatha means battling her powerful Ghost-type Pokémon!",
            "bulbasaur: T3he first Pokém4on species in Nintendo and Game Freak's Pokémon franchise.",
            "psyduck: qua4ck123 quack456",
            "pidgeot: Mark your calendars for #PokemonGOCommunityDay this Saturday, Trainers.  For three hours, Cyndaquil will appear more frequently in the wild, and as a bonus, you’ll also earn double XP and Stardust for any Pokémon you catch during"};

        return pokemonDialog;
    }

    /**
     * TO-DO implement the logic here that encrypt the text.
     *
     * @param plainText the sentence that will be encrypted.
     *
     * Hint: Use Stringbuilder
     *
     * @return encrypted sentence.
     */
    public String getEncryption(String plainText) {
        String encrypt = "";

        String[] split = plainText.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll(".*\\:$", "");
        }

        //System.out.println(Arrays.toString(split));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("")) {

            } else if (i == split.length - 1) {
                builder.append(split[i]);
            } else {
                builder.append(split[i] + " ");
            }
        }

        encrypt = builder.toString();
        char[] encrypt_arr = encrypt.toCharArray();

        for (int i = 0; i < encrypt_arr.length; i++) {
            encrypt_arr[i] = encrypt(encrypt_arr[i]);
        }
        encrypt = String.copyValueOf(encrypt_arr);

        return encrypt;
    }

    /**
     * TO-DO implement here the logic that returns the UNCLEANED line of a
     * pokemon. The name should also be removed.
     *
     * @param name the pokemon actor.
     *
     * @return the line of the pokemon without the name.
     */
    public String getDialogLine(String name) {
        String uncleaned_dialog = "Mismatch";
        for (int i = 0; i < getAllDialog().length; i++) {
            String dialog = getAllDialog()[i];
            String[] split = dialog.split(" ");
            split[0] = split[0].replaceAll(":", "");
            //System.out.println(split[0]);
            if (split[0].equals(name)) {
                uncleaned_dialog = dialog;
                String[] another_split = uncleaned_dialog.split(" ");
                StringBuilder builder = new StringBuilder();
                for (int j = 1; j < another_split.length; j++) {
                    if (another_split[j].matches("")) {

                    } else if (j == another_split.length - 1) {
                        builder.append(split[j]);
                    } else {
                        builder.append(split[j] + " ");
                    }
                }

                uncleaned_dialog = builder.toString();
                break;
            } 
        }

        return uncleaned_dialog;
    }

    /**
     * TO-DO implement here the logic that returns the CLEANED line of a
     * specific pokemon. The idea is to remove the following: links, numbers and
     * words that contains '@' and '#'
     *
     * HINT: use getDialogLine()
     *
     * @param name the pokemon actor.
     *
     * @return CLEANED line of the pokemon.
     */
    public String getCleanDialogLineOfSpecificPokemon(String name) {
        String uncleaned = getDialogLine(name);
        String uncleaned_temp = "";
        String[] patterns = {"\\@.*", "\\#.*", "http://.*", "\\d"};
        String[] split = uncleaned.split(" ");

        for (int i = 0; i < patterns.length; i++) {
            for (int j = 0; j < split.length; j++) {
                split[j] = split[j].replaceAll(patterns[i], "");
            }
            uncleaned_temp = Arrays.toString(split);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("")) {

            } else if (i == split.length - 1) {
                builder.append(split[i]);
            } else {
                builder.append(split[i] + " ");
            }
        }
        uncleaned_temp = builder.toString();
        uncleaned = uncleaned_temp;

        return uncleaned;
    }

    /**
     * TO-DO implement here the logic that returns the number of vowels in a
     * CLEANED line of a specific pokemon.
     *
     * HINT: use getCleanDialogLineOfSpecificPokemon()
     *
     * @param name the pokemon actor.
     *
     * @return vowel count of the CLEANED line of the pokemon.
     */
    public int getVowelCountInLine(String name) {
        String uncleaned = getCleanDialogLineOfSpecificPokemon(name);
        String uncleaned_temp = uncleaned.replaceAll("[^aeiou]", "");
        
        return uncleaned_temp.length();
    }

    /**
     * TO-DO implement here the logic that returns the sum of all numbers in an
     * UNCLEANED line of a specific pokemon.
     *
     * Note: "123" should be parsed as 1 + 2 + 3
     *
     * HINT: use getCleanDialogLineOfSpecificPokemon()
     *
     * @param name the pokemon actor.
     *
     * @return the sum of numbers in the line.
     */
    public int getSumOfNumbersInLine(String name) {
        int count = 0;
        String uncleaned = getDialogLine(name);
        String uncleaned_temp = uncleaned.replaceAll("[^0-9]", "");
        //System.out.println(uncleaned_temp);
        char[] temp_arr = uncleaned_temp.toCharArray();
        for(int i = 0; i < temp_arr.length; i++) {
            count += Character.getNumericValue(uncleaned_temp.charAt(i));
        }
        return count;
    }
    
    public int count(String str, int index) {
        while(index < str.length()) {
            if(str.charAt(index) == '1' || str.charAt(index) == '2') {
                return 1 + count(str, index + 1);
            }
            else {
                return count(str, index + 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RegexFileReading template = new RegexFileReading();
        String[] temp = template.getAllDialog();
        
//        System.out.println("ENCRYPTED LINES: ");
//        for (String sentence : temp) {
//            System.out.println(template.getEncryption(sentence));
//        }
//        System.out.println("");
//        System.out.println("DIALOG LINE: " + template.getDialogLine("pikachu"));
//        System.out.println("CLEAN DIALOG LINE OF SPECIFIC POKEMON: " + template.getCleanDialogLineOfSpecificPokemon("pikachu"));
//        System.out.println("VOWEL COUNT: " + template.getVowelCountInLine("psyduck"));
//        System.out.println("SUM OF NUMBERS IN LINE: " + template.getSumOfNumbersInLine("psyduck"));
//        System.out.println("DIALOG LINE: " + template.getDialogLine("batman"));

        System.out.println(template.count("jom1112",0));
    }

}