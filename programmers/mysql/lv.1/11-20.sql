

-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
-- 강원도에 위치한 생산공장 목록 출력하기

-- 특정 문자로 시작하는 데이터 필터링
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE "강원도%"
ORDER BY FACTORY_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131114
-- 경기도에 위치한 식품창고 목록 출력하기

-- NULL 값 치환할 때 IFNULL 활용하기
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
       IFNULL(FREEZER_YN, 'N')
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;

-- COALESCE() 함수를 사용할 수도 있음
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, 
       COALESCE(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;


-- -- IFNULL과 COALESCE 차이
-- COALESCE: 두 개 이상의 인수를 받을 수 있으며, 첫 번째로 NULL이 아닌 값을 반환한다.
-- IFNULL: 딱 두 개의 인수를 받으며, 첫 번째 인수가 NULL이면 두 번째 인수를 반환한다.

-- COALESCE 예시 )
-- employees 테이블에서 
-- first_name이 NULL인 경우 last_name을, last_name도 NULL인 경우 email을 반환
SELECT COALESCE(first_name, last_name, email) AS name
FROM employees;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
-- 조건에 맞는 회원수 구하기

-- JOINED가 날짜 형식이라면, 연도를 추출해 비교해야 함
-- ㄴ> YEAR() 함수를 사용해 JOINED의 연도를 추출할 수 있다.
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29
  AND YEAR(JOINED) = 2021;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132203
-- 흉부외과 또는 일반외과 의사 목록 출력하기

-- DATE_FORMAT()을 사용해 날짜를 원하는 형식으로 변환
-- 대문자 Y는 4자리 연도 / 소문자 y는 2자리 연도를 출력
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = "CS" OR MCDP_CD = "GS"
ORDER BY HIRE_YMD DESC, DR_NAME ASC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- 12세 이하인 여자 환자 목록 출력하기

-- PT_NO를 처음에 두고 제출해보면 틀림 -> 문제에서 요구한 순서에 맞게 출력하자 !
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE')
FROM PATIENT
WHERE AGE <=12 AND GEND_CD="W"
ORDER BY AGE DESC, PT_NAME ASC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/133024
-- 인기있는 아이스크림

SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
-- 조건에 맞는 도서 리스트 출력하기

SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY='인문' AND YEAR(PUBLISHED_DATE) = 2021
ORDER BY PUBLISHED_DATE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59034
-- 모든 레코드 조회하기

SELECT ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- 과일로 만든 아이스크림 고르기

-- JOIN: FIRST_HALF 테이블과 ICECREAM_INFO 테이블을 FLAVOR로 조인.
-- WHERE 조건: TOTAL_ORDER > 3000과 INGREDIENT_TYPE = 'fruit_based'로 필터링.
-- ORDER BY: 총주문량이 큰 순서대로 내림차순 정렬.

SELECT FH.FLAVOR
FROM FIRST_HALF FH
JOIN ICECREAM_INFO IC ON FH.FLAVOR = IC.FLAVOR
WHERE FH.TOTAL_ORDER > 3000 -- 3000보다 높다였으니까 이상x 초과해야함 !
  AND IC.INGREDIENT_TYPE = 'fruit_based' -- 비교할 값을 알고 있으니 like 보다 명확하게 필터링 해주자 !
ORDER BY FH.TOTAL_ORDER DESC;

-- = 연산자는 정확히 일치하는 값을 찾기 때문에, 데이터베이스가 비교를 빠르게 수행
-- 반면, LIKE는 패턴 매칭을 위해 더 많은 연산을 필요로 하므로 성능이 상대적으로 떨어질 수 있음

-- 정확한 값을 알고 있다면 =을 사용하는 것이 더 효율적이고 안전한 방법
-- LIKE는 부분 매칭이 필요할 때 사용하는 게 적합

-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- 평균 일일 대여 요금 구하기

SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'

/*

ROUND() 함수 : 숫자를 반올림하는 함수
ㄴ> ROUND(숫자, 소수점 자리수)

ROUND(AVG(DAILY_FEE), 0)에서 0은 소수점 몇 번째 자리에서 반올림할지를 지정하는 값

ROUND(AVG(DAILY_FEE), 0): AVG(DAILY_FEE)의 결과를 소수점 첫 번째 자리에서 반올림한다는 뜻 
ㄴ> 즉, 정수로 반올림 !!
0을 넣으면 소수점 이하를 표시하지 않고 정수로 반올림.
ㄴ> 만약 1을 넣으면 소수점 첫 번째 자리까지 표시하고, 2를 넣으면 소수점 두 번째 자리까지 표시하는 식으로 작동

ex ) 

ROUND(123.456, 0) → 123
ROUND(123.456, 1) → 123.5
ROUND(123.456, 2) → 123.46
이 문제에서는 ROUND(AVG(DAILY_FEE), 0)은 평균 대여 요금을 정수로 반올림하겠다는 의미
*/