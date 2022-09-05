//const d2 = document.getElementById("d2");
const d2 = document.querySelector("#d2");
const d1 = document.querySelector("#d1");
const d3 = document.querySelector("#d3");
const d4 = document.querySelector("#d4");

d2.addEventListener("mouseenter", function(){
    console.log("enter");
    console.log(d1.class);
    console.log(d1.getAttribute("class"));
    //d1.className="c2";
    d1.classList.replace("c3","c2");
}); 

d2.addEventListener("mouseleave",function(){
    console.log("leave");
    console.log(d1.className);
    console.log(d1.classList);
    d1.classList.add("c4");
});

d3.addEventListener("click", function(){
    console.log("dd");
    d2.classList.toggle("c2");
    console.log(d2.classList.contains("c2"));
});

d4.addEventListener("click",function(){
    console.log("request");
    console.log("origin : ",location.origin);
    console.log("hostName : ",location.hostname);
    console.log("pathName : ",location.pathname);
    console.log("search : ",location.search);
    //location.href="./dom_9.html?a=10";
}) //url은 uri에 아이피를 포함한주소d