

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form
		action='<c:url value="/quan-tri/product/upload_ckeditor"></c:url>'
		modelAttribute="sanPhamDTO" commandName="hinhAnhs" method="POST"
		id="form-submit" enctype="multipart/form-data">


		<input class="" type="file" name="upload" id="fileImage-2"
			placeholder="Upload file" accept="image/*" multiple="multiple" />
		<button type="submit">Send to sever</button>



	</form>
<script type="text/javascript">
var editor = '';
$(document).ready(function () {
	 	
	     editor = CKEDITOR.replace('description',
	    		 {
	    	 filebrowserBrowseUrl : 'ckfinder/ckfinder.html',
	    	 filebrowserUploadUrl :'/quan-tri/product/upload_ckeditor',
	    	 filebrowserImageUploadUrl:''
	    		 }
//	    		 {
//				filebrowserBrowseUrl : 'ckfinder/ckfinder.html',
//				filebrowserImageBrowseUrl : 'ckfinder/ckfinder.html?type=Images',
//				filebrowserFlashBrowseUrl : 'ckfinder/ckfinder.html?type=Flash',
//				filebrowserUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
//				filebrowserImageUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
//				filebrowserFlashUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
//		 }
	     );

	   
	 });
</script>


</body>
</html>