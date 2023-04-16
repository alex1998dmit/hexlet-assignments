package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    static public long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
            .filter((em) -> em.contains("@gmail.com") || em.contains("@yandex.ru") || em.contains("@hotmail.com"))
            .count();
    }
}
// END
