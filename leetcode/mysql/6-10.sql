

-- # 6.
-- https://leetcode.com/problems/rising-temperature/description/

-- 테이블을 셀프조인할 때 날짜를 기준으로 해야 함 !
SELECT a.id
FROM Weather a
JOIN Weather b
ON a.recordDate = DATE_ADD(b.recordDate, INTERVAL 1 DAY) -- a와 b 테이블의 recordDate를 기준으로 "오늘(a)과 어제(b)"를 연결
WHERE a.temperature > b.temperature; -- 오늘(a)의 온도가 어제(b)보다 높은 경우만 필터링
-- DATE_ADD(b.recordDate, INTERVAL 1 DAY)는 b.recordDate에 하루를 더한 날짜 반환