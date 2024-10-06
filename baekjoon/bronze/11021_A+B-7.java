
// https://www.acmicpc.net/problem/11021
// 16156KB	128ms

import java.io.*;
import java.util.StringTokenizer;

public class 11021번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        for (int i = 1; i <= T; i++) {
            // 한 줄마다 a,b 공백 두고 입력받기 
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println("Case #" + i + ": " + (A + B));
        }
        br.close();
    }
}