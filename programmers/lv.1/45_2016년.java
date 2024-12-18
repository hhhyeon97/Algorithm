
// https://school.programmers.co.kr/learn/courses/30/lessons/12901

class Solution {
    public String solution(int a, int b) {

    // 요일 배열: 일요일부터 시작
    String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    // 각 달의 일수 배열
    // 2016년은 윤년임 -> 2월은 29일까지
    int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 1월 1일부터 a월 b일까지의 총 일수 계산
    int totalDays = 0;

    for (int i = 1; i < a; i++) {
        totalDays += daysInMonth[i]; // 이전 달들의 일수 합산
    }

    totalDays += b; // 현재 달의 일수 추가

    // 1월 1일이 금요일(FRI)이므로 인덱스 5부터 시작
    int startDayIndex = 5;

    // 첫날인 1월 1일은 이미 요일이 정해져 있음 -> 계산에서 제외
    int dayIndex = (startDayIndex + (totalDays - 1)) % 7; // 요일 계산

    return days[dayIndex]; // 해당 요일 반환
    }
}
/*
ex)

입력: a = 5, b = 24

a = 5 이전 달(1월~4월)의 총 일수: 31 + 29 + 31 + 30 = 121
b = 24: 현재 달의 일수 추가 → 121 + 24 = 145
요일 계산: (5 + (145 - 1)) % 7 = 2
→ days[2] = "TUE"

결과: "TUE"
*/