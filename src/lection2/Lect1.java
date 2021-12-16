package lection2;

import com.sun.deploy.security.ruleset.ExceptionRule;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Collections;
import java.util.Vector;

public class Lect1 {

    public static void main(String[] args) {
        Book book = new Book();
        Double[] dbl = new Double[] {
                1.2, 3.4, 5.6
        };
        MyVector vector = new MyVector(dbl);
        vector.increment();
    }

    static class Book {
        private String name;

        public Book() {
            System.out.println(Book.class.getName());
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    static class MyVector {
        final private Vector<Double> vector;

        public MyVector() {
            vector = new Vector<>();
        };
        public MyVector(final int size) {
            vector = new Vector<>(size);
        }
        public MyVector(final Double[] array) {
            vector = new Vector<>(array.length);
            Collections.addAll(vector, array);
            for (int i = 0; i < array.length; ++i) {
                vector.set(i, array[i]);
            }
        }

        public MyVector add(final MyVector other) throws Exception {
            if (this.vector.size() != other.vector.size()) throw new Exception();
            MyVector myVector = new MyVector(this.vector.size());
            for (int i = 0; i < this.vector.size(); ++i)
                myVector.vector.add(this.vector.get(i) + other.vector.get(i));
            return myVector;
        }

        public MyVector iAdd(final MyVector other) throws Exception {
            if (this.vector.size() != other.vector.size()) throw new Exception();
            for (int i = 0; i < this.vector.size(); ++i) {
                this.vector.set(i, this.vector.get(i) + other.vector.get(i));
            }
            return this;
        }

        public MyVector increment() {
            for (int i = 0; i < this.vector.size(); ++i)
                this.vector.set(i, this.vector.get(i) + 1);
            return this;
        }

        public Double get (int index) {
            return this.vector.get(index);
        }

        public int size() {
            return this.vector.size();
        }
    }
}
