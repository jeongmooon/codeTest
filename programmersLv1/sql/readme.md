## 상위 n개 레코드

1. 동물 보호소에 가장 먼저 들어온 동물의 이름 조회
- SELECT name FROM ANIMAL_INS  ORDER BY DATETIME asc LIMIT 1

2. 가장 최근에 들어온 동물 조회
- SELECT datetime as 시간 FROM animal_ins ORDER BY datetime DESC LIMIT 1

3. 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회
- SELECT datetime as 시간 FROM animal_ins ORDER BY datetime asc LIMIT 1

4. 동물 보호소에 동물이 몇 마리 들어왔는지 조회
- select count(animal_id) as count from animal_ins

5. 동물 보호소에 들어온 동물의 이름은 몇개인지 조회(NULL인 경우 집계안함 & 중복되는 이름은 하나)
- SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IN (SELECT NAME
              FROM ANIMAL_INS
               WHERE NAME IS NOT NULL
              )

6. 동물 보호소에 들어온 동물 중 고양이와 개가 몇마리 인지 조회
- SELECT ANIMAL_TYPE, count(*)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;

7. 동물 보호소에 들어온 동물 이름 중 두번 이상 쓴 이름과 해당이름이 쓰인 횟수를 조회(이름없는 동물 제외 & 이름순으로 조회)
- SELECT NAME, COUNT(*) as COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT >= 2
ORDER BY NAME;

8. 보호소에서 몇 시에 입양이 가장 활발한지 조회(09:00~19:59까지 & 시간대 정렬)
- SELECT  HOUR, COUNT(HOUR)
FROM(
SELECT TO_CHAR(DATETIME, 'HH24') HOUR
FROM ANIMAL_OUTS)
WHERE HOUR BETWEEN 9 AND 19 
GROUP BY HOUR
ORDER BY HOUR

9. 보호소에서 몇시에 입양이 활발한지 조회(0시부터 23시 & 시간대 별로 모든 정보)
- SELECT b.lv HOUR,NVL(cnt, 0) AS COUNT
FROM
(
SELECT  HOUR, COUNT(HOUR) cnt
FROM(
SELECT TO_CHAR(DATETIME, 'HH24') HOUR
FROM ANIMAL_OUTS)
GROUP BY HOUR
) a,
(SELECT LEVEL-1 AS lv FROM dual CONNECT BY LEVEL<=24) b
WHERE a.HOUR(+) = b.lv
ORDER BY b.lv