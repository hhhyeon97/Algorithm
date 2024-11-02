

-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

/*
WHERE 절에서 날짜 범위 지정: 
ㄴ> START_DATE BETWEEN '2022-08-01' AND '2022-10-31'로 기간을 제한하여 해당하는 레코드만 가져온다.

CAR_ID IN 조건: 
ㄴ> 서브쿼리를 통해 해당 기간 동안 대여 횟수가 5회 이상인 자동차 ID를 필터링한다.

GROUP BY: 
ㄴ> MONTH(START_DATE)와 CAR_ID로 그룹화해 월별로 자동차 ID별 총 대여 횟수를 계산한다.

ORDER BY: 월 오름차순, 월이 같을 경우 자동차 ID 내림차순으로 정렬한다.
*/

SELECT 
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE 
    START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    AND CAR_ID IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        GROUP BY CAR_ID
        HAVING COUNT(*) >= 5
    )
GROUP BY 
    MONTH(START_DATE), CAR_ID
ORDER BY 
    MONTH(START_DATE) ASC, 
    CAR_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/298519
-- 특정 조건을 만족하는 물고기별 수와 최대 길이 구하기

