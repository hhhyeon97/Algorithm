
// https://school.programmers.co.kr/learn/courses/30/lessons/181867

class Solution {
    public int[] solution(String myString) {
        
        String[] parts = myString.split("x", -1);
      
        int[] answer = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            answer[i] = parts[i].length();
        }

      /* ex ) 
      "xabcxdefxghi"	
      [0, 3, 3, 3]
      */
        
        return answer;
    }
}
