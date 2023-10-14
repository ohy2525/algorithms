package Doit.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q07 {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

        public static final Comparator<PhyscData> VISION_ORDER = new PhyscData.VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? -1 :
                        (d1.vision < d2.vision) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("aaa", 150, 0.7),
                new PhyscData("bbb", 160, 0.6),
                new PhyscData("ccc", 170, 0.5),
                new PhyscData("ddd", 180, 0.4),
                new PhyscData("eee", 190, 0.3),
                new PhyscData("fff", 200, 0.2),
                new PhyscData("ggg", 210, 0.1)
        };

        System.out.println("시력 입력");
        double vision = scanner.nextDouble();

        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
