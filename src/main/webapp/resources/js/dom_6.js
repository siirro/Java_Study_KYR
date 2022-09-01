const btn1 = document.getElementById('btn1');
const d1 = document.getElementById('d1');
const d2 = document.getElementById('d2');
const d3 = document.getElementById('d3');
const list = document.getElementById('list');
const list2 = document.getElementById('list2');
const add = document.getElementById('add');
const add2 = document.getElementById('add2');
const add3 = document.getElementById('add3');
const add4 = document.getElementById('add4');
const add5 = document.getElementById('add5');


btn1.addEventListener("click",function(){
    d1.innerHTML = '<img src="/resources/images/title1.jpg">'

});


add.addEventListener("click",function(){
    let li = document.createElement("li");  //<li></li>
    let t = document.createTextNode("test"); //test
    li.append(t)
    list.append(li)
});

add2.addEventListener("click",function(){
    let li = document.createElement("li");  //<li></li>
    let h = document.createElement('h3');
    let t = document.createTextNode("hello");

    h.appendChild(t);
    li.appendChild(h);
    list2.prepend(li);

})

add3.addEventListener("click",function(){
    let i = document.createElement("input");
    let ch = document.createAttribute("type");
    ch.value="checkbox";
    i.setAttributeNode(ch);
    d2.appendChild(i);
})

add4.addEventListener("click",function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("Before");
    h.appendChild(t);
    d3.before(h);
})

add5.addEventListener("click",function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("After");
    h.appendChild(t);
    d3.after(h);
})