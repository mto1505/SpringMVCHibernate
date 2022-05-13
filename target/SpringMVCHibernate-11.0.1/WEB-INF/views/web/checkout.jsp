<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="orderUrl" value="/order/add" />
<c:url var="detailUrl" value="/apple" />
<c:url var="addCartItem" value="/cart/add" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="section">
	<!-- container -->
	<div class="container">
		<!-- row -->
		<div class="row">

			<div class="col-md-7">
				<!-- Shiping Details -->
				<div class="shiping-details">
					<div class="section-title">
						<h3 class="title">Địa chỉ giao hàng</h3>
					</div>
					<div class="input-checkbox">
						<input type="checkbox" id="shiping-address"> <label
							for="shiping-address"> <span></span> Giao đến địa chỉ khác ?
						</label>
						<div class="caption">
							<div class="form-group col-lg-5 sm-2">
							<label for="order-province">Tỉnh/Thành phố</label>
							<select id="order-province" class="form-control" name="calc_shipping_provinces" required="">
								<option value="">Tỉnh / Thành phố</option>
							</select> 
							<label for="order-district">Quận/Huyện</label>
							<select id="order-district" class="form-control" name="calc_shipping_district" required="">
								<option value="">Quận / Huyện</option>
							</select> 
							<input class="billing_address_1" name="" type="hidden" value="">
							
							<input class="billing_address_2" name="" type="hidden" value="">
							</div>
							<div class="form-group">
								<input id="order-address" class="input" type="text" name="diaChi"
									placeholder="Địa chỉ">
							</div>
							
						</div>
					</div>
				</div>
				<!-- /Shiping Details -->

				<!-- Order notes -->
				<div class="order-notes">
					<textarea class="input"  placeholder="Lời nhắn"></textarea>
				</div>
				<!-- /Order notes -->
			</div>

			<!-- Order Details -->
			<div class="col-md-5 order-details">
				<div class="section-title text-center">
					<h3 class="title">Đơn Hàng</h3>
				</div>
				<div class="order-summary">
					<div class="order-col">
						<div>
							<strong>Sản phẩm</strong>
						</div>
						<div>
							<strong>Tổng cộng</strong>
						</div>
					</div>
					<div class="order-products">
						<c:forEach  items="${myCartItems}" var="itemCart" >
						<div class="order-col">
							<div><strong>${itemCart.value.soLuong}</strong>x ${itemCart.value.chiTietSanPham.sanPham.ten}</div>
							<div><strong>${itemCart.value.chiTietSanPham.donGia}</strong></div>
						</div>
						</c:forEach>
						
					
					</div>
					<div class="order-col">
						<strong>Vận chuyển</strong>
						<div>
							<strong class="text-success">Miễn phí</strong>
						</div>
					</div>
					<div class="order-col">
						<div>
							<strong>Tổng</strong>
						</div>
						<div>
							<strong class="order-total">${myCartTotal}</strong>
						</div>
					</div>
				</div>
				<div class="payment-method">
					<!-- <div class="input-radio">
						<input type="radio" name="payment" id="payment-1"> <label
							for="payment-1"> <span></span> Direct Bank Transfer
						</label>
						<div class="caption">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
						</div>
					</div>
					<div class="input-radio">
						<input type="radio" name="payment" id="payment-2"> <label
							for="payment-2"> <span></span> Cheque Payment
						</label>
						<div class="caption">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
						</div>
					</div>
					<div class="input-radio">
						<input type="radio" name="payment" id="payment-3"> <label
							for="payment-3"> <span></span> Paypal System
						</label>
						<div class="caption">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
						</div>
					</div> -->
				</div>
				<div class="input-checkbox">
					<input type="checkbox" id="terms"> <label for="terms">
						<span></span> Đồng ý các <a href="#">quy định &
							điều khoản</a>
					</label>
				</div>
				<button type="submit" onclick="processOrder()" class="primary-btn order-submit">Đặt hàng</button>
			</div>
			<!-- /Order Details -->
		</div>
	</div>
	<!-- /row -->
</div>
<!-- /container -->
</div>
<form action="${orderUrl}" id="form-checkout" modelAttribute="order" method="post">
	
<!-- <input type="hidden" name="id" value=""></input> -->
<!-- <input  type="hidden" name="tinhTrang" value=""></input> -->

<input  type="hidden" name="diaChi" value=""></input>

<input  type="hidden" name="chuThich" value=""></input>

<%-- <c:forEach items="${myCartItems}" var="item" varStatus="loop">
<input type="hidden" name="chiTietDonDatHangs[${loop.index}].idCtsp" value="${item.value.idIdCtsp}">
<input type="hidden" name="chiTietDonDatHangs[${loop.index}].soLuong" value="${item.value.soLuong}">
</input>

</c:forEach> --%>


</form>

<script
	src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
