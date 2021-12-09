package solutions;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
import java.util.function.UnaryOperator;

public class Exception2 {

    public List<Integer> myMethod (UnaryOperator<Integer> method, List<Integer> list) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("Список пуст");
        Set<Integer> tempSet = new HashSet<>();

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > 100) throw new IndexOutOfBoundsException("Очень большое число");
            if (method.apply(list.get(i)) != 0) {
                tempSet.add(list.get(i));
            }
        }

        return new LinkedList<>(tempSet);
    }
}
