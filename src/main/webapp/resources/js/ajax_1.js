const d1 = document.querySelector("#d1");
const i1 = document.querySelector("#i1");
const result = document.querySelector("#result");

d1.addEventListener("click",function(){
    console.log("d1");

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    let idid = i1.value;
    
    //2. 요청 정보 
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+idid);

    //POST 일 때, 1)header 정보 2)파라미터 전송

    //3. 요청 발생
    xhttp.send();

    //3. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //여기서 this는 xhttp 객체를 말하는것
        // console.log("status : ",this.status);
        // console.log("readyState : ",this.readyState);
        // console.log("----------------------");

        if(this.readyState==4 && this.status==200){
            //console.log(this.responseText);
            let response = this.responseText.trim();
            response = JSON.parse(response);

            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

            let hu = document.createElement("h3");
            hu.innerHTML = response.userId;
            let hi = document.createElement("h3");
            hi.innerHTML = response.id;
            let ht = document.createElement("h3");
            ht.innerHTML = response.title;
            let hb = document.createElement("h3");
            hb.innerHTML = response.body;

            result.append(hu);
            result.append(hi);
            result.append(ht);
            result.append(hb);

        }

    };

    console.log("Ajax 발생");

    






});