-- 프로그래머스 3단계 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

-- 테이블을 만들어보자 
create table CAR_RENTAL_COMPANY_RENTAL_HISTORY
(
    HISTORY_ID      INTEGER         not null
    ,CAR_ID         INTEGER         not null  
    ,START_DATE  	DATE            not null
    ,END_DATE    	DATE            not null
);

-- 테이블에 값 대입 
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '1', '1', '2022-07-27', '2022-08-02');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '2', '1', '2022-08-03', '2022-08-04');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '3', '2', '2022-08-05', '2022-08-05');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '4', '2', '2022-08-09', '2022-08-12');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '5', '3', '2022-09-16', '2022-10-15');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '6', '1', '2022-08-24', '2022-08-30');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '7', '3', '2022-10-16', '2022-10-19');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '8', '1', '2022-09-03', '2022-09-07');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '9', '1', '2022-09-18', '2022-09-19');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '10', '2', '2022-09-08', '2022-09-10');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '11', '2', '2022-10-16', '2022-10-19');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '12', '1', '2022-09-29', '2022-10-06');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '13', '2', '2022-10-30', '2022-11-01');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '14', '2', '2022-11-05', '2022-11-05');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '15', '3', '2022-11-11', '2022-11-11');
-- 테이블 상태 확인하기

select *
from CAR_RENTAL_COMPANY_RENTAL_HISTORY;



--CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 
--총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 
--리스트를 출력하는 SQL문을 작성해주세요. 
--결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요. 
--특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.

--- 성공부분 
select MONTH, CAR_ID, RECORDS    -- 출력할 형식
from 
(
    select extract(MONTH from Start_date) AS MONTH, CAR_ID, count(*) AS RECORDS     -- 출력할 형식 count(*) 카운트를 셈  
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY                                          -- 테이블
    where extract(MONTH from Start_date) in('8','9','10')                           -- 8월, 9월,10월만 추출 
    group by extract(MONTH from Start_date),car_id                                  -- 시작날짜와 차id를 group으로 묶음
)
where car_id IN( select CAR_ID                                                      -- 카id에서 records 5 이상을 구한다.
                 from (select extract(MONTH from Start_date) AS MONTH, CAR_ID, count(*) AS RECORDS  
                        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        where extract(MONTH from Start_date) in('8','9','10')
                        group by extract(MONTH from Start_date),car_id
                       )
                 group by CAR_ID 
                 having sum(RECORDS) >= 5)              -- group by 조건절 
order by 1, 2 desc;                                   --오름차순, 내림차순




--------------------------------------------
-- 과정 연습 (실패부분) 
select extract(MONTH from Start_date) AS MONTH, CAR_ID, count(*) AS RECODES
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where extract(MONTH from Start_date) in('8','9','10') 
group by extract(MONTH from Start_date),car_id
having count(*) > 5
order by 1, 2 desc;


select extract(MONTH from Start_date) AS MONTH, CAR_ID, count(*) AS RECODES  
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where extract(MONTH from Start_date) in('8','9','10')
group by extract(MONTH from Start_date),car_id
order by 1, 2 desc



-- 테이블 삭제 
drop table CAR_RENTAL_COMPANY_RENTAL_HISTORY purge;
