package 프로그래머스.코딩테스트입문;

import java.util.Arrays;

public class 중앙값구하기 {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];
    }
}
