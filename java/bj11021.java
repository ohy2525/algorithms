import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int c = 1;

        while (T > 0) {
            String[] num = br.readLine().split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);

            System.out.println("Case #" + c + ": " + (a + b));
            c++;
            T--;
        }
    }
}
