package solutions;

public class Bridge {

    //==========================FIGURES================================

    public interface Figure {
        double square();
        int perimeter();
        String whoAreYou();
    }

    public static class Triangle implements Figure {

        private int a,
                    b,
                    c;

        private Color color;

        public Triangle(int a, int b, int c) {
            this(a, b, c, null);
        }

        public Triangle(int a, int b, int c, Color color) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.color = color;
        }

        @Override
        public double square() {
            double p = (a + b + c) / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public int perimeter() {
            return a + b + c;
        }

        @Override
        public String whoAreYou() {
            return "Треугольник " + (color == null ? "" : color.getName());
        }
    }

    public static class Rectangle implements Figure {

        private int a,
                    b;

        private Color color;

        public Rectangle(int a, int b) {
            this(a, b, null);
        }

        public Rectangle(int a, int b, Color color) {
            this.a = a;
            this.b = b;
            this.color = color;
        }

        @Override
        public double square() {
            return a * b;
        }

        @Override
        public int perimeter() {
            return (a + b) * 2;
        }

        @Override
        public String whoAreYou() {
            return "Прямоугольник " + (color == null ? "" : color.getName());
        }
    }

    public static class Square extends Rectangle {

        public Square(int a) {
            this(a, null);
        }

        public Square(int a, Color color) {
            super(a, a, color);
        }

        @Override
        public String whoAreYou() {
            return "Квадрат " + (super.color == null ? "" : super.color.getName());
        }
    }

    //========================================COLORS==================================

    public interface Color {
        String getName();
        RGB getCode();
    }

    public static class Red implements Color {

        private RGB code;

        public Red() {
            code = new RGB(255, 0, 0);
        }

        @Override
        public String getName() {
            return "red";
        }

        @Override
        public RGB getCode() {
            return this.code;
        }
    }

    public static class Blue implements Color {

        private RGB code;

        public Blue() {
            code = new RGB(0, 0, 255);
        }

        @Override
        public String getName() {
            return "blue";
        }

        @Override
        public RGB getCode() {
            return this.code;
        }
    }

    public static class RGB {

        private int r,
                    g,
                    b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public String toString() {
            return String.format("RGB(%d, %d, %d)", this.r, this.g, this.b);
        }
    }

}
