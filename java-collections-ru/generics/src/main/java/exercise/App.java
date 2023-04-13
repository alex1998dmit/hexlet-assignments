package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> res = new ArrayList<>();
        for (Map<String, String> book : books) {
            boolean isFound = true;
            for (Map.Entry<String, String> whereParam : where.entrySet()) {
                if (!book.containsValue(whereParam.getValue()) && book.containsKey(whereParam.getKey())) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) res.add(book);
        }
        return res;
    }
}
//END
