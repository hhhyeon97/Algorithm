// https://www.acmicpc.net/problem/1417
// 국회의원 선거

// 메모리 :  14304 KB	시간 : 124 ms
	
package study2.week2.day8;


/*
다솜이가 매수해야하는 사람의 최솟값을 출력하는 프로그램을 작성

첫째 줄에 후보의 수 N이 주어진다.
둘째 줄부터 차례대로 기호 1번을 찍으려고 하는 사람의 수, 기호 2번을 찍으려고 하는 수, 
이렇게 총 N개의 줄에 걸쳐 입력이 들어온다. N은 50보다 작거나 같은 자연수이고, 득표수는 100보다 작거나 같은 자연수이다.

!! 다솜이가 1번 후보라 가정 

첫째 줄에 다솜이가 매수해야 하는 사람의 최솟값을 출력한다.
*/

import java.util.*;
import java.io.*;

class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 후보자 수
        int dasomVotes = Integer.parseInt(br.readLine()); // 다솜이의 득표 수
        // 최대 힙 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 나머지 후보들의 득표 수를 읽어 PriorityQueue에 저장
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0; // 다솜이가 매수해야 하는 최소 인원 수

        // 다솜이의 득표 수가 나머지 후보들의 득표 수보다 많아질 때까지
        while (!pq.isEmpty() && pq.peek() >= dasomVotes) {
            // 가장 높은 득표 수를 가진 후보의 득표 수를 꺼냄 (poll이 반환하면서 제거함!)
            int topVotes = pq.poll(); 
            // 다솜이의 득표 수 증가
            dasomVotes++; 
            // 가장 높은 득표 수를 가진 후보의 득표 수를 1 감소 (1 감소시키고 다시 집어 넣는 것 !)
            pq.add(topVotes - 1); 
             // 매수한 사람 수 증가
            count++;
        }
        // 결과 출력
        System.out.println(count);
    }
}