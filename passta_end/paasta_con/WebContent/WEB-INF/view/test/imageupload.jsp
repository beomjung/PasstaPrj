<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>파일 업로드 예제</h1>
	
	<!-- 
	<form method="post" action="/testFileUplod"
		enctype="multipart/form-data">
		<label>파일:</label> <input multiple="multiple" type="file" name="file">
		<input id="btnUpload" type="submit" value="upload">
	</form>
	 -->
	

	<div class="profile-card">
		
		<form id="uploadForm" enctype="multipart/form-data">
			<div class="d-flex align-items-center">
				<div class="image">
					<img id="preview-image" src=""
						class="rounded" width="100%" alt="My Image">
				</div>
			</div>
			<div id="input-image"
				class="button mt-2 d-flex flex-row align-items-center">
				<input type="file" id="file" name="testFileUpload"
					onchange="changeValue(this)" style="display: none" />
					
				<button class="btn btn-sm btn-primary w-100" id="btn-upload"
					style="margin-right: 2px;">Select File</button>
					
				<button id="btnUpload" class="btn btn-sm btn-primary w-100"
					style="margin-left: 2px;">Register</button>
			</div>
		</form>
		
	</div>
</body>
<script type="text/javascript">
		$(function () {
			$('#btn-upload').click(function (e) {
				e.preventDefault();
				$('#file').click();
			});
		});
		
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		       
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            console.log("previewImage : " + previewImage)
		            previewImage.src = e.target.result
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image")
		inputImage.addEventListener("change", e => {
		    readImage(e.target)
		})
</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	$('#btnUpload').on('click', function(event) {
	    event.preventDefault();
	    
	    var form = $('#uploadForm')[0]
	    console.log("form : " + form.toString());
	    var data = new FormData(form);
	    $('#btnUpload').prop('disabled', true);
		
	    $.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
	        url: "/testFileUpload.do",
	        data: data,
	        processData: false,
	        contentType: false,
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	$('#btnUpload').prop('disabled', false);
	        	swal('등록이 성공하였습니다.')
	        },
	        error: function (e) {
	            $('#btnUpload').prop('disabled', false);
	            swal('등록이 실패하였습니다.');
	        }
	    });
	})
</script>
</html>