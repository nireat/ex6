/**
 * 
 */

//맨 위에 $(function){} 선언할 이유가 없음, 함수만 쭉 모아놓음
//-> 필요할 때 꺼내쓸 것
	
	function memoView(num) {
		$.get("memoView/"+num, function(data) {
			alert(data.writer);
		});
	}

	function memoWrite(writer, contents){
		$.ajax({
			url: "memoWrite",
			type: "POST",
			data:{
				writer:writer,
				contents:contents
			},
			success: function(data) {
				//alert(data);
				
				$("#result").html(data.trim());
				getList(1,'','');
			}
			
		});
	}
		function getList(curPage, find, search) {
			alert("getMemoList/"+curPage+"/"+find+"/"+search);
			$.ajax({
				url:"getMemoList/"+curPage+"/"+find+"/"+search,
				type:"GET",
				success: function(data) {
					//alert(data);
					
					/*data=data.trim();
					data= JSON.parse(data);*/
					var result="<table>";
					$(data).each(function() {
						result = result+"<tr>";
						result = result+"<td>"+this.num+"</td>";
						result = result+"<td>"+this.contents+"</td>";
						result = result+"<td>"+this.writer+"</td>";
						result = result+"<td>"+this.reg_date+"</td>";
						result = result+"</tr>";
					});
					result = result+"</table>";
					$("#result").html(result);
					
				}
			});
			//alert("test");
/* 			
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
			//#result 에 받아온 것을 뿌려달라 */
			
		}