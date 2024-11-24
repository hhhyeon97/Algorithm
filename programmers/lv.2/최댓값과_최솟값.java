
// https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.*;

class Solution {
    public String solution(String s) {
        
        /*
        공백으로 분리된 문자열 배열 생성
        split(" ") :
        문자열을 공백 기준으로 나눠 숫자 배열로 분리한다. 
        ex : "1 2 3 4" → ["1", "2", "3", "4"]
         */
        String[] numbers = s.split(" ");
        
        // 문자열 배열을 정수 배열로 변환
        int[] intNumbers = Arrays.stream(numbers)
                                 .mapToInt(Integer::parseInt) // 문자열 배열의 각 요소를 int로 변환한다.
                                 .toArray();
        
        // Arrays.stream()으로 최소값과 최대값 찾기
        int min = Arrays.stream(intNumbers).min().getAsInt();
        int max = Arrays.stream(intNumbers).max().getAsInt();
        
        // 결과를 문자열로 반환
        return min + " " + max;

    }
}

//Collections 활용 풀이
class Solution2 {
    public String solution2(String s){
        // 공백으로 분리된 문자열을 Integer 리스트로 변환
        List<Integer> numbers = new ArrayList<>();
        for (String num : s.split(" ")) {
            numbers.add(Integer.parseInt(num));
        }
        
        // 최소값과 최대값 찾기
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        
        // 결과 문자열 반환
        return min + " " + max;
    }
}