-- 프로그래머스 3단계 대여 기록이 존재하는 자동차 리스트 구하기

-- 테이블을 만들어보자 
create table CAR_RENTAL_COMPANY_CAR
(
    CAR_ID      INTEGER         not null
    ,CAR_TYPE    VARCHAR(255)   not null  
    ,DAILY_FEE   INTEGER        not null
    ,OPTIONS     VARCHAR(255)   not null
);

-- 테이블에 값 대입 
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '1', '세단', '16000', '가죽시트,열선시트,후방카메라');
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '2', 'SUV', '14000', '스마트키,네비게이션.열선시트');
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '3', '세단', '22000', '주차감지센서,후방카메라,가죽시트');
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '3', '세단', '12000', '주차감지센서');

-- 테이블 상태 확인하기
select *
from CAR_RENTAL_COMPANY_CAR;

-- 테이블을 만들어보자 
create table CAR_RENTAL_COMPANY_RENTAL_HISTORY
(
    HISTORY_ID    INTEGER     not null
    ,CAR_ID       INTEGER     not null  
    ,START_DATE   DATE        not null
    ,END_DATE     DATE        not null
);


-- 테이블에 값 대입 
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '1', '4', '2022-09-27', '2022-09-27');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '2', '3', '2022-10-03', '2022-10-04');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '3', '2', '2022-10-05', '2022-10-05');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '4', '1', '2022-10-11', '2022-10-14');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY(HISTORY_ID, CAR_ID , START_DATE, END_DATE) values( '5', '3', '2022-10-13', '2022-10-15');

-- 테이블 상태 확인하기
select *
from CAR_RENTAL_COMPANY_RENTAL_HISTORY;


--CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 자동차 종류가 
--'세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력하는 SQL문을 작성해주세요. 
--자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬해주세요.

-- JOIN을 사용하여 문제를 풀이 하였다.

SELECT B.CAR_ID                                 -- 출력 을 CAR_ID부분을 할 것이다 
    FROM 
    (
      select CAR_ID
      from CAR_RENTAL_COMPANY_CAR
      where CAR_TYPE = '세단'                     -- 세단을 구분하고 
    ) A
    JOIN                                        -- 합친다.
    (
      select CAR_ID                             
      from CAR_RENTAL_COMPANY_RENTAL_HISTORY
      where extract(month from START_DATE) = 10     -- 10월에 대여시작한 것을 구분한다.
    ) B
    ON A.CAR_ID = B.CAR_ID                      -- 조인조건절 CAR_ID가 공동컬럼이므로 묶어버린다.
    group by B.CAR_ID                           -- 중복값을 하나로 묶기 위해서 
    order by 1 desc;                            -- 내림차순 





-- 테이블 삭제 
drop table CAR_RENTAL_COMPANY_CAR purge;
drop table CAR_RENTAL_COMPANY_RENTAL_HISTORY purge;
