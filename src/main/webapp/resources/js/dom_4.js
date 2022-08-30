const ch = document.getElementsByClassName('ch');
const cb = document.getElementsByClassName('cb');
const all = document.getElementById('all');

for(let i=0;i<ch.length;i++){
    ch[i].addEventListener("click", function(){ //이벤트실행했을때뜨는함수:콜백함수
        alert(ch[i].value);
    })
}


all.addEventListener("click",function(){

    if(all.checked==true) {
        for(let i=0;i<cb.length;i++) {
            cb[i].checked=true;
        }
    } 
    if(all.checked==false) {
        for(let i=0;i<cb.length;i++) {
            cb[i].checked=false;
        }
    }
});