<script>

	//set value to input DiaChi and ChuThich
	function processOrder(){
		console.log(this.event.preventDefault());
		//event.preventDefault();
		//get note 
		var $noteOder=$(".order-notes textarea").val();
		//get diaChi
		var $district=$(".billing_address_1").val();
		var $province=$(".billing_address_2").val();
		var $diaChi= $province+","+$district+","+$("#order-address").val();
		
		//form-checkout
		var $formCheckout=$("form#form-checkout");
		$formCheckout.children("input[name='chuThich']").val($noteOder);
		$formCheckout.children("input[name='diaChi']").val($diaChi);
		
		console.log($formCheckout.children("input[name='chuThich']").val())
		console.log($formCheckout.children("input[name='diaChi']").val())
		//submit
		$formCheckout.submit();
	}
	/* /* function check()
	{	
		var $formCheckout=$("form#form-checkout");
		var inputChuThich=$formCheckout.children("input[name='chuThich']");
		inputChuThich.on("change",function(e){
			console.log("stop");
			if(inputChuThich.val()=="")
			{	console.log("stop");
				return false;
			}
	})
	} */
	
	
	/* $("form#form-checkout").on("submit",function(e){
		e.preventDefault();
		var $formCheckout=$("form#form-checkout");
		var inputChuThich=$formCheckout.children("input[name='chuThich']");
		if(inputChuThich.val()=="")
		{	
			console.log("empty")
			return false;
		}
		console.log(inputChuThich.val())
		return true;
		
		
	})
	$("form#form-checkout").on("submit",function(e){
		
		var $formCheckout=$("form#form-checkout");
		var inputChuThich=$formCheckout.children("input[name='chuThich']");
		console.log("can thiêp input")
		inputChuThich.val("")
		
	
		
	}) */
	 
	
	//<![CDATA[
	if (address_2 = localStorage.getItem('address_2_saved')) {
		$('select[name="calc_shipping_district"] option').each(function() {
			if ($(this).text() == address_2) {
				$(this).attr('selected', '')
			}
		})
		$('input.billing_address_2').attr('value', address_2)
	}
	if (district = localStorage.getItem('district')) {
		$('select[name="calc_shipping_district"]').html(district)
		$('select[name="calc_shipping_district"]').on(
				'change',
				function() {
					var target = $(this).children('option:selected')
					target.attr('selected', '')
					$('select[name="calc_shipping_district"] option').not(
							target).removeAttr('selected')
					address_2 = target.text()
					$('input.billing_address_2').attr('value', address_2)
					district = $('select[name="calc_shipping_district"]')
							.html()
					localStorage.setItem('district', district)
					localStorage.setItem('address_2_saved', address_2)
				})
	}
	$('select[name="calc_shipping_provinces"]')
			.each(
					function() {
						var $this = $(this), stc = ''
						c
								.forEach(function(i, e) {
									e += +1
									stc += '<option value=' + e + '>' + i
											+ '</option>'
									$this
											.html('<option value="">Tỉnh / Thành phố</option>'
													+ stc)
									if (address_1 = localStorage
											.getItem('address_1_saved')) {
										$(
												'select[name="calc_shipping_provinces"] option')
												.each(
														function() {
															if ($(this).text() == address_1) {
																$(this)
																		.attr(
																				'selected',
																				'')
															}
														})
										$('input.billing_address_1').attr(
												'value', address_1)
									}
									$this
											.on(
													'change',
													function(i) {
														i = $this
																.children(
																		'option:selected')
																.index() - 1
														var str = '', r = $this
																.val()
														if (r != '') {
															arr[i]
																	.forEach(function(
																			el) {
																		str += '<option value="' + el + '">'
																				+ el
																				+ '</option>'
																		$(
																				'select[name="calc_shipping_district"]')
																				.html(
																						'<option value="">Quận / Huyện</option>'
																								+ str)
																	})
															var address_1 = $this
																	.children(
																			'option:selected')
																	.text()
															var district = $(
																	'select[name="calc_shipping_district"]')
																	.html()
															localStorage
																	.setItem(
																			'address_1_saved',
																			address_1)
															localStorage
																	.setItem(
																			'district',
																			district)
															$(
																	'select[name="calc_shipping_district"]')
																	.on(
																			'change',
																			function() {
																				var target = $(
																						this)
																						.children(
																								'option:selected')
																				target
																						.attr(
																								'selected',
																								'')
																				$(
																						'select[name="calc_shipping_district"] option')
																						.not(
																								target)
																						.removeAttr(
																								'selected')
																				var address_2 = target
																						.text()
																				$(
																						'input.billing_address_2')
																						.attr(
																								'value',
																								address_2)
																				district = $(
																						'select[name="calc_shipping_district"]')
																						.html()
																				localStorage
																						.setItem(
																								'district',
																								district)
																				localStorage
																						.setItem(
																								'address_2_saved',
																								address_2)
																			})
														} else {
															$(
																	'select[name="calc_shipping_district"]')
																	.html(
																			'<option value="">Quận / Huyện</option>')
															district = $(
																	'select[name="calc_shipping_district"]')
																	.html()
															localStorage
																	.setItem(
																			'district',
																			district)
															localStorage
																	.removeItem(
																			'address_1_saved',
																			address_1)
														}
													})
								})
					})
	//]]>
</script>