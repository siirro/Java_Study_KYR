const btn = document.getElementById('btn');
const btn2 = document.getElementById('btn2');
const btn3 = document.getElementById('btn3');
const btn4 = document.getElementById('btn4');
const d1 = document.getElementById('d1')
const d2 = document.getElementById('d2')
const d3 = document.getElementById('d3')
const select = document.getElementById('select');
const c1 = document.getElementsByClassName('c1');
//익명함수, 이벤트리스너

btn.addEventListener("click", function(){
    console.log("operater : "+select.value);
    //d3.value = d1.value*1+d2.value*1;
    if(select.value=='+') {
        console.log('더하기')
        d3.value = d1.value*1+d2.value*1;
    } else if(select.value=='-') {
        console.log('빼기')
        d3.value = d1.value*1-d2.value*1;
    } else if(select.value=='*') {
        console.log('곱하기')
        d3.value = (d1.value*1)*(d2.value*1);
    } else if(select.value=='/') {
        console.log('나누기')
        d3.value = (d1.value*1)/(d2.value*1);
    } else if(select.value=='%') {
        console.log('나머지')
        d3.value = (d1.value*1)%(d2.value*1);
    }
});

btn2.addEventListener("click", function(){
    alert('btn2')
})

btn3.addEventListener("click", function(){
    btn2.click();
})

btn4.addEventListener("click", function(){
    alert(c1);
    console.log(c1);
    
    for(let i=0;i<c1.length;i++){
        console.log(c1[i].selected);
    }

    c1[1].selected=true;
})