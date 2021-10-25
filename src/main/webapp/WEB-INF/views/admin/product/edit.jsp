<%-- 
    Document   : list
    Created on : Feb 5, 2021, 10:41:14 AM
    Author     : MinhTo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new-list" />
<c:url var="UpdateSanPham" value="/quan-tri/product" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa sản phẩm</title>


</head>

<body>

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Chỉnh
							sửa sản phẩm</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="row">
							<div class="col-md-12">
								<form action="${UpdateSanPham}?id=${sanPham.getId()}"
									modelAttribute="sanPhamFormData" method="POST" id="form-submit">
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="input-name">Tên sản phẩm</label> <input
												type="text" class="form-control" rules="required"
												id="input-name" name="ten" value="${sanPham.getTen()}">
											<span class="form-message"></span>
										</div>
										<div class="form-group col-md-6">
											<label for="input-monitor">Màn hình</label> <input
												type="text" class="form-control"
												rules="required|min:1|max:100" id="input-monitor"
												name="manHinh" value="${sanPham.getManHinh()}"> <span
												class="form-message"></span>
										</div>
									</div>
									<div class="form-row">
										<div class="form-group col-md-4">
											<label for="input-battery">Pin sạc</label> <input type="text"
												class="form-control" id="input-battery"
												rules="required|min:1|max:50" name="pinSac"
												value="${sanPham.getPinSac()}"> <span
												class="form-message"></span>
										</div>
										<div class="form-group col-md-4">
											<label for="input-sim">Sim</label> <input type="text"
												class="form-control" id="customer-name"
												rules="required|min:1|max:50" name="sim"
												value="${sanPham.getSim()}"> <span
												class="form-message"></span>
										</div>
										<div class="form-group col-md-4">
											<label for="input-loai">Loại sản phẩm</label> <select
												name="loai.id" id="input-loai" class="form-control"
												rules="required">
												<c:forEach var="loai" items="${listLoai}">

													<option value="${loai.getId()}"
														<c:if test="${loai.getId()==sanPham.getLoai().getId()}">selected</c:if>>${loai.getTen()}</option>

												</c:forEach>
											</select> <span class="form-message"></span>
										</div>

										<!-- <div class="form-group col-md-4">
                        <label class="form-check-label" for="checkGenderDefault">Giới tính</label>
                        <div class="form-check" style="margin-top:1.2em;">
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio"  value="Nam" id="gender-default" name="khachHang.gioitinh">
                                <label class="form-check-label" for="gender-default">Nam</label>
                              
                            </div>
                            <div class="form-check-inline">
                                <input class="form-check-input" type="radio" id="gender-female" value="Nữ"name="khachHang.gioitinh">
                                <label class="form-check-label" for="gender-female">Nữ</label> 
                            </div>       
                        </div>
                        <span class="form-message"></span>   
                       
                    </div> -->

									</div>

									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="front-camera">Camera Trước</label> <input
												type="text" class="form-control" id="front-camera"
												rules="required|max:100" name="cameraTruoc"
												value="${sanPham.getCameraTruoc()}"> <span
												class="form-message"></span>
										</div>
										<div class="form-group col-md-6">
											<label for="back-came">Camera Sau</label> <input type="text"
												class="form-control" id="back-camera"
												rules="required|min:1|max:100" name="cameraSau"
												value="${sanPham.getCameraSau()}"> <span
												class="form-message"></span>
										</div>
										<!-- <div class="form-group col-md-6 dateForm">
                        <label for="date">Ngày sinh</label>
                        <input type="text" class="form-control" id="date" name="khachHang.ngaySinh" rules="required" placeholder="MM/DD/YYYY">
                        <span class="form-message"></span>
                    </div> -->
									</div>
									<div class="form-row">
										<div class="form-group">
											<label for="description">Mô tả sản phẩm</label>
											<textarea name="moTa" cols="50" rows="3" class="form-control"
												rules="required|min:1|max:100" id="description" name="moTa">${sanPham.getMoTa()}</textarea>
										</div>


									</div>
									<!-- <div class="form-row">
										<label class="col-form-label" for="fileImage">Hình ảnh</label>
										<div class="form-group form-inline">
											<input class="col-md-2" type="file" name="hinhAnhs[0]"
												id="fileImage" placeholder="Upload file" accept="image/*"
												multiple="multiple" /> 
											<input class="col-md-2" type="file"
												name="hinhAnhs[1]" id="fileImage-1" multiple="multiple"
												placeholder="Upload file" accept="image/*" />
											<input
												class="col-md-2" type="file" name="hinhAnhs[2]"
												id="fileImage-2" multiple="multiple"
												placeholder="Upload file" accept="image/*" />
										</div>

									</div>
									<div class="form-row">
										<div class="form-group form-inline">
											<img class="col-md-2" src="" alt="" width="100px"
												height="100px"> <img class="col-md-2" src="" alt=""
												width="100px" height="100px"> <img class="col-md-2"
												src="" alt="" width="100px" height="100px">
										</div>
									</div> -->

									<button type="submit" class="btn btn-primary"
										id="btnAddOrUpdate">Sửa</button>

								</form>
							</div>
						</div>



						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src='<c:url value="/template/web/js/validator.js" ></c:url>'></script>
	<script>
	
		$('.show-details-btn').on(
				'click',
				function(e) {
					e.preventDefault();
					$(this).closest('tr').next().toggleClass('open');
					$(this).find(ace.vars['.icon']).toggleClass(
							'fa-angle-double-down').toggleClass(
							'fa-angle-double-up');

				});

		$('#simple-table').on('click', 'td input[type=checkbox]', function() {
			var $row = $(this).closest('tr');
			if ($row.is('.detail-row '))
				return;
			if (this.checked)
				$row.addClass(active_class);
			else
				$row.removeClass(active_class);
		});

		/********************************/
		//add tooltip for small view action buttons in dropdown menu
		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});

		//tooltip placement on right or left
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			//var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}

		//And for the first simple table, which doesn't have TableTools or dataTables
		//select/deselect all rows according to table header checkbox
		var active_class = 'active';
		$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on(
				'click',
				function() {
					var th_checked = this.checked;//checkbox inside "TH" table header

					$(this).closest('table').find('tbody > tr').each(
							function() {
								var row = this;
								if (th_checked)
									$(row).addClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', true);
								else
									$(row).removeClass(active_class).find(
											'input[type=checkbox]').eq(0).prop(
											'checked', false);
							});
				});

		//select/deselect a row when the checkbox is checked/unchecked
		$('#simple-table').on('click', 'td input[type=checkbox]', function() {
			var $row = $(this).closest('tr');
			if ($row.is('.detail-row '))
				return;
			if (this.checked)
				$row.addClass(active_class);
			else
				$row.removeClass(active_class);
		});
	
		
		//#####Pagination
		
		/* var totalPages = $
		{
			totalPage
		};
		var currentPage = $
		{
			page
		};
		var limit = 4;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 4,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(10);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		}); */
		
		
		// Validate and CRUD
		  $("#btnAddOrUpdate").click(function(e){

              //e.preventDefault();
               // var data={};
               // var $formArrayDataInput=$('#formSunmit').serializeArray();
               // console.log($formArrayDataInput);
               // var jsonString=JSON.stringify($formArrayDataInput);
               // console.log(jsonString);
               // serialize();
              
       });

       function serialize(dataObject){
           // var elements=$('#formSunmit').children().toArray();
           // console.log(elements);
           

           var arrayObject=Object.entries(dataObject).map(([key,value])=>{
                       return {[key]:value};
               });

           console.log(arrayObject)
           
           var dataJson={};
           
           arrayObject.forEach(element => {
               const propertyName=Object.keys(element)[0];

               let val=Object.values(element)[0];
               console.log(propertyName)
               console.log(val)
                
               var fullName=propertyName;

               var fullNameParts=fullName.split('.');

               var prefix='';
               var stack=dataJson;
               var s={};
               
               for (let index = 0; index < fullNameParts.length-1; index++) {
                   prefix = fullNameParts[index];
                      // console.log(prefix);
                   if(!stack[prefix])
                   {
                        stack[prefix]={};   
                   }
                   stack=stack[prefix]; //THAY ĐỔI STACK, lấy ra prefix cuối
                 //  console.log("sssss",s)              
               }
      
               //     thêm dữ liệu cho prefix cuối 
   
               var prefix2 = fullNameParts[fullNameParts.length - 1];
                if (stack[prefix2]) {
                      var newVal = stack[prefix2] + ',' + val;
                      stack[prefix2] += newVal;
                } else {
                   stack[prefix2] = val;
                }
           });
           return dataJson;

       }


       function edit(data)
       {
           $.ajax({
               url:"/quan-tri/product"
           })
           
       }
		
       var sanPhamObject;
       validForm("#form-submit",{
           // radioGroups:[
           //     "loai.id"     
           // ],
           onSubmit:function(dataObject)
           {
             sanPhamObject= serialize(dataObject);
             console.log(sanPhamObject);
           }
       });
       
  
	</script>
</body>
</html>


