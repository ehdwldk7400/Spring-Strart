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

                 // 이미지 파일이 아니라면 (false) 다운로드 하게끔 
                 var fileCallPath = encodeURIComponent(obj.uploadPath+ "/" + obj.uuid+"_" + obj.fileName);
                 if (!obj.image) {
                    // var fileCallPath = encodeURIComponent(obj.uploadPath+ "/" + obj.uuid+"_" + obj.fileName);
                    str += "<li><a href='/jin/download?fileName="+ fileCallPath +"'>"
                    + "<img src='resources/image/cb.png'>" + obj.fileName + "</a></li>";
                    // 이미지 파일이면(true) display웹에 이미지 출력 
                 } else {
                    var fileCallPath = encodeURIComponent(obj.uploadPath+ "/s_" + obj.uuid+"_" + obj.fileName);
                    // var fileCallPath = encodeURIComponent(obj.uploadPath+ "/" + obj.uuid+"_" + obj.fileName);
                    str+= "<li data-fileName='"+obj.fileName+"' data-uuid='"+obj.uuid+"'" +
                          "data-uploadPath='"+obj.uploadPath+"' data-fileType='"+obj.image+"'>" +
                          "<img src='/jin/display?fileName="+ fileCallPath +"'>" +
                          "<span data-file='"+ fileCallPath +"' data-type='image'> x </span></li>";
                 }

              }) // uploadResultArr
        $(".uploadList ul").append(str);
     }// showUploadFile


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
				alert("업로드 성공!")
				console.log('data :', data);

			}
		});

	});
	
	var formObj=$("form[role='form'");
	
	$("input[type='submit']").on("click", function(e){
			e.preventDefault();
			alert("전송버튼 클릭이벤트가 적용되었습니다.");
			
			var str = "";
			$(".uploadList ul li").each(function(i, obj){
				var jobj=$(obj);
				console.log(jobj);
				
				str += "<input type='text' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
				str += "<input type='text' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
				str += "<input type='text' name='attachList["+i+"].uploadPath' value='"+jobj.data("uploadpath")+"'>";
				str += "<input type='text' name='attachList["+i+"].fileType' value='"+jobj.data("filetype")+"'>";
			})
			formObj.append(str).submit();
	});
	
});