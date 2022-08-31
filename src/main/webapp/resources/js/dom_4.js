const ch = document.getElementsByClassName('ch');
const cb = document.getElementsByClassName('cb');
const all = document.getElementById('all');

for(let i=0;i<ch.length;i++){
    ch[i].addEventListener("click", function(){ //이벤트실행했을때뜨는함수:콜백함수
        alert(ch[i].value);
    })
}


// all.addEventListener("click",function(){

//     if(all.checked==true) {
//         for(let i=0;i<cb.length;i++) {
//             cb[i].checked=true;
//         }
//     } 
//     if(all.checked==false) {
//         for(let i=0;i<cb.length;i++) {
//             cb[i].checked=false;
//         }
//     }
// });

for(let i=0;i<cb.length;i++){
    // cb[i].addEventListener("click", function(){
    //     check(1); //매개변수가 필요할때
    // });
    cb[i].addEventListener("click", check);
}

function check(){
    let result = true;
    for(let i=0;i<cb.length;i++){
        if(!cb[i].checked){
            result=false;
            break;
        }
    }
    all.checked=result;
}