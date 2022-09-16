const addFiles = document.getElementById('addFiles');
const addFilesb = document.getElementById('addFilesb');
const fileDelete = document.querySelectorAll(".fileDelete");
//const fileDelete = document.getElementsByClassName("fileDelete"); //foreach불가능

// --------update시 file Delete

try{
fileDelete.forEach(function(f){
	console.log(f);
	f.addEventListener("click", function(){
		


		let check = window.confirm("삭제하면 되돌릴 수 없음");
		if(!check){
			return; //밑에꺼 실행 안하고 바로 펑션종료.
		}

		console.log("file Delete");
		// ---이제 파일을 삭제하는 ajax 생성 (비동기)
		//url, method,
		let fileNum = f.getAttribute("date-file-num");
		//ajax 
		const xhttp = new XMLHttpRequest();

		xhttp.open("POST","./fileDelete");

		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            
		xhttp.send("fileNum="+fileNum);

		xhttp.onreadystatechange=function(){
			if(xhttp.readyState==4&&xhttp.status==200){
				let result = xhttp.responseText.trim();
				if(result==1){
					console.log(result);
					f.parentNode.remove();
					count--;

				}else {
					console.log(result);
				}

			}
		}

	});
});

}catch(e){
	console.log(e);
}

// for(fi of fileDelete){
// 	console.log(fi);
// }



// ---------Add시 file add------------------
let count = 0;
let idx = 0;

function setCount(c){
	if(c>=0) {
		count=c;
	}
}

try{

addFilesb.addEventListener("click", function(){
	
	
	if(count>4) {
		alert("파일 첨부는 최대 5개만 가능합니다")
		return;
	}
	
	let d = document.createElement("div");
	let dch = document.createAttribute("class");
	dch.value="form-floating";
	d.setAttributeNode(dch);
	//삭제기능을위해
	let c = document.createAttribute("id");
	c.value="file"+idx;
	d.setAttributeNode(c);
	

	let i = document.createElement("input");
	let it = document.createAttribute("type");
	it.value="file";
	let ic = document.createAttribute("class");
	ic.value="form-control";
	let ii = document.createAttribute("id");
	ii.value = "file";
	let ina = document.createAttribute("name");
	ina.value = "files";
	i.setAttributeNode(it);
	i.setAttributeNode(ic);
	i.setAttributeNode(ii);
	i.setAttributeNode(ina);
	d.appendChild(i);

	let l = document.createElement("label"); 	//<label></label>
	let lf = document.createAttribute("for"); 	//for=""
	lf.value = "floatingfile"; 					//for="floatingfile"
	let lt = document.createTextNode("파일첨부"); //파일첨부
	l.appendChild(lt);  						//<label>파일첨부</label>
	//l.innerText = "파일첨부";
	l.setAttributeNode(lf);
	d.appendChild(l);

	//삭제 버튼 Element 생성
	let b = document.createElement("button");
	let bc = document.createAttribute("class");
	bc.value="btn btn-danger del";
	b.setAttributeNode(bc);

	bc = document.createAttribute("type");
	bc.value="button";
	b.setAttributeNode(bc);

	let bt = document.createTextNode("삭제");
	b.appendChild(bt);

	bc = document.createAttribute("title");
	bc.value=idx;
	b.setAttributeNode(bc);


	d.appendChild(b);

	addFiles.append(d)

	count++;
	idx++;

	

});

addFiles.addEventListener("click", function(event){
	let button = event.target;
	if(button.classList[2]=='del'){
		document.getElementById("file"+button.title).remove();
		count--;
		// alert(button.getAttribute("title"));

		//인풋,라벨,버튼을 전부 삭제해야한다.
		//remove는 자식포함 전부삭제
		//removechild는 내부의 자식들 중 하나를 삭제

	
	}
});

}catch(e){

}