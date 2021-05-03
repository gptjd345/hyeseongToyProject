$('#login').click(function(e)
{
    
    var userId = $('#userid').val().trim();
    var passWord = $('#password').val().trim();

    if( userId.length == 0 )
    {
        //뒤에 span 태그는 하나만 있어야함 
        $('#userid').nextAll("*").remove();
        $('#userid').after('<span class="fail"> 아이디를 입력해주세요. </span>');
        
        e.preventDefault();
     }
    //남은 경우의 수는 password의 길이가 0인 경우 만 남게 됨 
    else if( passWord.length == 0 )
    { 
    	 //뒤에 span 태그는 하나만 있어야함 
        $('#password').nextAll("*").remove();
        $('#password').after('<span class="fail"> 비밀번호를 입력해주세요. </span>');
        
        e.preventDefault();
    }
             
    //button type이 submit이기 때문에 성공시 기본이벤트 수행된다. 
              	
                	
 });