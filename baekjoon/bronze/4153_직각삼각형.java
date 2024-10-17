
// https://www.acmicpc.net/problem/4153
// 17576KB	160ms


/*
 * 직각삼각형이 되려면 세 변의 길이가 
 * a, b, c인 삼각형에서 c2 = a2 + b2인 관계가 성립해야 한다.
 * ex ) 3,4,5 -> 9 + 16 = 25
 */
import java.util.*;

public class 4153_직각삼각형 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

            // 종료 조건 :
			// 0 0 0 들어오면 출력종료
			if (a == 0 && b == 0 && c == 0) {
				break;
			}

             // 변의 길이를 배열에 저장하고 정렬
             int[] sides = {a, b, c};
             Arrays.sort(sides);
 
             // 피타고라스 정리: 가장 긴 변(sides[2])의 제곱이 
             // 다른 두 변(sides[0], sides[1])의 제곱의 합과 같으면 직각삼각형임 !
             if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
                 System.out.println("right");
             } else {
                 System.out.println("wrong");
             }
		}
        sc.close();
    }
}
