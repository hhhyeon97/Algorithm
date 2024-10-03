
// https://school.programmers.co.kr/learn/courses/30/lessons/181910

class Solution {
    public String solution(String my_string, int n) {
         // my_string의 뒤에서 n글자를 추출
        return my_string.substring(my_string.length() - n);
        /*
        ex) HelloWorld!
        길이 : 11
        n : 5
        substring(11 - 5)
        : orld!
        */
    }
}