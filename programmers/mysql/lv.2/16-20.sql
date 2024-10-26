

-- https://school.programmers.co.kr/learn/courses/30/lessons/144854
-- 조건에 맞는 도서와 저자 리스트 출력하기

SELECT BOOK_ID, AUTHOR_NAME, 
DATE_FORMAT(PUBLISHED_DATE,"%Y-%m-%d") AS "PUBLISHED_DATE"
FROM BOOK
JOIN AUTHOR ON BOOK.AUTHOR_ID = AUTHOR.AUTHOR_ID
WHERE BOOK.CATEGORY = "경제"
ORDER BY PUBLISHED_DATE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131533
-- 상품 별 오프라인 매출 구하기

/*
PRODUCT_CODE별로 매출액(PRICE * SALES_AMOUNT)을 합산하여 SALES로 나타냄.
매출액을 기준으로 내림차순, 매출액이 같을 경우 PRODUCT_CODE 기준으로 오름차순 정렬
*/
SELECT PR.PRODUCT_CODE, SUM(PR.PRICE * OS.SALES_AMOUNT) AS SALES
FROM PRODUCT PR
JOIN OFFLINE_SALE OS ON PR.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY PR.PRODUCT_CODE
ORDER BY SALES DESC, PR.PRODUCT_CODE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/133026
-- 성분으로 구분한 아이스크림 총 주문량

-- INGREDIENT_TYPE별로 총주문량을 합산하여 TOTAL_ORDER로 나타냄.
-- 주문량이 적은 순으로 정렬

SELECT II.INGREDIENT_TYPE, SUM(FH.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF FH
JOIN ICECREAM_INFO II ON FH.FLAVOR = II.FLAVOR
GROUP BY II.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
-- 루시와 엘라 찾기

-- WHERE 절에서 IN 연산자를 사용할 때 괄호가 필요 !
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ("Lucy", "Ella", "Pickle", "Rogan", "Sabrina", "Mitty")
ORDER BY ANIMAL_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
-- 3월에 태어난 여성 회원 목록 출력하기

-- DATE_OF_BIRTH에서 월을 추출
-- GENDER가 여성인 경우 필터링

SELECT MEMBER_ID, MEMBER_NAME, GENDER, 
DATE_FORMAT(DATE_OF_BIRTH,"%Y-%m-%d") AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO IS NOT NULL
 AND MONTH(DATE_OF_BIRTH) = 3
  AND GENDER = 'W'
ORDER BY MEMBER_ID;

/*
일반적으로 AS 뒤에 붙이는 별칭에는 큰따옴표(" ")나 작은따옴표(' ')를 쓰지 않아도 된다. 
다만, 특수문자나 공백이 포함된 경우에는 반드시 큰따옴표나 작은따옴표로 묶어줘야 한다.

ex ) 다음과 같은 경우 별칭에 따옴표가 필요하다

SELECT COLUMN_NAME AS "별칭 예시"
FROM TABLE_NAME;

ㄴ> 하지만 일반적인 별칭, 즉 특수문자나 공백이 없는 경우에는 생략해도 된다.

SELECT COLUMN_NAME AS COLUMN_ALIAS
FROM TABLE_NAME;

또한 데이터베이스 종류에 따라 
별칭에 큰따옴표와 작은따옴표 사용 규칙이 다를 수 있으므로, 
사용하는 DB의 문법도 참고하는 것이 좋다.
*/