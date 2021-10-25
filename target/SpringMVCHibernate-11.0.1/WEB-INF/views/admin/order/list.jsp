<%-- 
    Document   : list
    Created on : Feb 5, 2021, 10:41:14 AM
    Author     : MinhTo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new-list" />
<c:url var="editSanPham" value="/quan-tri/product" />
<c:url var="DetailOrder" value="/quan-tri/order/danh-sach" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-size:16px">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách đơn đặt hàng</title>
</head>

<body style="font-size: 16px">
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Quản
							lí đơn đặt hàng</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row justify-content-md-center">
					<div class="col-md-8">
						<h5>Chi tiết đơn đặt hàng</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col" colspan="2" >Tên sản phẩm</th>

									<th scope="col" colspan="2"  >Bộ nhớ</th>

									<th scope="col" colspan="2" >Chip</th>

									<th scope="col" colspan="2" >Ram</th>

									<th scope="col" colspan="1" >Màu</th>
									<th scope="col" colspan="2">Đơn giá</th>

									<th scope="col" colspan="1">Số lượng</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${detailOrders!=null}">
									<c:forEach items="${detailOrders}" var="detailOrder">
									<tr>
										<td colspan="2" >${detailOrder.getChiTietSanPham().getSanPham().getTen()}</td>
										<td colspan="2" >${detailOrder.getChiTietSanPham().getBoNho().getDungLuong()}</td>
										<td colspan="2" >${detailOrder.getChiTietSanPham().getChip().getTen()}</td>
										<td colspan="2" >${detailOrder.getChiTietSanPham().getRam().getDungLuong()}</td>
										<td colspan="1" >${detailOrder.getChiTietSanPham().getMau().getTen()}</td>
										<td colspan="2" >${detailOrder.getChiTietSanPham().getDonGia()}</td>
										<td colspan="1">${detailOrder.getChiTietSanPham().getSoLuong()}</td>
										<td></td>
									</tr>
								</c:forEach>
								</c:if>
						

							</tbody>
						</table>
					</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<!-- PAGE CONTENT BEGINS -->

							<table id="simple-table"
								class="table table-bordered table-hover table-sm">
								<thead>
									<tr>
										<th class="center"><label class="pos-rel"> <input
												type="checkbox" class="ace" /> <span class="lbl"></span>
										</label></th>

										<th class="detail-col" colspan="1">Details</th>
										<th colspan="1">Mã đơn</th>
										<th colspan="1">Số điện thoại</th>
										<th colspan="3">Địa chỉ</th>
										<th colspan="3">Khách hàng</th>
										<th colspan="2">Thời gian</th>
										<th colspan="1">Tình trạng</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dondathang" items="${listOrder}">
										<tr>
											<td class="center"><label class="pos-rel"> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
											</label></td>
											<td colspan="1">
												<div class="action-buttons">
<!-- 													page=1&limit=10&sortName=title&sortBy=desc-->
													<a href="${DetailOrder}?id=${dondathang.getId()}&page=${currentPage}&trangThai=${trangThai}"
														class="green bigger-140 show-details-btn"
														title="Show Details"> <i
														class="ace-icon fa fa-angle-double-down"></i> <span
														class="sr-only">Details</span>
													</a>
												</div>
											</td>
											<td colspan="1">${dondathang.getId()}</td>
											<td colspan="1">${dondathang.getKhachHang().getSoDienThoai()}</td>
											<td colspan="3">${dondathang.getKhachHang().getDiaChi()}</td>
											<td colspan="3">${dondathang.getKhachHang().getHoVaTenDem()}
												${dondathang.getKhachHang().getTen()}</td>
											<td colspan="2">${dondathang.getThoiGian()}</td>
											<td colspan="1">${dondathang.getTinhTrang()}</td>
											<td>
												<div class="btn-group">
													<div class="d.none d-sm-block action-buttons">
														<a class="blue" href="#"> <i
															class="ace-icon fa fa-search-plus bigger-130"></i>
														</a> <a class="green"
															href="${editSanPham}?id=${sanPham.getId()}&type=edit">
															<i class="ace-icon fa fa-pencil bigger-130"></i>
														</a> <a class="red" href="#"> <i
															class="ace-icon fa fa-trash-o bigger-130"></i>
														</a>
													</div>
												</div>

												<div class="d-block d-md-none btn-group">
													<div class="inline pos-rel">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<li><a
																href='${editSanPham}?id=${sanPham.getId()}&type=edit'
																class="tooltip-info" data-rel="tooltip" title="View">
																	<span class="blue"> <i
																		class="ace-icon fa fa-search-plus bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="Edit"> <span class="green">
																		<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="Delete"> <span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-120"></i>
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
							<ul class="pagination" id="pagination"></ul>
							<form action="<c:url value='/quan-tri/order/danh-sach'/>"
								id="formSubmit" method="get">
								<input type="hidden" value="" id="page" name="page" /> <input
									type="hidden" value="" id="maxPageItem" name="limit" /> <input
									type="hidden" value="" id="sortName" name="sortName" /> <input
									type="hidden" value="" id="sortBy" name="sortBy" /> 
										 <input type="hidden" value="${trangThai}" id="trangThai" name="trangThai" /> 	
									<input type="hidden" value="" id="idDonHang" name="id" />						
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
						//e.preventDefault();
						$(this).closest('tr').next().toggleClass('open');
						$(this).find(ace.vars['.icon']).toggleClass(
								'fa-angle-double-down').toggleClass(
								'fa-angle-double-up');

					});

			$('#simple-table').on('click', 'td input[type=checkbox]',
					function() {
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

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
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
												'input[type=checkbox]').eq(0)
												.prop('checked', true);
									else
										$(row).removeClass(active_class).find(
												'input[type=checkbox]').eq(0)
												.prop('checked', false);
								});
					});

			//select/deselect a row when the checkbox is checked/unchecked
			$('#simple-table').on('click', 'td input[type=checkbox]',
					function() {
						var $row = $(this).closest('tr');
						if ($row.is('.detail-row '))
							return;
						if (this.checked)
							$row.addClass(active_class);
						else
							$row.removeClass(active_class);
					});

			var totalPages = ${totalPage};
			var currentPage =${currentPage};
			var limit = 5;//số item hiển thị lên
			$(function() {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : totalPages,
					visiblePages : 5, //số trang hiển thị
					startPage : currentPage,
					onPageClick : function(event, page) {
						if (currentPage != page) {
							$('#maxPageItem').val(limit);
							$('#page').val(page);
							$('#sortName').val('tinhTrang');
							$('#sortBy').val('desc');
						
							$('#formSubmit').submit();
						}
					}
				});
			}); 
		</script>
</body>
</html>


