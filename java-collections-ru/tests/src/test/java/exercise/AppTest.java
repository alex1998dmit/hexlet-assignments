package exercise;


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> arr = new ArrayList<>();
        List<Integer> expectedArr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        expectedArr.add(1);
        expectedArr.add(2);
        List<Integer> res = App.take(arr, 2);
        Assertions.assertEquals(res, expectedArr);
        // END
    }
}
