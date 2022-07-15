# JavaScript
ajax : 배열, 객채 = 해체할당
default, rest, spred
shorthand property
concise method
symbol, iterable/iterator
map,set,list
promise, async/await
packaging

## 함수형 프로그램 **
- 일급 : 값으로 취급한다.
    int a= 10

- const a = (()=>{return a+b});
- callback function

============

## 순수함수
- 입력값에 의해서만 출력이 결정되는 함수
- 함수형 프로그램에선 이것을 기본으로 사용

============
1. 객체 : {k:v, k:v}
2. 배열 : []
3. 함수 
    - 함수 선언 : function add(a,b){console.log(a+b)}
    - 함수 표현식 : const add = (a,b)=>{a+b}
  
4. var => 함수 스코프
let, const => 블럭 스코프

stack에 있는 값은 변경가능
========
- compiler가 전처리 단계함(persion.method명.p1객체명)
static block

filter : filter(data,predi)


map, flatmap : map(data, mapper) => mapper는 function인터페이스
each : forEach()
curry,curryr : stream과 같다 closeur
    * f
        r f
    => 이런 형태가 클로저 함수
    = 렉시칼 스코프(자유 변수) //필수
    = private 변수로 사용가능(식 = 값)
    문 : if,for등등..

즉시실행 함수
- (function(a,b){return a*b})(10,100)
reduce
pripe
go

# Java => 필수
generic (class g, method g) : static인 이유
collection (list,set,map) => 배열
lamda
functional interface
stream
optional

# DataBase
server architecture
함수
분석 함수
cartition product => grouping
rollup, cube
통계
connectBy, prior 계층형쿼리
권한관리(인증,인가)

- 분실 갱신
- IP 컴퓨터위치, Port 프로세스 위치
- SID
- 리스너(Dedicated Server) 디폴트, (Shared Sever)

## 공통 사항
1. FROM dual 
    - 가상테이블(실제로 잇긴함) 테이블이 필요없는 연산 할 때 사용

2. INLINE VIEW
    - 테이블 만들기

3. SQL 저장하는 수단
    - VIEW
    ```
    CREATE VIEW V_TOT AS
    (SQL);
    ```

4. CONNECT BY LEVEL 
    - Row 만들기

5. Rownum
    - 순서 매기기

6. Binding 변수
    - :변수명
    - 변수 입력하면 됨(Java에서 스캐너)
    
    ```
    SELECT ROWNUM
    FROM DUAL
    CONNECT BY LEVEL <= :V_CNT;
    ```

7. SELECT 중첩
    - SELECT : Scalar Subquery
    - FROM : Inline View
    - WHERE : Subquery

    - 조건(SubQuery)가 속도 적으로는 제일 중요하다(데이터 건수를 줄일 숭 있음)
    - 하지만 Inline View를 가장 많이씀

    - ** Scalar, Vector 

8. DB IF문
    - DECODE
        - 부등호 비교가 안된다.

    - CASE
        - 부등호 비교가 가능하다

    ```
    SELECT ROWNUM, DECODE(MOD(ROWNUM,2),0,'EVEN','ODD'),
            CASE WHEN MOD(ROWNUM,2) = 0 THEN 'EVEN'
            ELSE 'ODD' END
    FROM DUAL
    CONNECT BY LEVEL <=5;
    ```

## SQL 함수
- ABS 절대값
- FLOOR : 정수 하한가
- CEIL : 정수 상한가
- ROUND : 소수점도 가능(반올림)
- TRUNC : 자르기
- SQLT

- ADD_MONTHS : (SYSDATE, 3) => 3개월뒤
- EXTRACT : 시간 뽑기(영국표준시로 나옴)
- LAST_DAY : 기준달의 마지막 날짜
- MONTHS_BETWEEN : 날짜 끼리의 차이
- NEXT_DAY : 원하는 요일의 날짜 찾기
- TRUNC(SYSDATE) : 년월 일만 나옴