문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/59042
없어진 기록 찾기




SELECT ANIMAL_ID, NAME
from ANIMAL_OUTS

MINUS

SELECT ANIMAL_ID, NAME
from ANIMAL_INS
