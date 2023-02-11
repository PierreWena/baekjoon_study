show user;

-- 테이블을 만들어보자 
create table ANIMAL_INS
(
    ANIMAL_ID           VARCHAR(4000)     not null
    ,ANIMAL_TYPE        VARCHAR(4000)     not null     
    ,DATETIME           DATE              not null
    ,INTAKE_CONDITION   VARCHAR(4000)     not null
    ,NAME               VARCHAR(4000)     null
    ,SEX_UPON_INTAKE    VARCHAR(4000)     not null
);

-- 테이블에 값 대입 
insert into ANIMAL_INS(ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A350276', 'Cat', TO_DATE('2017-08-13 13:50:00','yyyy-mm-dd HH24:MI:SS'), 'Normal', 'Jewel', 'Spayed Female');
insert into ANIMAL_INS(ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A350375', 'Cat', TO_DATE('2017-03-06 15:01:00','yyyy-mm-dd HH24:MI:SS'), 'Normal', 'Meo', 'Neutered Male');
insert into ANIMAL_INS(ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE) values( 'A368930', 'Dog', TO_DATE('2014-06-08 13:20:00','yyyy-mm-dd HH24:MI:SS'), 'Normal', NULL, 'Spayed Female');

-- 테이블 상태 확인하기
select ANIMAL_ID
      ,ANIMAL_TYPE
      ,to_char(DATETIME, 'yyyy-mm-dd HH24:MI:SS') AS DATETIME
      ,INTAKE_CONDITION
      ,NAME
      ,SEX_UPON_INTAKE
from ANIMAL_INS;


--마지막 줄의 개는 이름이 없기 때문에, 이 개의 이름은 "No name"으로 표시합니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.(이름 오름차순)
select ANIMAL_TYPE
      ,nvl(NAME,'No name') AS NAME
      ,SEX_UPON_INTAKE
from ANIMAL_INS
order by ANIMAL_ID;

drop table ANIMAL_INS purge;
