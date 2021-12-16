package solutions;

public class Point2D {
    private float   x,
                    y;
    public Point2D() { this(0f, 0f); }
    public Point2D(float x) { this(x, 0f); }
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }

    public float getX() { return this.x; }
    public float getY() { return this.y; }

    @Override
    public String toString() {
        return String.format("Point2D(%.2f, %.2f)", this.x, this.y);
    }

    public Point2D add(Point2D other) { return new Point2D(this.x + other.x, this.y + other.y); }
    public Point2D sub(Point2D other) { return new Point2D(this.x - other.x, this.y - other.y); }
    public Point2D mul(Point2D other) { return new Point2D(this.x * other.x, this.y * other.y); }

    public boolean lt(Point2D other) { return this.getRad() < other.getRad(); }
    public boolean le(Point2D other) { return this.getRad() <= other.getRad(); }
    public boolean gt(Point2D other) { return !this.le(other); }
    public boolean ge(Point2D other) { return !this.lt(other); }

    public boolean eq(Point2D other) { return this.x == other.x && this.y == other.y; }
    public boolean ne(Point2D other) { return !this.eq(other); }

    private float getRad() { return (float)Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));}
}
