const addFiles = document.getElementById('addFiles');
const addFilesb = document.getElementById('addFilesb');


addFilesb.addEventListener("click", function(){
	let d = document.createElement("div");
	let dch = document.createAttribute("class");
	dch.value="form-floating";
	d.setAttributeNode(dch);
	addFiles.prepend(d)

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

	let l = document.createElement("label");
	let lf = document.createAttribute("for");
	lf.value = "floatingfile";
	l.innerText = "파일첨부";
	l.setAttributeNode(lf);

	d.appendChild(l);



});
