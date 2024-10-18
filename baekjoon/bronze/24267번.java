
// https://www.acmicpc.net/problem/24267
// 17620KB	168ms

/*
코드 1의 수행 횟수 / 최고차항의 차수 출력하기 

 * MenOfPassion(A[], n) {
    sum <- 0;
    for i <- 1 to n - 2
        for j <- i + 1 to n - 1
            for k <- j + 1 to n
                sum <- sum + A[i] × A[j] × A[k]; # 코드1
    return sum;
}
 * 첫 번째 for문 : i는 1부터 n-2까지 돈다.
 * 두 번째 for문 : j는 i+1부터 n-1까지 돈다.
 * 세 번째 for문 : k는 j+1부터 n까지 돈다.
 * 
 * ex ) n = 7
 * 첫 for문에서 i는 1부터 5까지 반복
 * 두 번째 for문에서 i=1일 때 .. j는 2부터 6까지, 
 * j=2일 때 .. k는 3부터 7까지 (5번)
 * j=3 -> 4부터 7 (4번)... j=4 -> 5부터 7 (3번) ... j=5 -> (2번), j=6 -> (1번) = > 5+4+3+2+1 = > 15번
 * 
 * i=2 -> j는 3부터 6까지 -> 4+3+2+1 -> 10번
 * i=3 -> j는 4부터 6까지 -> 3+2+1 -> 6번
 * i=4 -> j는 5부터 6까지 -> 2+1 -> 3번
 * i=5 -> j는 6부터 6까지 -> 1 - > 1번
 * 
 * total => 15+10+6+3+1 => 35번 !
 * 이걸 식으로 도출해야 되는데ㅔㅔ
 * ㄴ> n(n-2)(n-1) / 6 
 * 6으로 나누는 이유 ( 조합 떠올려야 함 ... - > nC3 )
 */
import java.util.*;
public class 24267번 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 수행 횟수 계산
        long count = (long) n * (n - 1) * (n - 2) / 6;
        System.out.println(count);

        // 최고차항 차수 출력
        System.out.println(3);

    }
}
