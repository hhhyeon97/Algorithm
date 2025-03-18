
// https://school.programmers.co.kr/learn/courses/30/lessons/181892

/*

Arrays.copyOfRange() 메서드
ㄴ num_list의 n번째(즉, n-1 인덱스)부터 마지막 원소까지 복사

n - 1을 시작 인덱스로 설정하는 이유
ㄴ 배열의 인덱스가 0부터 시작하기 때문

num_list.length를 끝 인덱스로 설정하면 마지막 원소까지 포함된다.

*/
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
