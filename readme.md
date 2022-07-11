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
generic (classg, method g) : static인 이유
collection (list,set,map)
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