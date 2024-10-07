
// https://www.acmicpc.net/problem/10699
// 16864KB	152ms

import java.time.LocalDate;
import java.time.ZoneId;

public class 10699_오늘_날짜 {
    public static void main(String[] args) {
        LocalDate seoulDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulDate);
    }
}