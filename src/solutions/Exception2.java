package solutions;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
import java.util.function.UnaryOperator;

public class Exception2 {

    public static List<Integer> myMethod (UnaryOperator<Integer> method, List<Integer> list) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("Список пуст");
        Set<Integer> tempSet = new HashSet<>();

        for (Integer integer : list) {
            if (integer > 100) throw new IndexOutOfBoundsException("Очень большое число");
            if (method.apply(integer) != 0) {
                tempSet.add(integer);
            }
        }
        return new LinkedList<>(tempSet);
    }
}
