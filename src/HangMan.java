// import block
import java.util.*;
import java.util.random.RandomGenerator;

public class HangMan {

    public static void main(String[] args) {
        // boolean's for game
        boolean gameEnd = false;

        // Create Array for the rows
        Map<Integer, ArrayList> HangManDrawingContainer = new TreeMap<>();
        for (int i = 1; i < 9; i++) {
            // create an arraylist to hold each row
            HangManDrawingContainer.put(i, new ArrayList<Character>());
        }

        // Set up each row with spaces as default
        for (int i = 1; i < 9; i++) {
            // Access the ArrayList and add eight blank entries
            for (int j = 0; j < 8; j++) {
                HangManDrawingContainer.get(i).add(' ');
            }
        }

        // Test print
        for (Map.Entry<Integer, ArrayList> entry : HangManDrawingContainer.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Character> value = entry.getValue();

            System.out.print(key + ": ");
            for (Character character : value) {
                System.out.print(character + ",");
            }
            System.out.println();
        }

        // pick random word from a list
        // Create list
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("Cheese");
        wordList.add("France");
        wordList.add("Xylophone");
        wordList.add("Tamagotchi");
        wordList.add("Lumberjack");
        wordList.add("Toast");
        wordList.add("Jangle");
        wordList.add("Flywheel");
        wordList.add("Encapsulate");

//        // test print
//        for (String word : wordList) {
//            System.out.println(word);
//        }

        // Select from list
        Random rando = new Random();
        String answer = wordList.get(rando.nextInt(0, wordList.size()));

        // test print
//        System.out.print("Answer: ");
//        System.out.println(answer);

        // map for word
        ArrayList<Character> HangManWordArr = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            HangManWordArr.add('_');
        };

        // test print
        System.out.println(HangManWordArr);


        
        

        // print hash map state

        // print underlines

        // start game loop (while loop, condition boolean lose/win

            // ask for input

            // check if it matches any of the letters
                // if yes fill those letters out
                // else draw a hang man line

    }
}
