let each =(data, iter)=>{
    for(let i=0; i<data.length; i++){
        iter(data[i]);
    }
}

each([1,2,3,4,5,6],(num)=>{console.log(num)})