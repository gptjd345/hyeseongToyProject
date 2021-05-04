



$('#delete').click(function(e) 
{
	var selectedRow = [];
	
	$('input[name=checkbox]:checked').each(function(){
		selectedRow.push($(this).val());
	});
	
	$.ajax({
        url: "/member/delete.do",
        type: "post",
        traditional : true,
        data: { "selectedRow" : selectedRow } ,
        dataType: "text",
        success: function(result)
        {
            if(result == "success"){
            	alert("삭제 되었습니다.");
                window.location.replace("/member/list.do?curBlock="+$('.curBlock').val());
                
            }
            else if(result == "fail"){
                alert("실패");
               
            }
        }
    });
});

