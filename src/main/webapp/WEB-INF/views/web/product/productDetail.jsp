<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 11:14:39 PM
    Author     : MinhTo
--%>
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:url var="addCartItem" value="/cart/add" />
<!DOCTYPE html>
<!-- SECTION -->
<c:url var="detailUrl" value="/apple" />
<c:set var="categories" value="${categories}" scope="application" />
	<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- Product main img -->
				
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
						<c:forEach items="${hinhAnhs}" var="hinhAnh" >
							<div class="product-preview">
								<img src='<c:url value="${hinhAnh.getPhotosImagePath()}"></c:url>' alt="">
							</div>
			</c:forEach>
						</div>
					</div>
				
					<%-- <div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<div class="product-preview">
								<img src='<c:url value="/template/web/img/product01.png"></c:url>' alt="">
							</div>

						</div>
					</div> --%>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					
					<div class="col-md-2  col-md-pull-5">
					
						<div id="product-imgs">
						<c:forEach items="${hinhAnhs}" var="hA" >
							<div class="product-preview">
									<img src='<c:url value="${hA.getPhotosImagePath()}"></c:url>' alt="">
							</div>
							</c:forEach>
						</div>
							
					</div>
					
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${ctsp.sanPham.ten}</h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
								<a class="review-link" href="#">Thêm bình luận</a>
							</div>
							<div>
								
								<h3 class="product-price">	<fmt:formatNumber maxFractionDigits="1"  value = "${ctsp.donGia}" type = "number"/>
								<!-- <del class="product-old-price">$990.00</del> -->
								</h3>
								<span class="product-available">Còn Hàng</span>
							</div>
							<p></p>

							<div class="product-options">
								<label>
									Bộ nhớ
									<select class="input-select"  onChange="window.location.href=this.value">
										<c:forEach items="${ctsps}" var="c">
										<option value="${detailUrl}/${c.id}?mau=${c.mau.ten}&boNho=${c.boNho.dungLuong}" <c:if test='${param.boNho==c.boNho.dungLuong}'>selected</c:if>> 
											${c.boNho.dungLuong}
										</option>
										</c:forEach>
										
									</select>
								</label>
								<label>
									Màu
									<select onChange="window.location.href=this.value" class="input-select">
										<c:forEach items="${ctsps}" var="c">
										<option value="${detailUrl}/${c.id}?mau=${c.mau.ten}&boNho=${c.boNho.dungLuong}" <c:if test='${param.mau==c.mau.ten}'>selected </c:if>>
										${c.mau.ten}
										</option>
										</c:forEach>
									</select>
								</label>
							</div>

							<div class="add-to-cart">
								<div class="qty-label">
									Qty
									<div class="input-number">
										<input type="number" value="1">
										<span class="qty-up">+</span>
										<span class="qty-down">-</span>
									</div>
								</div>
								<button class="add-to-cart-btn" id="${ctsp.id}"><i class="fa fa-shopping-cart"></i> Thêm vô giỏ</button>
							</div>

							

							

							<ul class="product-links">
								<li>Chia sẽ:</li>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-envelope"></i></a></li>
							</ul>

						</div>
					</div>
					
					
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
								<li><a data-toggle="tab" href="#tab2">Details</a></li>
								<li><a data-toggle="tab" href="#tab3">Reviews (3)</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">
											<p></p>
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<div class="col-md-12">
											${ctsp.sanPham.moTa}
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								<!-- tab3  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										<!-- Rating -->
										<div class="col-md-3">
											<div id="rating">
												<div class="rating-avg">
													<span>4.5</span>
													<div class="rating-stars">
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star-o"></i>
													</div>
												</div>
												<ul class="rating">
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 80%;"></div>
														</div>
														<span class="sum">3</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 60%;"></div>
														</div>
														<span class="sum">2</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
												</ul>
											</div>
										</div>
										<!-- /Rating -->

										<!-- Reviews -->
										<div class="col-md-6">
											<div id="reviews">
												<ul class="reviews">
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p></p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p></p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
												</ul>
												<ul class="reviews-pagination">
													<li class="active">1</li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												</ul>
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">
											<div id="review-form">
												<form class="review-form">
													<input class="input" type="text" placeholder="Your Name">
													<input class="input" type="email" placeholder="Your Email">
													<textarea class="input" placeholder="Your Review"></textarea>
													<div class="input-rating">
														<span>Your Rating: </span>
														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div>
													</div>
													<button class="primary-btn">Submit</button>
												</form>
											</div>
										</div>
										<!-- /Review Form -->
									</div>
								</div>
								<!-- /tab3  -->
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

<form id="form-add-to-cart" action="${addCartItem}" method="GET">
	<input name="idCTSP" type="hidden" value="">
	<input name="quality" type="hidden" value="">
</form>
<script>
$(document).ready(function() {
    // jQuery code goes here
  
	$(".add-to-cart-btn").on("click",function(e){
		console.log($(this))
		var $productID=$(this).attr("id");
		var $quality=$('div input[type="number"]').val();
		var $idInputForm=$("#form-add-to-cart").children("input[name='idCTSP']");
		$idInputForm.val($productID);
		
		var $qualityInputForm=$("#form-add-to-cart").children("input[name='quality']");
		$qualityInputForm.val($quality);
		
		console.log($productID);
		console.log($quality);
		$("form#form-add-to-cart").submit();
	})
		

	$(".delete").on("click",function(event){
		
		console.log($(this))
		var $productID=$(this).attr("id");
	
		var $idInputForm=$("#cart-item-delete-form").children("input[name='idCTSP']");
		$idInputForm.val($productID);
		
	
		console.log($productID);
		
		$("#cart-item-delete-form").submit();
	})

});

</script>

