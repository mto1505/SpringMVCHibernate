<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 11:14:39 PM
    Author     : MinhTo
--%>
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
	 <fmt:setLocale value = "vi_VN"/>
<%--  <fmt:formatNumber value = "${balance}" type = "currency"/> --%>
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
						
								<c:forEach var="ctSanPhamPage" items="${listCTSanPhamPage}">
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
										 		<fmt:formatNumber  maxFractionDigits="1"  value = "${ctSanPhamPage.donGia} " type = "number"/> 
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
						<c:forEach var="sanPhamPage" items="${listSanPhamPage}">
						<!-- product -->
						<div class="col-md-3 col-xs-6">
								<div class="product">
									<div class="product-img">
										<img src="<c:url value='${sanPhamPage.getHinhAnhSps()[0].getPhotosImagePath()}'/>"
											alt="">
										<div class="product-label">
											<span class="sale">-30%</span> <span class="new">NEW</span>
										</div>
									</div>
									<div class="product-body">
										<p class="product-category">${sanPhamPage.getLoai().ten}</p>
										<h3 class="product-name">
												<a href="${detailUrl}/${sanPhamPage.chiTietSanPhams[0].id}">${sanPhamPage.ten}</a>
										</h3>
										<h4 class="product-price">
										 	<fmt:formatNumber maxFractionDigits="1"  value = "${sanPhamPage.chiTietSanPhams[0].donGia} " type = "number"/> 
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
										<button class="add-to-cart-btn" id="${sanPhamPage.chiTietSanPhams[0].id}">
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
<!-- /SECTION -->
<!-- <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <div class="container">
            Heading Row
            <div class="row align-items-center my-5">
                <div class="col-lg-7">
                    <img class="img-fluid rounded mb-4 mb-lg-0" src="http://placehold.it/900x400" alt="">
                </div>
                /.col-lg-8
                <div class="col-lg-5">
                    <h1 class="font-weight-light">Business Name or Tagline</h1>
                    <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it makes a great use of the standard Bootstrap core components. Feel free to use this template for any project you want!</p>
                    <a class="btn btn-primary" href="#">Call to Action!</a>
                </div>
                /.col-md-4
            </div>
            /.row

            Call to Action Well
            <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body">
                    <p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p>
                </div>
            </div>

            Content Row
            <div class="row">
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Card One</h2>
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem magni quas ex numquam, maxime minus quam molestias corporis quod, ea minima accusamus.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary btn-sm">More Info</a>
                        </div>
                    </div>
                </div>
                /.col-md-4
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Card Two</h2>
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod tenetur ex natus at dolorem enim! Nesciunt pariatur voluptatem sunt quam eaque, vel, non in id dolore voluptates quos eligendi labore.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary btn-sm">More Info</a>
                        </div>
                    </div>
                </div>
                /.col-md-4
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">Card Three</h2>
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem magni quas ex numquam, maxime minus quam molestias corporis quod, ea minima accusamus.</p>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary btn-sm">More Info</a>
                        </div>
                    </div>
                </div>
                /.col-md-4

            </div>
            /.row

        </div>
    </body>
</html> -->
