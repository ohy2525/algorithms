package 알고리즘스터디.중급;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] num = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                if (num[s - '0'] > 0) cows++;
                if (num[g - '0'] < 0) cows++;
                num[s - '0']--;
                num[g - '0']++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
