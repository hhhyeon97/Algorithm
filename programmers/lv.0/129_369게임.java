
// https://school.programmers.co.kr/learn/courses/30/lessons/120891

// 내가 푼 풀이
class Solution2 {
    public int solution(int order) {
        int answer = 0;
        String s = order+"";
        
        String[] game = s.split("");
        
        for(int i = 0; i < game.length; i++) {
            if(game[i].equals("3") || 
            game[i].equals("6") || 
            game[i].equals("9")) {
                answer++;
            }
        }
                 
        return answer;
    }
}

// 더 간결하게 equals 메서드 안 쓰고 비교할 수도 있음
class Solution {
    public int solution(int order) {
        int answer = 0;
         
        String str = order+"";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='3'||c=='6'||c=='9') answer++;
        }

        return answer;
    }
}

