$('#login').click(function(e)
{
    
    var userId = $('#userid').val().trim();
    var passWord = $('#password').val().trim();

    if(userId.length != 0 && passWord.length != 0 )
    {
	    $.ajax({
	        url: "./login_check.do",
	        type: "post",
	        async: true,
	        data: $("#login-form").serialize(),
	        dataType: "text",
	        success: function(result)
	        {
	            if(result == "success"){
	                alert("로그인 성공");
	                window.location.replace('/');
	            }
	            else if(result == "fail"){
	                alert("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
	                window.location.href = './login.do';
	            }
	        }
	    });
	}
    else if( userId.length == 0 )
    {
        //뒤에 span 태그는 하나만 있어야함 
        $('#userid').nextAll("*").remove();
        $('#userid').after('<span class="fail"> 아이디를 입력해주세요. </span>');
     }
    //남은 경우의 수는 password의 길이가 0인 경우 만 남게 됨 
    else
    { 
    	 //뒤에 span 태그는 하나만 있어야함 
        $('#password').nextAll("*").remove();
        $('#password').after('<span class="fail"> 비밀번호를 입력해주세요. </span>');     
    }
             
              	
                	
 });