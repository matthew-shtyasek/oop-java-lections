package solutions;

import java.util.Arrays;

public class TicTacToe {
    private final static int SIZE_TABLE = 3;
    private final static String FINAL_GAME = "Ход не может быть выполнен";
    private char sym;
    private char[][] table = new char[SIZE_TABLE][SIZE_TABLE];
    private boolean isGameFinished = false;

    public TicTacToe() { this('x'); }
    public TicTacToe(char sym) {
        if (!(sym == 'x' || sym == '0')) sym = 'x';
        this.sym = sym;
        restart();
    }

    public void makeToMove(int row, int col) {
        if (!this.isGameFinished) {
            --row; --col;
            try {
                if (this.table[row][col] != '*') throw new Exception();
                this.table[row][col] = this.sym;
                nextMove();
            } catch (Exception e) {
                System.out.println(FINAL_GAME);
            }
        } else
            System.out.println(FINAL_GAME);
    }

    public void showTable() {
        for (char[] row : this.table) {
            for (char elem : row)
                System.out.print(elem);
            System.out.println();
        }
    }

    public void restart() {
        for (char[] row : table)
            Arrays.fill(row, '*');
        this.isGameFinished = false;
    }

    private char getWinner() {
        char temp = '.';
        for (int i = 0; i < SIZE_TABLE; ++i) {
            if (this.table[i][0] != '*' && this.table[i][0] == this.table[i][1] && this.table[i][0] == this.table[i][2])
                temp = this.table[i][0];
            else if (this.table[0][i] != '*' && this.table[0][i] == this.table[1][i] && this.table[0][i] == this.table[2][i])
                temp = this.table[0][i];
        }
        if (this.table[1][1] != '*') {
            if (this.table[0][0] == this.table[1][1] && this.table[0][0] == this.table[2][2])
                temp = this.table[0][0];
            else if (this.table[2][0] == this.table[1][1] && this.table[2][0] == this.table[0][2])
                temp = this.table[2][0];
        }

        if (isTableFull())
            return '=';
        return temp;
    }

    private void nextMove() {
        char tmp = getWinner();
        if (tmp != '.') {
            this.isGameFinished = true;
            if (tmp == '=')
                System.out.println("Ничья");
            else
                System.out.println("Победитель - " + tmp);
            return;
        }
        if (this.sym == 'x') this.sym = '0';
        else this.sym = 'x';
    }

    private boolean isTableFull() {
        for (char[] row : this.table)
            for (char elem : row)
                if (elem == '*') return false;
        return true;
    }
}
