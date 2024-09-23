package study2.week1.day1;
// https://www.acmicpc.net/problem/2477

/*
참외밭의 넓이를 구하고, 주어진 1m²당 자라는 참외의 개수를 이용해
전체 참외의 개수를 계산하는 문제

주어진 육각형의 변 길이를 이용해 참외밭의 전체 면적을 구하는 방법 이해 필요 !
*/

// 메모리 : 14408 KB	시간 : 124 ms

// 아직 이해 못함 어렵다요 ...
// ++ BufferedReader 사용하면 스캐너보다 좀 더 시간이 단축되는데
// 무슨 차이인지 정리해두기 ! + 사용법도 쪼금 다른 듯 ! 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test8 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 1m²당 자라는 참외의 개수
        int[] arr = new int[6]; // 각 변의 길이를 저장할 배열
        int MaxWidthI = 0, MaxWidth = 0, MaxHeight = 0, MaxHeightI = 0, d;

        // 각 변의 길이와 방향을 입력 받음
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            
            // 가장 긴 가로의 길이와 그 위치 찾기
            if ((d == 1 || d == 2) && MaxWidth < arr[i]) {
                MaxWidth = arr[i];
                MaxWidthI = i;
            }
            // 가장 긴 세로의 길이와 그 위치 찾기
            else if ((d == 3 || d == 4) && MaxHeight < arr[i]) {
                MaxHeight = arr[i];
                MaxHeightI = i;
            }
        }
        
        int right, left, minWidth, minHeight;
        
        // 빈 사각형의 세로 길이를 구함
        if (MaxWidthI + 1 == 6) right = 0;
        else right = MaxWidthI + 1;
        
        if (MaxWidthI - 1 == -1) left = 5;
        else left = MaxWidthI - 1;
        
        minHeight = Math.abs(arr[right] - arr[left]); // 큰 사각형의 가로를 기준으로 양 옆의 차이를 구해서 빈 사각형의 세로 길이를 구함

        // 빈 사각형의 가로 길이를 구함
        if (MaxHeightI + 1 == 6) right = 0;
        else right = MaxHeightI + 1;
        
        if (MaxHeightI - 1 == -1) left = 5;
        else left = MaxHeightI - 1;
        
        minWidth = Math.abs(arr[right] - arr[left]); // 큰 사각형의 세로를 기준으로 양 옆의 차이를 구해서 빈 사각형의 가로 길이를 구함

        // 전체 참외밭의 넓이에서 빈 사각형의 넓이를 뺀 후, 1m²당 자라는 참외의 개수인 N을 곱함
        System.out.println(((MaxWidth * MaxHeight) - (minHeight * minWidth)) * N);
    }
}