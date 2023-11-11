package 알고리즘스터디.중급;

public class RottingOrangs {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        int oc = 0, rc = 0;
        //Queue<Point> q = new LinkedList<>();
        Deque<Point> q = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Point(j, i));
                    oc++; rc++;
                } else if (grid[i][j] == 1) {
                    oc++;
                }
            }
        }

        int minutes = -1;

        while (!q.isEmpty()) {
            minutes++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || ny >= grid.length || nx >= grid[ny].length) continue;

                    if (grid[ny][nx] == 1) {
                        grid[ny][nx] = 2;
                        rc++;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        return oc == 0 ? 0 : oc == rc ? minutes : -1;
    }
}