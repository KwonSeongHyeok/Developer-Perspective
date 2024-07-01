
function random_img(){
	num1 = Math.floor(Math.random()*24);
	num2 = Math.floor(Math.random()*24);
	num3 = Math.floor(Math.random()*24);
	document.randomImg1.src="/imagesCopy/" + num1 + ".jpg";
	document.randomImg2.src="/imagesCopy/" + num2 + ".jpg";
	document.randomImg3.src="/imagesCopy/" + num3 + ".jpg";
	
}