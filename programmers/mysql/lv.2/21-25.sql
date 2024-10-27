

-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
-- 가격대 별 상품 개수 구하기

/*
구간별 최소 가격을 기준으로 상품 개수를 세기 위해 
PRICE를 만원 단위로 나누는 로직 추가 
FLOOR 함수로 가격을 만원 단위로 그룹화하고, 
그 값을 PRICE_GROUP 별칭으로 지정한 후 
각 구간별 상품 수를 계산하는 COUNT를 PRODUCTS 별칭으로 지정하기
*/
SELECT FLOOR(PRICE / 10000) * 10000 AS PRICE_GROUP, 
COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP;

/*
FLOOR 함수
ㄴ> 지정한 숫자의 소수점을 버리고 
가장 가까운 작거나 같은 정수로 내림하는 함수

ex ) FLOOR(12.34)는 12로, FLOOR(-5.67)는 -6으로 내림한다.

SQL에서 FLOOR를 사용하는 주된 이유는 
특정 숫자 범위로 묶어 구간을 나눌 때 편리하기 때문이다.

ex ) SELECT FLOOR(12345 / 10000) * 10000; 
-- 결과는 10000. (만원 단위로 내림하여 그룹화)
이를 활용하면 원하는 구간(만원 단위, 천원 단위 등)으로 손쉽게 그룹화할 수 있다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/293257
-- 물고기 종류 별 잡은 수 구하기

-- 물고기 이름 별로 잡은 수(FISH_COUNT)를 내림차순으로 정렬
SELECT COUNT(*) AS FISH_COUNT, FNI.FISH_NAME AS FISH_NAME
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
GROUP BY FNI.FISH_NAME
ORDER BY FISH_COUNT DESC;

/*
문제에서 물고기의 종류 별 물고기의 이름과 잡은 수라고 되어 있어서 
물고기의 종류마다 그에 해당하는 개별 이름을 세는 것으로 풀이할 수 있다. 
즉, 같은 종류에 여러 이름이 있을 수 있으므로 이름을 기준으로 그룹화해야 한다는 뜻이다. 
만약 물고기 종류마다 한 가지 이름만 있다면 FISH_TYPE으로 그룹화해도 상관없다.

이제 두 경우의 차이점을 간단히 정리해보겠다:

이름을 기준으로 그룹화하는 경우: 
ㄴ> 물고기 종류에 여러 이름이 있으면 각 이름에 따라 개수를 세어 출력.
종류로만 그룹화하는 경우: 
ㄴ> 각 물고기 종류의 총 개수만 집계해 출력.
만약 테이블 구조상 각 종류에 하나의 이름만 있다면 FISH_TYPE으로 그룹화해도 된다.

=================================
MySQL은 GROUP BY에 포함되지 않은 컬럼을 
SELECT 절에 사용하지 못하게 기본 설정이 되어 있다. 
이는 그룹화되지 않은 컬럼이 SELECT 절에 포함될 경우, 
어떤 값을 가져와야 할지 모호해지기 때문이다. 
예를 들어, 그룹화된 데이터에서 GROUP BY에 포함되지 않은 컬럼의 값이 여러 개 있으면 
MySQL이 어떤 특정 값을 반환해야 할지 알 수 없기 때문이다.

이 문제에서는 fish_type과 fish_name이 1대1 대응 관계라서 -> (종류별로 이름이 한 개씩만 있음)
FISH_NAME을 GROUP BY에 사용해도 모호하지 않다. 
각 fish_type에 대해 딱 하나의 fish_name만 매칭되므로, 
GROUP BY에 fish_name만 사용해도 문제가 발생하지 않는 것이다.

따라서, 이 경우에는 GROUP BY FISH_NAME을 사용해도 
FISH_TYPE으로 그룹화한 것과 같은 결과가 나온다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/284530
-- 연도 별 평균 미세먼지 농도 조회하기

-- ROUND 함수로 소수 표현, 
-- 별칭 지정, 년도별로 그룹화, 수원 지역으로 필터링, 년도로 정렬

SELECT 
    YEAR(YM) AS YEAR, 
    ROUND(AVG(PM_VAL1), 2) AS PM10, 
    ROUND(AVG(PM_VAL2), 2) AS "PM2.5"
FROM 
    AIR_POLLUTION
WHERE 
    LOCATION2 = '수원'
GROUP BY 
    YEAR(YM)
ORDER BY 
    YEAR;


-- https://school.programmers.co.kr/learn/courses/30/lessons/273710
-- ROOT 아이템 구하기

-- ROOT 아이템의 PARENT 아이템 ID는 
-- NULL 이라고 제시되어 있음 -> 이걸로 필터링하면 됨

SELECT II.ITEM_ID, II.ITEM_NAME
FROM ITEM_INFO II
JOIN ITEM_TREE IT ON II.ITEM_ID = IT.ITEM_ID
WHERE IT.PARENT_ITEM_ID IS NULL
ORDER BY ITEM_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/293260
-- 월별 잡은 물고기 수 구하기

SELECT COUNT(*) AS FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH
ORDER BY MONTH;