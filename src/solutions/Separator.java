package solutions;
import java.util.*;

public class Separator {
    private Vector<Float> numbers;

    public Separator(float...numbers) {
        this.numbers = new Vector<>();
        for (float n : numbers)
            this.numbers.add(n);
    }

    public void add(float num) {
        this.numbers.add(num);
    }

    public Vector<Float> positive() {
        Vector<Float> positive = new Vector<>();
        for (float n : this.numbers)
            if (n > 0) positive.add(n);
        return positive;
    }

    public Vector<Float> negative() {
        Vector<Float> negative = new Vector<>();
        for (float n : this.numbers)
            if (n < 0) negative.add(n);
        return negative;
    }

    public boolean isZeroExist() {
        return this.numbers.contains(0f);
    }
}
