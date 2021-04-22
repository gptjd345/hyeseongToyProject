
//유효성 검사 후 성공 글씨는 나중에 지울 것 !!

$('#login').click(function(e)
{
    e.preventDefault();

    var userid = $('#userid').val().trim();
    var password = $('#password').val().trim();

    if(userid.length == 0 )
        {
            //뒤에 span 태그는 하나만 있어야함 
            $('#userid').nextAll("*").remove();
            $('#password').nextAll("*").remove();

            $('#userid').after('<span class="fail"> 아이디를 입력해주세요. </span>');
            if(password.length == 0 )
                {
                    $('#password').after('<span class="fail"> 비밀번호를 입력해주세요. </span>');     
                }
                else{
                    $('#login').after('<span class="success"> 성공 </span>'); 
                }
        }


})
//아이디 유효성 검사 
$('#userid').blur(function(e)
{
   var userid = $('#userid').val().trim();

    var IdCheck = RegExp(/^[a-zA-Z0-9]{5,20}$/); 

    if(!IdCheck.test(userid))
    {
        $(this).nextAll("*").remove();
        $(this).after('<span class="fail"> 5 ~ 20 자 사이의 영문 대소문자 가능</span>');
    }
    else{
        //ajax 통신통해 id 중복확인 하고 성공이면 성공 아니면 중복된 아이디 임을 알림 
        $(this).nextAll("*").remove();
        $(this).after('<span class="success">성공</span>');
    }
});

//비밀번호 유효성 검사 
$('#password').blur(function(e)
{
   var password = $('#password').val().trim();

    var pwCheck = RegExp(/^[a-zA-Z0-9]{5,20}$/); 

    if(!pwCheck.test(password))
    {
        $(this).nextAll("*").remove();
        $(this).after('<span class="fail"> 5 ~ 20 자 사이의 영문 대소문자 가능</span>');
    }
    else{
        $(this).nextAll("*").remove();
        $(this).after('<span class="success">성공</span>');
    }
});

//비밀번호 확인 유효성 검사 
$('#password2').blur(function(e)
{
   var password2 = $('#password2').val().trim();

   var pwCheck = RegExp(/^[a-zA-Z0-9]{5,20}$/);

   if(!pwCheck.test(password2))
   {
       $(this).nextAll("*").remove();
       $(this).after('<span class="fail"> 5 ~ 20 자 사이의 영문 대소문자 가능</span>');
   }
    else if(password2 == $('#password').val().trim())
    {
        $(this).nextAll("*").remove();
        $(this).after('<span class="success">성공</span>');
    }
    else{
        $(this).nextAll("*").remove();
        $(this).after('<span class="fail"> 비밀번호를 확인해주세요. </span>');
    }
});

//이름 유효성 검사 입력했는지 안했는지만 확인 
$('#name').blur(function(e)
{
    if($(this).val().trim().length == 0 )
    {
        $(this).nextAll("*").remove();
        $(this).after('<span class="fail"> 이름을 입력 해주세요. </span>');
    }
    else{
        $(this).nextAll("*").remove();
        $(this).after('<span class="success"> 성공 </span>');
    }    
});

//전화번호 유효성 검사 
$('#phoneNumber').blur(function(e)
{
    var phoneCheck = RegExp(/^\d{3}-\d{3,4}-\d{4}$/); 
    var phoneNumber = $(this).val().trim();

    if(!phoneCheck.test(phoneNumber))
    {
        $(this).nextAll("*").remove();
        $(this).after('<span class="fail"> 올바른 전화번호 형식이 아닙니다. </span>');
    }
    else{
        $(this).nextAll("*").remove();
        $(this).after('<span class="success">성공</span>');
    }
});

//등록 버튼 클릭 시 success클래스의 개수 확인
$("#registration").click(function(e)
{
    //유효성검사 통과한 필드 수와 입력 필드 수와 같다면 통과 
    if($('.success').length == $('#registration-form .p_star').length )
    {
        e.preventDefault();
        window.alert("통과");
    }
    else
    {
        e.preventDefault();
        window.alert("실패");
    }

    
}); 







