

-- https://school.programmers.co.kr/learn/courses/30/lessons/144856
-- 저자 별 카테고리 별 매출액 집계하기

-- 저자와 카테고리별로 매출액을 구해 조건에 맞게 정렬된 결과를 반환
-- SUM(C.SALES * A.PRICE): 판매량 * 판매가로 매출액(TOTAL_SALES)을 계산

SELECT 
    A.AUTHOR_ID, 
    B.AUTHOR_NAME, 
    A.CATEGORY, 
    SUM(C.SALES * A.PRICE) AS TOTAL_SALES
FROM 
    BOOK A
JOIN 
    AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
JOIN 
    BOOK_SALES C ON A.BOOK_ID = C.BOOK_ID
WHERE 
    C.SALES_DATE LIKE '2022-01%'
GROUP BY 
    A.AUTHOR_ID, B.AUTHOR_NAME, A.CATEGORY
ORDER BY 
    A.AUTHOR_ID ASC, A.CATEGORY DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/62284
-- 우유와 요거트가 담긴 장바구니

-- 이렇게 생각하게 하는 문제 좋은 것 같다요 아직은 부족하지만 킵고잉 ...!!

-- CART_ID가 동일하면서 
-- Milk와 Yogurt 두 제품 모두 포함된 장바구니를 조회해야 하므로, 
-- HAVING 절과 COUNT를 활용한 집계를 사용

SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID -- CART_ID별로 그룹화하여 각 장바구니를 구분
HAVING COUNT(DISTINCT NAME) = 2 -- 2는 Milk와 Yogurt가 각각 한 번씩 나타남을 의미
ORDER BY CART_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/133027
-- 주문량이 많은 아이스크림들 조회하기

-- SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC를 
-- ORDER BY에서 직접 사용해 집계한 내용은 테이블에 출력되지 않도록 설정
-- JOIN 절: FLAVOR를 기준으로 FIRST_HALF와 JULY 테이블을 연결한다. 
-- SHIPMENT_ID가 아닌 FLAVOR로 연결해야 각 맛에 대해 주문량을 합산할 수 있다.
-- ㄴ> 조건에서 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 된다는 부분이 있으므로 !!

SELECT B.FLAVOR
FROM FIRST_HALF A
JOIN JULY B
ON A.FLAVOR = B.FLAVOR
GROUP BY B.FLAVOR
ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
LIMIT 3;


-- https://school.programmers.co.kr/learn/courses/30/lessons/284528
-- 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기

