-- 프로그래머스 3단계 대여 기록이 존재하는 자동차 리스트 구하기
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
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A373687', 'Dog', to_date('2014-03-20 12:31:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Rosie', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A412697', 'Dog', to_date('2016-01-03 16:25:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Jackie', 'Neutered Male');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A413789', 'Dog', to_date('2016-04-19 13:28:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Benji', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A414198', 'Dog', to_date('2015-01-29 15:01:00','YYYY-MM-DD HH24:MI:SS'), 'Normal', 'Shelly', 'Spayed Female');
insert into ANIMAL_INS( ANIMAL_ID, ANIMAL_TYPE , DATETIME , INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A368930', 'Dog', to_date('2014-06-08 13:20:00','YYYY-MM-DD HH24:MI:SS'), 'Normal',  NULL, 'Spayed Female');
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
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A373687', 'Dog', to_date('2014-03-20 12:31:00','YYYY-MM-DD HH24:MI:SS'), 'Rosie', 'Spayed Female');
insert into ANIMAL_OUTS(ANIMAL_ID, ANIMAL_TYPE , DATETIME , NAME, SEX_UPON_OUTCOME) values( 'A368930', 'Dog', to_date('2014-06-13 15:52:00','YYYY-MM-DD HH24:MI:SS'), NULL, 'Spayed Female');
-- 테이블 상태 확인하기
select *
from ANIMAL_OUTS;


--아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.
    
-- 정답 코드
select NAME, DATETIME
from
(   
    SELECT A.NAME, to_char(A.DATETIME, 'yyyy-mm-dd hh24:mi:ss') AS DATETIME
    from ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B
    ON A.ANIMAL_ID = B.ANIMAL_ID
    where B.ANIMAL_ID is null
    order by 2
)
where rownum <= 3;

-- 테이블 삭제 
drop table ANIMAL_INS purge;
drop table ANIMAL_OUTS purge;
