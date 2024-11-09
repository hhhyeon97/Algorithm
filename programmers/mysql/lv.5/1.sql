

-- https://school.programmers.co.kr/learn/courses/30/lessons/131534
-- 상품을 구매한 회원 비율 구하기

-- 2021년에 가입한 회원을 필터링하여 JOINED2021 CTE에 저장
WITH JOINED2021 AS (
    SELECT  *
    FROM    USER_INFO
    WHERE   YEAR(JOINED) = "2021"
)
-- JOINED2021의 회원 중 상품을 구매한 회원 수와 비율을 연월별로 계산
SELECT 
    YEAR(B.SALES_DATE) YEAR,               -- 구매 날짜의 연도 추출
    MONTH(B.SALES_DATE) MONTH,             -- 구매 날짜의 월 추출
    COUNT(DISTINCT B.USER_ID) PURCHASED_USERS,   -- 월별로 중복 없이 구매한 회원 수
    ROUND(COUNT(DISTINCT B.USER_ID) / (SELECT COUNT(*) FROM JOINED2021), 1) AS PURCHASED_RATIO
                                           -- 구매한 회원 수를 전체 회원 수로 나눈 비율
FROM 
    JOINED2021 A                           -- 2021년에 가입한 회원을 포함하는 CTE
JOIN 
    ONLINE_SALE B ON A.USER_ID = B.USER_ID -- 가입 회원 중 구매한 사람 필터링
GROUP BY 
    YEAR, MONTH                            -- 연도와 월 기준으로 그룹화
ORDER BY 
    YEAR, MONTH                            -- 연도와 월 기준으로 결과 정렬