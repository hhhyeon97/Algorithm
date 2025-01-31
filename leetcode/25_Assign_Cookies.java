

// https://leetcode.com/problems/assign-cookies/description/

// 탐욕 알고리즘 (greedy...)

/*
문제 접근

- 정렬

g(자식들의 탐욕 요인)과 s(쿠키 크기)를 오름차순 정렬
작은 크기의 쿠키를 작은 탐욕 요인부터 할당하는 것이 최적

- 투 포인터로 탐색

i → g(탐욕 요인 리스트)의 인덱스
j → s(쿠키 리스트)의 인덱스
두 리스트를 순회하면서 s[j] >= g[i] 이면 만족할 수 있으므로 할당하고 i, j를 증가
그렇지 않으면 j만 증가 (현재 쿠키가 작기 때문에 더 큰 쿠키를 확인해야 함)

- 반복 종료

i == g.length(모든 아이에게 쿠키를 나눠줌)
j == s.length(더 이상 줄 쿠키가 없음)
*/

import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);  // 탐욕 요인 정렬
        Arrays.sort(s);  // 쿠키 크기 정렬
        
        // i는 아이들, j는 쿠키들
        int i = 0, j = 0;  

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // 쿠키가 아이의 탐욕 요인을 만족할 때
                i++; // 아이에게 쿠키를 줌
            }
            j++; // 다음 쿠키 확인
        }
        // 만족한 아이 수 반환
        return i; 
    }
}