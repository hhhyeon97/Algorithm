package java.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) throws IOException{
        
        // Scanner 

        Scanner sc =new Scanner(System.in);

        String inputStr = sc.next();

        System.out.println(inputStr);

        // BufferedReader - > 입력 많을 땐 BufferedReader 활용하기 !

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr2 = br.readLine();
        // 버퍼드리더 쓸 땐 문자열 빼곤 형변환 수동으로 해주어야 함!
        int count = Integer.parseInt(inputStr2);

        System.out.println(count);

    }
}
