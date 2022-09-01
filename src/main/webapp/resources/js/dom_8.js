const result = document.getElementById("result"); //div
const count = document.getElementById("count");
const btn = document.getElementById("btn");
const c1 = document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const google = document.getElementById("google");

google.addEventListener("click",function(event){
    alert("Go Google");
    event.preventDefault(); //다른이벤트제거.(a태그이벤트가제거됨)
});

d1.addEventListener("click",function(event){
    console.log("d1 click");
    console.log(event);
    console.log(event.currentTarget);

    console.log(event.target);
    //event.stopPropagation(); //중복이벤트실행X(버블링,캡쳐링따라달라짐)

    if(event.target.className=='buttons'){
        alert("button");
        console.log("this",this);
        alert(event.target.innerHTML);
    }
}, false);

// d1_1.addEventListener("click",function(){
//     console.log("d1_1 click");
// }, false);

// d1_1_1.addEventListener("click",function(event){
//     console.log("d1_1_1 click");
//     //event.stopPropagation();
// }, false);


//얜 안됨 부모가아니라..
// for(c of c1) {
//     c.addEventListener("click",function(){
//         alert(c.innerHTML);
//     });
// }

//부모에게 걸린 이벤트를 자식에게 전달해야 합니다.
result.addEventListener("click", function(event){
    if(event.target.className=='c1'){ //.target은 실제내가누른것
        alert(event.target.innerHTML);
    }
});

btn.addEventListener("click",function(){
    let cv = count.value;
    
    
    for(let i=0;i<cv;i++) {
        let b = document.createElement("button"); //div안에 버튼
        let t = document.createTextNode("CLICK "+(i*1+1));
        b.appendChild(t);
        let bc = document.createAttribute("class");
        bc.value = "c1";
        b.setAttributeNode(bc);
        result.appendChild(b);
    }

});




