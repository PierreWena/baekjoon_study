--헤비 유저가 소유한 장소
--https://school.programmers.co.kr/learn/courses/30/lessons/77487


--이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다. 
--헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회하는 SQL문을 작성해주세요.
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN(SELECT HOST_ID
                FROM PLACES
                GROUP BY HOST_ID
                having count(*) > 1
                )
--GROUP BY HOST_ID
ORDER BY 1;
