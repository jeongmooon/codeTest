# Lamda
- 익명함수(Anonymous Function)을 지칭함
- 두 개 이상의 입력이 있는 함수는 최종적으로 1개의 입력만 받는 람다 대수로 단순화 가능 (커링)

- 장점
    1. 코드의 간결성 : 불필요한 반복문 삭제 가능, 단순화 표현
    2. 지연연산 수행 : 지연연상을 수행함으로 불필요한 연산 최소화
    3. 병렬처리 가능 : 멀티쓰레드를 활용하여 병렬처리 가능

- 단점
    1. 호출이 까다로움
    2. 람다Stream 사용 시 단순 for문 while문일 경우 성능이떨어짐
    3. 불필요하게 너무 사용한다면 가독성이 떨어짐

## 익명함수
- 일급객체(First Class citizen)특징을 가지고 있음

## 람다의표현식
- 매개변수 화살표(->) 함수몸체로 이용하여 사용 가능
- 단일 실행문이라면 괄호 생략 가능
- 몸체가 return 문으로만 구성되어 있다면 괄호 생략 불가능

ex)
```
()->{}
()->1
()->{return 1;}
```

## 람다 예제
```
- 기존의 문법
new Tread(new Runnable(){
    public void run(){
        System.out.println("HI");
    }
}).start();

- 람다 문법
new Tread(()->{
    System.out.println("HI");
}).start();
```

# 함수형 인터페이스(@FunctionalInterface)
- Functional Interface는 일반적으로 구현해야 할 메소드가 하나만 정의된 인터페이스

- 자바 컴파일러는 이렇게 명시된 함수형 인터페이스에서 두개 이상의 메소드가 선언된다면 오류 발생

ex)
```
// 가능
@FunctionalInterface
public interface Math{
    public int Calc(int first, int second);
}

// 불가능
@FunctionalInterface
public interface Math{
    public int Calc(int first, int second);
    public int Calc2(int first, int second);
}
```

## 람다식 이중콜론(::)
- 메소드 참조 표현식으로 파라미터를 중복해서 쓰기 싫을 때 사용
- 사용법은 [인스턴스]::[메소드명] 으로 사용

- 예제
```
List<String> names = Arrays.asList("김갑순","김갑덜");

// x를 건내고 받는 과정에 x를 두번사용
names.forEach(x -> System.out.println(x));

// x들을 아얘 빼고 이와 같이 작성 가능
names.forEach(System.out::println);

```

- 다른 예
```
dct 객체가 name으로 "님"을 가지고 있다

names.stream().map(x -> dct.addNim(x)).forEach(System.out::println);

// 변경 후
names.stream().map(dct::addNim).forEach(System.out::println)'

```

## 함수형 인터페이스 람다 사용예제
- 함수형 Interface 선언
```
@FunctionalInterface
interface Math{
    public int Calc(int first, int second);
}

/////////////
- 구현 Class
package lamda;

import java.util.function.BinaryOperator;
import java.util.function.IntFunction;

public class LamdaApp {
	public static void main(String[] args) {
		LamdaTest plusLambda = (first, second) -> first + second;
		System.out.println(plusLambda.Calc(4, 2));
		
		LamdaTest minusLambda = (first, second) -> first - second;
		System.out.println(minusLambda.Calc(4, 2));
		
		// 인수를 받아 들이고 결과를 생성하는 함수
		IntFunction intSum = (x)-> x+1;
		System.out.println(intSum.apply(2));
		
		// 동일한 유형의 두 피연산자에 대한 연산을 나타내고 피연산자와 동일한 유형의 결과를 생성
		BinaryOperator stringSum=(x,y)->x+" "+y;
		System.out.println(stringSum.apply("HI", 2));
	}
}

```

# 스트림(Streams)
- 람다를 활용 할 수 있는 기술 중 하나
- 스트림은 '데이터의 흐름'으로 배열 또는 컬렉션 인스턴스에 함수를 여러개 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을수 있다

