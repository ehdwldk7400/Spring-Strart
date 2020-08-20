/**
 * 
 */
// 댓글 리스트
$(document).ready(
		function() {
						
			var bno = $("#bno").val(); // 게시판 번호
			var page = 1; // 페이지 번호

			getAllList();

			function getAllList() {
				$("#modDiv").hide();
				var str = "";
				// method방식인 get인 ajax 시작 ( $.getJSON)
				$.getJSON("/jin/replies/" + bno + "/" + page, function(data) {
					console.log(data.list);
					$(data.list).each(
							function() {
								str += "<li data-rno='" + this.rno + "' class='replyLi'>" + this.rno + ":"
										+ this.replytext
										+ "<button>수정</button></li>"
							});
					
					
					// 댓글 페이징 구현
					console.log("댓글 전체 수 = " + data.replycnt);
					// endNum 계산식
					var endNum=Math.ceil(page/10.0)*10;
					var startNum = endNum-9;
					
					var prev = startNum > 1;
					var next = false;
					
					if(endNum*10 >= data.replycnt){
						endNum = Math.ceil(data.replycnt/10.0);
					}
					console.log(next);
					console.log(endNum*10);
					console.log(data.replycnt);
					if(endNum*10 < data.replycnt){
						next = true;
					}
					console.log(next);
					var pagestr="";
					if(prev){
						pagestr += "<li><a herf='"+(startNum-1)+"'>이전</a></li>";
					}
					
					for(var i = startNum; i <= endNum; i++){
						
						var active = page == i ? "active" : "";
						pagestr += "<li class='page-item " + active + "'><a href="+i+">"+i+"</a></li>";
					}
					
					if(next){
						pagestr += "<li><a herf='"+(endNum+1)+"'>다음 </a></li>";
					}
					
					
					$("#replyPage").html(pagestr);
					$("#replies").html(str);
				});

			};// getALlList END
			
			$("#replyPage").on("click", "li a", function(e){
				e.preventDefault();
				var targetPageNum = $(this). attr("href");
				page=targetPageNum;
				
				getAllList(page);
			});

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
				}); // ajax END
			}); // 댓글 쓰기 END
			
			$("#replies").on("click", ".replyLi button", function(e) {
				e.preventDefault();
				
				var reply = $(this).parent();
				var rno = reply.attr("data-rno");
				var replytext=reply.text();
// alert(replytext);
				$(".modal-title").html(rno);
				$("#replytext").val(replytext);
				$("#modDiv").show("slow");
				
			}); 
			
			
			
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
			
			$("#replyModBtn").on("click", function(){
				var rno = $(".modal-title").html();
				var replytext = $("#replytext").val();
				$.ajax({
					type:"put",
					url : "/jin/replies/"+rno,
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method_Override" : "PUT"
					},
					data:JSON.stringify({replytext:replytext}),
					dataType: "text",
					success:function(result){
						if(result == "Update SUCCESS"){
							alert("수정 되었습니다.");
							getAllList();
						}
					}
				})
				
			}) // Update END
		})
