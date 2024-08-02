// https://www.acmicpc.net/problem/24431

package baekjoon.week3.day13;

// 20464KB	220ms

import java.io.*;
import java.util.*;

public class P24431_유사_라임_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            // 각 테스트 케이스의 입력 처리
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 단어 수
            int L = Integer.parseInt(st.nextToken()); // 단어의 길이
            int F = Integer.parseInt(st.nextToken()); // 최대 공통 접미사 길이 임계값

            String[] words = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                words[i] = st.nextToken(); // 단어 입력
            }

            // "유사 라임 쌍"을 찾기 위한 리스트 생성
            List<int[]> pairs = new ArrayList<>();
            
            // 모든 단어 쌍을 비교
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (getSuffixLength(words[i], words[j]) >= F) {
                        // 최대 공통 접미사 길이가 F 이상이면 쌍을 추가
                        pairs.add(new int[]{i, j});
                    }
                }
            }
            
            // 최대 유사 라임 쌍 수를 찾기 위한 최대 매칭 알고리즘
            System.out.println(maxMatching(pairs, n));
        }
    }

    // 두 단어의 최대 공통 접미사 길이를 계산하는 함수
    static int getSuffixLength(String a, String b) {
        int len = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(a.length() - 1 - i) == b.charAt(b.length() - 1 - i)) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    // 최대 매칭을 찾기 위한 함수
    static int maxMatching(List<int[]> pairs, int n) {
        // 각 단어의 매칭 상태를 나타내는 배열
        int[] match = new int[n];
        Arrays.fill(match, -1); // -1로 초기화

        int matchCount = 0;

        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];

            if (match[u] == -1 && match[v] == -1) {
                // 두 단어 모두 매칭되지 않은 경우, 매칭 추가
                match[u] = v;
                match[v] = u;
                matchCount++;
            }
        }

        return matchCount;
    }
}


// 다른 풀이

// 15080	144


class Main {
    public static void main(String[] args) throws IOException {
        /*
         * n : 단어의 개수
         * L : 단어의 길이
         * F : 최대 공통 접미사의 길이
         * 주어진 단어들에서 최대 공통 접미사 길이가 F 이상인 쌍을 찾아서
         * 각 쌍은 한 번만 사용할 수 있도록 최대 쌍의 개수를 계산
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 한 번에 출력하기 위한 StringBuilder

        int num = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int i = 0; i < num; i++) {
            // 각 테스트 케이스 처리
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 단어의 개수
            int L = Integer.parseInt(split[1]); // 단어의 길이
            int F = Integer.parseInt(split[2]); // 공통 접미사의 길이

            Set<String> set = new HashSet<>(); // 접미사를 저장할 Set (중복 제거 및 빠른 검색을 위해)
            int count = 0; // 유사 라임 쌍의 수

            String[] arr = br.readLine().split(" "); // 단어 배열 입력

            for (int j = 0; j < n; j++) {
                // 각 단어의 길이 L에서 마지막 F 글자를 추출
                String substring = arr[j].substring(L - F, L);

                // 접미사가 이미 Set에 존재하는 경우, 유사 라임 쌍을 하나 만들 수 있음
                if (!set.contains(substring)) {
                    // 접미사가 Set에 없으면 추가
                    set.add(substring);
                } else {
                    // 접미사가 이미 존재하면 유사 라임 쌍을 형성할 수 있음
                    count++;
                    // 이미 존재한 접미사는 제거하여 중복 사용 방지
                    set.remove(substring);
                }
            }

            // 결과를 StringBuilder에 추가
            sb.append(count).append('\n');
        }

        // 모든 테스트 케이스에 대한 결과 출력
        System.out.print(sb);
    }
}