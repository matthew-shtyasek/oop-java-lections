package solutions;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
    }

    public static void testWatch() {
        Watch watch = new Watch();
        for (int i = 0; i < 10; ++i) watch.tick();
    }

    public static void testButton() {
        Button button = new Button();
        System.out.println(button.getClickCount());
        for (int i = 0; i < 10; ++i) button.click();
        System.out.println(button.getClickCount());
        button.reset();
        System.out.println(button.getClickCount());
    }

    public static void testTugOfWar() {
        TugOfWar tugOfWar = new TugOfWar();
        for (int i = 0; i < 10; ++i) {
            int[] tmp = {new Random().nextInt(10), new Random().nextInt(10) };
            tugOfWar.addLeft(tmp[0]);
            tugOfWar.addRight(tmp[1]);
            System.out.println(String.format("tmp { %d, %d }", tmp[0], tmp[1]));
            System.out.println(tugOfWar.result());
        }

    }
}
