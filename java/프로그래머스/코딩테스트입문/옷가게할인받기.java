package 프로그래머스.코딩테스트입문;

public class 옷가게할인받기 {
    public int solution(int price) {

        if (price >= 500000) {
            return (int) (price * 0.8);
        } else if (price >= 300000) {
            return (int) (price * 0.9);
        } else if (price >= 100000) {
            return (int) (price * 0.95);
        } else {
            return price;
        }
    }
}
