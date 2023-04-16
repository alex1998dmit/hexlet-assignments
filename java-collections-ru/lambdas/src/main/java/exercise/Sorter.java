package exercise;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Sorter::sortByAge)
                .map(Sorter::getUserName)
                .collect(Collectors.toList());
    }

    public static String getUserName(Map<String, String> user) {
        return user.get("name");
    }
    
    private static int sortByAge(Map<String, String> u1, Map<String, String> u2) {
        LocalDate  dt1 = LocalDate.parse( u1.get("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate  dt2 = LocalDate.parse( u2.get("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return dt1.compareTo(dt2);
    }
}
// END
