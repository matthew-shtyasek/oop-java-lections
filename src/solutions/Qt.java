package solutions;

public class Qt {

    public static class Size {
        private int width;
        private int height;

        public Size() {
            this(0, 0);
        }

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return String.format("Size(%d; %d)", this.width, this.height);
        }
    }

    public static class Point {
        private int x;
        private int y;

        public Point() {
            this(0, 0);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("Point(%d; %d)", this.x, this.y);
        }
    }

    public static class QWidget {
        private Size size;
        private Point point;

        public QWidget(int width, int height) {
            this(new Size(width, height));
        }

        public QWidget(Size size) {
            this.size = size;
            this.point = new Point();
        }

        public Size getSize() {
            return this.size;
        }

        public void move(int x, int y) {
            move(new Point(x, y));
        }

        public void move(Point point) {
            this.point = point;
        }

        public Point getCurrentLocation() {
            return this.point;
        }
    }

    public static class QPushButton extends QWidget {

        public QPushButton(int width, int height) {
            super(width, height);
        }

        public QPushButton(Size size) {
            super(size);
        }

        public void push() {
            System.out.println("На меня нажали");
        }
    }

    public static class QCheckBox extends QPushButton {

        private boolean flag = false;

        public QCheckBox(int width, int height) {
            super(width, height);
        }

        public QCheckBox(Size size) {
            super(size);
        }

        @Override
        public void push() {
            flag = !flag;
            System.out.println(flag ? "Check" : "Uncheck");
        }
    }
}
