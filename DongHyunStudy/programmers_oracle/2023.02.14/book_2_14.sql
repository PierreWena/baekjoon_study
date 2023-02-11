show user;

-- 테이블을 만들어보자 
create table BOOK
(
    BOOK_ID          INTEGER
    ,CATEGORY        VARCHAR(4000)
    ,AUTHOR_ID       INTEGER
    ,PRICE           INTEGER
    ,PUBLISHED_DATE  DATE
);

-- 테이블에 값 대입 
insert into BOOK(BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE) values( '1', '인문', '1', '10000', '2020-01-01');
insert into BOOK(BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE) values( '2', '경제', '2', '9000', '2021-02-05');
insert into BOOK(BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE) values( '3', '인문', '2', '11000', '2021-04-11');
insert into BOOK(BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE) values( '4', '인문', '3', '10000', '2021-03-15');
insert into BOOK(BOOK_ID, CATEGORY, AUTHOR_ID, PRICE, PUBLISHED_DATE) values( '5', '생활', '1', '12000', '2021-01-10');

-- 테이블 상태 확인하기
select *
from BOOK;

-- 조건에 속하는 도서는 도서 ID 가 3, 4인 도서이므로 다음과 같습니다.
select BOOK_ID, PUBLISHED_DATE
from BOOK
where CATEGORY = '인문' and to_char(PUBLISHED_DATE, 'yyyy') = '2021';


--그리고 출판일 오름차순으로 정렬하여야 하므로 다음과 같은 결과가 나와야 합니다.
select BOOK_ID, to_char(PUBLISHED_DATE, 'yyyy-mm-dd') AS PUBLISHED_DATE
from BOOK
where CATEGORY = '인문' and to_char(PUBLISHED_DATE, 'yyyy') = '2021'
order by 2 asc;

drop table BOOK purge;
