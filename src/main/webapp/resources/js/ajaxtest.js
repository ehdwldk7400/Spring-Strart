/**
 * 
 */
// 댓글 리스트
$(document).ready(
		function() {
			var bno = 2; // 게시판 번호
			var page = 1; // 페이지 번호

			getAllList();

			function getAllList() {
				$("#modDiv").hide();
				var str = "";
				// method방식인 get인 ajax 시작 ( $.getJSON)
				$.getJSON("/jin/replies/" + bno + "/" + page, function(data) {
					console.log(data);
					$(data).each(
							function() {
								str += "<li data-rno='" + this.rno + "' class='replyLi'>" + this.rno + ":"
										+ this.replytext
										+ "<button>수정</button></li>"
							});
					$("#replies").html(str);
				})

			} // getALlList END

			$("#replyAddBtn").on("click", function() {
				var replyer = $("#newReplyWriter").val();
				var replytext = $("#newReplyText").val();
				console.log(replyer);
				console.log(replytext);

				$.ajax({
					type : "post",
					url : "/jin/replies",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method_Override" : "POST"
					},
					dataType : "text",
					data : JSON.stringify({
						bno : bno,
						replytext : replytext,
						replyer : replyer
					}),
					success : function(result) {
						if (result == "SUCCESS") {
							alert("등록 되었습니다.");
							getAllList();
						}

					}
				}) // ajax END
			}) // 댓글 쓰기 END
			
			$("#replies").on("click", ".replyLi button", function() {
				var reply = $(this).parent();
				
				var rno = reply.attr("data-rno");
				var replytext=reply.text();
//				alert(replytext);
				$(".modal-title").html(rno);
				$("#replytext").val(replytext);
				$("#modDiv").show();
				
			})
			$("#replyDelBtn").on("click", function(){
				var rno = $(".modal-title").html();
				console.log(rno);
				$.ajax({
					type:"delete",
					url : "/jin/replies/"+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method_Override" : "DELETE"
					},
					dataType: "text",
					success:function(result){
						if(result == "DELETE SUCCESS"){
							alert("삭제 되었습니다.");
							getAllList();
						}
					}
				})
				
			}) // Delete END
		})
