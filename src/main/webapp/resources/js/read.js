/**
 * 
 */

$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click",function(){
		formObj.attr("action","/jin/board/update");
		formObj.attr('method','get');
		formObj.submit();
	});
	$(".btn-danger").on("click",function(){
		formObj.attr("action","/jin/board/delete");
		formObj.attr('method','post');
		formObj.submit();
	});
	$(".btn-primary").on("click",function(){
		formObj.attr("action","/jin/board/list");
		formObj.attr('method','get');
	});
});