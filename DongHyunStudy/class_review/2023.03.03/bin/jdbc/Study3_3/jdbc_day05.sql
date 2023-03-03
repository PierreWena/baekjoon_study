show user;
-- USER이(가) "JDBC_USER"입니다.

select *
from tbl_member
order by userseq desc;
/*
5	leess	1234	이순신	010-1234-5678	0	23/02/23	0
4	sonjh	qWer1234$	손정화	010-3245-4562	0	23/02/23	1
3	parkjh	qWer1234$	박정화	010-9245-7562	0	23/02/23	1
2	kimjh	qWer1234$	김정화	010-8245-8562	0	23/02/23	1
1	eomjh	qWer1234$	엄정화	010-5245-2562	0	23/02/23	1
*/

update tbl_member set status = 1;
-- 5개 행 이(가) 업데이트되었습니다.

update tbl_member set status = 0
where userid = 'sonjh';
-- 1 행 이(가) 업데이트되었습니다.    sonjh 는 탈퇴처리라고 처리하기 위해 update 한다.

commit;
-- 커밋 완료.

-- 형태확인 
desc tbl_member;
/*
    이름          널?       유형            
    ----------- -------- ------------- 
    USERSEQ     NOT NULL NUMBER        
    USERID      NOT NULL VARCHAR2(30)  
    PASSWD      NOT NULL VARCHAR2(30)  
    NAME        NOT NULL NVARCHAR2(20) 
    MOBILE               VARCHAR2(20)  
    POINT                NUMBER(10)    
    REGISTERDAY          DATE          
    STATUS               NUMBER(1)     

*/


----- **** 게시판 테이블 생성하기 **** -----
create table tbl_board
(boardno       number         not null     --- 글번호
,fk_userid     varchar2(30)   not null     --- 작성자 아이디
,subject       Nvarchar2(100) not null     --- 글제목
,contents     Nvarchar2(200) not null     --- 글 내용  -- contents로 변경해야함 
,writeday      date default sysdate not null  --- 작성일자 
,viewcount     number default 0 not null         --- 조회수 
,boardpasswd   varchar2(20)     not null         --- 글암호 
,constraint PK_tbl_board_boardno primary key (boardno)
,constraint FK_tbl_board_fk_userid foreign key (fk_userid) references tbl_member (userid)
);
-- Table TBL_BOARD이(가) 생성되었습니다.


-- 시퀀스 생성 
create sequence seq_board
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence SEQ_BOARD이(가) 생성되었습니다.

-- 현재 테이블 형태 확인 
desc tbl_board;

-- 현재 상황 (글쓰기 내용)
select *
from tbl_board
order by boardno desc;



---- **** 댓글 테이블 생성하기 **** ----
create table tbl_comment
(commentno        number               not null   -- 댓글번호
,fk_boardno       number               not null   -- 원글의 글번호
,fk_userid        varchar2(30)         not null   -- 작성자 아이디 
,contents         Nvarchar2(100)       not null   -- 댓글 내용
,writeday         date default sysdate not null   -- 작성일자 
,constraint       Pk_tbl_comment_commentno primary key (commentno) 
,constraint       Fk_tbl_comment_fk_boardno foreign key(fk_boardno) references tbl_board(boardno) on delete cascade
,constraint       Fk_tbl_comment_fk_userid  foreign key(fk_userid) references tbl_member(userid)
);
-- Table TBL_COMMENT이(가) 생성되었습니다.


-- 시퀀스 생성 
create sequence seq_comment
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence SEQ_COMMENT이(가) 생성되었습니다.

-- 현재 댓글 상황 
select *
from tbl_comment;


--------------------------------------------------------------------------------------
/*
    Transaction(트렌잭션) 처리 실습을 위해서 
    tbl_member 테이블의 Point 컬럼의 값은 최대 30을 넘지 못하도록 check 재약울 걸도록 하겠습니다
*/
--------------------------------------------------------------------------------------

-- 체크제약을 걸어주자 
alter table tbl_member
add constraint ck_tbl_member_point check( point between 0 and 30);
-- Table TBL_MEMBER이(가) 변경되었습니다.


-- 체크제약이 잘되는지 확인해 보기 
update tbl_member set point = 40
where userid = 'leess';
-- 오류 보고 - ORA-02290: 체크 제약조건(JDBC_USER.CK_TBL_MEMBER_POINT)이 위배되었습니다

-- DB에서 입력한것을 나중에는 자바에서 입력해보자
insert into tbl_comment(commentno, fk_boardno , fk_userid , contents)
values(seq_comment.nextval, 2, 'eomjh' , '즐거운 하루라는 글이 너무 좋아요 ' );
--1 행 이(가) 삽입되었습니다.

