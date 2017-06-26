<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, '%', '%');
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
		/* 	alert(writer);
			alert(contents); */
			memoWrite(writer, contents);
		});
		
		$("#btnView").click(function() {
			memoView(1);
		});
	});
	
/* 	function memoWrite(writer, contents){
		$.ajax({
			url: "memoWrite",
			type: "POST",
			data:{
				writer:writer,
				contents:contents
			},
			success: function(data) {
				alert(data);
				$("#result").html(data.trim());
			}
			
		});
	}
		function getList(curPage, find, search) {
			
			$.ajax({
				url:"getMemoList",
				type:"GET",
				data:{
					curPage:curPage,
					find:find,
					search:search
				},
				success: function(data) {
					//alert(data.trim());
				//$("#result").html(data); -> 덮어씌워짐
				//append: 최하위에 글이 달림-> preappend
				
				}
			});
			//alert("test");
 			
			$.get("URL?name=, value=",  function(data) {
				
			});
			$.post("URL", {name:value:},function(data) {
				
			});
			$.ajax({
				url:,
				type:,
				data:{},
				success: function(data) {
					
				}
			});
			$("#result").load
			//#result 에 받아온 것을 뿌려달라 
			
		} */
</script>
</head>
<body>

	<!-- ajax 사용 -->
	<div>
		<form action="getMemoList">
			<p>WRITER:<input type="text" id="writer"></p>
			<p>CONTENTS:<input type="text" id="contents"></p>
			<p><input type="button" value="WRITE" id="btn"> </p>
		</form>
	</div>
	<div id="result">
		
	</div>
	<button id="btnView">VIEW</button>

</body>
</html>