const bb = document.getElementById('bb');
const aa = document.getElementById('aa');
const userName = document.getElementById('userName');
const password = document.getElementById('password');
const h5 = document.getElementById('h5');


bb.addEventListener("click", function(){
    console.log("Submit Button Click");
    let u = userName.value;
    let p = password.value;
    console.log(u.length);

    if(u=="") {
        alert('id는 필수입니다');
        h5.innerText = 'ID를 입력해주세요';
        return;
    }

    if(p=="") {
        alert('pw는 필수입니다')
    }

    // if(u.length>0 && p.length>0) {
    //     aa.submit();
    // } else {
    //     alert("ID, PW를 입력하세요")
    // } 
})