insert into tbl_comment(commentno, fk_boardno , fk_userid , contents)
values(seq_comment.nextval, 2, 'eomjh' , '글 잘보고 갑니다' );
--1 행 이(가) 삽입되었습니다.

insert into tbl_comment(commentno, fk_boardno , fk_userid , contents)
values(seq_comment.nextval, 1, 'eomjh' , '와우 포스팅 보는 당신은 멋진 사람입니다.' );
--1 행 이(가) 삽입되었습니다.

commit;

-- 현재 댓글 상황 
select *
from tbl_comment;

select *
from tbl_board
order by boardno desc;


                    --  [퀴즈]
            -->>>>> 이렇게 만들어 보자 <<<<< -- 
--  글번호    글제목   작성자명    작성일자     조회수 
/*
5	저는 가수 엄정화입니다 반갑습니다!!![0] 	         엄정화	23/02/27	0	
3	세번째 글쓰기 입니당~[0]                         이순신	23/02/27	0	
2	두번째 글쓰기 입니닷[2]                          이순신  23/02/27	0	
1	첫번째 글입니다 ㅎㅎㅎ[0]	                     이순신  23/02/27	    0	
*/

select A.boardno AS 글번호
     , A.subject || '[' || nvl(CNT.COMMENTCNT, 0) || ']' AS 글제목
     , A.NAME AS 작성자명
     , A. writeday AS 작성일자
     , A. viewcount AS 조회수 
from 
(
    select B.boardno, B.subject, M.name, to_char(B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday, B.viewcount
    from tbl_member M join tbl_board B
    ON M.userid = B.fk_userid
) A
LEFT JOIN
(
    select fk_boardno, count(*) AS COMMENTCNT 
    from tbl_comment 
    group by fk_boardno
) CNT
ON A.boardno = CNT.fk_boardno
ORDER BY boardno desc;





----------------------------------------------------------------------------
select A.boardno 
     , A.subject
     , A.NAME
     , A. writeday 
     , A. viewcount 
     , nvl(CNT.COMMENTCNT, 0) AS COMMENTCNT
from 
(
    select B.boardno, B.subject, M.name, to_char(B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday, B.viewcount
    from tbl_member M join tbl_board B
    ON M.userid = B.fk_userid
) A
LEFT JOIN
(
    select fk_boardno, count(*) AS COMMENTCNT 
    from tbl_comment 
    group by fk_boardno
) CNT
ON A.boardno = CNT.fk_boardno
ORDER BY boardno desc;

----------------------------------------------------------------------
-- 글 내용보기 실험부분

select subject, contents, fk_userid, boardpasswd
from tbl_board
where boardno = 3;

-- 안됨
select subject, contents, fk_userid, boardpasswd
from tbl_board
where boardno = '홍길동';


-- String 타입으로 변경해서 출력시 성공 
select subject, contents, fk_userid, boardpasswd
from tbl_board
where boardno = to_number('3');

-- 오류 발생 number 타입이 아님 
select subject, contents, fk_userid, boardpasswd
from tbl_board
where boardno = to_number('홍길동');
-- ORA-01722: 수치가 부적합합니다, 01722. 00000 -  "invalid number"


-- 댓글 상황 보기 
select *
from tbl_comment
where fk_boardNo = 2;   -- 2 번글에 대해 댓글을 보자 


-- 댓글내용 작성자명  작성일자를 출력해보자 

-- 과정 1
select fk_userid, contents, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY
from tbl_comment 
where fk_boardNo = 2;   -- 2 번글에 대해 댓글을 보자

-- 과정 2
select userid, name 
from tbl_member;

-- 2번 글에 대한 결과 (결과 두개)

select A.contents, B.name, WRITEDAY
from
(
    select fk_userid, contents, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY
    from tbl_comment 
    where fk_boardNo = 2   -- 2 번글에 대해 댓글을 보자
) A
JOIN
(
    select userid, name 
    from tbl_member
) B 
ON A.fk_userid = B.userid;


-- 1번 글에 대한 결과 (결과 하나)

select A.contents, B.name, WRITEDAY
from
(
    select fk_userid, contents, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY
    from tbl_comment 
    where fk_boardNo = 1   -- 1 번글에 대해 댓글을 보자
) A
JOIN
(
    select userid, name 
    from tbl_member
) B 
ON A.fk_userid = B.userid;


-- 3번 글에 대한 결과 (결과 없음)

select A.contents, B.name, WRITEDAY
from
(
    select fk_userid, contents, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY
    from tbl_comment 
    where fk_boardNo = 3   -- 3 번글에 대해 댓글을 보자
) A
JOIN
(
    select userid, name 
    from tbl_member
) B 
ON A.fk_userid = B.userid;



--------------------------------------------------------------------------------------
/*
    Transaction(트렌잭션) 처리 실습을 위해서 
    tbl_member 테이블의 Point 컬럼의 값은 최대 30을 넘지 못하도록 check 재약울 걸도록 하겠습니다
    이제는 Transaction(트렌잭션)이 무엇인지 알았으니 위에서 준 check 제약을 해제 하겠습니다. 
*/
--------------------------------------------------------------------------------------

alter table tbl_member 
drop constraint ck_tbl_member_point;
-- Table TBL_MEMBER이(가) 변경되었습니다.



--> 이제는 check 제약이 풀렸으므로 포인트는 계속 올라갈 수 있다.

-- 사용자가 다른 사용자가 쓴 원글에 댓글쓰기를 하면 포인트 점수를 5점씩 증가하도록 하겠습니다.


--                  --- ***  최근 1주일간 일자별 게시글 작성건수 *** ---


insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '첫번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234');

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '두번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234');
 
insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '세번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '네번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '다섯번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '여섯번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '일곱번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

insert into tbl_board(boardno, fk_userid, subject, contents, boardpasswd)
values(seq_board.nextval, 'eomjh', '여덟번째 엄정화가 글을 씁니다.', '안녕하세요~~ 엄정화 입니다.', '1234'); 

commit;
-- 커밋 완료.

-- 확인하기 
select*
from tbl_board
order by boardno asc;


-- 업데이트
update tbl_board set writeday = writeday - 7
where boardno in(1,3);
-- 2개 행 이(가) 업데이트되었습니다.


-- 확인하기 
select*
from tbl_board
order by boardno asc;


-- 업데이트
update tbl_board set writeday = writeday - 1
where boardno in(8,9,10);
-- 3개 행 이(가) 업데이트되었습니다.

-- 확인하기 
select*
from tbl_board
order by boardno asc;

commit;
-- 커밋 완료 

-- 일주일 전 쓴 글까지만 확인하기 
select *
from tbl_board
where to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd') < 7
order by boardno asc;
-- 3월 2일(현재날자) 에서 쓴 날자를 뺌


-- 각종 일자 차이 
select writeday   
                                                                                                                            --6일차이 6일차이 일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),6, 1, 0) AS PREVIOUS6
                                                                                                                            --5일차이 5일차이 일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),5, 1, 0) AS PREVIOUS5
                                                                                                                            --4일차이 4일차이 일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),4, 1, 0) AS PREVIOUS4
                                                                                                                            --3일차이 3일차이 일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),3, 1, 0) AS PREVIOUS
                                                                                                                            --2일차이 2일차이 일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),2, 1, 0) AS PREVIOUS2
                                                                                                                            --어제 어제일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),1, 1, 0) AS PREVIOUS1
                                                                                                                            --오늘 오늘일때 1,  아닐때 0
      , decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),0, 1, 0) AS TODAY
from tbl_board
where to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd') < 7
order by boardno asc;




-- 최근 1주일간 게시물 건수 나타내기 
select count(writeday)   as TOTAL     -- 최근 1주일간 게시물 건수 
                                                                                                                            --6일차이 6일차이 일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),6, 1, 0)) AS PREVIOUS6
                                                                                                                            --5일차이 5일차이 일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),5, 1, 0)) AS PREVIOUS5
                                                                                                                            --4일차이 4일차이 일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),4, 1, 0)) AS PREVIOUS4
                                                                                                                            --3일차이 3일차이 일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),3, 1, 0)) AS PREVIOUS
                                                                                                                            --2일차이 2일차이 일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),2, 1, 0)) AS PREVIOUS2
                                                                                                                            --어제 어제일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),1, 1, 0)) AS PREVIOUS1
                                                                                                                            --오늘 오늘일때 1,  아닐때 0
      , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),0, 1, 0)) AS TODAY
from tbl_board
where to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd') < 7;



-- 이번달만 보기 (3월)
select *
from tbl_board
where to_char(writeday, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm');

/*
    결과 목표 
    ------------------------
    writeday      cnt      
    ------------------------
    2023-03-01    3
    2023-03-02    5
    전체           8
*/

-- 3월달에서 날자별로 확인 과정 
select to_char(writeday, 'yyyy-mm-dd')
     , grouping ( to_char(writeday, 'yyyy-mm-dd'))
     , count(*) AS CNT
from tbl_board
where to_char(writeday, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm')
group by rollup (to_char(writeday, 'yyyy-mm-dd'));


-- 3월달에서 날자별로 확인 완성본 
select decode( grouping ( to_char(writeday, 'yyyy-mm-dd') ), 0, to_char(writeday, 'yyyy-mm-dd'), '전체' ) AS writeday
     , count(*) AS CNT
from tbl_board
where to_char(writeday, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm')
group by rollup (to_char(writeday, 'yyyy-mm-dd'));