function validate(frm)
{
	//alert("in client side");
	//read form data
	var name=frm.uname.value;
	var pass=frm.upwd.value;
	var age=frm.page.value;
	//alert("in client side");
	//perform client side validations
	if(name=="")
	{
		alert("name must be requried");
		return false;
	}
	if(pass==""){
		alert("password must be mandatory");
		return false;
	}
	if(pass.length<=8){
		alert("password must be in eight letters")
	}
	if(age==""){
		alert("age must be requried");
		return false;
	}
	else if(age>=130){
		alert("age must be <b> 1 </b> to <b> 130</b> ");
		return false;
	}
	else if(isNaN(age)){
		alert("age must be in number");
		return false;
	}
	return true;
}//function