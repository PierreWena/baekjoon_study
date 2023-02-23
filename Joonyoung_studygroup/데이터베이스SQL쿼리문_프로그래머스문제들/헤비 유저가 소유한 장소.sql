헤비 유저가 소유한 장소
문제출처 : https://school.programmers.co.kr/learn/courses/30/lessons/77487


 SELECT ID
         , NAME
         , HOST_ID
 from PLACES
      where HOST_ID IN (SELECT HOST_ID 
                                FROM PLACES 
                                GROUP BY HOST_ID    HAVING count(HOST_ID)>1 )
  order by 1;
