/**
 * 
 */

$(document).ready(function() {

	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	var maxSize = 5232880;

	function checkExtension(fileName, fileSize) {

		if (fileSize >= maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		if (regex.test(fileName)) {
			alert("해당 종료의 파일은 업로드 할 수 없습니다.")
			return false;
		}
		return true;
	}

	function showUploadFile(uploadResultArr) {
		var str = "";
			
		$(uploadResultArr).each(function(i, obj) {
			var fileCallPath = obj.uploadPath;
			var uuid = obj.uuid;
			var name = obj.fileName;
			var image = encodeURIComponent(fileCallPath + "/" + uuid + "_" + name);
			var simage = encodeURIComponent(fileCallPath + "/s_" + uuid + "_" + name);
			if(!obj.image){
				str += "<li><a href='/jin/download?fileName="+image+"'>"+"<img src='resources/image/5.jpg'>" + obj.fileName + "</a></li>";	
			}else{
				str += "<li><img src='/jin/display?fileName="+image+"'>"+"<span data-file='"+simage+"' data-type='image'>X</span>" + "</li>";				
			}
		})
		$(".uploadList ul").append(str);
	}

	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
		// alert("drag");
	});
	$(".fileDrop").on("drop", function(event) {
		event.preventDefault();
		var files = event.originalEvent.dataTransfer.files;
		// 해당 jsp에 form태그가 없으면 대체하기 위한 메서드
		var formData = new FormData();
		for (var i = 0; i < files.length; i++) {
			// var file = files[i];
			// console.log(files[i].name);
			// console.log(files[i].size);
			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			formData.append("file", files[i]);
		}

		$.ajax({
			url : '/jin/uploadAjax',
			data : formData,
			dataType : 'json',
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				showUploadFile(data);
				console.log('data :', data);

			}
		});

	});
	
	$(".uploadList").on("click", "span", function(e){
		var fileName = $(this).data("file");
		var type = $(this).data("type");
		console.log(fileName);
		console.log(type);
		
		$.ajax({
			url : "/jin/deleteFile",
			data: {fileName:fileName, type:type},
			dataType: "text",
			type: "POST",
			success: function(data){
				console.log(data);
				if(data == "delete"){
					alert("삭제 성공!!");					
				}
				
			}
		})
	})
	
});