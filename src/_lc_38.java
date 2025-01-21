/**
 * LC 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

public class _lc_38 {

    public static void main(String[] args) {
        char[][] board =
                {       {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        char[] line = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        System.out.println("Line status= " +isLineDuplicate(line));
        return false;
    }
    //[ 1, 2, 4, 1, 9...]
    static boolean isLineDuplicate(char[] line) {
        int[] num = new int[9]; //counter array

        for(int index = 0; index < 9; index++) {
            char c = line[index];
            if(c == 46) continue;
            int val = num[(c - 49)];
            if(val == 1) {
                return false;
            }
            num[index] = 1;
        }
        return true;
    }
}
