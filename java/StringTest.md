### String 관련 메서드

```java
 String str1 = "Hello";
 // 0. equals()

 // 1. length()
        System.out.println(str1.length()); // 5

 // 2. charAt()
        System.out.println(str1.charAt(0)); // H

 // 3. substring()
        System.out.println(str1.substring(0, 2)); // HE

 // 4. contains()
        System.out.println(str1.contains("el")); // true

 // 5. replace()
        System.out.println(str1.replace("H", "B")); // Bello

 // 6. split()
        String str2 = "서울시 마포구 123";
        String[] str2_split = str2.split(" ");

        // 배열의 내용을 순회하며 출력
        for (String s : str2_split) {
            System.out.print(s + " ");
        } // 서울시 마포구 123
        System.out.println(); // 줄바꿈

        // 배열의 내용을 한 줄로 출력 -> [서울시, 마포구, 123]
        System.out.println(Arrays.toString(str2_split));

 // 7. toCharArray()

        // 문자열을 문자 배열로 변환한 뒤 출력
        char[] str1CharArray = str1.toCharArray();

        // 배열의 내용을 순회하며 출력
        for (char c : str1CharArray) {
            System.out.print(c + " ");
        } // H e l l o
        System.out.println(); // 줄바꿈

        // 배열의 내용을 한 줄로 출력
        System.out.println(Arrays.toString(str1CharArray));
        // [H, e, l, l, o]

```
