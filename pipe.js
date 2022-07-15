/*
    Pipe///
    const f1 = _pipe(
        function(a){return a+1};
        function(a){return a*2};
    )
    pipe는 reduce로 만든것
    함수들을 인자값으로 받음
    함수를 리턴하는 함수
*/

const add = function(a,b){return a+b};

let curry = (fn)=>{
    return (a,b)=>{
        return (arguments.length === 2) ? fn(a,b) :(b)=>{return fn(a,b)}
    }
}

let _curryr = (fn)=>{
    return (a,b)=>{
        return (arguments.length === 2) ? fn(a,b) :(b)=>{return fn(b,a)}
    }
}

let _get = _curryr((obj, key)=>{
    return obj === null ? undefined : obj[key];
});

let _length = _get('length');

let _each =(data, iter)=>{
    for(let i=0,len = _length(data); i<len; i++){
        iter(data[i]);
    }
}

// map
let _map = function(data, mapper){
    let retlist = [];

    _each(data,(val)=>{
        retlist.push(mapper(val))
    });

    return retlist;
}

// filter
let _filter = (data,predi)=>{
    let retlist = [];

    _each(data,(val)=>{
        if(predi(val)) retlist.push(val);
    });

    return retlist;
}

const slice = Array.prototype.slice;

function _rest(list,num){
    return slice.call(list,num||1);
}

function _reduce(list, iter, memo){
    if(arguments.length === 2){
        memo = list[0];
        list = _rest(list);
    }
    _each(list, function(val){
        memo = iter(memo,val);
    });

    return memo;
}

function _pipe(){
    const fns = arguments;
    return function(arg){
        return _reduce(fns, function(arg,fn){
            return fn(arg);
        }, arg);
    }
}

const f1 = _pipe(
    function(a){return a+1;},
    function(a){return a*2;},
    function(a){return a*a;}
)

console.log(f1(1))

/*
    Go/////
    pipe함수인데 즉시실행하는 pipe
*/

function _go(arg){
    const fns = _rest(arguments);
    _pipe.apply(null,fns)(arg);
}

_go(1,
    function(a){return a+1;},
    function(a){return a*2;},
    function(a){return a*a;},
    console.log
);

_each(null,console.log)
console.log(_map(null, v => {return v;})); // 빈배열
console.log(_filter(null, v => {return v;})); // 빈배열

// 함수형 프로그래밍은 에러가나도 물흐르듯이 나오게한다
_go([1,2,3,4],
    //_filter(function(v){return v%2; }),
    _map(function(v){return v*v; }),
    console.log);
