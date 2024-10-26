

-- https://school.programmers.co.kr/learn/courses/30/lessons/273709
-- 조건에 맞는 아이템들의 가격의 총합 구하기

SELECT SUM(PRICE) AS "TOTAL_PRICE"
FROM ITEM_INFO
WHERE RARITY = "LEGEND";

-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
-- 고양이와 개는 몇 마리 있을까

-- 고려할 점
-- 고양이와 개가 각각 몇 마리인지 조회
-- 고양이를 개보다 먼저 조회

SELECT ANIMAL_TYPE, COUNT(*) AS "count"
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
-- 중성화 여부 파악하기

-- 중성화 여부를 'O' 또는 'X'로 표시하기 위해 CASE문 사용

SELECT ANIMAL_ID, NAME,
       CASE 
           WHEN SEX_UPON_INTAKE LIKE '%Neutered%' 
           OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
           ELSE 'X'
       END AS "중성화"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

/*
CASE 문은 SQL에서 조건에 따라 다른 값을 반환할 때 사용된다.
IF문과 비슷하게 작동하며, 특정 조건이 TRUE일 때 값을 반환하고, 
그렇지 않으면 다른 값을 반환한다.

기본 구조
------------------------------
CASE 
    WHEN 조건1 THEN 결과1
    WHEN 조건2 THEN 결과2
    ...
    ELSE 기본결과
END
------------------------------
WHEN : 조건을 설정하는 부분
THEN : 조건이 참일 때 반환할 값을 지정
ELSE : 모든 조건이 거짓일 때 반환할 기본 값
END : CASE 문을 마무리하는 부분
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- 입양 시각 구하기(1)

-- 시간대별로 입양 건수를 조회하기 위해
-- HOUR 함수를 사용하여 DATETIME 컬럼에서 시간만 추출
-- 추출된 시간별로 그룹핑하고, 시간대 오름차순으로 정렬하여 결과 출력

SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR
ORDER BY HOUR;

/*
BETWEEN은 이상과 이하를 포함하는 범위를 지정하는 키워드
양 끝값을 포함하는 조건을 설정할 때 유용

ex ) WHERE HOUR(DATETIME) BETWEEN 9 AND 19는
9 이상 그리고 19 이하의 값을 모두 포함하는 범위를 의미한다.

반대로 초과나 미만 조건이 필요하다면 
BETWEEN 대신 >, <, >=, <=와 같은 비교 연산자를 사용하면 된다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/151137
-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기

SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' 
   OR OPTIONS LIKE '%열선시트%' 
   OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;

/*
ㄴ> 예시에 있는 OPTIONS를 확인해보면 위 3개 옵션 제외하고는 시트라는 말이 안 들어감
ㄴ> 그래서 공통 문구인 %시트%로만 줄여서 돌려봐도 정답 처리됨 ! 
*/
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;
