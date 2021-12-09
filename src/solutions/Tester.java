package solutions;

import solutions.NumericalCharacteristics.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tester {
    private static PrintStream out = System.out;
    private static PrintStream customOut = new MyPrintStream(new MyOutputStream());
    private static int counter;

    public static void main(String[] args) {
        //separator(); //task e
        //tictactoe(); //task f
        //numericalCharacteristics(); //task g
        //point(); //task h
        reversedMyList(); //task i
        //table(); //task k
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



    public static void table() { //Task K
        MyTable table = new MyTable(10, 10);
        for (int i = 0; i < 10; ++i)
            for (int j = 0; j < 10; ++j)
                table.setValue(i, j, new Random().nextInt(100));

        table.showTable();
        System.out.println("======================================================");
        table.addRow(9);
        table.addCol(3);
        table.showTable();
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
