const addFiles = document.getElementById('addFiles');
const addFilesb = document.getElementById('addFilesb');
let count = 0;
let idx = 0;

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

	addFiles.prepend(d)

	count++;
	idx++;

	

});

addFiles.addEventListener("click", function(event){
	if(event.target.classList[2]=='del'){
		alert("삭제버튼");
		//인풋,라벨,버튼을 전부 삭제해야한다.
		//remove는 자식포함 전부삭제
		//removechild는 자식을삭제
		for(let i=0;i<idx;i++){
			const id+i = document.getElementById("file"+i);
			console.log(id[i]);
			id+i.remove();
		}
	}
});

