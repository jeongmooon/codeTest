/*
    _reduce([1,2,3], add, 0); 이라면 6의 값을 기대
    memo = add(0,1);
    memo = add(memo,2);
    memo = add(memo,3);
    return memo;

    add(add(add(0,1),2),3);
    으로 나오게 됨
*/

const add = function(a,b){return a+b};

let _each =(data, iter)=>{
    for(let i=0; i<data.length; i++){
        iter(data[i]);
    }
}

let curry = (fn)=>{
    return (a,b)=>{
        return (arguments.length === 2) ? fn(a,b) :(b)=>{return fn(a,b)}
    }
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



console.log(
    _reduce([1,2,3],add,0)
);

console.log(
    _reduce([1,2,3],add)
);

console.log(
    _reduce([1,2,3],add,4)
);