- 다른 장점으로는 병렬처리가 가능하다.

- 생성하기 : 스트림 인스턴스 생성
- 가공하기 : 필터링 및 맵핑등 원하느 결과를 만들어가는 중간과정
- 결과 만들기 : 최종적으로 결과를 만들어내는 과정

## 컬렉션 스트림
- Collection타입인 경우에는 인터페이스에 추가된 디폴트 메소드 stream을 이용하여 만들 수 있다.

```
public interface Collection<E> extends Iterable<E> {
    default Stream<E> stream(){
        return StreamSupport.stream(spliterator(), false);
    }
    //....
}

// 때문에
List<String> list = Arrays.asList("a","b","c");
Stream<String> stream = list.stream();
Stream<String> parallelStream = list.paralleStream(); // 병렬 처리 스트림
```

## Stream.builder()
- 빌더(Builder)를 사용한다면 스트림에 직접적으로 원하는값을 입력가능
```
Stream<String> builderStream =
    Stream<String> builder()
        .add("Eric").add("Elena").add("Java")
        .build(); //[위에 값들 들어 가있음]
```

## Stream.generate()
- generate메소드를 이용한다면 Supplier<T>에 해당하는 람다로 값을 넣을 수 있음. 이것은 인자가 없고 리턴값만 있는 함수형 인터페이스다.
- 스트림은 크기가 정해져 있지 않고 무한하기 때문에 최대크기를 제한해야 한다.

```
Stream<String> genneratedStream =
    Stream.generate(()->"gen").limit(5); // 5개의 "gen"이 들어감
```

## Stream.iterate()
- iterate 메소드는 초기값과 해당 값을 다루는 람다를 이용해 스트림에 들어갈 요소를 만든다.

```
Stream<Integer> iteratedStream =
    Stream.iterate(30,n->n+2).limit(5);
    // 초기값은 30이고 제한은 5개 2씩증가
```

## 기본 타입형 스트림
- 난수 생성하기
```
DoubleStream doubles = new Random().doubles(3); // 난수3개 생성
```

## 병렬 스트림(Parallel Stream)
- 스트림 생성시 사용하는 stream대신 parallelStream 메소드를 사용해서 병렬 스트림을 쉽게 생성이 가능. 내부적으로는 쓰레드를 처리하기 위해 Fork/Join framework를 사용

```
// 병렬 스트림 생성
Stream<Product> parallelStream = productList.parallelStream();

// 병렬 여부 확인
boolean isParallel = parallelStream.isParallel();

// 이코드는 각 작업을 쓰레드를 이용하여 병렬 처리된다.
boolean isMany = paralleStream
    .map(product -> product.getAmount() * 10)
    .anyMatch(amount -> amount >200);
```

## 스트림 연결하기
- Stream.concat 메소드를 이용해서 두개의 스트림을 연결하여 새로운 스트림생성이 가능

## 가공하기
- API를 이용해서 내가 원하는 것만 뽑아 낼수 있음
- 중간과정(intermediate operations)이라하는데, 스트림을 리턴하기에 여러 작업을 이어 붙여서(chaining) 작성 가능

```
List<String> names = Arrays.asList("Eric","Elena","Java");
를 대상으로 예제 코드
```

### Filtering
- filter는 스트림 내 요소를 평가하여 걸러내는 작업
```
Stream<String> stream =
    names.stream()
    .filter(name -> name.contains("a"));
// a포함 객체만 남김
```

### Mapping
- map은 스트림 내 요소들을 하나씩 특정 값으로 변환
- 스트림에 들어가 있는값이 input이 되어서 특정로직을 거치고 output 되어 새로운 스트림에 담김

```
Stream<String> stream =
    names.stream()
    .map(String::toUpperCase);
// 모든 요소 대문자

Stream<Integer> stream =
    productList.stream()
    .map(Product::getAmount);
// Product 개체의 수량만 꺼내오기
```

