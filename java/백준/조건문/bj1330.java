package 백준.조건문;

import java.util.Scanner;

public class bj1330 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        in.close();

        if(A>B) System.out.println(">");
        else if(A<B) System.out.println("<");
        else System.out.println("==");
    }
}
