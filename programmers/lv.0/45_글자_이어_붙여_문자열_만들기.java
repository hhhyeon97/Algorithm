
// https://school.programmers.co.kr/learn/courses/30/lessons/181915

class Solution {
    public String solution(String my_string, int[] index_list) {
      
        StringBuilder resultStr = new StringBuilder();
         
        // index_list의 각 인덱스에 해당하는 문자를 추출하여 결과 문자열에 추가
        for (int index : index_list) {
            resultStr.append(my_string.charAt(index));
        }
        
        // 결과 문자열 반환
        return resultStr.toString();
        
    }
}