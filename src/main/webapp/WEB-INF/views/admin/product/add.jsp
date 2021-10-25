<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Thêm sản phẩm</title>
</head>
<body>
<div class="container">

	<div>Thêm sản phẩm</div>

	<form:form id="form-submit" commandName="hinhAnhs"
		action="http://localhost:8080/SpringMVCHibernate/quan-tri/product?id=&type=add"
		modelAttribute="hinhAnhs" method="POST" enctype="multipart/form-data">
		 <fieldset>
		 <input name="loai.ten" value="minh" /> <input
			name="chiTietSanPhams[0].donGia" value="1000" /> <input
			name="chiTietSanPhams[0].soLuong" value="10" /> <input
			name="chiTietSanPhams[0].boNho.dungLuong" value="5000" /> <input
			name="chiTietSanPhams[0].chip.ten" value="meditek" /> <input
			name="chiTietSanPhams[1].boNho.dungLuong" value="6000" /> <input
			name="chiTietSanPhams[1].soLuong" value="20" /> <input
			name="chiTietSanPhams[1].donGia" value="2000" /> <input
			name="chiTietSanPhams[1].chip.ten" value="snap" /> 
			
			 <div class="form-row">
                <label class="col-form-label" for="fileImage">Hình ảnh</label>
                <div class="form-group form-inline">
                    <input class="col-md-2" type="file"  name="hinhAnhs[0]" id="fileImage" placeholder="Upload file"
                        accept="image/*" multiple="multiple" />

                     <input class="col-md-2" type="file" name="hinhAnhs[1]" id="fileImage-1" multiple="multiple" placeholder="Upload file"
                        accept="image/*" />

                    <input class="col-md-2" type="file" name="hinhAnhs[2]" id="fileImage-2" multiple="multiple"placeholder="Upload file"
                        accept="image/*" /> 
                </div>

            </div>
            <div class="form-row">
                <div class="form-group form-inline">
                    <img class="col-md-2" src="" alt="" width="100px" height="100px">
                    <img class="col-md-2" src="" alt="" width="100px" height="100px">
                    <img class="col-md-2" src="" alt="" width="100px" height="100px">
                </div>
            </div>
		<button type="submit"></button>
		 </fieldset>
	</form:form>
	</div>
<script type="text/javascript">
//Upload and preview Image
// Get element img 
var imageElements = $("img").toArray();
//Get element input files

var imageElementInput = $("input[type='file']").toArray();
imageElementInput.forEach((item, index) => {
    item.onchange = evt => {
       // var reader = new FileReader();
        var file = evt.target.files[0];
        if (file) {
            var output = $(imageElements[index]).src;
            output = URL.createObjectURL(file);
            $(imageElements[index]).attr("src",output)
            console.log(output);
            // reader.onload = function () {
            //     $(imageElements[index]).attr("src",output)
            // }
            // reader.readAsDataURL($("input[type='file']").get(index).files[0]);

            output.onload = function () {
                URL.revokeObjectURL(output.src);
            }
        }
    }
}
);</script>
</body>

</html>