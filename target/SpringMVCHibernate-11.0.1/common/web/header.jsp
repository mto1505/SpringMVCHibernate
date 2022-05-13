<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 11:19:23 PM
    Author     : MinhTo
--%>
<%--<%@page import="com.mycompany.springmvctest.utils.SecurityUtils"%>--%>
<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/cart/delete" var="deleteItemUrl"></c:url>
<c:url value="/checkout" var="checkoutUrl"></c:url>
<c:url value="/search" var="search"></c:url>
<c:url value="/template/web/img/APPLE-SHOP.png" var="logo-img"/>

<security:authentication var="user" property="principal"/>
<%-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <!-- <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button> -->
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value='/trang-chu'/>" >Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <security:authorize access="isAnonymous()">
                     <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/dang-ki'/>">Đăng Kí</a>
                </li>
                </security:authorize>
               
               <security:authorize access="isAuthenticated()">
                     <li class="nav-item">
                         <a class="nav-link" href="#">Welcome<%= SecurityUtils.getPrincipal().getName()%></a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a>
                </li>
                </security:authorize>
              
               
            </ul>
        </div>
    </div>
</nav> --%>
<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +0929330701</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> buiminhto99@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 279 Đặng văn lãnh</a></li>
					</ul>
					<ul class="header-links pull-right">
						<!--
						<li>
						<a href="#">
						<i class="fa fa-dollar">
						</i>USD</a>
						</li>
						-->
						<li><a href="#"><i class="fa fa-user-o"></i> <security:authorize access="isAuthenticated()">${user.displayName} </security:authorize> </a></li>
						<li>${__spring_security_scpf_applied}</li>
							<li> <%= response.isCommitted() %></li>
						 <security:authorize access="isAnonymous()">
		                     <li class="nav-item">
		                    <a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a>
		                </li>
		                 <li class="nav-item">
		                    <a class="nav-link" href="<c:url value='/dang-ki'/>">Đăng Kí</a>
		                </li>
		                </security:authorize>
		                 <security:authorize access="isAuthenticated()">
		                <li class="nav-item">
                  		  <a class="nav-link" href='<c:url value="/logout"/>'>Thoát</a>
              			</li>
              			<li class="nav-item">
                  		  <a class="nav-link" href='<c:url value="/don-hang/danh-sach"/>'>Xem đơn hàng</a>
              			</li>
                </security:authorize>
					</ul>
				</div>
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="<c:url value="/home" />" class="logo">
									<img src="<c:url value='/template/web/img/APPLE-SHOP.png'/> " alt="MT Shop" style="border-radius: 32px;">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form:form action="${search}" method="POST">
									<select class="input-select" name="tenLoai">
										<c:forEach items="${categories}" var="category" varStatus="index">
												<option value="${category.ten}" >${category.ten}</option>
										</c:forEach>
									</select>
									<input class="input" placeholder="Nhập từ khoá" name="searchField">
									<button class="search-btn" type="submit">Tìm kiếm</button>
								</form:form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3 clearfix">
							<div class="header-ctn">
								 <!-- Wishlist -->
								<!-- <div>
									<a href="#">
										<i class="fa fa-heart-o"></i>
										<span>Your Wishlist</span>
										<div class="qty">2</div>
									</a>
								</div> -->
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Your Cart</span>
										 <div class="qty">${myCartNum}</div> 
									</a>
									<div class="cart-dropdown">
										<div class="cart-list">
									
										<c:forEach items="${myCartItems}" var="item">
											<div class="product-widget">
												<div class="product-img">
													<img src="<c:url value='/product-photos/${item.value.chiTietSanPham.sanPham.ten}/${item.value.chiTietSanPham.sanPham.getHinhAnhSps()[0].hinhAnh}'/>" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">${item.value.chiTietSanPham.sanPham.ten}</a></h3>
													<h4 class="product-price"><span class="qty">${item.value.soLuong}</span>${item.value.chiTietSanPham.donGia}</h4>
												</div>
												<button class="delete" id="${item.value.chiTietSanPham.id}"><i class="fa fa-close"></i></button>
											</div>
										</c:forEach>
										
										
										</div>
										<div class="cart-summary">
											<small>${myCartNum}  sản phẩm đã chọn</small>
											<h5>Tổng tiền: 
											<c:if test="${myCartTotal==''}">
											 <fmt:formatNumber maxFractionDigits="1"  value = "${myCartTotal} " type = "number"/> 
											</c:if>VND</h5>
										</div>
										<div class="cart-btns">
											<a href="#">Xem giỏ</a>
											<a href="${checkoutUrl}">Thanh toán  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<form id="cart-item-delete-form" method="post" action="${deleteItemUrl}" modelAttribute="chiTietGioHang">
			<input type="hidden" name="idIdCtsp" value=""></input>
		</form>
		<script>
		$(".delete").on("click",function(event){
			
			console.log($(this))
			var $productID=$(this).attr("id");
		
			var $idInputForm=$("#cart-item-delete-form").children("input[name='idIdCtsp']");
			$idInputForm.val($productID);
			
		
			console.log($productID);
			
			$("#cart-item-delete-form").submit();
		})
		</script>