-- 상반기+하반기 점수 평균을 기준으로 조건 걸어야 했음 !!
/*
CASE 구문 내에서 정의한 GRADE 별칭을 바로 사용할 수 없다.
SQL에서는 SELECT 절에서 지정한 별칭을 다른 CASE 구문에서 직접 참조할 수 없으므로, 
각 CASE 구문 내에서 성과금을 계산하는 조건을 반복해 주어야 한다.
*/
SELECT 
    B.EMP_NO, 
    B.EMP_NAME,
    CASE
        WHEN AVG(C.SCORE) >= 96 THEN 'S'
        WHEN AVG(C.SCORE) >= 90 THEN 'A'
        WHEN AVG(C.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE 
        WHEN AVG(C.SCORE) >= 96 THEN B.SAL * 0.2
        WHEN AVG(C.SCORE) >= 90 THEN B.SAL * 0.15
        WHEN AVG(C.SCORE) >= 80 THEN B.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM HR_DEPARTMENT A
JOIN HR_EMPLOYEES B ON A.DEPT_ID = B.DEPT_ID
JOIN HR_GRADE C ON B.EMP_NO = C.EMP_NO
GROUP BY B.EMP_NO, B.EMP_NAME
ORDER BY B.EMP_NO;

/* GROUP BY 관련 설명 추가
GROUP BY는 지정한 컬럼을 기준으로 데이터를 그룹화하므로 
그룹화한 컬럼에 대해 중복을 제거하는 효과를 낸다. 
예를 들어, GROUP BY B.EMP_NO를 사용하면 동일한 사번(EMP_NO)을 가진 레코드는 하나로 그룹화된다. 
각 그룹 내에서 특정 집계 함수(SUM, COUNT, MAX 등)를 사용해 계산하거나, 
집계 없이 각 그룹의 첫 번째 행의 값을 가져온다.

예를 들어 GROUP BY 없이 테이블에 동일한 사번에 대해 
여러 행이 있으면 그대로 중복으로 표시된다. 
그러나 GROUP BY B.EMP_NO를 사용하면 사번별로 그룹화가 되어 한 사원당 하나의 레코드만 반환된다.

주의점
GROUP BY가 있다고 해도 각 필드에 대해 다중 레코드를 병합하지 않는다는 점은 주의해야 한다. 
예를 들어 GROUP BY에 포함되지 않은 컬럼(예: B.SAL, C.SCORE)을 SELECT 절에 사용하면 
각 그룹에서 어느 값을 보여줄지 SQL은 알 수 없으므로 보통 집계 함수와 함께 사용해야 한다.

따라서 GROUP BY를 활용할 때는 중복을 없애려는 컬럼을 기준으로 하고, 
필요에 따라 집계 함수를 추가해야 한다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/131124
-- 그룹별 조건에 맞는 식당 목록 출력하기

/*
리뷰를 가장 많이 작성한 회원을 먼저 구한 후, 
그 회원의 리뷰 내역을 조회하는 방식으로 해결 접근

1. 가장 리뷰를 많이 작성한 회원 구하기
ㄴ> 서브쿼리에서 REST_REVIEW 테이블을 MEMBER_ID로 그룹화하고, 
COUNT(B.REVIEW_ID)를 기준으로 내림차순 정렬해 리뷰가 가장 많은 회원을 가져온다.
LIMIT 1로 가장 많이 작성한 회원 한 명만 선택한다.

2. 리뷰 조회
ㄴ> 메인 쿼리에서 MEMBER_PROFILE과 REST_REVIEW 테이블을 조인하여 해당 회원의 리뷰를 조회한다.
조건에 맞게 오름차순 정렬한다.

주의할 점
HAVING 절 대신 서브쿼리를 사용해 가장 많이 리뷰를 작성한 회원을 찾았다. 
HAVING으로 최대 COUNT를 직접 필터링하기 어려운 경우 서브쿼리를 활용하면 유용하다.
*/
SELECT A.MEMBER_NAME, 
       B.REVIEW_TEXT, 
       DATE_FORMAT(B.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE A
JOIN REST_REVIEW B
ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID = (
    SELECT B.MEMBER_ID
    FROM REST_REVIEW B
    GROUP BY B.MEMBER_ID
    ORDER BY COUNT(B.REVIEW_ID) DESC
    LIMIT 1
)
ORDER BY B.REVIEW_DATE ASC, B.REVIEW_TEXT ASC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131537
-- 오프라인/온라인 판매 데이터 통합하기

/*
JOIN은 테이블 간 관계가 필요할 때 사용하지만, 
여기서는 단순히 온라인과 오프라인 판매 데이터를 
날짜 기준으로 합쳐서 정렬하는 것이 목표이기 때문에 UNION ALL이 더 나은 접근이다.
*/

-- UNION ALL 활용하기 
-- UNION ALL을 사용해 두 테이블의 데이터를 합친다. 
-- UNION ALL은 중복을 허용하며, 두 테이블 간 필드 수와 타입이 동일해야 사용 가능하다.
-- 조건에 맞게 오프라인에는 없는 USER_ID는 NULL로 설정하여 동일한 형식으로 맞춘다.

/* 추가 꼬꼬 내용
UNION: 두 테이블의 중복된 행을 제거한 합집합을 반환한다.
UNION ALL: 중복된 행을 제거하지 않고 그대로 모두 포함하여 반환한다.
예를 들어, 두 테이블에 동일한 데이터가 있다면 UNION은 한 번만 표시하고, 
UNION ALL은 각각의 중복된 데이터도 모두 표시한다. 
UNION ALL은 UNION보다 성능이 조금 더 빠르기도 하다.
*/

SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, 
       PRODUCT_ID, 
       USER_ID, 
       SALES_AMOUNT
FROM (
    SELECT SALES_DATE, 
           PRODUCT_ID, 
           USER_ID, 
           SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE SALES_DATE LIKE '2022-03%'
    
    UNION ALL
    
    SELECT SALES_DATE, 
           PRODUCT_ID, 
           NULL AS USER_ID,  -- 오프라인 판매 데이터는 USER_ID를 NULL로 표시
           SALES_AMOUNT
    FROM OFFLINE_SALE
    WHERE SALES_DATE LIKE '2022-03%'
) AS SALES_DATA
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;
