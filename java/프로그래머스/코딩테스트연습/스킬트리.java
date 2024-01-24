package 프로그래머스.코딩테스트연습;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] arr = skill.toCharArray();
        for (String tree : skill_trees) {
            int index = -2;
            boolean flag = true;
            for (char c : arr) {
                int tmp = tree.indexOf(c);
                if (index == -1 && tmp != -1) {
                    flag = false;
                    break;
                }
                if (tmp != -1 && tmp < index) {
                    flag = false;
                    break;
                }
                index = tmp;
            }
            if (flag) answer++;
        }

        return answer;
    }
}
