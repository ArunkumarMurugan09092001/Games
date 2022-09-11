package minesweeper;

import java.util.Scanner;

public class minesweeper {

    static String[][] min = new String[8][8];
    static int[][] mine = new int[8][8];
    static int bombs = 10;
    static int[] bombslist = new int[bombs];
    static Scanner in = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        setbombs();
        show();
        boolean checks;
        do {
            System.out.println("enter the row:");
            int row = in.nextInt();
            System.err.println("enter the column:");
            int col = in.nextInt();
            row--;
            col--;
            int total = 10 * row + col;
            checks = check(total);
            if (checks) {
                open(row, col);
            } else {
                System.out.println("game over");
                endGame();
            }
            show();
        } while (checks && ( count!=54));
        if (count == (64 - bombs)) {
            System.out.println("you win");
        } else {
            System.out.println("ugsdffj");
        }

    }

    public static void setbombs() {
        int initial;
        int ran;
        int x, y;
        for (initial = 0; initial < bombs; initial++) {
            ran = (int) (77 * (Math.random()));
            for (int i = 0; i < initial; i++) {
                if (ran == bombslist[i]) {
                    ran++;
                }
            }
            x = ran / 10;
            y = ran % 10;
            y = y % 8;
            ran = x * 10 + y;
            bombslist[initial] = ran;
            counter(x, y);
        }
    }

    public static void show() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (min[i][j] == null) {
                    System.out.print("\t" + "_");
                } else
                    System.out.print("\t" + min[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean check(int total) {
        for (int i = 0; i < bombs; i++) {
            if (total == bombslist[i]) {
                return false;
            }
        }
        return true;
    }

    public static void counter(int i, int j) {
        int[][] possible = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        for (int x = 0; x < 8; x++) {
            if ((i + possible[x][0] >= 0) && (i + possible[x][0] < 8) && (j + possible[x][1] >= 0)
                    && (j + possible[x][1]) < 8)
                mine[i + possible[x][0]][j + possible[x][1]]++;
        }
    }

    public static void endGame() {
        int size = bombslist.length;
        int tot, x, y;
        for (int i = 0; i < size; i++) {
            tot = bombslist[i];
            x = tot / 10;
            y = tot % 10;
            min[x][y] = "*";
        }
    }

    public static void empty(int row, int col) {
        int row1, col1;
        int[][] possible = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        for (int i = 0; i < 8; i++) {
            row1 = row + possible[i][0];
            col1 = col + possible[i][1];
            if ((row1 >= 0) && (row1 < 8) && (col1 >= 0) && (col1 < 8)) {
                open(row1, col1);
            }
        }
    }

    public static void open(int row, int col) {
        count++;
        if (min[row][col] != null) {
            return;
        }
        min[row][col] = " " + (mine[row][col]) + " ";
        if (mine[row][col] == 0) {
            empty(row, col);
        }

    }
}
