package solutions;

import java.util.List;

public class ReversedMyList <T> {
    List<T> list;

    public ReversedMyList(List<T> list) {
        this.list = list;
    }

    public int len() {
        return this.list.size();
    }

    public T get(int index) {
        return list.get(list.size() - index - 1);
    }
}