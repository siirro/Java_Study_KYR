const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const update = document.getElementsByClassName("update");
const deletee = document.querySelectorAll(".delete");

//page 번호 담는 변수
let page = 1;
//bookNum을 담을 변수
const bookNum = commentAdd.getAttribute("data-book-num");
getCommentList(page, bookNum);

commentAdd.addEventListener("click",function(){
    // console.log(writer.value);
    // console.log(contents.value);
    // //console.log(commentAdd.data-book-num);
    // console.log(commentAdd.getAttribute("data-book-num"));
    let bookNum = commentAdd.getAttribute("data-book-num");
    let wv = writer.value;
    let cv = contents.value;
    

    //-------------ajax----------
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2.URL 준비
    xhttp.open("POST","./commentAdd");
    
    //3. Enctype
    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 전송(post일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);

            console.log(result);

            writer.value="";
            contents.value="";

            if(result.result==1) {
                alert("댓글 등록 성공");
                // if(commentList.children.length!=0){
                    for(let i=0;i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                    

                //}
                page=1;
                getCommentList(page, bookNum);
                
            } else {

            }

            


            
        }
    }

}); //click 이벤트 끝

function getCommentList(p, bn){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open("GET", "./commentList?page="+p+"&bookNum="+bn);
    //3. 요청 전송
    xhttp.send();
    //4. 응답 처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            //console.log(xhttp.responseText);
            //1. jsp 사용한 결과물
            // let result = xhttp.responseText;
            // commentList.innerHTML=result;
            
            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value = "table";
            // result.setAttributeNode(resultAttr); //<table class="table"></table>

            let pager = result.pager;
            let ar = result.list;

            let tbody = document.createElement("tbody");

            for(let i=0;i<ar.length;i++){
                let tr = document.createElement("tr");
                
                let td= document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                //날짜 format 변경
                //let date = new Date(ar[i].regDate)
                //console.log(date);
                //tdText = document.createTextNode(date.getFullYear()+"년-"+date.getMonth()+"월-"+date.getDate()+"일");
                tdText = document.createTextNode(ar[i].regDate);

                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                let tdnum = document.createAttribute("data-comment-num");
                tdnum.value=ar[i].num;
                td.setAttributeNode(tdnum);
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdnum = document.createAttribute("data-comment-num");
                tdAttr.value="delete";
                tdnum.value=ar[i].num;
                td.setAttributeNode(tdnum);
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                

                tbody.append(tr);

                if(page >= pager.totalPage) {
                    more.classList.add("disabled");

                }else {
                    more.classList.remove("disabled");
                }

                commentList.append(tbody);

                
            }
            
            // console.log(result);

            // let t = commentList.children;
            // if(t.length !=0){
            //     commentList.children[0].remove();
            // }

            // try{
            //     console.log(commentList.children());
            //     throw new Error("에러 메세지 ")
            // }catch(exeception){
            
            // }finally{

            // }


        }
    });



};

//comment 더보기 버튼 - 5개 더나오기

const more = document.querySelector("#more");


more.addEventListener("click",function(){
    page++;
    console.log(page);
    console.log(bookNum);

    getCommentList(page, bookNum);
});


//----------------delete------------------
commentList.addEventListener("click",function(event){
    console.log("d1 click");
    console.log(event.target);
    //event.stopPropagation(); //중복이벤트실행X(버블링,캡쳐링따라달라짐)

    if(event.target.className=="update"){
        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // let v = contents.innerHTML;
        // contents.innerHTML="<textarea>"+v+"</textarea>";

        
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-comment-num");

        document.querySelector("#updateContents").value=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#num").value=num;
        
        document.querySelector("#up").click();

    }

    if(event.target.className=='delete'){
        let check = window.confirm("이 댓글을 삭제하시겠습니까?");
        if(check){
            let dcn = event.target.getAttribute("data-comment-num");
            alert(dcn);
            //-------------ajax 전송------------------------------
            const xhttp = new XMLHttpRequest();
            xhttp.open("POST","./commentDelete");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num="+dcn);
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200) {
                    let result = xhttp.responseText.trim();
                    console.log(result);
                    // result = JSON.parse(result);
                    // console.log(result);
                    if(result==1){
                        alert("댓글 삭제 완료");
                        for(let i=0;i<commentList.children.length;){
                            commentList.children[0].remove();
                        }
                        page=1;
                        getCommentList(page, bookNum);

                    }else{
                        alert("삭제 실패");
                    }
                }
            }
        }else{
            alert("취소완");
        }
    }

    
});

const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click",function(){
    // modal에서 num, contents

    
    let contents = document.querySelector("#updateContents").value;
    let num = document.querySelector("#num").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./commentUpdate");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num="+num+"&contents="+contents);
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200) {
            let result = xhttp.responseText.trim();
            console.log(result);

            if(result==1){
                alert("댓글 수정 완료");
                for(let i=0;i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                page=1;
                getCommentList(page, bookNum);

            }else{
                alert("수정 실패");
            }

            //document.querySelector("#updateClose").click();
        }
    }




});





