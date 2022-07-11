let person = [{name:'홍길동',age:30},{name:'이순신',age:10},{name:'을지문덕',age:20},{name:'강감찬',age:50}]

let each =(data, iter)=>{
    for(let i=0; i<data.length; i++){
        iter(data[i]);
    }
}

let map = function(data, mapper){
    let retlist = [];

    for(let i=0; i<data.length; i++){
        retlist.push(mapper(data[i]))
    }

    return retlist;
}

let _map = function(data, mapper){
    let retlist = [];

    each(data,(val)=>{
        retlist.push(mapper(val))
    });

    return retlist;
}

console.log(map(person,(user)=>{return `user name length : ${user.name} (${user.name.length})`}));
console.log(_map(person,(user)=>{return `user name length : ${user.name} (${user.name.length})`}));