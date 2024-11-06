

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