### flatMap
- 인자로 mapper를 받고 리턴은 Stream
- 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야함
- 이것은 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어 주는 역할(이것을 플래트님(flattening)이라고 함)

- 이와같은 중첩된 리스트가 존재
```
List<List<String>> list=
    Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));
// [[a],[b]]
```

- 이것을 flatMap을 사용해 중첩 구조를 제거 후 작업가능
```
List<String> flatList =
    list.stream()
    .flatMap(Collection::stream)
    .collect(Collectors.toList);
    // [a,b]
```

- 객체에 적용
```
students.stream()
    .flatMapToInt(student ->
                    IntStream.of(student.getKor(),
                                 student.getEng(),
                                 student.getMath()))
    .average().ifPresent(avg->System.out.println(Math.round(avg*10)/10.0));

    // 학생 객체를 가진 스트림에서 학생의 국영수 점수를 뽑아 새로운 스트림을 만들어 평균을 구하는 코드
```

### Soting
- 인자 없이 호출할 경우에는 오름차순

### Iterating
- 특정연산을 수행하는 메소드로 peek, 이것은 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer를 인자로 받음
- 이것은 스트림 내 요소들 각각에 특정 작업을 수행할 뿐, 결과에는 영향을 안줌

## 결과 만들기
- 가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계
- 최종작업(terminal operations)라고함

### Calculating
- 최소, 최대, 합, 평균등 기본형 타입으로 결과를 만들 수 있음
- long count = IntStream.of(1,3,5,7,9).count();

- 스트림이 비어있어서 표현 할 수 없는 경우에는 Optional을 이용하여 리턴함
- 이것을 바로 ifPresent메소드를 이용해 Optional을 처리 가능

```
DoubleStream.of(1.1,2.2,3.3,4.4,5.5)
    .average()
    .ifPresent(System.out::println);
```

