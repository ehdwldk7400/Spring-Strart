/**
 * 
 */

$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	
	
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
	
	var bno = $("#bno").val();
	
	$.getJSON("/jin/board/getAttachList", {bno:bno}, function(arr){
		console.log(arr);
		var str = "";
		
		$(arr).each(function(i, attach){
			var fileCallPath = attach.uploadPath;
			var uuid = attach.uuid;
			var name = attach.fileName;
			var image = encodeURIComponent(fileCallPath + "/" + uuid + "_" + name);
			var simage = encodeURIComponent(fileCallPath + "/s_" + uuid + "_" + name);
			if(attach.fileType){
				str += "<li><img src='/jin/display?fileName="+image+"'>"+"<span data-file='"+simage+"' data-type='image'></span>" + "</li>";
			}else{
				str += "<li><a href='/jin/download?fileName="+image+"'>"+"<img src='resources/image/5.jpg'>" + name + "</a></li>";
			}
		});
		$(".uploadList ul").append(str);
	});
});