
-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
-- 가격이 제일 비싼 식품의 정보 출력하기

SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
-- DATETIME에서 DATE로 형 변환

SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME,'%Y-%m-%d') AS "날짜"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131529
-- 카테고리 별 상품 개수 구하기

-- SUBSTRING() 함수를 사용하여 PRODUCT_CODE 앞 두 자리를 추출
-- 각 카테고리별 상품 개수를 구하기 위해 GROUP BY를 사용
/*
별칭 사용의 규칙
ㄴ>
SQL에서 GROUP BY와 ORDER BY 절에서는 원래 컬럼명이나 별칭을 사용할 수 있지만, 
일반적으로 별칭을 사용하는 게 권장됨.
특히 SUBSTRING() 같은 함수로 
변형된 컬럼 값을 기준으로 그룹핑하거나 정렬할 때는 별칭을 쓰면 더 이해하기 쉽다.

SUBSTRING() 함수
ㄴ>
SUBSTRING(column_name, start, length)는 
주어진 문자열에서 start 번째 위치부터 length 만큼의 문자를 추출하는 함수
예를 들어, SUBSTRING('PRODUCT123', 1, 2)는 PR을 반환해
column_name: 추출할 컬럼 또는 문자열.
start: 추출을 시작할 위치(1부터 시작).
length: 추출할 문자 수.
*/
SELECT SUBSTRING(PRODUCT_CODE, 1, 2) AS CATEGORY_CODE, 
COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY_CODE
ORDER BY CATEGORY_CODE ASC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59406
-- 동물 수 구하기 

SELECT COUNT(*) AS count
FROM ANIMAL_INS;

-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
-- 진료과별 총 예약 횟수 출력하기

-- 조건
-- 0. 2022년 5월 예약한 환자수를 진료과 코드별로 조회 
-- 1. 컬럼명 지정
-- 2. 진료과별 예약한 환자 수를 기준 오름차순 정렬 = 예약 건수를 기준으로 오름차순 정렬
-- 3. 예약 건수가 같은 경우 진료과 코드를 기준으로 오름차순 정렬

SELECT MCDP_CD AS "진료과코드", COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD LIKE "2022-05%"
GROUP BY MCDP_CD
ORDER BY COUNT(*) ASC, MCDP_CD ASC;