
// https://www.acmicpc.net/problem/4673
// 14496KB	124ms

// 1부터 10000까지의 셀프 넘버를 계산하고 출력하기
// 생성자가 없는 숫자 = 셀프 넘버
/*
양의 정수 n에 대해서 d(n) =  n과 n의 각 자리수를 더하는 함수 정의
 * 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 
 * 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 
 * 이런식으로 다음과 같은 수열을 만들 수 있다.

33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...

n을 d(n)의 생성자라고 한다. 
위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 

한 줄에 하나씩 출력
 * 
 */

public class 4673번 {
    public static void main(String[] args) {
        // 셀프 넘버가 아닌 수를 표시하기 위한 배열
        boolean[] isNotSelfNumber = new boolean[10001]; 

        for (int i = 1; i <= 10000; i++) {
            int dn = d(i);
            if (dn <= 10000) {
                isNotSelfNumber[dn] = true; // 생성자가 있는 수는 셀프 넘버가 아님
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isNotSelfNumber[i]) { // 셀프 넘버만 출력
                System.out.println(i);
            }
        }
    }

    // d(n)을 계산하는 함수
    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10; // 각 자리수를 더함
            n /= 10;
        }
        return sum;
    }
}
