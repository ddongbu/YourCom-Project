$(() => {
	//모달 팝업창 닫기 버튼
	$('#closeBtn').on('click', (e) => {
		let val = $('#popup').text();
		$('.background').remove();
	});
	
	// 아이디, 비밀번호 모두 입력되면 암호화 및 데이터 전송
	$('#btn').on('click', (e) => {
		let idval = $('.id').val();
		let pwval = $('.pw').val();
		
		console.log('로그인 시도');
		
		let checkMsg;
		let checkState = true;
		
		if (idval == "" || pwval == "") {
			checkMsg = "ID와 비밀번호를 모두 입력해주세요.";
			checkState = false;
			
			$('body').append("<div class=background><div id=popup>"+ checkMsg 
							+ "<button id=closeBtn type=button>확인</button>" +"</div></div>");
		}
		
		if (checkState) {
			// 평문 암호화 후 다음 페이지로 전송
			// 각 공개키의 n, e 값을 가져옴
			let rsaPublicKeyModulus = "<%=publicKeyModulus%>";
			let rsaPublicKeyExponent = "<%=publicKeyExponent%>";
			
			// 암호화에 필요한 n, e 값 지정
			let rsa = new RSAKey();
			rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);
			
			// 암호화에 필요한 RSA 암호 알고리즘으로 평문 암호화
			let cipherID = rsa.encrypt(idval);
			let cipherPW = rsa.encrypt(pwval);
			
			// Form의 input 태그의 값을 암호문으로 변경
			$('#_RSAID').attr("value", cipherID);
			console.log(cipherID);
			$('#_RSAPW').attr("value", cipherPW);
			console.log(cipherPW);
			
			// 암호문 전송
			$('#_loginData').submit();
		}
	});
})