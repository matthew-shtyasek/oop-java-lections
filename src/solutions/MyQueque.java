package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyQueque<T> {
    private List<T> list;

    @SafeVarargs
    public MyQueque(T...args) {
        this.list = new ArrayList<>(args.length);
        this.list.addAll(Arrays.asList(args));
    }
    public MyQueque(List<T> list) {
        this.list = list;
    }

    @SafeVarargs
    public final void append(T... args) {
        this.list.addAll(Arrays.asList(args));
    }

    public T pop() {
        T temp = list.get(0);
        list.remove(0);
        return temp;
    }

    public MyQueque<T> next() {
        return new MyQueque<T>(this.list.subList(1, list.size()));
    }

    public static <I>MyQueque add(MyQueque<I> q1, MyQueque<I> q2) {
        List<I> list = new ArrayList<>(q1.list.size() + q2.list.size());
        list.addAll(q1.list);
        list.addAll(q2.list);
        return new MyQueque<I>(list);
    }

    public void addi(MyQueque<T> other) {
        this.list.addAll(other.list);
    }

    public boolean equals(MyQueque<T> other) {
        if (this.list.size() != other.list.size()) return false;
        for (int i = 0; i < this.list.size(); ++i)
            if (this.list.get(i) != other.list.get(i)) return false;
        return true;
    }

    public MyQueque<T> shiftR(int sh) {
        if (sh < 0 || sh > this.list.size() - 1) return null;
        return new MyQueque<T>(this.list.subList(sh, list.size()));
    }

    public MyQueque<T> shiftL(int sh) {
        if (sh < 0 || sh > this.list.size() - 1) return null;
        return new MyQueque<T>(this.list.subList(0, list.size() - sh));
    }

    public int size() {
        return this.list.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (T el : this.list)
            stringBuilder.append(el).append(" -> ");
        return stringBuilder.substring(0, stringBuilder.length() - 4) + ']';
    }
}
