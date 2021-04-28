
//close버튼이 눌렸을 때
$('#close-container').click(function(e)
{
	$('#sendMe-manage-box').css("display","none");
});


//등록 버튼이 클릭되었을 때
$('#register-form').click(function(e)
{
    //등록폼을 페이저 번호 밑에 삽입한다. 가져온다. 
	$.ajax({
		type : "get",
		url : "./manage.do",
		success: function(result){ 
			
			$("#sendMe-manage-box").html(result).find('#managebox-form').append($('.curBlock'));
			//태그의 css('속성','값')
			$("#sendMe-manage-box").css("display","block");
			
			}
		}); 
	
});

