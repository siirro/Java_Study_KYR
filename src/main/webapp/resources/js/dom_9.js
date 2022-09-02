const d1 = document.querySelector("#d1")
const d1_2_1_2 = document.querySelector("#d1_2_1_2")
const btn = document.querySelector("#btn")

console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);

console.log("-----------------")

btn.addEventListener("click",function(){
    d1_2_1_2.parentNode.parentNode.remove();
});

console.log(d1_2_1_2.parentNode.parentNode);


console.log("-----------------")

console.log(d1.childNodes);
console.log(d1.children);
console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML); //childnodes는 공백포함이라 배열이커진다
console.log(d1.children[1].children[0].children[0].innerHTML) //children은 위랑 기능은같지만 공백제외

d1.addEventListener("click",function(){
    //li 노드 삭제
    //console.log(d1.children[1].children[0].children);
    let li = d1.children[1].children[0].children;
    console.log(li);
    

    // li.array.forEach(element => { //배열이면 forEach자동완성이뜨고 유사배열이면안뜸
        
    // });

    for(let i=0; i != li.length;) { //i를 0에서 증가시키지않고, 렝스가 0이 될때까지만 반복! 
        li[0].remove();
    }
});