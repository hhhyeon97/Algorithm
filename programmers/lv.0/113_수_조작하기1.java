
// https://school.programmers.co.kr/learn/courses/30/lessons/181926

class Solution {
    public int solution(int n, String control) {
        
        int answer = n;
        
        // 문자열 쪼개서 배열로 만들기
        String[] control_list = control.split("");
        
        // 비교 후 연산
        for(String s : control_list){
            if(s.equals("w")){
                answer += 1;
            }else if(s.equals("s")){
                answer -= 1;
            }else if(s.equals("d")){
                answer += 10;
            }else if(s.equals("a")){
                answer -= 10;
            }
        }
        return answer;
    }
}