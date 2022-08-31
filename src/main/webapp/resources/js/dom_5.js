const d2 = document.getElementById('d2');
const d1 = document.getElementById('d1');
const d3 = document.getElementById('d3');
const d4 = document.getElementById('d4');
const d5 = document.getElementById('d5');
const span1 = document.getElementById('span1');


d2.addEventListener('focus',function(){
    console.log("입력 준비");
});

d2.addEventListener('blur',function(){ //포커스 후 밖을 클릭했을때 블러발생
    console.log("블러")
})

//d1에 뭔가를 입력하고 나왔을때 글자의 길이가 3글자 이하라면, d1 강제입력 대기 상태




d1.addEventListener("blur",function(){
    let d1v = d1.value;
    console.log(d1v.length);
    if(d1v.length<=3) {
        d1.focus();

    }
});

d3.addEventListener("change",function(){ //내용이 바뀌고 나오면 체인지 이벤트 발생
    console.log("change event 발생");
});

d5.addEventListener("change",function(){
    console.log("SELECT가 변경");
})

d4.addEventListener("keyup",function(){
    let d4v = d4.value;
    let d4vl = d4v.length;
    span1.innerHTML=d4vl+"천원";
})

//d4에 한글자입력하면 천원 두글자 입력하면 2천원 세글자 3천원
