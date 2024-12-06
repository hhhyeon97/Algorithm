
// https://school.programmers.co.kr/learn/courses/30/lessons/12930


/* ex )
테스트 케이스
"try hello world" → "TrY HeLlO WoRlD"
" java programming " → " JaVa PrOgRaMmInG "
"a" → "A"
" " → " " (공백만 입력)
" a b " → " A B "
*/

class Solution {
    public String solution(String s) {
       
        StringBuilder result = new StringBuilder();

        // split(" ", -1)을 사용해 문자열을 공백 기준으로 나누되, 
        // 연속된 공백도 분리하여 처리.
        // 각 단어를 변환한 뒤 공백은 유지함.
        // 공백 자체는 배열에 들어가지 않는다.
        // 연속된 공백이 있더라도, 그 사이에 빈 문자열은 공백 개수와 무관하게 하나씩만 추가된다.
        String[] words = s.split(" ", -1); 
        /*
        ex )
        입력: " java programming "
        split(" ", -1) 결과:
        words = ["", "java", "", "programming", ""]
        맨 앞 공백 → 빈 문자열 "".
        중간 공백 두 개 → 빈 문자열 "", "".
        마지막 공백 → 빈 문자열 "".
         */

        // 변환된 단어를 StringBuilder에 추가 + 단어 사이에는 공백을 직접 추가.
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder transformedWord = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (j % 2 == 0) {
                    transformedWord.append(Character.toUpperCase(c)); // 짝수: 대문자
                } else {
                    transformedWord.append(Character.toLowerCase(c)); // 홀수: 소문자
                }
            }
            result.append(transformedWord); // 변환된 단어 추가

            // 마지막 단어 뒤에 공백이 추가되지 않도록 조건 추가
            if (i < words.length - 1) {
                result.append(" "); // 단어 간 공백 추가
            }
            /*
            첫 번째 반복 (words[0] = ""):
            빈 문자열 그대로 추가.
            result.append(" ")로 공백 추가.
            현재 result = " ".
            
            두 번째 반복 (words[1] = "java"):
            "java" → "JaVa"로 변환.
            result.append(" ")로 공백 추가.
            현재 result = " JaVa ".

            세 번째 반복 (words[2] = ""):
            빈 문자열 그대로 추가.
            result.append(" ")로 공백 추가.
            현재 result = " JaVa ".

            네 번째 반복 (words[3] = "programming"):
            "programming" → "PrOgRaMmInG"로 변환.
            result.append(" ")로 공백 추가.
            현재 result = " JaVa PrOgRaMmInG ".

            다섯 번째 반복 (words[4] = ""):
            빈 문자열 그대로 추가.
            마지막 반복이므로 공백 추가 없음.
            최종 result = " JaVa PrOgRaMmInG ".
            */
        }

        return result.toString();
    }
}
