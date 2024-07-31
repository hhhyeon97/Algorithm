// https://www.acmicpc.net/problem/15686
// 치킨 배달

package baekjoon.week1.test1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    static int N, M; // 도시의 크기 N과 선택할 치킨집의 수 M
    static int[][] city; // 도시의 정보를 담고 있는 2D 배열
    static List<int[]> houses = new ArrayList<>(); // 집의 위치를 저장하는 리스트
    static List<int[]> chickens = new ArrayList<>(); // 치킨집의 위치를 저장하는 리스트
    static int minCityChickenDistance = Integer.MAX_VALUE; // 최소 치킨 거리 초기화

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 도시의 크기와 선택할 치킨집의 수를 입력받음
        N = scanner.nextInt();
        M = scanner.nextInt();
        city = new int[N][N];

        // 도시 정보를 입력받고 집과 치킨집의 위치를 각각 리스트에 저장
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                city[r][c] = scanner.nextInt();
                if (city[r][c] == 1) {
                    houses.add(new int[]{r, c}); // 집의 위치를 리스트에 추가
                } else if (city[r][c] == 2) {
                    chickens.add(new int[]{r, c}); // 치킨집의 위치를 리스트에 추가
                }
            }
        }

        // 치킨집 조합을 선택하기 위한 백트래킹 호출
        boolean[] selected = new boolean[chickens.size()];
        selectChickenHouses(0, 0, selected);

        // 최소 치킨 거리를 출력
        System.out.println(minCityChickenDistance);

        scanner.close();
    }

    // 치킨집 선택을 위한 백트래킹 함수
    private static void selectChickenHouses(int idx, int count, boolean[] selected) {
        // M개의 치킨집을 선택한 경우 치킨 거리 계산
        if (count == M) {
            calculateCityChickenDistance(selected);
            return;
        }
        
        // 모든 치킨집을 대상으로 선택 또는 비선택을 반복
        if (idx >= chickens.size()) return;

        // 현재 치킨집을 선택하는 경우
        selected[idx] = true;
        selectChickenHouses(idx + 1, count + 1, selected);
        
        // 현재 치킨집을 선택하지 않는 경우
        selected[idx] = false;
        selectChickenHouses(idx + 1, count, selected);
    }

    // 선택된 치킨집으로부터 도시의 치킨 거리 계산
    private static void calculateCityChickenDistance(boolean[] selected) {
        int cityChickenDistance = 0; // 도시의 치킨 거리를 초기화

        // 모든 집에 대해 최소 치킨 거리를 계산
        for (int[] house : houses) {
            int houseChickenDistance = Integer.MAX_VALUE; // 집의 치킨 거리 초기화
            // 선택된 치킨집들 중에서 가장 가까운 치킨집을 찾음
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickens.get(i);
                    int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    houseChickenDistance = Math.min(houseChickenDistance, distance);
                }
            }
            cityChickenDistance += houseChickenDistance; // 집의 치킨 거리를 도시의 치킨 거리에 추가
        }

        // 현재 선택된 치킨집 조합의 도시 치킨 거리와 최소 치킨 거리 비교
        minCityChickenDistance = Math.min(minCityChickenDistance, cityChickenDistance);
    }
}