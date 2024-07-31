// https://www.acmicpc.net/problem/2309
// 일곱 난쟁이
	
// 메모리 :  17728 KB	시간 : 204 ms


// bufferedReader 쓰면 메모리/시간 단축됨 !

// - >  14236KB	    124ms

package baekjoon.week2.day10;


import java.util.*;
import java.io.*;

public class Test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        // 9명의 난쟁이 키를 저장할 배열
        int[] heights = new int[9]; 

        // 입력을 받아 heights 배열에 저장
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        br.close();
  

        // 난쟁이들의 키 배열을 오름차순으로 정렬
        Arrays.sort(heights);

        // 모든 가능한 7명의 난쟁이를 선택하기 위해 조합을 검사

        // 경우의 수 : 36
        
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;

                // i와 j를 제외한 나머지 7명의 난쟁이의 키의 합을 계산
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        sum += heights[k];
                    }
                }

                // 합이 100인 경우, 해당 조합을 출력
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(heights[k]);
                        }
                    }
                    return; // 프로그램 종료
                }
            }
        }
    }
}


// ================ 이중 for문으로 보완하기 ! 

class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난쟁이들의 키를 담을 배열
        int[] heights = new int[9];
        int sum = 0;

        // 배열에 입력받은 값 넣어주기 및 총합 계산
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        // 배열 오름차순 정렬
        Arrays.sort(heights);

        // 난쟁이 아닌 두명 찾기
        int x = 0, y = 0;

        // 이중 for문을 돌면서 sum에서 2가지를 뺐을 때 100이 되는 두 수 찾기
        outerLoop:
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    x = heights[i];
                    y = heights[j];
                    break outerLoop; // 조건을 만족하는 경우 루프 종료
                }
            }
        }

        // 출력: x와 y를 제외한 나머지 난쟁이들의 키를 출력
        for (int height : heights) {
            if (height != x && height != y) {
                System.out.println(height);
            }
        }
    }
}

/*
outerLoop 라벨은 루프에 이름을 붙여서 중첩 루프를 쉽게 제어할 수 있도록 하는 기능

라벨의 역할

라벨을 사용하여 루프 식별: outerLoop는 루프에 붙인 이름으로, 이 이름을 통해 어떤 루프를 종료할지 지정할 수 있다.
중첩 루프 제어: break나 continue와 함께 사용하여 특정 라벨이 붙은 루프만 종료하거나 계속할 수 있다.

ex) 
outerLoop:
for (int i = 0; i < heights.length - 1; i++) {
    for (int j = i + 1; j < heights.length; j++) {
        if (sum - heights[i] - heights[j] == 100) {
            x = heights[i];
            y = heights[j];
            break outerLoop; // outerLoop 라벨이 붙은 루프를 종료
        }
    }
}
outerLoop 라벨: 첫 번째 for문에 outerLoop라는 이름을 붙인다.
break outerLoop;: 두 번째 for문 안에서 break outerLoop;를 호출하면, 이름이 outerLoop로 붙은 첫 번째 for문 전체가 종료된다.

이 방식은 중첩된 루프 구조에서 특정 루프만 종료하고 싶을 때 유용 - > 
outerLoop 라벨이 붙은 루프를 명시적으로 종료할 수 있어, 코드의 흐름을 제어하기 좋다.
*/