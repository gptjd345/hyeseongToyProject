

$('#login').click(function(e)
{
    e.preventDefault();

    var userId = $('#userid').val().trim();
    var passWord = $('#password').val().trim();

    if(userid.length != 0 && password.length != 0 )
    {
	    $.ajax({
	        url: "./login_check.do",
	        type: "post",
	        async: true,
	        data: JSON.stringify({
	            userid :userId,
	            password :passWord
	        }),
	        contentType:"application/json",
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
    else if(userid.length == 0 )
    {
        //뒤에 span 태그는 하나만 있어야함 
        $('#userid').nextAll("*").remove();
        $('#password').nextAll("*").remove();

        $('#userid').after('<span class="fail"> 아이디를 입력해주세요. </span>');
     }   
    else(password.length == 0 )
    {
    	 //뒤에 span 태그는 하나만 있어야함 
        $('#userid').nextAll("*").remove();
        $('#password').nextAll("*").remove();
        $('#password').after('<span class="fail"> 비밀번호를 입력해주세요. </span>');     
    }
             
                	
                	
 });





