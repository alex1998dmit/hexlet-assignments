package exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> first, Map<String, Object> second) {
        TreeMap<String, String> res = new TreeMap<>();
        first.entrySet().stream()
                .forEach(el-> {
                    if (second.containsKey(el.getKey())) {
                        // ключ присутствовал и в первом и во втором массиве с одинаковыми значениями
                        if (el.getValue().equals(second.get(el.getKey()))) {
                            res.put(el.getKey(), "unchanged");
                        } else {
                            // ключ присутствовал и в первом и во втором массиве, но значения отличаются
                            res.put(el.getKey(), "changed");
                        }
                    } else {
                        res.put(el.getKey(), "deleted");
                    }
                    second.remove(el.getKey());
                });
        second.entrySet().stream()
                .forEach(el -> res.put(el.getKey(), "added"));
        return res.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (x, y) -> y,
                LinkedHashMap::new
        ));
    }
}
//END
