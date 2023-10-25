package Doit.ch06;

import java.io.*;
import java.util.*;

public class 좌표정렬하기2 {

    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.y == other.y) {
                return this.x - other.x;
            }
            return this.y - other.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            points[i] = new Point(x, y);
        }
        br.close();

        Arrays.sort(points);

        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }
    }

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            points.add(new int[]{x, y});
        }

        points.sort(Comparator.comparingInt((int[] point) -> point[1]).thenComparingInt(point -> point[0]));

        points.forEach(point -> System.out.println(point[0] + " " + point[1]));
    }*/
}
