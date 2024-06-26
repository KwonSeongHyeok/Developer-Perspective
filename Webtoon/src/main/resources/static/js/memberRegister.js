/*jquery사용해서 실시간 유효검사*/
/*jquery사용해서 유효성 실시간띄우기*/

/*id*/
$(document).ready(
	function() {
		$("#mem_id_box").on(
			"input",
			function() {
				const userId = $(this).val();
				const idPattern = /^[a-z0-9]{6,10}$/;

				if (idPattern.test(userId)) {
					$("#idRegexMsg").text("아이디가 유효합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#idRegexMsg").text("아이디가 유효하지 않습니다. 6~10영소,수").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

/*이름*/
$(document).ready(
	function() {
		$("#mem_name_box").on(
			"input",
			function() {
				const userName = $(this).val();
				const namePattern = /^[가-힣]{2,5}$/;

				if (namePattern.test(userName)) {
					$("#nameRegexMsg").text("이름이 유효합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#nameRegexMsg").text("이름이 유효하지 않습니다. 한글2~5자").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

/*닉네임*/
$(document).ready(
	function() {
		$("#mem_nickName_box").on(
			"input",
			function() {
				const userNickName = $(this).val();
				const nickNamePattern = /^[a-z0-9]{6,10}$/;

				if (nickNamePattern.test(userNickName)) {
					$("#nickNameRegexMsg").text("닉네임이 유효합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#nickNameRegexMsg").text("닉네임이 유효하지 않습니다. 6~10영소,수").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

/*비밀번호-유효성, 비밀번호확인 값과일치*/
$(document).ready(
	function() {
		$("#mem_pw_box").on(
			"input",
			function() {
				const userPw = $(this).val();
				const pwPattern = /^[a-zA-Z0-9]{8,12}$/;

				if (pwPattern.test(userPw)) {
					$("#pwRegexMsg").text("비밀번호가 유효합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#pwRegexMsg").text("비밀번호가 유효하지 않습니다. 8~12영대소,수").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

$(document).ready(
	function() {
		$("#mem_pwConfirm_box").on(
			"input",
			function() {
				const password = $("#mem_pw_box").val();

				const passwordConfirm = $(this).val();

				if (password === passwordConfirm) {
					$("#pwConfirmMsg").text("비밀번호가 일치합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#pwConfirmMsg").text("비밀번호가 일치하지 않습니다.").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

/*성별 M/F 중 한글자 입력했는지 확인*/
$(document).ready(
	function(){
		$("#mem_gender_box").on(
			"input",
			function(){
				const userGender = $(this).val();
				const genderPattern = /^[MF]$/;
				
				if (genderPattern.test(userGender)) {
					$("#genderRegexMsg").text("성별이 유효합니다.").css("color", "green");
					$("#joinToggle").show();
				} else {
					$("#genderRegexMsg").text("성별이 유효하지 않습니다. M/F").css("color", "red");
					$("#joinToggle").hide();
				}
			});
	});

/* 유효성 검사로 checkList key value로 true false저장해서 error-display:none */
const checkList = {
                "finId" : false,
                "finName" : false,
                "finNickName" : false,
                "finPw" : false,
                "finPwConfirm" : false,
                "finGender" : false
                
            }
/*const*/ 











