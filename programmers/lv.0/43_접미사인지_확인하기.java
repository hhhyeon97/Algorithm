
// https://school.programmers.co.kr/learn/courses/30/lessons/181908

class Solution {
    public int solution(String my_string, String is_suffix) {
      // 문자열이 접미사로 끝나는지 확인
        if (my_string.endsWith(is_suffix)) {
            return 1;
        } else {
            return 0;
        }
    }
}