### Reduction
- 스트림은 reduce라는 메소드를 이용해서 결과를 만들어낸다.
- reduce메소드는 세가지의 파라미터를 받을 수 있다.
    - accumulator : 각 요소를 처리하는 계산로직, 각요소가 계산할때마다 중간 결과를 생성하는 로직
    - identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴
    - combiner : 병렬(parallel)스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직

    ```
    // 1개(accumulator)
    Optional<T> reduce(BinaryOperator<T> accumulator);

    // 2개(identity)
    T reduce(T identity, BinaryOperator<T> accumulator);

    // 3개(combiner)
    <U> U reduce(U identity,
        BiFunction<U, ? super T, U> accumulator,
        BinaryOperator<U> combiner);
    ```

    - 인자가 하나 있는 경우 예시
    ```
    OptionalInt reduced =
        IntStream.range(1, 4) //[1,2,3]
        .reduce((a,b) -> {
            return Integer.sum(a,b);
        });
    ```    
    - 같은 타입의 인자 두개를 받아 같은타입의 결과를 반환하는 함수형 인터페이스(BinaryOperator<T>)

    - 두개의 인자를 받는 예시
    ```
    int reducedTwoParams =
        IntStream.range(1,4)
        .reduce(10, Integer::sum); //method reference
    ```
    - 초기 값은 10이고 스트림 내 값을 더해 결과는 16(10+1+2+3)

    - 세개의 인자를 받는 예시
    ```
    Integer reducedParams = Stream.of(1,2,3)
        .reduce(10, // identity
                    Integer::sum, //accumulator
                    (a,b)->{
                        System.out.println("combiner was called");
                        return a+b;
                });
    ```
    - Combiner가 실행되지 않는다. 이것은 다른 쓰레드에서 실행한 결과를 마지막에 합치는 단계로, 병렬 스트림에서만 작동함
    - accumulator는 총 세번 동작한다(초기값10에 각 스트림 값을 더해서 계산)
    - Combiner는 이것들을 가지고 여러쓰레드에 나눠서 계산한 결과를 합치는역할

    ```
    combiner was called
    combiner was called
    36
    ```
    - 으로 출력하게 된다.(12+13=25, 25+11=36) 두번 사용 되기 때문

    ### Collecting
    - collect 메소드는 또 다른 종료 작업
    - Collector 타입의 인자를 받아서 처리함

    ### Collectors.toList()
    - 작업 결과를 리스트에 담아서 반환
    - 예시는 map으로 요소의 이름을가져온 후 이 메소드를 써서 결과를 가져옴

    ```
    List<String> collectorCollection = 
        productList.stream()
            .map(Product::getName)
            .collect(Collectors.otList());
    // 상품이름들이 담겨져서 반환
    ```

    ### Collectors.joining()
    - 스트림에서 작업한 결과를 하나의 스트링으로 이어 붙이기
    ```
    String listToString =
        productList.stream()
        .map(Product::getName)
        .collect(Collectors.joining());
    // 이름들이 이어붙여져서 반환
    ```

    - 이것은 세개의 인자를 받을 수있음
        - delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
        - prefix : 결과 맨앞에 붙이는 문자
        - suffix : 결과 맨뒤에 붙는 문자
    ```
    String listToString =
        productList.stream()
        .map(Product::getName)
        .collect(Collectors.joining(", ","<",">"));
    // <이름, 이름, 이름....>
    ```

    ### Collectors.aaverageingInt()
    - 숫자 값(Integer value)의 평균을 구함
    ```
    Double avg =
        productList.stream()
        .collect(Collectors.averagingInt(Product::getAmount));
    // 리스트안에담긴 수량의 평균
    ```

    ### Collectoers.summingInt()
    - 숫자의 합
    ```
    Integer sum =
        productList.stream()
        .collect(Collectors.summingInt(Product::getAmount));
    // 리스트안에담긴 수량의 합
    ```

    - mapToInt 메소드를 이용해 더 간단히 표현
    ```
    Integer sum =
        productList.stream()
        .mapToInt(Product::getAmount)
        .sum();
    ```

    ### Collectors.summarizingInt()
    - 합계와 평균을 모두 얻기
    ```
    IntSummaryStatistics statistics = 
        productList.stream()
            .collect(Collectors.summarizingInt(Product::getAmount));
    // 이 statics에는 이런 정보가 있다
    // IntSummaryStatistics {count=5, sum=86, min=13, average=17.20000, max=23}
    // get으로 얻기 가능
    ```
    
    ### Collectors.groupingBy()
    - 특정조건으로 요소들을 그룹짓는 것
    ```
    Map<Integer,List<Product>> collectorMap =
        productList.stream()
        .collect(Collectors.groupingBy(product::getAmount));
    // 갯수대로 묶어서 리스트로 반환
    ```

    ### Collectors.partitioningBy()
    - groupingBy는 함수형 인터페이스 Function을 이용해 특정값을 기준으로 묶었다면, 이것은 함수형 인터페이스 Predicate를 받습니다.
    - 이것은 boolean값을 기준으로 리턴합니다
    ```
    Map<Boolean,List<Product>> mapPartitioned =
        productList.stream()
        .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));
    // false, true로 반환함
    ```

    ### Collectors.collectingAndThen()
    - 특정 타입 결과를 collect 한 이후에 추가 작업이 필요한경우 사용
    - finisher가 추가됬는데, 이것은 collect 이후 실행할 작업을 의미

    - toSet을 이용해 결과를 Set으로 collect한 후 수정 불가한 Set으로 변환하는 예시
    ```
    Set<Product> unmodifiableSet =
        productList.stream()
        .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                        Collections::unmodifiableSet));
    ```

    ### Collector.of()
    - 직접 collector을 만들기

    ### Matching
    - 매칭은 조건식 람다 Predicate를 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴
        - 하나라도 조건을 만족하는 요소가 있는지(anyMatch)
        - 모두 조건을 만족하는지(allMatch)
        - 모두 조건을 만족하지 않는지(noneMatch)

    ### Iterating
    - foreach 요소를 돌면서 실행되는 최종 작업
    - peek와는 차이가 있음
    
    ```
    names.stream().forEach(System.out::println);
    ```

