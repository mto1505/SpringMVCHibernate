<%-- 
    Document   : list
    Created on : Feb 5, 2021, 10:41:14 AM
    Author     : MinhTo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new-list" />
<c:url var="editSanPham" value="/quan-tri/product"/>
<c:url var="addSanPham" value="/quan-tri/product"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-size:16px">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách sản shẩm</title>


</head>

<body style="font-size:16px">

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Quản
							lí sản phẩm</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				     
           

            </div>
				<div class="row">
					<div class="col-md-12">
						<!-- PAGE CONTENT BEGINS -->
								<button class="btn btn-primary" onclick="location.href='${addSanPham}?id=${sanPham.getId()}&type=add'">Thêm sản phẩm</button>
									<table id="simple-table"
										class="table table-bordered table-hover table-sm" >
										<thead>
											<tr>
												<th class="center"><label class="pos-rel"> <input
														type="checkbox" class="ace" /> <span class="lbl"></span>
												</label></th>

												<th class="detail-col" colspan="1">Details</th>
												<th colspan="1">Mã sản phẩm</th>
												<th colspan="1">Tên sản phẩm</th>
												<th colspan="1">Camera sau</th>
												<th colspan="1">Camera trước</th>
												<th colspan="2">Màn hình</th>
												<th colspan="1">Pin sạc</th>
												<th colspan="1">Sim</th>
												<th colspan="1">Loại sản phẩm</th>
												<th colspan="2" >Mô tả</th>
												<th>
												<div class="btn-group">
														<div class="d.none d-sm-block action-buttons">
															 <a class="red" href="#"
																<%-- href="${editSanPham}?id=${sanPham.getId()}&type=edit" --%>
																>
															 <i class="ace-icon fa	 fa-trash-o bigger-130"></i>
			
															</a> 
														</div>
													</div>
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="sanPham" items="${listSanPham}">
												<tr>
													<td class="center"><label class="pos-rel"> <input
															type="checkbox" class="ace" /> <span class="lbl"></span>
													</label></td>

													<td colspan="1">
														<div class="action-buttons">
															<a href="#" class="green bigger-140 show-details-btn"
																title="Show Details"> <i
																class="ace-icon fa fa-angle-double-down"></i> <span
																class="sr-only">Details</span>
															</a>
														</div>
													</td>
													<td colspan="1">${sanPham.getId()}</td>
													<td  colspan="1">${sanPham.getTen()}</td>
													<td colspan="1" >${sanPham.getCameraSau()}</td>
													<td colspan="1">${sanPham.getCameraTruoc()}</td>
													<td colspan="2">${sanPham.getManHinh()}</td>
													<td colspan="1">${sanPham.getPinSac()}</td>
													<td colspan="1">${sanPham.getSim()}</td>
													<td colspan="1">${sanPham.getLoai().getTen()}</td>
													<td colspan="2">${sanPham.getMoTa()}</td>
													<td>
														<div class="btn-group">
														<div class="d.none d-sm-block action-buttons">
															<!-- <a class="blue" href="#"> <i
																class="ace-icon fa fa-search-plus bigger-130"></i>
															</a> --> 
															<a class="green"
																href="${editSanPham}?id=${sanPham.getId()}&type=edit">
																<i class="ace-icon fa fa-pencil bigger-130"></i>
															</a> <a class="red" href="#"> <i
																class="ace-icon fa fa-trash-o bigger-130"></i>
															</a>
														</div>
													</div>

														<div class="d-block d-md-none btn-group">
															<div class="inline pos-rel">
																<button
																	class="btn btn-minier btn-primary dropdown-toggle"
																	data-toggle="dropdown" data-position="auto">
																	<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
																</button>

																<ul
																	class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																	<li><a href='${editSanPham}?id=${sanPham.getId()}&type=edit' class="tooltip-info"
																		data-rel="tooltip" title="View"> <span
																			class="blue"> <i
																				class="ace-icon fa fa-search-plus bigger-120"></i>
																		</span>
																	</a></li>

																	<li><a href="#" class="tooltip-success"
																		data-rel="tooltip" title="Edit"> <span
																			class="green"> <i
																				class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																		</span>
																	</a></li>

																	<li><a href="#" class="tooltip-error"
																		data-rel="tooltip" title="Delete"> <span
																			class="red"> <i
																				class="ace-icon fa fa-trash-o bigger-120"></i>
																		</span>
																	</a></li>
																</ul>
															</div>
														</div>
													</td>
												</tr>
												<tr class="detail-row">
													<td><div class="table-detail">
															<div class="row"></div>
														</div></td>
													<td colspan="12">
														<div class="table-detail">
															<div class="row">
																<div class="col-xs-12 col-sm-12 ">
																	<table class="table">
																		<thead>

																			<tr>
																				<th>ID</th>

																				<th>Đơn giá</th>

																				<th>Số lượng</th>

																				<th>Bộ nhớ</th>

																				<th>Chip</th>

																				<th>Ram</th>

																				<th>Màu</th>
																			</tr>
																		</thead>
																		<tbody>
																			<c:forEach var="ctsp"
																				items="${sanPham.getChiTietSanPhams()}">
																				<tr>
																					<td>${ctsp.getId()}</td>
																					<td>${ctsp.getDonGia()}</td>
																					<td>${ctsp.getSoLuong()}</td>
																					<td>${ctsp.getBoNho().getDungLuong()}</td>
																			
																					<td>${ctsp.getChip().getTen()}</td>
																					<td>${ctsp.getRam().getDungLuong()}</td>
																					<td>${ctsp.getMau().getTen()}</td>

																					<td>
																						<div class="d-none d-md-block  btn-group">
																							<button class="btn btn-xs btn-success">
																								<i class="ace-icon fa fa-check bigger-120"></i>
																							</button>

																							<button class="btn btn-xs btn-info">
																								<i class="ace-icon fa fa-pencil bigger-120"></i>
																							</button>

																							<button class="btn btn-xs btn-danger">
																								<i class="ace-icon fa fa-trash-o bigger-120"></i>
																							</button>

																							<button class="btn btn-xs btn-warning">
																								<i class="ace-icon fa fa-flag bigger-120"></i>
																							</button>
																						</div>

																						<div class="d-block d-md-none">
																							<div class="inline pos-rel">
																								<button
																									class="btn btn-minier btn-primary dropdown-toggle"
																									data-toggle="dropdown" data-position="auto">
																									<i
																										class="ace-icon fa fa-cog icon-only bigger-110"></i>
																								</button>

																								<ul
																									class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																									<li><a href="#" class="tooltip-info"
																										data-rel="tooltip" title="View"> <span
																											class="blue"> <i
																												class="ace-icon fa fa-search-plus bigger-120"></i>
																										</span>
																									</a></li>

																									<li><a href="#" class="tooltip-success"
																										data-rel="tooltip" title="Edit"> <span
																											class="green"> <i
																												class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																										</span>
																									</a></li>

																									<li><a href="#" class="tooltip-error"
																										data-rel="tooltip" title="Delete"> <span
																											class="red"> <i
																												class="ace-icon fa fa-trash-o bigger-120"></i>
																										</span>
																									</a></li>
																								</ul>
																							</div>
																						</div>
																					</td>
																				</tr>
																			</c:forEach>

																		</tbody>
																	</table>

																	<table class="table">
																		<thead>
																			<tr aria-colspan="4">
																				<th colspan="1">#</th>
																				<th colspan="1">Hình ảnh</th>
																				<th></th>
																			</tr>
																		</thead>
																		<tbody>


																			<c:forEach var="hinhAnh" items="${listHinhAnh}">
																				<%-- 							<tr> 
																			<td>Helllo ${hinhAnh.getSanPham().getTen()} +++${sanPham.getId()}  +idddđ+ ${hinhAnh.getSanPham().getId()}</td>
																		</tr> --%>
																				<c:if
																					test="${hinhAnh.getSanPham().getId()==sanPham.getId()}">
																					<tr>
																						<td>${hinhAnh.getId()}</td>
																						<td> 
																						<img alt="${sanPham.getTen()}" src="<c:url value='${hinhAnh.getPhotosImagePath()}'/>">
																						
																						</td>
																						<td>
																							<div class="d-none d-md-block action-buttons">
																								<a class="blue" href="#"> <i
																									class="ace-icon fa fa-search-plus bigger-130"></i>
																								</a> <a class="green" href="#"> <i
																									class="ace-icon fa fa-pencil bigger-130"></i>
																								</a> <a class="red" href="#"> <i
																									class="ace-icon fa fa-trash-o bigger-130"></i>
																								</a>
																							</div>

																							<div class="d-block d-md-none">
																								<div class="inline pos-rel">
																									<button
																										class="btn btn-minier btn-yellow dropdown-toggle"
																										data-toggle="dropdown" data-position="auto">
																										<i
																											class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																									</button>

																									<ul
																										class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																										<li><a href="#" class="tooltip-info"
																											data-rel="tooltip" title="View"> <span
																												class="blue"> <i
																													class="ace-icon fa fa-search-plus bigger-120"></i>
																											</span>
																										</a></li>

																										<li><a href="#" class="tooltip-success"
																											data-rel="tooltip" title="Edit"> <span
																												class="green"> <i
																													class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																											</span>
																										</a></li>

																										<li><a href="#" class="tooltip-error"
																											data-rel="tooltip" title="Delete"> <span
																												class="red"> <i
																													class="ace-icon fa fa-trash-o bigger-120"></i>
																											</span>
																										</a></li>
																									</ul>
																								</div>
																							</div>
																						</td>
																					</tr>


																				</c:if>

																			</c:forEach>


																			</tr>

																		</tbody>
																	</table>


																</div>
															</div>
													</td>
												</tr>


											</c:forEach>

										</tbody>
									</table>
									<ul class="pagination" id="pagination"></ul>
									<form action="<c:url value='/quan-tri/xe-may/danh-sach'/>"
										id="formSubmit" method="get">
										<input type="hidden" value="" id="page" name="page" /> <input
											type="hidden" value="" id="maxPageItem" name="limit" /> <input
											type="hidden" value="" id="sortName" name="sortName" /> <input
											type="hidden" value="" id="sortBy" name="sortBy" /> <input
											type="hidden" value="" id="type" name="type" />
									</form>
								

						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

			</div>
		</div>
	</div>

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
	</script>
</body>
</html>


