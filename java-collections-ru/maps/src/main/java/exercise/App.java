package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence = "word text dog apple word apple word";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);System.out.println(result);
    }
    public static Map<String, Integer> getWordCount(String str) {
        Map<String, Integer> res = new HashMap<>();
        if (str.length() == 0) {
            return res;
        }
        String[] strArr = str.split(" ");
        for (String word: strArr) {
            if (res.containsKey(word)) {
                res.replace(word, res.get(word) + 1);
            } else {
                res.put(word, 1);
            }
        }
        return res;
    }

    public static String toString(Map<String, Integer> words) {
        if (words.size() == 0) {
            return "{}";
        }
        String res = "{";
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            res += "\n" + "  " + word.getKey() + ": " + word.getValue();
        }
        res+="\n}";
        return res;
    }
}
//END
