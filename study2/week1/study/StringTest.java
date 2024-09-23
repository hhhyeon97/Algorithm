package study2.week1.study;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {

        // String str1 = "hi";
        // String str2 = "hi";
        // System.out.println(str1 == str2);
        // String str3 = new String("hi");
        // System.out.println(str2 == str3);
        // System.out.println(str2.equals(str3));

        String str1 = "Hello";
        System.out.println(str1.length());
        System.out.println(str1.charAt(0));
        System.out.println(str1.substring(0, 2));
        System.out.println(str1.contains("el"));
        System.out.println(str1.replace("H", "B"));
        String str2 = "서울시 마포구 123";
        String[] str2_split = str2.split(" ");

        // 배열의 내용을 순회하며 출력
        for (String s : str2_split) {
            System.out.print(s + " ");
        }
        System.out.println(); // 줄바꿈
        // 배열의 내용을 한 줄로 출력
        System.out.println(Arrays.toString(str2_split));

        // 문자열을 문자 배열로 변환한 뒤 출력
        char[] str1CharArray = str1.toCharArray();

        // 배열의 내용을 순회하며 출력
        for (char c : str1CharArray) {
            System.out.print(c + " ");
        }
        System.out.println(); // 줄바꿈

        // 배열의 내용을 한 줄로 출력
        System.out.println(Arrays.toString(str1CharArray));

    }
}