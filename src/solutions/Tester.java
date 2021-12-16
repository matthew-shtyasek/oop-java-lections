package solutions;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import solutions.NumericalCharacteristics.*;
import java.io.*;
import java.util.*;

import solutions.Qt.*;
import solutions.InternetShop.*;
import solutions.Bridge.*;

public class Tester {
    private static PrintStream out = System.out;
    private static PrintStream customOut = new MyPrintStream(new MyOutputStream());
    private static int counter;

    public static void main(String[] args) {
        //separator(); //task e
        //tictactoe(); //task f
        //numericalCharacteristics(); //task g
        //point(); //task h
        //reversedMyList(); //task i
        //queque(); //task j
        //table(); //task k
        //qt(); //task l
        //shop(); //task m
        //social(); //task o
        //bridge(); //task p
        //validator(); //task q
        exception2(); //task r
    }

    public static void separator() { //Task E
        Separator sep = new Separator();
        Separator sep2 = new Separator(1, -2, 3, 4, -5);
        sep.add(1);
        sep.add(-3);
        sep.add(100);
        sep.add(0);
        sep.add(-1000);
        System.out.println(sep.isZeroExist());
        System.out.println(sep2.isZeroExist());
        System.out.println(sep.positive().toString());
        System.out.println(sep.negative().toString());
    }

    public static void tictactoe() { //Task F
        TicTacToe ttt = new TicTacToe();
        ttt.showTable();
        ttt.makeToMove(1, 1);
        ttt.makeToMove(1, 1);
        ttt.makeToMove(2, 1);
        ttt.makeToMove(2, 2);
        ttt.makeToMove(2, 3);
        ttt.makeToMove(3, 3);
        ttt.makeToMove(3, 2);
        ttt.showTable();
        ttt.restart();
        ttt.showTable();
        ttt.makeToMove(1, 1);
        ttt.makeToMove(1, 1);
        ttt.makeToMove(2, 1);
        ttt.makeToMove(2, 2);
        ttt.makeToMove(2, 3);
        ttt.makeToMove(3, 3);
        ttt.makeToMove(3, 2);
        ttt.showTable();
    }

    public static void numericalCharacteristics() { //task g
        MinValue min = new MinValue();
        min.add(1);
        min.add(-100);
        min.add(0);

        MaxValue max = new MaxValue();
        max.add(-100);
        max.add(0);
        max.add(101);
        max.add(1);

        MeanValue mean = new MeanValue();
        mean.add(1);
        mean.add(-1);
        mean.add(10);

        MedianValue median = new MedianValue();
        median.add(1);
        median.add(5);
        median.add(2);
        median.add(3);

        System.out.println(min.getResult()); //min
        System.out.println(max.getResult()); //max
        System.out.println(mean.getResult()); //mean
        System.out.println(median.getResult()); //median
    }

    public static void point() { //task h
        Point2D point = new Point2D();
        Point2D point2 = new Point2D(3, 4);
        point.setX(10);
        point.setY(100);

        System.out.println(point2.getX()); //get x, y
        System.out.println(point2.getY());
        System.out.println(point); //toString()
        System.out.println(point2);
        System.out.println(String.format("%s + %s = %s", point, point2, point.add(point2))); //add
        System.out.println(String.format("%s - %s = %s", point, point2, point.sub(point2))); //sub
        System.out.println(String.format("%s * %s = %s", point, point2, point.mul(point2))); //mul

        point2 = new Point2D(point.getX(), point.getY());

        System.out.println(String.format("%s > %s = %s", point, point2, point.gt(point2))); //>
        System.out.println(String.format("%s >= %s = %s", point, point2, point.ge(point2))); //>=
        System.out.println(String.format("%s < %s = %s", point, point2, point.lt(point2))); //<
        System.out.println(String.format("%s <= %s = %s", point, point2, point.le(point2))); //<=

        System.out.println(String.format("%s == %s = %s", point, point2, point.eq(point2))); //==
        System.out.println(String.format("%s != %s = %s", point, point2, point.ne(point2))); //!=
    }

