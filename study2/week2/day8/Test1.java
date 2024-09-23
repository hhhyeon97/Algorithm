// https://www.acmicpc.net/problem/9933
// 민균이의 비밀번호

// 메모리 :  18640 KB	시간 : 212 ms

package study2.week2.day8;

import java.util.HashSet;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단어의 수
        int N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        // 단어를 저장할 HashSet 생성 -> HashSet은 중복 허용 x !
        HashSet<String> words = new HashSet<>();

        // 단어를 읽어와서 HashSet에 저장
        for (int i = 0; i < N; i++) {
            words.add(scanner.nextLine());
        }

        // 단어 목록을 순회하며 비밀번호 찾기
        for (String word : words) {
            // 현재 단어의 역순 만들기 
            String reversedWord = new StringBuilder(word).reverse().toString();

            // 단어와 역순 모두 HashSet에 있는지 확인
            if (words.contains(reversedWord)) {
                // 비밀번호를 찾았으면 길이와 가운데 문자 출력하기
                int length = word.length();
                char middleChar = word.charAt(length / 2);

                System.out.println(length + " " + middleChar);
                break; // 비밀번호를 찾았으므로 종료
            }
        }

        scanner.close();
    }
}