
//close버튼이 눌렸을 때
$('#close-container').click(function(e)
{
	$(this).prev().css("display","none");
});


//등록 버튼이 클릭되었을 때
$('#register').click(function(e)
{
    //등록폼을 페이저 번호 밑에 삽입한다. 가져온다. 
	
	$("input-container").prev().css("display","visible");

});