    public static void reversedMyList() { //task I
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-1);
        ReversedMyList<Integer> r = new ReversedMyList<Integer>(list);

        System.out.println("ReversedMyList:");
        for (int i = 0; i < r.len(); ++i) {
            System.out.println(r.get(i));
        }
    }

    public static void queque() { //Task J
        MyQueque<Integer> q = new MyQueque<Integer>(1, 2, 3, 4, 10, -12);
        MyQueque<Integer> q1 = new MyQueque<Integer>();
        q.append(100);
        q1.append(1, 2, 3);
        q1.append(-10);
        for (int i = 0; i < 5; ++i) {
            System.out.println(q1.pop());
        }

        q1.append(1, 2, 10, -100, 100, -11, -22);
        System.out.println(q1.next());
        System.out.println(String.format("%s + %s = %s", q1, q, MyQueque.add(q1, q)));
        q1.addi(new MyQueque<Integer>(1, 3));
        System.out.println(q1);
        System.out.println(q.equals(new MyQueque<Integer>(1, 2, 3, 4, 10, -12, 100)));
        System.out.println(q.equals(q1));

        int shift = 2;
        MyQueque<Integer> q2 = q.shiftL(shift);
        System.out.println(String.format("%s << %d = %s", q, shift, q2));
        shift = 0;
        q2 = q.shiftL(shift);
        System.out.println(String.format("%s << %d = %s", q, shift, q2));
        shift = 7;
        q2 = q.shiftL(shift);
        System.out.println(String.format("%s << %d = %s", q, shift, q2));

        shift = 2;
        q2 = q.shiftR(shift);
        System.out.println(String.format("%s >> %d = %s", q, shift, q2));
        shift = 0;
        q2 = q.shiftR(shift);
        System.out.println(String.format("%s >> %d = %s", q, shift, q2));
        shift = 7;
        q2 = q.shiftR(shift);
        System.out.println(String.format("%s >> %d = %s", q, shift, q2));

        System.out.println(String.format("size(%s) = %d", q, q.size()));
        System.out.println(String.format("size(%s) = %d", q1, q1.size()));
        System.out.println(String.format("size(%s) = %d", q2, q2.size()));
    }

    public static void table() { //Task K
        MyTable table = new MyTable(10, 10);
        for (int i = 0; i < 10; ++i)
            for (int j = 0; j < 10; ++j)
                table.setValue(i, j, new Random().nextInt(100));

        table.showTable();
        System.out.println("======================================================");
        table.addRow(10);
        table.addCol(0);
        table.showTable();

        System.out.println();
        System.out.println(table.value(10, 10));
        System.out.println(table.value(-1, 10));
        System.out.println(table.value(11, 11));

        System.out.println();
        table.setValue(10, 10, 1000);
        System.out.println(table.value(10, 10));

        System.out.println(table.nRows());
        System.out.println(table.nCols());

        table.removeCol(10);
        table.removeRow(0);
        table.showTable();
    }

    public static void qt() { //Task L
        QWidget qw = new QWidget(new Size(10, 10));
        QWidget qw2 = new QWidget(110, 110);
        System.out.println("size(qw) = " + qw.getSize());
        System.out.println("size(qw2) = " + qw2.getSize());

        System.out.println("location(qw) = " + qw.getCurrentLocation());
        System.out.println("location(qw2) = " + qw2.getCurrentLocation());
        qw.move(10, 10);
        qw2.move(new Point(110, 110));
        System.out.println("location(qw) = " + qw.getCurrentLocation());
        System.out.println("location(qw2) = " + qw2.getCurrentLocation());

        System.out.println("\n===================BUTTON=====================\n");

        QPushButton bt = new QPushButton(10, 10);
        QPushButton bt2 = new QPushButton(new Size(110, 110));
        System.out.println("size(bt) = " + bt.getSize());
        System.out.println("size(bt2) = " + bt2.getSize());
        System.out.println("location(bt) = " + bt.getCurrentLocation());
        System.out.println("location(bt2) = " + bt2.getCurrentLocation());

        bt.push();
        bt2.push();

        System.out.println("\n===================CHECKBOX=====================\n");

        QCheckBox ch = new QCheckBox(10, 10);
        QCheckBox ch2 = new QCheckBox(new Size(1111, 1111));
        System.out.println("size(ch) = " + ch.getSize());
        System.out.println("size(ch2) = " + ch2.getSize());
        System.out.println("location(ch) = " + ch.getCurrentLocation());
        System.out.println("location(ch2) = " + ch2.getCurrentLocation());
        ch.push();
        ch.push();
        ch.push();
        ch2.push();
        ch2.push();
    }

    public static void shop() { //Task M
        User u = new User("user");
        System.out.println(u.getLogin());
        System.out.println(u.showProduct("prod"));
        System.out.println();

        Client c = new Client("client");
        System.out.println(c.getLogin());
        System.out.println(c.buy("product"));
        System.out.println();

        Manager m = new Manager("manager");
        System.out.println(m.createProduct("phone"));
        System.out.println(m.updateProduct("mouse"));
        System.out.println(m.deleteProduct("keyboard"));
        System.out.println();

        SuperManager s = new SuperManager("supermanager");
        System.out.println(s.setDiscount(10, c));
        System.out.println();

        Admin a = new Admin("admin");
        System.out.println(a.createUser("user", "user"));
        System.out.println(a.createUser("client", "client"));
        System.out.println(a.createUser("manager", "manager"));
        System.out.println(a.createUser("supermanager", "supermanager"));
        System.out.println(a.createUser("admin", "admin"));
        System.out.println(a.createUser("", ""));
        System.out.println(a.deleteUser("hello"));
    }

    public static void social() { //Task O
        Social.User u = new Social.User("User");
        System.out.println(u.getName());
        u.post("hello");
        u.post("world");
        u.post("for all");
        System.out.println(u.getAllMyPosts());
        System.out.println();

        Social.Person p = new Social.Person("Person", "Russia");
        Social.Person p2 = new Social.Person("Person2", "USA");
        Social.Person p3 = new Social.Person("Person3", "UK");
        System.out.println(p.getCountry());
        System.out.println(p2.getName());
        System.out.println(p3.getCountry());
        System.out.println();

        Social.Group g = new Social.Group("Group", "Hello world");
        Social.Group g2 = new Social.Group("Group 2", "For all world");
        System.out.println(g.getInfo());
        System.out.println(g2.getInfo());

        g.subscribe(p);
        g.subscribe(p2);
        g2.subscribe(p2);
        g2.subscribe(p3);
        g2.subscribe(p3);
        System.out.println(g.getAllSubs());
        System.out.println(g2.getAllSubs());

        g.userPost("hello", p3);
        g.userPost("hello", p);
        g.userPost("11111", p2);
        g.userPost("2222", p);
        g.userPost("333333", p);
        g.userPost("4444", p2);
        System.out.println(g.getAllPosts());
        System.out.println(g.getAllPosts(p));
        System.out.println(g.getAllPosts(p2));
        System.out.println(g.getAllPosts(p3));
        System.out.println();

        g.unsubscribe(p3);
        g.unsubscribe(p2);
        System.out.println(g.getAllPosts());
        System.out.println(g.getAllPosts(p2));
        System.out.println(g.getAllPosts(p));
    }

    public static void bridge() { //Task P
        Triangle t = new Triangle(2, 2, 3);
        System.out.println(t.square());
        System.out.println(t.perimeter());
        System.out.println(t.whoAreYou());
        System.out.println();

        Rectangle r = new Rectangle(10, 15);
        System.out.println(r.square());
        System.out.println(r.perimeter());
        System.out.println(r.whoAreYou());
        System.out.println();

        Square s = new Square(100);
        System.out.println(s.square());
        System.out.println(s.perimeter());
        System.out.println(s.whoAreYou());

        Square s2 = new Square(100, new Blue());
        System.out.println(s2.whoAreYou());
        System.out.println(new Blue().getCode());
        System.out.println(new Red().getCode());
    }

    public static void validator() { //Task Q
        try {
            Validator.checkPassword("hello");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Validator.checkPassword("hellooooo");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Validator.checkPassword("Hellloooooo");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Validator.checkPassword("HELLOOOOO23");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Validator.checkPassword("Hellooooo2345");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("oh");
        }
    }

    public static void exception2() { //Task R
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(9);
        list.add(11);
        list.add(8);
        list.add(10);
        list.add(10);
        System.out.println(Arrays.toString(Exception2.myMethod(Tester::iff, list).toArray()));

        list.clear();
        Exception2.myMethod(Tester::iff, list);
    }

    public static Integer iff(int a) {
        if (a == 10)
            return 0;
        return a;
    }

    //===================================Test Methods======================================//

    public static void testWatch() {
        final int count = 10;
        counter = 0;
        Watch watch = new Watch();
        for (int i = 0; i < count; ++i) watch.tick();
        if (counter != count) {
            System.err.println(String.format("2. В задаче B строка \"тик\" вывелась %d раз вместо %d", counter, count));
            System.exit(0);
        }
        MyPrintStream.printMessage("Задача B решена верно!");
    }

    public static void testButton() {
        final int count = 10;
        counter = 0;
        Button button = new Button();
        System.out.println(button.getClickCount());
        for (int i = 0; i < count; ++i) button.click();
        System.out.println(button.getClickCount());
        button.reset();
        System.out.println(button.getClickCount());
        MyPrintStream.printMessage("Задача C решена верно!");
    }

    public static void testTugOfWar() {
        counter = 0;
        TugOfWar tugOfWar = new TugOfWar();
        for (int i = 0; i < 10; ++i) {
            int[] tmp = {new Random().nextInt(10), new Random().nextInt(10)};
            tugOfWar.addLeft(tmp[0]);
            tugOfWar.addRight(tmp[1]);
            System.out.println(String.format("tmp { %d, %d }", tmp[0], tmp[1]));
            System.out.println(tugOfWar.result());
        }

    }

    //======================================Stream Classes=====================================

    static class MyPrintStream extends PrintStream {
        ArrayList<String> testMethodNames = new ArrayList<String>(Arrays.asList("testWatch", "testButton", "testTugOfWar"));

        public MyPrintStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) { handler(x); }
        @Override
        public void println(int x) { handler(x); }

        private void handler(Object obj) {
            String str = obj.toString();
            String methodName = "";
            try { //Проверка на наличие одного из методов тестирования в стеке вызовов
                for (StackTraceElement el : Thread.currentThread().getStackTrace()) {
                    if (testMethodNames.contains(el.getMethodName())) {
                        methodName = el.getMethodName();
                        break;
                    }
                }
            } catch (Exception e) {
                for (StackTraceElement el : e.getStackTrace())
                    System.err.println(el.toString());
            }

            switch (methodName) { //tests
                case "testWatch":
                    if (!str.equals("тик")) {
                        System.err.println(String.format("1. В задаче B выводится \"%s\" вместо \"тик\"", str));
                        System.exit(0);
                    }
                    break;

                case "testButton":
                    boolean flag = false;
                    if ((counter == 0 || counter == 2) && !str.equals("0") || counter == 1 && !str.equals("10")) {
                        System.err.println("1. В задаче C выводится неверное количество нажатий на кнопку");
                        System.exit(0);
                    }
                    break;

                case "testTugOfWar":
                    break;

                default:
                    printMessage(str);
                    --counter;
            }
            ++counter;
        }

        public static void printMessage(String str) {
            System.setOut(Tester.out);
            System.out.println(str);
            System.setOut(Tester.customOut);
        }
    }

    static class MyOutputStream extends OutputStream {
        @Override
        public void write(int b) {

        }
    }
}
