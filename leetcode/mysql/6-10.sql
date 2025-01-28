

-- # 6.
-- https://leetcode.com/problems/rising-temperature/description/

-- 테이블을 셀프조인할 때 날짜를 기준으로 해야 함 !
SELECT a.id
FROM Weather a
JOIN Weather b
ON a.recordDate = DATE_ADD(b.recordDate, INTERVAL 1 DAY) -- a와 b 테이블의 recordDate를 기준으로 "오늘(a)과 어제(b)"를 연결
WHERE a.temperature > b.temperature; -- 오늘(a)의 온도가 어제(b)보다 높은 경우만 필터링
-- DATE_ADD(b.recordDate, INTERVAL 1 DAY) : b.recordDate에 하루를 더한 날짜 반환

-- # 7.
-- https://leetcode.com/problems/game-play-analysis-i/description/

-- 게임 플레이 분석하기
-- player_id 별로 가장 빠른 event_date를 출력
select player_id as player_id, min(event_date) as first_login
from Activity
group by player_id;

-- # 8.
-- https://leetcode.com/problems/employee-bonus/description/

-- 직원 보너스 금액 보고하기
-- 보너스가 1000 미만인 직원 정보 출력
select e.name as name, b.bonus as bonus
from Employee e
left join Bonus b
on e.empId = b.empId
where b.bonus < 1000 or b.empId is null;
