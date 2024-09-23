// https://www.acmicpc.net/problem/9372

// https://applemango2021.tistory.com/9 참고 

// 30988KB	256ms

package study2.week3.day12;

import java.io.*;
import java.util.*;

public class P9372_상근이의_여행 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    // 첫 줄의 입력을 분리하기 위한 StringTokenizer
    StringTokenizer st = new StringTokenizer(br.readLine(), " "); 

    int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine(), " "); // 각 테스트 케이스의 첫 줄 읽기
      int N = Integer.parseInt(st.nextToken()); // 국가 수
      int M = Integer.parseInt(st.nextToken()); // 비행기 종류 수
      
      for (int j = 0; j < M; j++) {
        st = new StringTokenizer(br.readLine(), " "); // 비행기 경로 입력 (읽기만 하고 사용하지 않음)
      }
      
      // 모든 국가를 여행하기 위해 필요한 최소 비행기 종류 수는 N - 1
      System.out.println(N - 1);
    }
    
    bw.flush(); // 버퍼에 남아 있는 데이터를 출력
    br.close(); // BufferedReader 종료
    bw.close(); // BufferedWriter 종료
  }
}