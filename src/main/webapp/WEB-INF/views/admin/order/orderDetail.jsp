<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
				<div class="row">
					<div class="col-md-12">
						<!-- PAGE CONTENT BEGINS -->

						<table id="simple-table"
							class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th class="center"><label class="pos-rel"> <input
											type="checkbox" class="ace" /> <span class="lbl"></span>
									</label>
									</th>
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
									<tr >
										<td class="center"><label class="pos-rel"> <input
												type="checkbox" class="ace" /> <span class="lbl"></span>
										</label></td>
										<td colspan="1">
											<div class="action-buttons">
												<a href="${DetailOrder}/${dondathang.getId()}" class="green bigger-140 show-details-btn"
													title="Show Details"> <i
													class="ace-icon fa fa-angle-double-down"></i> <span
													class="sr-only">Details ${dondathang.diaChi} </span>
												</a>
											</div>
										</td>
										<td colspan="1">${dondathang.getId()}</td>
										<td colspan="1">${dondathang.getKhachHang().getSoDienThoai()}</td>
										<td colspan="3">${dondathang.diaChi not empty ? dondathang.diaChi : dondathang.getKhachHang().getDiaChi() }</td>
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
					//e.preventDefault();
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

	</script>
</body>
</html>