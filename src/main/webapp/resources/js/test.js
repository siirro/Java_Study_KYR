alert("welcome");


// 1
// int num; java
var num=1;
// num = 'abc';

let num2='1';

console.log(num == num2) //sysout과 동일한 기능
console.log(num === num2)
var count=1;
for(var i=0;i<10;i++){
    console.log(i)
    var count=2;
}

console.log('------------')
console.log(i)
console.log(count)
console.log('------------')

let ar = ['4', 1, 3, '2'];
console.log(ar[0]);
console.log(ar[1]);
console.log('------------')

ar.push(5)
console.log(ar);
ar.unshift('9')
console.log(ar);
ar.sort();
console.log(ar)
ar.reverse();
console.log(ar)

ar.forEach(function(v, i, ar){
    console.log("v : ", v);
    console.log("i : ", i);
    console.log('---------------');

});
