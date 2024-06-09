package 알고리즘스터디.고급;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> revDiag = new HashSet<>();

        find(map, result, 0, col, diag, revDiag);

        return result;
    }

    private void find(char[][] map, List<List<String>> result, int y, Set<Integer> col, Set<Integer> diag, Set<Integer> revDiag) {
        if (y == map.length) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                tmp.add(new String(map[i]));
            }
            result.add(tmp);

            return;
        }

        for (int x = 0; x < map.length; x++) {
            if (isValid(y, x, col, diag, revDiag)) {
                col.add(x);
                diag.add(x + y);
                revDiag.add(x - y);
                map[y][x] = 'Q';

                find(map, result, y + 1, col, diag, revDiag);

                map[y][x] = '.';
                col.remove(x);
                diag.remove(x + y);
                revDiag.remove(x - y);
            }
        }
    }

    private boolean isValid(int y, int x, Set<Integer> col, Set<Integer> diag, Set<Integer> revDiag) {
        if (col.contains(x)) {
            return false;
        }
        if (diag.contains(x + y)) {
            return false;
        }
        if (revDiag.contains(x - y)) {
            return false;
        }

        return true;
    }
}
