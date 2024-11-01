

-- https://school.programmers.co.kr/learn/courses/30/lessons/284529
-- 부서별 평균 연봉 조회하기

SELECT 
    A.DEPT_ID, 
    A.DEPT_NAME_EN, 
    ROUND(AVG(B.SAL), 0) AS AVG_SAL
FROM 
    HR_DEPARTMENT A
JOIN 
    HR_EMPLOYEES B ON A.DEPT_ID = B.DEPT_ID
GROUP BY 
    A.DEPT_ID, A.DEPT_NAME_EN
ORDER BY 
    AVG_SAL DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/299307
-- 대장균의 크기에 따라 분류하기 1

/*
CASE
    WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
    WHEN SIZE_OF_COLONY > 100 AND SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
    ELSE 'HIGH'
END

이렇게 지정해줘도 됨 !
*/
-- 내가 푼 방식은 조건의 순서에 따라 
-- CASE문이 첫 번째로 일치하는 조건을 적용하기 때문에 유효

SELECT ID, 
CASE
WHEN SIZE_OF_COLONY <=100 THEN "LOW"
WHEN SIZE_OF_COLONY <= 1000 THEN "MEDIUM"
WHEN SIZE_OF_COLONY > 1000 THEN "HIGH"
END AS SIZE
FROM ECOLI_DATA
ORDER BY ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/157340
-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기

/*
1. 서브쿼리 사용:

SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
ㄴ> 2022-10-16에 대여 중인 CAR_ID 목록을 반환한다.
이 서브쿼리는 특정 날짜(2022-10-16)가 START_DATE와 END_DATE 사이에 있는 차량만 필터링하여 가져온다.

2. 메인 쿼리의 CASE문:

CASE WHEN CAR_ID IN (...) THEN '대여중' ELSE '대여 가능' END
ㄴ> 서브쿼리에서 반환된 CAR_ID 목록에 현재 CAR_ID가 포함되면 "대여중", 포함되지 않으면 "대여 가능"으로 표시한다.

3. GROUP BY :

GROUP BY CAR_ID는 CAR_ID별로 중복 없이 결과를 출력한다.
이 방식은 조건을 서브쿼리로 처리해 
중첩된 조건을 단순화하면서도 
각 CAR_ID별로 대여 가능 여부를 정확히 구분할 수 있다.
어렵다요 ...! 많이 해보는 수밖에..?!
*/

SELECT CAR_ID,
(CASE WHEN CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE)
THEN '대여중'
ELSE '대여 가능'
END) AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/164671
-- 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기

/*
WHERE A.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)는 조회수가 가장 높은 게시물을 선택한다.
서브쿼리 (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)가 전체 테이블에서 최고 조회수를 찾기 때문에, 해당 조회수를 가진 게시물만 필터링한다.
*/

SELECT 
    CONCAT('/home/grep/src/', A.BOARD_ID, '/', 
           B.FILE_ID, B.FILE_NAME, B.FILE_EXT) AS FILE_PATH
FROM 
    USED_GOODS_BOARD A
JOIN 
    USED_GOODS_FILE B ON A.BOARD_ID = B.BOARD_ID
WHERE 
    A.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY 
    B.FILE_ID DESC;

/*
WHERE 절에는 집계 함수를 사용할 수 없는 것은 SQL 규칙 중 하나다. 
그 이유는 WHERE 절이 행 필터링 단계에서 먼저 실행되고, 
그 후에 집계 함수가 적용되기 때문이다. 

ㄴ> SQL 쿼리의 실행 순서를 보면 이해하기 쉬운데, 대략적인 실행 순서는 다음과 같다:

FROM / JOIN: 테이블을 결합하고 데이터를 가져온다.
WHERE: 각 행을 필터링한다.
GROUP BY: 그룹을 만든다.
집계 함수(Aggregation): 각 그룹에 대해 집계 계산을 수행한다.
HAVING: 집계 결과를 필터링한다.
SELECT: 최종적으로 선택한 컬럼을 출력한다.
ORDER BY: 결과를 정렬한다.

ㄴ> 결론 : 집계 함수는 GROUP BY 이후에 계산되므로, 
집계 함수를 필터링할 때는 WHERE가 아닌 HAVING 절을 사용해야 한다. 
HAVING은 이미 계산된 집계 결과를 대상으로 필터링하기 때문에 집계 함수를 사용할 수 있다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/77487
-- 헤비 유저가 소유한 장소

/*
GROUP BY를 사용하는 경우, 
SELECT 절에 포함된 컬럼들은 그룹화되지 않은 컬럼이어도 되는데, 
이때 모든 컬럼이 개별 그룹에 따라 집계된 데이터만을 포함해야 한다. 
GROUP BY는 HOST_ID 기준으로 그룹을 만들어 집계하므로 
SELECT에 들어간 ID와 NAME 컬럼은 그룹화되지 않은 필드를 그대로 포함하고 있어 에러가 발생할 수 있다.
ㄴ>이 문제에서는 먼저 헤비 유저 ID를 추출한 후, 
이를 활용해 해당 유저가 등록한 공간들을 조회하는 방법을 사용하면 된다.
*/

/*
1. 서브쿼리: HOST_ID 기준으로 그룹화한 후, 
등록한 공간 수(COUNT(ID))가 2개 이상인 HOST_ID만 추출해 헤비 유저 목록을 만든다.

2. 메인 쿼리: PLACES 테이블에서 WHERE HOST_ID IN (...) 조건을 통해 
헤비 유저가 등록한 공간만 조회한다.

3. 정렬: 최종적으로 ID 기준으로 오름차순 정렬한다.
*/

SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(ID) >= 2
)
ORDER BY ID;
