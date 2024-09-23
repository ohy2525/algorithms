package 프로그래머스;

public class 동영상재생기 {

    public String solution(String video_len, String start, String op_start, String op_end, String[] commands) {
        int videoLen = getTime(video_len);
        int pos = getTime(start);
        int opStart = getTime(op_start);
        int opEnd = getTime(op_end);

        for (String s : commands) {
            if (pos >= opStart && pos <= opEnd) {
                pos = opEnd;
            }
            if ("prev".equals(s)) {
                pos = Math.max(0, pos - 10);
            } else {
                pos = Math.min(videoLen, pos + 10);
            }
        }

        if (pos >= opStart && pos <= opEnd) {
            pos = opEnd;
        }

        int m = pos / 60;
        int s = pos % 60;

        return String.format("%02d", m) + ":" + String.format("%02d", s);
    }

    public int getTime(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
