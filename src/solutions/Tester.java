package solutions;

import com.sun.deploy.security.ruleset.ExceptionRule;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import javafx.application.Application;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Tester {
    private static PrintStream out = System.out;
    private static PrintStream customOut = new MyPrintStream(new MyOutputStream());
    private static int counter;

    public static void main(String[] args) {
        System.setOut(customOut);
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
