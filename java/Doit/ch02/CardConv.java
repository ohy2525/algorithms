package Doit.ch02;

import java.util.Scanner;

public class CardConv {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits -i -1] = t;
        }

        return digits;
    }

    public static void main(String[] args) {
        int i;
        for (i = 2; i < 10; i++) {
            System.out.println("i = " + i);
        }
        System.out.println(i);
        /*Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        int dno;
        int retry;
        char[] cno = new char[32];

        do {
            do {
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConv(no, cd, cno);

            System.out.println("진수로 ");
            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }
            retry = stdIn.nextInt();
        } while (retry == 1);*/
    }
}
