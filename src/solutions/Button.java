package solutions;

public class Button {
    private int clickCount = 0;

    public void click() { ++this.clickCount; }
    public int getClickCount() { return this.clickCount; }
    public void reset() { this.clickCount = 0; }
}
