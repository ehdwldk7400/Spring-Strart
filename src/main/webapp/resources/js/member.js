var idcheck = false;
var pwcheck = false;
var repwcheck =false;
var idtest = false;

$(document).ready(function(){
	
	// blur : 포커스를 잃었을 때 발생하는 이벤트
	// keyup : 키보드의 입력이 들어오면 발생하는 이벤트
	
	$("#userid").on("blur", function(){
		//alert("aaaa");
		// 아이디 유효성 검사
		var idreg = /^[a-zA-Z0-9]{4,12}$/; // ID 유호성검사를 위한 정규식
		var idVal=$("#userid").val();
	
		
		if(idreg.test(idVal)){
//			alert("유효성 통과");
			$("#idmsg").html("멋진 아이디 입니다.");
			idcheck = true;
		}else{
//			alert("ID 다시 입력");
			$("#idmsg").html("영문+숫자 총 길이는 4~12자 입니다.");
			idcheck = false;
		}
	
	})
	$("#userpw").on("blur", function(){
		
		// 비밀번호 유효성 검사(대문소,소문자, 숫자, 특수문자 모두 포함하며, 총길이는 8자 이상)
		// a* : a가 0개 또는 여러개
		// a? : a가 0게 또는 1개
		// . : 아무 문자
		
		var pwreg=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		var pwVal=$("#userpw").val();
		if(pwreg.test(pwVal)){
			$("#pwmsg").html("멋진 비밀번호 입니다.");
			pwcheck = true;
		}else{
			$("#pwmsg").html("영대문자+숫자+툭스문자 포함 총 길이는 8자 이상입니다.");
			pwcheck = false;
		}
	})
	$("#re_userpw").on("blur", function(){
		var pw = $("#userpw").val();
		var repw = $("#re_userpw").val();
		
		if(pw == repw){
			$("#repwmsg").html("비밀번호가 일치합니다.");
			repwcheck = true;
		}else{
			$("#repwmsg").html("비밀번호가 불일치 합니다.");
			repwcheck = false;
		}
	})
	$("#test").on("blur", function(){
		var userid = $("#userid").val();
		console.log(userid);
		$.ajax({
			type : "post",
			url : "/jin/member/idChk",
			dataType : "json",
			data : {
				userid : userid
			},
			success : function(result){
				console.log(result);
				if(result == 1){
					alert("아이디가 중복되었습니다.");
				}else{
					alert("사용 가능한 아이디입니다.");
					idtest = true;
				}
			}
		})
	})

})

function checkmem(){
	
	if(idcheck == true && pwcheck == true && idtest == true && repwcheck == true){
		if(namecheck == null || emailcheck == null){
			alert("이름 & Email 중 공백이 존재합니다.")
			return false;
		}
		return true;
	}
	alert("유호성 검사에 실패하셨습니다.")
	return false;
}