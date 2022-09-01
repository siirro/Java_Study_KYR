const remove1 = document.getElementById("remove1"); //button#remove1
const remove2 = document.getElementById("remove2"); 

const d1 = document.getElementById("d1"); 
const d2 = document.getElementById("d2");
const d2c = document.getElementsByClassName("d2");

remove1.addEventListener("click", function(){
    //삭제할거임
    d1.remove();
});

remove2.addEventListener("click",function(){

    const d2c = document.getElementsByClassName("d2"); //배열임
    const ar = [];
    for(let i=0;i<d2c.length;i++){
        ar.push(d2c[i].id);
    }

    for(i of ar){
        let d = document.getElementById(i);
        d2.removeChild(d);
    }

    // for(let i=1;i<5;i++) {

    //     const d2_1 = document.getElementById("d2_"+i);
    //     d2.removeChild(d2_1);
    // }
    
});
