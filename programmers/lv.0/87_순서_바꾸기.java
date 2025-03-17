
// https://school.programmers.co.kr/learn/courses/30/lessons/181891

/*
System.arraycopy() 활용 → 배열 복사 속도가 빠름
System.arraycopy(원본 배열, 시작 인덱스, 복사할 배열, 복사 위치, 복사할 개수)
첫 번째 arraycopy(): n 이후의 원소를 result[0]부터 복사
두 번째 arraycopy(): n까지의 원소를 result[len - n]부터 복사
*/

class Solution {
    public int[] solution(int[] num_list, int n) {

       int len = num_list.length;
       int[] result = new int[len];

        // 앞부분(n 이후) 복사
        System.arraycopy(num_list, n, result, 0, len - n);
        // 뒷부분(n까지) 복사
        System.arraycopy(num_list, 0, result, len - n, n);

        return result;
    }
}