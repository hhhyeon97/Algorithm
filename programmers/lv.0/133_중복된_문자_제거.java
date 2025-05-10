
// https://school.programmers.co.kr/learn/courses/30/lessons/120888

import java.util.*;
class Solution {
    public String solution(String my_string) {
        
        StringBuilder answer = new StringBuilder();
        
        Set<Character> set = new HashSet<>();
		
		for (int i = 0; i < my_string.length(); i++) {

			char c = my_string.charAt(i);
		    
		    if (!set.contains(c)) {
	            answer.append(c);
	            set.add(c);
	        }
		}
		
		 return answer.toString();
    }
}