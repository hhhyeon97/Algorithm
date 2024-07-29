// https://www.acmicpc.net/problem/2309
// 일곱 난쟁이
	
// 메모리 :  17728 KB	시간 : 204 ms


// bufferedReader 쓰면 메모리/시간 단축됨 !

// 14236KB	124ms

package baekjoon.day10;


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