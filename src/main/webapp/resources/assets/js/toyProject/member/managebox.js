
//close버튼이 눌렸을 때
$('#close-managebox').click(function(e)
{
	$('#manage-box').css("display","none");
});

//확인 버튼 눌렀을 때
//유효성 검사 후 성공 글씨는 나중에 지울 것 !!

//id 유효성 검사 함수 
var idValidate = function(){
  var ID = $('#userid').val().trim();
  
  var IdCheck = RegExp(/^[a-zA-Z0-9]{5,16}$/);
  
  if(!IdCheck.test(ID))
  { 
      $('#userid').nextAll("*").remove();
      $('#userid').after('<div><span class="fail">영문 대소문자, 숫자(5~16)</span></div>');
  }
  else
  {
      $('#userid').nextAll("*").remove();
      //id중복확인해야함 ajax?
      $.ajax({
          url: "/member/idCheck.do",
          type: 'post',
          data: {"userid" : ID},
          dataType: "text",
          success: function(result)
          {
              if(result==1){
              	 $('#userid').nextAll("*").remove();
                  $('#userid').after('<div><span class="fail">사용 중 이거나 휴면상태인 아이디</span></div>');
              }
              else{
              	 $('#userid').nextAll("*").remove();
                  $('#userid').after('<div><span class="success">사용 가능한 아이디</span></div>');
                    
              }
          }
      });
  } 
};

//비밀번호 유효성 검사 함수 
var pwValidate = function() {
  var PW = $("#password").val().trim();

  var pwCheck = RegExp(/^(?=.*[a-zA-Z])(?=.*[`~!@#$%^&*()+=-?])(?=.*\d).{8,16}$/);

  if(!pwCheck.test(PW))
  {
      $("#password").nextAll("*").remove();
      $("#password").after('<div><span class="fail">영문 대소문자, 숫자,특수문자 (8~16)</span></div>');
  }
  else{
      $("#password").nextAll("*").remove();
      $("#password").after('<div><span class="success">성공</span></div>');
  }
  
}

//비밀번호 확인 유효성 검사 함수 
var pwValidate2 = function() {
  var PW2 = $("#password2").val().trim();

  if(PW2 == $("#password").val().trim())
  {
      $("#password2").nextAll("*").remove();
      $("#password2").after('<div><span class="success">성공</span></div>');
  }
  else{
      $("#password2").nextAll("*").remove();
      $("#password2").after('<div><span class="fail">비밀번호 불일치</span></div>');
  }
}

//이름 확인 유효성 검사 함수
var nameValidate = function() {
  var Name = $("#name").val().trim();
  // (?:x|y) x와 y중 하나  이거 안쓰면 앞검사통과하면 뒤에 검사 진행하지 않는다. 
  var pwCheck = RegExp(/^(?:([가-힣]{2,4})|([a-zA-Z]{3,16}))$/);
  
  if(!pwCheck.test(Name))
  {
      $("#name").nextAll("*").remove();
      $("#name").after('<div><span class="fail">한글(2~4),영문(3~16)</span></div>'); 
  }
  else{
      $("#name").nextAll("*").remove();
      $("#name").after('<div><span class="success">성공</span></div>'); 
  }
}

//전화번호 유효성 검사 함수
var phoneValidate = function() {
	//사용자가 하이픈 처리를 신경쓰지 않아도 되도록한다. 
  var phoneCheck = RegExp(/^01[016789]-?(\d{3,4})-?(\d{4})$/); 
  var phonenum = $("#phonenum").val().trim();

  if(!phoneCheck.test(phonenum))
  {
      $("#phonenum").nextAll("*").remove();
      $("#phonenum").after('<div><span class="fail"> 올바른 전화번호 형식이 아닙니다. </span></div>');
  }
  else{
      $("#phonenum").nextAll("*").remove();
      $("#phonenum").after('<div><span class="success">성공</span></div>');
  }    
}

/* --- 입력필드에 blur 이벤트가 실행될 경우 유효성 검사를 진행한다. --- */ 

//id 유효성 검사 
$('#userid').blur(idValidate);

//비밀번호 유효성 검사 
$('#password').blur(pwValidate);

//비밀번호 확인 유효성 검사 
$('#password2').blur(pwValidate2);

//이름 유효성 검사 
$('#name').blur(nameValidate);

//전화번호 유효성 검사
$('#phonenum').blur(phoneValidate);



//등록 버튼 클릭 시 fail클래스의 개수 확인
$("#registration").click(function(e)
{
	//사용자가 입력 필드에 입력한 내용을 수정하고 등록버튼을 누를수있으니 버튼클릭시 검사를 다시 진행한다.
	//id 유효성 검사 
  idValidate();

  //비밀번호 유효성 검사 
  pwValidate();

  //비밀번호 확인 유효성 검사 
  pwValidate2();

  //이름 유효성 검사 
  nameValidate();

  //전화번호 유효성 검사
  phoneValidate();

  //fail span 태그가 하나도 없으면 통과 기본이벤트 진행 
  if($('.fail').length == 0 )
  {
      window.alert("회원 등록이 완료 되었습니다.");
      $('#managebox-form').submit();
  }
  else
  {
  	//기본이벤트를 막는다. 
      e.preventDefault();
  }

  
}); 


