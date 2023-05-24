$(() => {
	$('.logo').on('click', (e) => {
		console.log('로고 클릭~!');
		location.href = "Main.jsp";
	})
	
	$('._login').on('click', (e) => {
		console.log('로그인 창으로 이동 !');
		
		//window.open("Login.jsp", "Login Form", 'width=' + popupWidth + ',height=' + popupHeight + ',left=' + popupX + ',top=' + popupY, 'histroy=no, resizable=no, status=no, scrollbars=yes, menubar=no');
		//window.open("Login.jsp", "Login Form", "width=400, height=500, history=no, resizable=no, status=no, scrollbars=yes, menubar=no");
	});
	
	$('._home').on('click', (e) => {
		console.log('home 버튼 클릭함');
		location.href = "Main.jsp";
	});
	
	//$('.btn').on('click', (e) => {
	//	console.log('로그인 시도함!!!!');
	//	location.href = "Main.jsp";
	//});
	
	//$('._join').on('click', (e) => {
	//	console.log('회원가입할거임 !!!');
	//	window.open("join.jsp", "회원가입", "width=500, height=600, history=no, resizable=no, status=no, scrollbars=yes, menubar=no");
	//});
	
	//$('._find').on('click', (e) => {
	//	console.log('계정찾기 클릭!!!');
	//	window.open("SearchUser.jsp", "계정찾기", "width=1100, height=650, history=no, resizable=no, status=no, scrollbars=yes, menubar=no");
	//});
});