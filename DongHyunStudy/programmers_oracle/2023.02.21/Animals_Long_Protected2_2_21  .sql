-- 프로그래머스 3단계 오랜 기간 보호한 동물(2)
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
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A354597', 'Cat', to_date('2014-05-02 12:16:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Ariel', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A362707', 'Dog', to_date('2016-01-27 12:27:00','YYYY-MM-DD HH24:MI:SS'), 'Sick', 'Girly Girl', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A370507', 'Cat', to_date('2014-10-27 14:43:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Emily', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A414513', 'Dog', to_date('2016-06-07 09:17:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Rocky	', 'Neutered Male');

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
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A354597', 'Cat', to_date('2014-05-02 12:16:00','YYYY-MM-DD HH24:MI:SS'), 'Ariel', 'Spayed Female');
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A362707', 'Dog', to_date('2016-01-27 12:27:00','YYYY-MM-DD HH24:MI:SS'), 'Girly Girl', 'Spayed Female');
insert into ANIMAL_OUTS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A414513', 'Dog', to_date('2016-06-07 09:17:00','YYYY-MM-DD HH24:MI:SS'), 'Rocky', 'Neutered Male');
-- 테이블 상태 확인하기
select *
from ANIMAL_OUTS;


--아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.
    
-- 정답 코드
SELECT ANIMAL_ID, NAME
FROM
(
    SELECT B.ANIMAL_ID , B.NAME , (B.DATETIME - A.DATETIME) AS DATETIME
    FROM ANIMAL_INS A JOIN ANIMAL_OUTS B 
    ON A.ANIMAL_ID = B.ANIMAL_ID
    ORDER BY DATETIME desc
)
WHERE ROWNUM <= 2;

-- 테이블 삭제 
drop table ANIMAL_INS purge;
drop table ANIMAL_OUTS purge;
