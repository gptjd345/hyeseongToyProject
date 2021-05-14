



$('#delete').click(function(e) 
{
	
	$('input[name=checkbox]:checked').each(function(e){
		let value = $(this).val(); 
		$('#deleteForm').append($('<input/>',{type:'hidden',name:'list',value:value}));
	});
	
	$('#deleteForm').submit();
});

$('#searchButton').click(function(e))
{	
	
	 $.ajax({
	        url: "./list.do",
	        type: 'post',
	        data: ,
	        dataType: "text",
	        success: function(result)
	        {
	            if(result == "success"){
	                alert("로그인 되었습니다.");
	                window.location.replace('/');
	            }
	            else if(result == "error"){
	                alert("아이디 혹은 비밀번호를 잘못입력하셨습니다.");
	                window.location.href = './login.do';
	            }
	        }
	    });

});