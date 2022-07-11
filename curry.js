let person = [{name:'홍길동',age:30},{name:'이순신',age:10},{name:'을지문덕',age:20},{name:'강감찬',age:50}]

// 클로저 모양
let f = (fn)=>{
    return (a)=>{
        return (b)=>{
            return fn(a,b);
        }
    }
}

let curry = (fn)=>{
    return (a,b)=>{
        return (arguments.length === 2) ? fn(a,b) :(b)=>{return fn(a,b)}
    }
}

// cuuryr은 역방향 맵핑
let curryr = (fn)=>{
    return (a,b)=>{
        return (arguments.length === 2) ? fn(a,b) :(b)=>{return fn(b,a)}
    }
}

let each =(data, iter)=>{
    for(let i=0; i<data.length; i++){
        iter(data[i]);
    }
}

let filter = (data,predi)=>{
    let retlist = [];

    each(data,(val)=>{
        if(predi(val)) retlist.push(val);
    });

    return retlist;
}

const p1 = f((a,b)=>{return a*b});
console.log(p1);

const p2 = p1(10);
console.log(p2)

console.log(p2(1000))

