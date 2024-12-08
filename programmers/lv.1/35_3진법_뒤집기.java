
// https://school.programmers.co.kr/learn/courses/30/lessons/68935

class Solution {
    public int solution(int n) {
         // 1. n을 3진법 문자열로 변환
        String ternary = Integer.toString(n, 3);
        
        // 2. 문자열 뒤집기
        String reversed = new StringBuilder(ternary).reverse().toString();
        
        // 3. 뒤집힌 3진법 문자열을 10진수로 변환
        int result = Integer.parseInt(reversed, 3);
        
        // 4. 결과 반환
        return result;
    }
}

// 중요 2가지 메서드
/*
1. Integer.toString(n, radix)
ㄴ> 주어진 정수 n을 radix (진법) 기반의 문자열로 변환
ㄴ n을 radix에 해당하는 진법으로 나눠서 각 자리 숫자를 계산
ㄴ 그 숫자들을 문자열로 이어 붙여 반환

ex )
int n = 45;
String ternary = Integer.toString(n, 3); // 10진법 정수 45를 3진법 문자열로 변환
System.out.println(ternary); // 출력: 1200

과정:

45를 3으로 나누며 나머지를 기록:

45 ÷ 3 = 15, 나머지 0
15 ÷ 3 = 5, 나머지 0
5 ÷ 3 = 1, 나머지 2
1 ÷ 3 = 0, 나머지 1 (끝)
나머지를 역순으로 이어 붙이면: 1200
*/

/*
2. Integer.parseInt(s, radix)
ㄴ> 문자열 s를 radix (진법) 기반으로 해석하여 10진수 정수로 변환
ㄴ s의 각 문자를 오른쪽에서 왼쪽으로 읽으며, radix 값을 곱해서 합산

ex )
String reversed = "0021";
int decimal = Integer.parseInt(reversed, 3); // 3진법 문자열 "0021"을 10진법 정수로 변환
System.out.println(decimal); // 출력: 7

과정:

"0021"을 3진법으로 해석:
0×3^3+0×3^2+2×3^1+1×3^0 = 0 + 0 + 6 + 1 =7
*/