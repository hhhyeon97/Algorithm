
// https://school.programmers.co.kr/learn/courses/30/lessons/12934

/*
n의 범위가 크기 때문에 long 타입을 사용해야 한다.
Math.pow 결과도 실수(double)이므로 long으로 변환해야 한다.
*/
class Solution {
    public long solution(long n) {
        // n의 제곱근 구하기
        double sqrt = Math.sqrt(n);
        
        // 제곱근이 정수인지 확인
        // ㄴ (실수 값에서 정수 부분만 남긴 후 비교한다. 같다면 정수이다.)
        if (sqrt == (int) sqrt) {
            // 제곱근이 정수라면 (sqrt + 1)^2 반환
            long result = (long) Math.pow((int) sqrt + 1, 2);
            return result;
        } else {
            // 정수가 아니라면 -1 반환
            return -1;
        }
    }
}
/* 관련 꼬꼬 개념

Math.sqrt(double a)
: 입력값 a의 제곱근을 구한다.
ㄴ> 반환값은 항상 double 타입이다.
ex )
double result = Math.sqrt(25); // 결과: 5.0
double result2 = Math.sqrt(2); // 결과: 1.4142135623730951
Math.pow(double a, double b)
: 입력값 a를 b 제곱한 값을 반환한다.
ㄴ> 반환값은 항상 double 타입이다.
ex )
double result = Math.pow(3, 2);  // 결과: 9.0
double result2 = Math.pow(2, 0.5); // 결과: 1.4142135623730951 (2의 제곱근)

왜 실수형으로 반환하나요?
ㄴ> 수학적 계산에서 제곱근이나 제곱 연산 결과는 종종 소수점을 포함할 가능성이 있다.
예를 들어, Math.sqrt(2)는 정확히 표현할 수 없는 무리수이므로 실수형(double)로 반환해야 한다.
Math.pow도 마찬가지로, 소수 제곱(예: 2의 0.5제곱 = 1.414...) 등 
다양한 경우를 처리해야 하므로 double로 반환된다.

정수형으로 변환하려면?
ㄴ> 정수값이 필요한 경우 (int)나 (long)으로 명시적으로 변환해야 한다.

ex )

double sqrt = Math.sqrt(25);    // 결과: 5.0
int intSqrt = (int) sqrt;       // 결과: 5 (정수형 변환)

double pow = Math.pow(3, 2);    // 결과: 9.0
long longPow = (long) pow;      // 결과: 9 (정수형 변환)
단, 변환 시 소수점 이하가 잘리므로, 정수인지 확인할 때는 반드시 조건을 추가해야 한다.
ex )
if (sqrt == (int) sqrt) {
    // sqrt가 정수일 때만 실행
}
*/