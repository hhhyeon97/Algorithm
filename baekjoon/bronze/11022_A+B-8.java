
// https://www.acmicpc.net/problem/11022
// 19068KB	224ms

// 이전문제는 io 활용 이번엔 scanner로 풀어보기 
// 그리고 i=1로 설정한 이유 -> 조건에서 출력문에 1부터 시작하므로 !

import java.util.*;
public class 11022번 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        for(int i=1; i<=T; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();
            System.out.println("Case #"+i+": "+A+" + "+B+" = "+(A+B));
        }
        scan.close();
    }
}
