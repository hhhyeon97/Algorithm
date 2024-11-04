

-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
-- 보호소에서 중성화한 동물


SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A
JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE "Intact%" -- "Intact"로 시작하는 동물(즉, 중성화되지 않은 동물)을 필터링
AND B.SEX_UPON_OUTCOME NOT LIKE 'Intact%' -- "Intact"로 시작하지 않는 동물(즉, 중성화된 동물)을 필터링
ORDER BY A.ANIMAL_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
-- 식품분류별 가장 비싼 식품의 정보 조회하기

/*
서브쿼리는 특정 그룹 내에서 조건을 만족하는 행을 정확히 찾아야 할 때 특히 유용

예를 들어, 그룹별로 최대값이나 최소값을 가진 행 전체를 가져와야 할 때 
서브쿼리를 사용하면 복잡한 조건을 깔끔하게 처리할 수 있다.

서브쿼리를 사용해야 하는 경우

1. 그룹별 최대/최소값 조건이 있는 경우: 
그룹별로 가장 큰 값이나 작은 값을 가진 행을 찾아야 할 때, 
이 값을 구한 뒤 해당 조건을 만족하는 전체 행을 가져오려면 서브쿼리가 효과적
예: 각 카테고리별 가장 높은 가격을 가진 제품의 모든 정보(가격, 이름 등)를 조회할 때


2. 특정 조건에 맞는 행이 다른 테이블의 조건에 의존하는 경우: 
두 테이블의 데이터를 결합하면서, 한쪽 테이블의 특정 조건을 만족하는 값에 맞추어 다른 테이블에서 데이터를 필터링할 때 유용
예: 보호소 입소 시 중성화되지 않았지만 출소 시 중성화된 동물 정보를 조회할 때


3. 특정 계산 결과를 기준으로 다시 필터링이 필요한 경우: 
쿼리 안에서 계산된 결과를 다시 필터링 조건으로 사용해야 하는 경우, 서브쿼리를 통해 그 계산을 먼저 수행하고 메인 쿼리에서 필터링하는 방식이 효과적
예: 평균 이상 또는 특정 백분위수를 넘는 값만 필터링해야 하는 경우


4. 중첩된 조건: 
복잡한 조건이나 여러 단계로 데이터를 필터링해야 할 때, 각 단계마다 별도의 서브쿼리로 분리해 진행하면 가독성과 유지보수성이 높아짐


이 문제에서도 FOOD_PRODUCT 테이블에서 CATEGORY별로 
가장 비싼 제품의 이름과 가격을 구해야 하는데
만약 서브쿼리를 사용하지 않으면, MAX(PRICE)와 함께 
다른 컬럼(PRODUCT_NAME)을 GROUP BY 없이 선택할 수 없고, 정확한 값을 가져오기 어려워짐
*/

-- 장점: 서브쿼리를 통해 바로 최대 가격을 찾기 때문에, 
-- 테이블을 반복적으로 조회하지 않아도 된다.
-- 단점: SQL 엔진이 서브쿼리와 메인 쿼리를 최적화하는 방식에 따라 성능 차이가 발생할 수 있으며, 
-- 일부 SQL 엔진에서는 서브쿼리를 비효율적으로 처리할 가능성이 있다.

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
)
ORDER BY PRICE DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131117
-- 5월 식품들의 총매출 조회하기

/*
SQL에서 GROUP BY 절을 사용할 때, 
SELECT 절에 있는 모든 컬럼은 GROUP BY 절에 포함하거나, 집계 함수로 감싸야 한다. 
즉, GROUP BY A.PRODUCT_ID만 사용하고 
A.PRODUCT_NAME을 포함하지 않으면 대부분의 SQL 엔진에서 에러가 발생한다. 
이 규칙은 SQL 표준에서 GROUP BY에 포함되지 않은 컬럼이 
SELECT에 나올 때 어떤 값을 반환해야 하는지 애매해지는 것을 방지하기 위해서다.
ㄴ>
GROUP BY A.PRODUCT_ID만 사용하고 PRODUCT_NAME을 집계 함수 없이 사용하면, 
동일한 PRODUCT_ID에 여러 PRODUCT_NAME이 있을 때 
어떤 이름을 반환해야 할지 SQL 엔진이 결정할 수 없기 때문에 애매해진다.
따라서 GROUP BY에 PRODUCT_NAME도 추가하면, 
각각의 PRODUCT_ID와 PRODUCT_NAME의 조합이 하나의 그룹으로 처리되면서 
SQL 엔진이 정확히 어떤 데이터를 반환해야 할지 알 수 있다.
만약 상품 ID만으로 그룹핑할 수 있는 상황
ㄴ>
만약 PRODUCT_ID가 기본 키라서 PRODUCT_NAME이 항상 같은 값이라면, 
대부분의 SQL 엔진에서 GROUP BY PRODUCT_ID로만 써도 정상 작동한다. 
다만, SQL 쿼리 작성에서 일관성과 명확성을 유지하기 위해 둘 다 포함하는 것이 좋다.
*/

SELECT A.PRODUCT_ID, A.PRODUCT_NAME, SUM(B.AMOUNT * A.PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT A
JOIN FOOD_ORDER B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE B.PRODUCE_DATE LIKE '2022-05%'
GROUP BY A.PRODUCT_ID, A.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID ASC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/132204
-- 취소되지 않은 진료 예약 조회하기





-- https://school.programmers.co.kr/learn/courses/30/lessons/131118
-- 서울에 위치한 식당 목록 출력하기

