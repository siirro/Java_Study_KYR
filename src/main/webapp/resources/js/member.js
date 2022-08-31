
function loginCheck(){
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
            return;
        }

        aa.submit();

        // if(u.length>0 && p.length>0) {
        //     aa.submit();
        // } else {
        //     alert("ID, PW를 입력하세요")
        // } 
    })
}


function check(){
    const all = document.getElementById('all');
    const cb = document.getElementsByClassName('cb');
    const join = document.getElementById('join');
    const submitform = document.getElementById('submitform')
    const req = document.getElementsByClassName('req');

    all.addEventListener("click",function(){
        for(let i=0;i<cb.length;i++) {
            cb[i].checked=all.checked;
        }
    })

    for(let i=0;i<cb.length;i++){
        cb[i].addEventListener("click",function(){
            let result = true;
            for(let j=0;j<cb.length;j++){
                if(!cb[j].checked){
                    result=false;
                    break;
                }
            }
            all.checked=result;
        })
    }


	join.addEventListener("click",function(){
        let result=true;
        for(let i=0;i<req.length;i++){
            if(!req[i].checked) {
                result=false;
                break;
            }
        }
        if(result){
            submitform.submit();
        }else{
            alert("필수약관동의하세요")
        }


        // if(all.checked=true){
        //     submitform.submit();
        // } else {
        //     alert("약관에 동의해주세요");
        // }
    });





}
