

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

-- # 9.
-- https://leetcode.com/problems/find-customer-referee/description/

-- 조건
-- 추천인이 2가 아닌 고객
-- 추천인을 지정하지 않은 고객

SELECT name
FROM Customer
WHERE referee_id IS NULL OR referee_id != 2;

-- # 10.
-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/description/

-- 가장 많은 주문을 한 고객 찾기

select customer_number
from Orders
group by customer_number -- 고객별로 주문 개수를 그룹화
order by count(*) desc -- 주문 개수가 많은 순서대로 정렬
limit 1; -- 가장 많이 주문한 고객 한 명만 선택

