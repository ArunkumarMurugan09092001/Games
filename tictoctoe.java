import java.util.Arrays;
import java.util.Scanner;

public class tictoctoe {

    public static int[] inputWindow(String[][] position) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Row Index:");
        int row_ind = input.nextInt();
        System.out.println("Enter the Column Index:");
        int col_ind = input.nextInt();
        if (row_ind < 3 && col_ind < 3 && position[row_ind][col_ind] == "_") {
            return new int[] { row_ind, col_ind };
        }
        System.out.println("Invalid Input");
        return inputWindow(position);
    }

    public static int checking(String position[][], String chr) {
        int LENGTH_ROW_COL = 3;
        int row_index = 0;
        int col_index = 0;
        for (; row_index < LENGTH_ROW_COL; row_index++) {
            if (position[row_index][col_index] == chr && position[row_index][col_index + 1] == chr &&
                    position[row_index][col_index + 2] == chr) {
                System.out.println(chr + " Wins");
                return 1;
            }
        }
        row_index = 0;
        for (; col_index < LENGTH_ROW_COL; col_index++) {
            if (position[row_index][col_index] == chr && position[row_index + 1][col_index] == chr &&
                    position[row_index + 2][col_index] == chr) {
                System.out.println(chr + " Wins");
                return 1;
            }
        }
        col_index = 0;
        if (position[row_index][col_index] == chr && position[row_index + 1][col_index + 1] == chr &&
                position[row_index + 2][col_index + 2] == chr) {
            System.out.println(chr + " Wins");
            return 1;
        }
        col_index = 2;
        if (position[row_index][col_index] == chr && position[row_index + 1][col_index - 1] == chr &&
                position[row_index + 2][col_index - 2] == chr) {
            System.out.println(position[row_index][col_index] + " Wins");
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        int TOTAL_PLACES = 9;
        String postion[][] = { { "_", "_", "_" }, { "_", "_", "_" }, { "_", "_", "_" } };

        String chr = "X";
        for (int input_range = 0; input_range < TOTAL_PLACES; input_range++) {
            System.out.println(Arrays.toString(postion[0]));
            System.out.println(Arrays.toString(postion[1]));
            System.out.println(Arrays.toString(postion[2]));

            switch (input_range % 2) {
                case 0:
                    chr = "X";
                    break;
                case 1:
                    chr = "O";
            }
            int[] row_col = inputWindow(postion);
            postion[row_col[0]][row_col[1]] = chr;
            if (checking(postion, chr) == 1) {
                break;
            }

        }

    }

}