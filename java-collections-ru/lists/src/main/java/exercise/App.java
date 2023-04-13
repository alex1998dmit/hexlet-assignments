package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) {
        System.out.println("test");
    }

    public static boolean scrabble(String words, String word) {
        List<String> wordsList = new ArrayList<String>(Arrays.asList(words.split("")));
        List<String> wordList = new ArrayList<String>(Arrays.asList(word.split("")));

        for (int i = 0; i < wordsList.size(); i++) {
            wordsList.set(i, wordsList.get(i).toLowerCase());
        }
        for (String wordLetter: wordList) {
            if (!wordsList.contains(wordLetter.toLowerCase())) {
                return false;
            } else {
                wordsList.remove(wordLetter.toLowerCase());
            }
        }
        return true;
    }

}
//END
