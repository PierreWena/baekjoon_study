--프로그래머스 3단계 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기

-- 테이블 생성 
create table CAR_RENTAL_COMPANY_RENTAL_HISTORY
(HISTORY_ID    INTEGER    NOT NULL
,CAR_ID        INTEGER    NOT NULL
,START_DATE    DATE       NOT NULL
,END_DATE      DATE       NOT NULL
);

-- 테이블에 값 대입 
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('1','4','2022-09-27', '2022-09-27');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('2','3','2022-10-03', '2022-10-04');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('3','2','2022-10-05', '2022-10-05');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('4','1','2022-10-11', '2022-10-16');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('5','3','2022-10-13', '2022-10-15');
insert into CAR_RENTAL_COMPANY_RENTAL_HISTORY values ('6','2','2022-10-15', '2022-10-17');

-- 확인하기 
select * 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY;

-- 정답 코드 
select CAR_ID
      ,MAX(case when to_char(START_DATE, 'yyyy-mm-dd') <= '2022-10-16' and '2022-10-16' <= to_char(END_DATE, 'yyyy-mm-dd') then '대여중' else '대여 가능' end) AS AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc;

--> 시작 날짜와 끝 날짜를 비교하고 그 안에 있으면 대여중, 아니면 대여가능으로 해준다
--> CAR_ID 2번이 중복되어 두개가 나오므로 group by 에서 오류가 생긴다.
--> 그렇기 때문에 group by 를 묶기위해 하나의 값으로 통일 시켜줘야 하는데 2번의 경우 대여중을 나타내는 것으로 
--> MAX 함수를 써줘 강제로 대여중을 만들어 준것이다. 

----------------------------------------------------------------------------------

-- MAX와 MIN을 차이점을 알기위해 써줌 
select CAR_ID
      ,MIN(case when to_char(START_DATE, 'yyyy-mm-dd') <= '2022-10-16' and '2022-10-16' <= to_char(END_DATE, 'yyyy-mm-dd') then '대여중' else '대여 가능' end) AS AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc;



--MAX를 하면 case 문에서 then 부분을 나타내준다. (최대)
--MIN을 하면 case 문에서 else 부분을 나타내준다. (최소)


 drop table CAR_RENTAL_COMPANY_RENTAL_HISTORY purge;

