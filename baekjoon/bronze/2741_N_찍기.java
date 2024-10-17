

// https://www.acmicpc.net/problem/2741
// 30360KB	728mS

import java.io.*;

public class 2741_N_찍기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            System.out.println(i);
        }
        br.close();
    }
}
