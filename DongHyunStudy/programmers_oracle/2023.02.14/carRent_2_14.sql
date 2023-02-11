show user;

-- 테이블을 만들어보자 
create table CAR_RENTAL_COMPANY_CAR
(
    CAR_ID      INTEGER
    ,CAR_TYPE    VARCHAR(255)
    ,DAILY_FEE   INTEGER
    ,OPTIONS     VARCHAR(255)
);

-- 테이블에 값 대입 
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '1', '세단', '16000', '가죽시트,열선시트,후방카메라');
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '2', 'SUV', '14000', '스마트키,네비게이션.열선시트');
insert into CAR_RENTAL_COMPANY_CAR(CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS) values( '3', 'SUV', '22000', '주차감지센서,후방카메라,가죽시트');

-- 테이블 상태 확인하기
select *
from CAR_RENTAL_COMPANY_CAR;

-- 테이블에서 차 종류가suv일때 모든 suv에 평균 일일 대여 요금을 구하세요 (소수점 첫째자리에서 반올림하세요)
select round(avg(DAILY_FEE),0) AS AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = 'SUV';

drop table CAR_RENTAL_COMPANY_CAR purge;
