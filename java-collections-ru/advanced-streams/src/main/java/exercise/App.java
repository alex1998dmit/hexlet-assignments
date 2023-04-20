package exercise;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    static public String getForwardedVariables(String content) {
        String myList = new ArrayList<String>(Arrays.asList(content.split("\n"))).stream()
                .filter(str->str.startsWith("environment="))
                .flatMap(str -> new ArrayList<String>(
                        Arrays.asList(
                            str
                            .replaceAll("environment=", "")
                            .replaceAll("\"", "")
                            .trim()
                            .split(","))
                ).stream()
                    .filter(word->word.startsWith("X_FORWARDED_"))
                    .map(word->word.replaceAll("X_FORWARDED_", ""))
        ).collect(Collectors.joining(","));
        return myList;
    }
}
//END
