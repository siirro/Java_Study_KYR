const idid = document.getElementById('idid');
const iderror = document.getElementById('iderror');
const password = document.getElementById('password');
const pwerror = document.getElementById('pwerror');
const passwordCheck = document.getElementById('passwordCheck');
const pce = document.getElementById('pce');
//const = document.getElementById('');
const namen = document.getElementById('namen');
const nerror = document.getElementById('nerror');
const email = document.getElementById('email');
const eerror = document.getElementById('eerror');
const phone = document.getElementById('phone');
const perror = document.getElementById('perror');


//1. ID를 입력하고 나왔을 때 2글자 미만이면
//메세지를 출력 : ID는 2글자 이상이어햐마
let result = false;


idid.addEventListener("blur", function(){
    let ididd = idid.value;
    let idlength = ididd.length;
    //console.log(idlength);

    if(idlength<2) {
        iderror.innerHTML="ID는 2글자 이상이어야 합니다";
    } else {
        iderror.innerHTML="";
        result = true;
    }
});

// 2. 최소 6글자 이상이어야 한다.
// PW를 입력할때 마다 메세지를 띄운다
// 비번은 최소 6글자 이상이어야함
password.addEventListener("keyup",function(){
    let pw = password.value;
    let pwc = passwordCheck.value;
    let pwlength = password.value.length;

    if(pwlength<6) {
        pwerror.innerHTML="비밀번호는 6글자 이상이어야 합니다";
        result=false;   
    } else {
        pwerror.innerHTML="";
        result=true;
    }

    if(pwlength>=6) {
        if(pw==pwc) {
            pce.innerHTML="일치합니다";
            result=true;
        } else {
            pce.innerHTML="비밀번호가 일치하지 않습니다";
            result=false;
        }
    } else {
        pce.innerHTML="";
    }

    if(pw==null){
        result==false;
    }
});



// 3. 두번째 pw를 입력하고 나왔을 때  
// 첫번재 pw와두번째 pw값 비교
// 메세지를 출력 : 같으면 같다, 다르면 다르다
passwordCheck.addEventListener("keyup",function(){
    let pw = password.value;
    let pwc = passwordCheck.value;
    let pwlength = pw.length;

    if(pwlength>=6) {
        if(pw==pwc) {
            pce.innerHTML="일치합니다";
            result=true;
        } else {
            pce.innerHTML="비밀번호가 일치하지 않습니다";
        }
    } else {
        pce.innerHTML="";
    }
});


// 4. name, email, phone
// 입력이 끝난 후, 최소 1글자 이상이어야 함
namen.addEventListener("blur", function(){
    let n = namen.value.length;
    if(n<1) {
        nerror.innerHTML="1글자 이상 입력해주세요";
    } else {
        nerror.innerHTML="";
        result = true;
    }
});

email.addEventListener("blur", function(){
    let e = email.value.length;
    if(e<1) {
        eerror.innerHTML="1글자 이상 입력해주세요";
    } else {
        eerror.innerHTML="";
        result = true;
    }
});

phone.addEventListener("blur", function(){
    let p = phone.value.length;
    if(p<1) {
        perror.innerHTML="1글자 이상 입력해주세요";
    } else {
        perror.innerHTML="";
        result = true;
    }
});


// 5. 입력이 다 끝나고, 모든 조건을 다 확인한 후 회원가입한다.


const gg = document.getElementById('gg');
const jbutton = document.getElementById('jbutton');

jbutton.addEventListener("click",function(){
    if(result) {
        gg.submit();
    } else {
        alert("입력창을 확인해주세요")
    }
})
