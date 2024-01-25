// import block
import java.util.*;
import java.util.random.RandomGenerator;

public class HangMan {
    public static void main(String[] args) {
        // boolean's for game
        boolean gameEnd = false;


        // Create Array for the rows
        Map<Integer, ArrayList> HangManDrawingContainer = new TreeMap<>();
        for (int i = 0; i < 9; i++) {
            // create an arraylist to hold each row
            HangManDrawingContainer.put(i, new ArrayList<Character>());
        }

        // Set up each row with spaces as default
        for (int i = 0; i < 9; i++) {
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
        System.out.print("Answer: ");
        System.out.println(answer);

        // map for word
        ArrayList<Character> HangManWordArr = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            HangManWordArr.add('_');
        }
        // test print
        System.out.println(HangManWordArr);

        // Lives to control game loop
        int lives = 10;

            // start game loop
        while (lives > 0) {
            // check if they have got the word?
            if (!HangManWordArr.contains('_')) {
                System.out.println("Congratulations you win!");
                break;
            }


            // print current answer line,
            System.out.println(HangManWordArr);
            // ask for input
            Scanner guessInput = new Scanner(System.in);
            System.out.println("Guess a letter: ");
            String guess = guessInput.nextLine();
            Character firstChar = guess.toLowerCase().charAt(0);
            // check if it matches any of the letters already in the HangManWordArr
            if (HangManWordArr.contains(firstChar)) {
                System.out.println("You've already got that letter try again.");
                continue;
            } else if (answer.toLowerCase().contains(firstChar.toString())) {
            // if yes fill those letters out
                System.out.println("Good guess");
                // get the indecies of every instance of that letter
                ArrayList<Integer> updateIndecies = new ArrayList<>();
                // loop thru to check for all instances
                for (int index = answer.toLowerCase().indexOf(firstChar); index < answer.length(); index = answer.indexOf(firstChar, index+1)) {
                    // debug print
                    System.out.println("Index:" + index);
                         if (index != -1) {
                            // append the index to the arrayList
                            updateIndecies.add(index);
                            // break condition
                        } else {
                            break;
                        }
                }
                // replace the values at the indicies of HangManWordArr
                for (int index : updateIndecies) {
                    HangManWordArr.set(index, firstChar);
                }
                continue;
            } else {
            // else draw a hang man line and decrement lives
                System.out.println("Sorry, that's missing, you've lost a life");
                lives--;
                System.out.printf("Lives remaining %s%n", lives);
            }
        }
    }
}
