package solutions;

public class TugOfWar {
    private int countLeft = 0,
                countRight = 0;

    public void addLeft(int countLeft) { this.countLeft = countLeft; }
    public void addRight(int countRight) { this.countRight = countRight; }
    public char result() {
        switch (Integer.compare(this.countLeft, this.countRight)) {
            case 1: return 'L';
            case -1: return 'R';
            default: return '=';
        }
    }
}
