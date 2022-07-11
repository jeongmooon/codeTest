let person = [{name:'홍길동',age:30},{name:'이순신',age:10},{name:'을지문덕',age:20},{name:'강감찬',age:50}]
let predi = (user)=>{return user.age>20};

let each =(data, iter)=>{
    for(let i=0; i<data.length; i++){
        iter(data[i]);
    }
}

let filter = (data,predi)=>{
    let retlist = [];

    for(let i=0; i<data.length; i++){
        if(predi(data[i])) retlist.push(data[i]);
    }

    return retlist;
}

let _filter = (data,predi)=>{
    let retlist = [];

    each(data,(val)=>{
        if(predi(val)) retlist.push(val);
    });

    return retlist;
}

console.log(filter(person,predi));
console.log(_filter(person,predi));