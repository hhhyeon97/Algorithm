// https://www.acmicpc.net/problem/13975
// 파일 합치기 3

// 메모리 - 360108 KB	시간 - 3400 ms

package baekjoon.test2;

import java.io.*;
import java.util.PriorityQueue;

public class P13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // 파일의 개수
            String[] sizes = br.readLine().split(" "); // 40 30 30 50 
            // 우선순위 큐 생성
            PriorityQueue<Long> pq = new PriorityQueue<>();

            // 파일 크기를 우선순위 큐에 추가
            for (String size : sizes) {
                pq.add(Long.parseLong(size)); // 30 30 40 50
            }

            Long totalCost = 0L;

            // 파일을 하나로 합칠 때까지 반복
            while (pq.size() > 1) {
                // 가장 작은 두 파일 크기 가져오기
                Long first = pq.poll();
                Long second = pq.poll();

                // 합치는 비용 계산
                Long cost = first + second;
                totalCost += cost;

                // 합쳐진 파일을 큐에 다시 추가
                pq.add(cost);
            }
            // 결과 출력
            System.out.println(totalCost);
        }
        br.close();

    }
}

// ========== 메모리/시간 단축해보기 ! 

// 378700 KB	2620 ms


class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());  // 파일의 개수
            String[] sizes = br.readLine().split(" ");
            
            // 우선순위 큐 생성
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            // 파일 크기를 우선순위 큐에 추가
            for (String size : sizes) {
                pq.add(Long.parseLong(size));
            }
            
            long totalCost = 0;

            // 파일을 하나로 합칠 때까지 반복
            while (pq.size() > 1) {
                // 가장 작은 두 파일 크기 가져오기
                long first = pq.poll();
                long second = pq.poll();
                
                // 합치는 비용 계산
                long cost = first + second;
                totalCost += cost;
                
                // 합쳐진 파일을 큐에 다시 추가
                pq.add(cost);
            }
            
            // 결과 출력
            bw.write(totalCost + "\n");
        }
        
        br.close();
        bw.close();
    }
}

