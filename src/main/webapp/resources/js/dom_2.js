
//1. 선택자
const d1 = document.getElementById('d1');
// alert(d1.getAttribute('value'));
// alert(d1.value);

const d2 = document.getElementById('d2')

d2.setAttribute("type","text");

// d2.type="button";
// d2.setAttribute('type','button');


const d3 = document.getElementById('d3')
let count = window.prompt("숫자를 입력하세요");
let t="";

for(let i=0;i<count;i++) {
    t=t+'<input type="text">';
}

d3.innerHTML=t;


const year = document.getElementById('year')
const month = document.getElementById('month')
const day = document.getElementById('day')

let a="";
for(let i=1900;i<2023;i++) {
    a=a+'<option>'+i+'</option>';
}

year.innerHTML=a;

let b="";
for(let i=1;i<13;i++) {
    b=b+'<option>'+i+'</option>';
}
month.innerHTML=b;

let ccc="";
for(let i=1;i<32;i++) {
    ccc=ccc+'<option>'+i+'</option>';
}
day.innerHTML=ccc;

let r = prompt("ROW의 숫자를 입력하세요")
let c = prompt("COLUMN의 갯수를 입력하세요")

let rr = "";
for(let i=0;i<r;i++){
    rr=rr+'<tr>'
    for(let i=0;i<c;i++){
        rr=rr+'<td>칸</td>'
    }
    rr=rr+'</tr>'
}

const d4 = document.getElementById('d4');
d4.innerHTML=rr;



