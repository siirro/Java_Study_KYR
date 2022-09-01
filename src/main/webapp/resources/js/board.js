const addFiles = document.getElementById('addFiles');
const addFilesb = document.getElementById('addFilesb');
let count = 0;

addFilesb.addEventListener("click", function(){

	count++;
	
	if(count>5) {
		alert("파일 첨부는 최대 5개만 가능합니다")
		return;
	}
	
	let d = document.createElement("div");
	let dch = document.createAttribute("class");
	dch.value="form-floating";
	d.setAttributeNode(dch);
	

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

	addFiles.prepend(d)

});
