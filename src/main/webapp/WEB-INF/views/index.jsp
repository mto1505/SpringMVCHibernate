<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 11:14:39 PM
    Author     : MinhTo
--%>
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url var="detailUrl" value="/apple/" />
<c:url var="addCartItem" value="/cart/add" />
<!DOCTYPE html>
<!-- SECTION -->

<c:set var="categories" value="${categories}" scope="application" />
<div class="section">
	<!-- container -->
	<div class="container">
		<!-- row -->
		<div class="row">

			<!-- section title -->
			<div class="col-md-12">
				<div class="section-title">
					<h3 class="title">Top selling</h3>
					<div class="section-nav">
						<ul class="section-tab-nav tab-nav">
							<li class="active"><a data-toggle="tab" href="#tab2">Iphone</a></li>
							
							<li><a data-toggle="tab" href="#tab2">Ipad</a></li>
							<li><a data-toggle="tab" href="#tab2">Macbook</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /section title -->

			<!-- Products tab & slick -->
			<div class="col-md-12">
				<div class="row">
					<div class="products-tabs">
						<!-- tab -->
						<div id="tab2" class="tab-pane fade in active">
							<div class="products-slick" data-nav="#slick-nav-2">
								<!-- product -->
						
								<c:forEach var="ctSanPhamPage" items="${listSanPhamPage}">
								<div class="product">
									<div class="product-img">
									<!-- 	/template/web/img/product06.png' ${sanPhamPage.getHinhAnhSps()[0].getPhotosImagePath()}-->
										<img src="<c:url value='${ctSanPhamPage.sanPham.getHinhAnhSps()[0].getPhotosImagePath()}'/>"
											alt="">
										<div class="product-label">
											<span class="sale">-30%</span> <span class="new">NEW</span>
										</div>
									</div>
									<div class="product-body">
										<p class="product-category">${ctSanPhamPage.sanPham.getLoai().ten}</p>
										<h3 class="product-name">
											<a href="${detailUrl}/${ctSanPhamPage.id}">${ctSanPhamPage.sanPham.ten}</a>
										</h3>
										<h4 class="product-price">
										<fmt:formatNumber maxFractionDigits="1"  value = "${ctSanPhamPage.donGia}  " type = "number"/> 
					 
											<!-- <del class="product-old-price">$990.00</del> -->
										</h4>
										<div class="product-rating">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
										<div class="product-btns">
											<button class="add-to-wishlist">
												<i class="fa fa-heart-o"></i><span class="tooltipp">add
													to wishlist</span>
											</button>
											<button class="add-to-compare">
												<i class="fa fa-exchange"></i><span class="tooltipp">add
													to compare</span>
											</button>
											<button class="quick-view">
												<i class="fa fa-eye"></i><span class="tooltipp">quick
													view</span>
											</button>
										</div>
									</div>
									<div class="add-to-cart">
										
										<button class="add-to-cart-btn" id="${ctSanPhamPage.id}">
											<i class="fa fa-shopping-cart"></i> add to cart
										</button>
									</div>
								</div>
								<!-- /product -->
								</c:forEach>
							</div>
							<div id="slick-nav-2" class="products-slick-nav"></div>
						</div>
						<!-- /tab -->
					</div>
				</div>
			</div>
			<!-- /Products tab & slick -->
			<div class="section">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<div class="section-title text-center">
								<h3 class="title">Products</h3>
							</div>
						</div>
						<c:forEach var="ctSanPhamPage" items="${listSanPhamPage}">
						<!-- product -->
						<div class="col-md-3 col-xs-6">
								<div class="product">
									<div class="product-img">
										<img src="<c:url value='${ctSanPhamPage.sanPham.getHinhAnhSps()[0].getPhotosImagePath()}'/>"
											alt="">
										<div class="product-label">
											<span class="sale">-30%</span> <span class="new">NEW</span>
										</div>
									</div>
									<div class="product-body">
										<p class="product-category">${ctSanPhamPage.sanPham.getLoai().ten}</p>
										<h3 class="product-name">
												<a href="${detailUrl}/${ctSanPhamPage.id}">${ctSanPhamPage.sanPham.ten}</a>
										</h3>
										<h4 class="product-price">
											<fmt:formatNumber maxFractionDigits="1"  value = "${ctSanPhamPage.donGia}  " type = "number"/> 
										 	
											<!-- <del class="product-old-price">$990.00</del> -->
										</h4>
										<div class="product-rating">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
										<div class="product-btns">
											<button class="add-to-wishlist">
												<i class="fa fa-heart-o"></i><span class="tooltipp">add
													to wishlist</span>
											</button>
											<button class="add-to-compare">
												<i class="fa fa-exchange"></i><span class="tooltipp">add
													to compare</span>
											</button>
											<button class="quick-view">
												<i class="fa fa-eye"></i>
												<span class="tooltipp">quick
													view</span>
											</button>
										</div>
									</div>
									<div class="add-to-cart">
										<button class="add-to-cart-btn" id="${ctSanPhamPage.id}">
											<i class="fa fa-shopping-cart"></i> add to cart
										</button>
									</div>
								</div>
						</div>
						
						<!-- /product -->
						</c:forEach>
						<div class="clearfix visible-sm visible-xs"></div>

					</div>
					<!-- /row -->
				</div>
				<!-- /container -->
			</div>
			<!-- /Section -->

		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>

<form id="form-add-to-cart" action="${addCartItem}" method="GET">
	<input name="idCTSP" type="hidden" value="">
</form>
<script>
$(document).ready(function() {
    // jQuery code goes here
  
	$(".add-to-cart-btn").on("click",function(e){
		console.log($(this))
		var $productID=$(this).attr("id");
		var $inputForm=$("#form-add-to-cart").children("input[name='idCTSP']");
		$inputForm.val($productID);
		
		console.log($productID);
		$("form#form-add-to-cart").submit();
	})
});

</script>
