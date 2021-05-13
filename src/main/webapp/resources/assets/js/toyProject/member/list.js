



$('#delete').click(function(e) 
{
	
	$('input[name=checkbox]:checked').each(function(e){
		let value = $(this).val(); 
		$('#deleteForm').append($('<input/>',{type:'hidden',name:'list',value:value}));
	});
	
	$('#deleteForm').submit();
});

