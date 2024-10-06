package 알고리즘스터디.초급;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return valid(s, l, r - 1) || valid(s, l + 1, r);
            }
            l++; r--;
        }

        return true;
    }

    private boolean valid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }

        return true;
    }
}
