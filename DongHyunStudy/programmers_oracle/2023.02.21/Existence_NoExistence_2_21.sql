-- 프로그래머스 3단계 있었는데요 없었습니다
drop table ANIMAL_INS purge;

-- 테이블을 만들어보자 
create table ANIMAL_INS
(
    ANIMAL_ID          VARCHAR(20)        not null   --동물 아이디
    ,ANIMAL_TYPE       VARCHAR(30)        not null   --생물 종
    ,DATETIME          DATE               not null   --보호 시작인
    ,INTAKE_CONDITION  VARCHAR(30)        not null   --보호 시작시 상태
    ,NAME              VARCHAR(30)                   --이름
    ,SEX_UPON_INTAKE   VARCHAR(30)        not null   -- 성별 및 중성화 여부
);

-- 테이블에 값 대입 
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A350276', 'Cat', to_date('2017-08-13 13:50:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Jewel', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A381217', 'Dog', to_date('2017-07-08 09:41:00','YYYY-MM-DD HH24:MI:SS'), 'Sick', 'Cherokee', 'Neutered Male');


-- 테이블 상태 확인하기
select ANIMAL_ID, ANIMAL_TYPE, to_char(DATETIME, 'yyyy-mm-dd hh24:mi:ss'), INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
from ANIMAL_INS;

-- 테이블을 만들어보자 
create table ANIMAL_OUTS
(
    ANIMAL_ID          VARCHAR(20)     not null       --동물 아이디
    ,ANIMAL_TYPE       VARCHAR(30)     not null       --생물 종
    ,DATETIME          DATE            not null       --입양일
    ,NAME              VARCHAR(30)                    --이름
    ,SEX_UPON_OUTCOME  VARCHAR(30)     not null       --성별 및 중성화 여부 
);


-- 테이블에 값 대입 
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A350276', 'Cat', to_date('2018-01-28 17:51:00','YYYY-MM-DD HH24:MI:SS'), 'Jewel', 'Spayed Female');
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A381217', 'Dog', to_date('2017-06-09 18:51:00','YYYY-MM-DD HH24:MI:SS'), 'Cherokee', 'Neutered Male');
-- 테이블 상태 확인하기
select *
from ANIMAL_OUTS;


--관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
--보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
--이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

-- 정답 코드
SELECT ANIMAL_ID, NAME
FROM
(
    SELECT A.ANIMAL_ID , B.NAME, A.DATETIME
    FROM ANIMAL_INS A JOIN ANIMAL_OUTS B 
    ON A.ANIMAL_ID = B. ANIMAL_ID
    where A.DATETIME > B.DATETIME
    order by 3 
);


-- 테이블 삭제 
drop table ANIMAL_INS purge;
drop table ANIMAL_OUTS purge;
