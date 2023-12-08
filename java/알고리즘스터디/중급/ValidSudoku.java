package 알고리즘스터디.중급;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j] + "row" + i) || !set.add(board[i][j] + "column" + j) || !set.add(board[i][j] + "square" + i/3 + "." + j/3)) return false;
                }
            }
        }
        return true;
    }
}
