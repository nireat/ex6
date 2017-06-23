<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function (){
		var name = 0;
		var count=0;
		$("#add").click(function (){
				if(count<5){
				count++;
				name++;
				var data = '<p><input type="file" name="f'+name+'"><span class="del">X</span></p>';
				$("#file").append(data);
				}else{
					alert("최대 5개만 가능");
				}
		});
		
		$("#file").on("click", ".del", function() {
		$(this).parent().remove();
		count--;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<hr>
	<h2>단일 파일 업로드</h2>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드</h2>
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드 - 이름이 같을 때</h2>
	<!-- 파라미터 이름은 같은데 다른 파일이 넘어가는 경우 -->
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드 - 이름이 같을 때: 파라미터 모름</h2>
	<!-- 파라미터 이름은 같은데 다른 파일이 넘어가는 경우 : 파라미터 모름 -->
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<div id="file">
			
		</div>
		<input type="button" id="add" value="FILE ADD">
		<button>UPLOAD</button>
	</form>
</body>
</html>