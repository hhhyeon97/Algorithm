
// https://www.acmicpc.net/problem/10814
// 51468KB	 628ms


/*
 * 2차원 배열 사용: 회원 정보를 배열로 처리
 * 각 회원은 [나이, 이름]을 저장하는 배열로 표현

members[i][0]에 나이, members[i][1]에 이름 저장
정렬: Arrays.sort()와 Comparator를 사용하여 
나이 순으로 오름차순 정렬 수행
나이가 같을 경우에는 입력 순서가 유지된다.(안정적인 정렬)

출력: StringBuilder로 결과를 모아서 한 번에 출력

핵심:
Comparator로 나이만 비교하여 정렬하며, 
Integer.parseInt()를 사용해 
문자열로 입력받은 나이를 정수로 변환하여 비교한다.
 * 
 */


import java.util.*;
import java.io.*;


public class 10814번 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 회원의 수 N
        int N = Integer.parseInt(br.readLine());
        String[][] members = new String[N][2];

        // 회원 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken(); // 나이
            members[i][1] = st.nextToken(); // 이름
        }

        // 정렬 (나이 기준으로 오름차순, 나이가 같으면 입력 순서 유지)
        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] member1, String[] member2) {
                return Integer.compare(Integer.parseInt(member1[0]), Integer.parseInt(member2[0]));
            }
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}