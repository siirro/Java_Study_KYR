const btn1 = document.getElementById('btn1');
const d1 = document.getElementById('d1');
const list = document.getElementById('list');
const list2 = document.getElementById('list2');
const add = document.getElementById('add');
const add2 = document.getElementById('add2');

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

    h.append(t);
    li.append(h);
    list2.prepend(li);

})