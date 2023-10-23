<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<div class="form-group">
			<label for="name"><b>이름</b></label>
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
				<input type="button" id="nameCheckBtn" class="btn btn-info" value="중복확인">
			</div>
			<small id="nameStatusArea"></small>		
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		</div>
	</div>
<script>
$(document).ready(function(){
	$('#nameCheckBtn').on('click', function(){
		let name = $('#name').val().trim();
		// 중복 확인 클릭시 nameCheckBtn 안쪽 태그 초기화
		// -- 안내 문구를 하나만 띄우기 위해
		$(this).empty(); // 자식 태그들을 모두 제거
		// validation
		
		// 이름이 비어있는지 확인
		if(name == ""){
			$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
		}
		
		// 이름 중복 확인 -> 서버에서 확인(DB 조회)
		$.ajax({
			// request
			type:"GET"
			, url:"/lesson06/ex01/is-duplication"
			, data:{"name":name}
		
			// response
			, success:function(data){ // data는 string 또는 JSON -> dictionary
			  // {"code":200, "is_duplication":true}
			  if(data.is_duplication){
				  $('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
			  }
			}
			, error:function(request, status, error){
				alert("중복확인에 실패했습니다.");
			}
		});
	});
	
	// 가입 버튼 클릭
	$('#joinBtn').on('click', function(){
		// alert("가입");
		console.log($('#nameStatusArea').children().length);
		
		// nameStatusArea에 아무 자식 노드(태그)가 없으면 submit을 한다.
		if($('#nameStatusArea').children().length == 0){
			alert("가입 가능");
		} else {
			alert("가입 불가");
		}
	});
});
</script>
</body>
</html>