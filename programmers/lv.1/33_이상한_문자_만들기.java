
// https://school.programmers.co.kr/learn/courses/30/lessons/12930

class Solution {
    public String solution(String s) {
       StringBuilder result = new StringBuilder();
        String[] words = s.split(" ", -1); // 공백 포함하여 단어 분리

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

            if (i < words.length - 1) {
                result.append(" "); // 단어 간 공백 추가
            }
        }

        return result.toString();
    }
}