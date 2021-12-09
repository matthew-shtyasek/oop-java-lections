package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyTable {
    private int[][] table;

    public MyTable(int rows, int cols) {
        if (rows <= 0 || cols <= 0) throw new IndexOutOfBoundsException("В качестве количества строк или столбцов использованы отрицательные числа");
        this.table = new int[rows][cols];
        for (int[] row : this.table)
            Arrays.fill(row, 0);
    }

    public Integer value(int row, int col) {
        if (isIndexExsist(row, col)) return this.table[row][col];
        return null;
    }

    public void setValue(int row, int col, int value) {
        if (isIndexExsist(row, col))
            this.table[row][col] = value;
    }

    public int nRows() { return this.table.length; }
    public int nCols() { return this.table[0].length; }

    public void removeRow(int row) {
        if (!isIndexExsist(row, 0) || nRows() == 1) return;
        int[][] arr = new int[this.nRows() - 1][this.nCols()];
        for (int i = 0; i < nRows(); ++i)
            if (i != row)
                arr[i] = this.table[i];
        this.table = arr;
    }

    public void removeCol(int col) {
        if (!isIndexExsist(0, col) || this.nCols() == 1) return;
        int[][] temp = this.table.clone();
        for (int i = 0; i < this.nRows(); ++i) {
            for (int j = col; j < this.nCols(); ++j) {
                if (j == temp[i].length - 1) break;
                temp[i][j] = temp[i][j + 1];
            }
            this.table[i] = Arrays.copyOf(temp[i], temp.length - 1);
        }
    }

    public void addRow(int row) {
        if (!isIndexExsist(row, 0) && !isIndexExsist(row - 1, 0)) return;
        int[][] temp = this.table.clone();
        this.table = new int[nRows() + 1][nCols()];
        for (int i = 0, j = 0; i < nRows(); ++i, ++j) {
            if (i != row)
                this.table[i] = Arrays.copyOf(temp[j], temp.length);
            else {
                Arrays.fill(this.table[i], 0);
                --j;
            }
        }
    }

    public void addCol(int col) {
        if (!isIndexExsist(0, col) && !isIndexExsist(col - 1, 0)) return;
        int[][] temp = this.table.clone();
        this.table = new int[nRows()][nCols() + 1];
        for (int i = 0; i < nRows(); ++i) {
            for (int j = 0, k = 0; j < nCols(); ++j, ++k) {
                if (j == col) {
                    this.table[i][j] = 0;
                    --k;
                    continue;
                }
                this.table[i][j] = temp[i][k];
            }
        }
    }

    public void showTable() {
        for (int[] ints : table) {
            for (int anInt : ints) System.out.print(anInt + "\t");
            System.out.println();
        }
    }

    private boolean isIndexExsist(int row, int col) {
        return this.nRows() > row && this.nCols() > col;
    }
}
