<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="category" value="/category"/>
	<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<!-- <li><a href="#">Hot Deals</a></li>
						
						<li><a href="#">Categories</a></li> -->
						<c:forEach var="categoryItem" items="${categories}">
							<li><a href="${category}/${categoryItem.ten}">${categoryItem.ten}</a></li>
						</c:forEach>
						
						<!-- <li><a href="#">Iphone</a></li>
						<li><a href="#">Ipad</a></li> -->
						
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>