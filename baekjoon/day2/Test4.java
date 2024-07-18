// https://www.acmicpc.net/problem/11945

// 뜨거운 붕어빵

// 메모리 : 17696 KB	시간 : 208 ms


import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에서 N과 M을 입력받음
        int N = sc.nextInt();
        int M = sc.nextInt();

        // N 또는 M이 0인 경우 종료
        if (N == 0 || M == 0) {
            sc.close();
            return;
        }

        // 공백 소비 (nextInt() 후의 남아있는 newline)
        sc.nextLine();

        // 각 줄에 대해 처리
        for (int i = 0; i < N; i++) {
            // 각 줄의 입력을 받음
            String line = sc.nextLine();
            // StringBuilder를 사용하여 문자열을 뒤집음
            StringBuilder sb = new StringBuilder(line);
            // 뒤집은 문자열을 출력
            System.out.println(sb.reverse().toString());
        }

        sc.close();
    }
}

/*
- 문제 설명

Scanner 객체를 사용하여 정수 입력 (nextInt(), nextDouble(), 등)를 받은 후에 !
문자열 입력 (nextLine())을 받으려고 하면, 
줄바꿈 문자가 남아서 의도하지 않은 입력 대기 상태가 발생할 수 있다.

- 동작 방식

nextInt() 메서드는 입력 버퍼에서 정수만 읽고, 뒤에 남아 있는 줄바꿈 문자 \n를 읽지 않고 남겨둔다.
nextLine() 메서드는 줄바꿈 문자 \n까지를 읽어 들이고 나머지 내용을 한 줄로 읽음 !
nextLine()을 바로 호출하면 버퍼에 남아 있는 줄바꿈 문자 \n만 읽고 종료하게 되어 다음 입력을 읽지 않게 됨

- 결론 

실제 입력을 받기 전에 nextLine()을 한 번 호출하여 남아 있는 줄바꿈 문자를 소비해줘야 한다.
*/