# Collection

## List
- 순서가 있는 Collection
- 데이터를 넣는 순서가 보장되고 index로 특정아이템 가져오기가능
- 중복이 허용

## Set
- 순서가 없는 Collection
- 데이터를 넣는 순서가 보장안되고 index로 특정아이템 가져오기 불가능
- 중복이 허용하지 않음
- 탐색이 잦거나 중복을 허용하지 않는다면 Set을 고려해볼만함

## Map
- Key, Value 형태

# 제네릭(Generics)
- 클래스, 메소드에서 데이터타입을 인스턴스 생성이나 메서드 호출시에 정하는 의미
- 제네릭은 데이터의 타입과 관련이 있다.

- Object를 사용할 때와 다르게 객체의 타입을 컴파일 타임에 체크가능해서 안정성이 높고 형변환을 안해도됨

## 제네릭 클래스
- 제네릭 타입을 클래스에 선언한 제네릭 클래스
- Box<Paper,String>
- static 변수에는 제네릭 사용할 수 없다.
- 이유는 인스턴스가 되기전에 메모리에 올라가는데 이 때 타입이 결정되지 않기 때문이다.

## 제네릭 메소드
- 제네릭 모소드는 static이 가능하다
- 호출 시에 매게 타입을 지정하기 때문이다.
- 제네릭 클래스에 붙은 <T>와 제네릭 메소드에 붙은 <T>는 같은 T를 사용하더라도 전혀 별개의 것이다.
- 제네릭 메소드를 사용하면 T는 지역변수로 되기 때문이다.

- ex)
```
public class Util {
    
    public static<T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.setT(t);
        return box;
    } 
 }
 ```

 # Optional
 - 개발을 할 때 가장 많이 발생하는 변수(NullPointerException)을 감싸는 클래스로, NPE가 발생하지 않도록 도와준다.

 ## Optional 생성하기
 - Optional<String> optional = Optional.empty();
 - 로 값이 Null인 객체를 생성이 가능하다.

 - Optional은 static변수로 empty객체를 생성해서 가지고 있고 이 때문에 빈 객체를 여러번 생성해줘야하는 경우에도 empty객체 1개를 공유하여 메모리를 절약한다.

 - Optional<String> optional = Optional.of("name");
 - 절대 null이 아니라면 이것으로 생성이 가능하다.
 - 만약 이것으로 Null을 저장하려 한다면 NullPointerException이 발생한다.

 - Optional<String> optional = Optional.ofNullalbe(getName());
 - 어떤 데이터가 null이 올 수 있고 아닐 수 있는경우 사용

 ## Optional 예시 코드
 - null 검사후 객체 생성 과정

 - 기존
 ```
 List<String> name = getNames();
 List<String> tempName = list !=null ? list : new ArrayList<>();
 ```

 - Optional<T>, Lamda를 사용
 ```
 List<String> nameList = Optional.ofNullalbe(getNames())
    .orElseGet(() -> new ArrayList<>());
 ```

 ## 실사용 예시
 - null 검사하여 우편번호 꺼내기
 ```
 public String findPostCode() {
    UserVO userVO = getUser();
    if (userVO != null) {
        Address address = user.getAddress();
        if (address != null) {
            String postCode = address.getPostCode();
            if (postCode != null) {
                return postCode;
            }
        }
    }
    return "우편번호 없음";
}
 ```

 - Optional 사용하여 변경
 ```
 public String findPostCode(){
    // Optional로 펼치기
    Optional<UserVO> user = Optional.ofNullable(getUser());
    Optional<Address> address = user.map(UserVO::getAddress);
    Optional<String> postCode = address.map(Address::getPostCode);
    String result = postCode.orElse("우편번호 없음");

    // Optional 축약 사용
    String result = user.map(UserVO::getAddress)
        .map(Address::getPostCode)
        .orElse("우편번호 없음");
 }
 ```