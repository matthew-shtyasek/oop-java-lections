package solutions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NumericalCharacteristics {
    ArrayList<Integer> list;

    public NumericalCharacteristics() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public static class MinValue extends NumericalCharacteristics {
        public int getResult() {
            return Collections.min(list);
        }
    }

    public static class MaxValue extends NumericalCharacteristics {
        public int getResult() {
            return Collections.max(list);
        }
    }

    public static class MeanValue extends NumericalCharacteristics {
        public double getResult() {
            AtomicInteger sum = new AtomicInteger();
            list.forEach(sum::addAndGet);
            return sum.intValue() / (double)list.size();
        }
    }

    public static class MedianValue extends NumericalCharacteristics {
        public double getResult() {
            return list.size() % 2 == 0 ? (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0 : list.get(list.size() / 2);
        }
    }

}