<%-- 
    Document   : header
    Created on : Jan 29, 2021, 9:25:47 PM
    Author     : MinhTo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<security:authentication var="user" property="principal"/>
<%-- <div id="navbar" class="navbar navbar-default ace-save-state">
	<div class=" container navbar-container ace-save-state"
		id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<div class="row  justify-content-start  navbar-header pull-left">
			<div class="col">
				<a href="<c:url value="/quan-tri/trang-chu"/>" class="navbar-brand">
					<small> <i class="fa fa-leaf"></i> Trang quản trị
				</small>
				</a>

			</div>
		</div>

		<div
			class="row justify-content-end navbar-buttons navbar-header pull-right justify-content-md-right"
			role="navigation">
			<div  class="col" >
				<ul class="nav ace-nav">
					  <li class="nav-item ">
                       
<a class="nav-link" href="#">Welcome<%= SecurityUtils.getPrincipal().getFullName()%></a>
                      
                </li>
					<li class="nav-item light-blue dropdown-modal"><a
						class="nav-link" href='<c:url value="/logout"/>'>Thoát</a></li>

				</ul>
			</div>
			
		</div>

	</div>
</div>
 --%>
 	<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="<c:url value="/quan-tri/trang-chu"/>" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							MT SHOP ADMIN
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey dropdown-modal">
							<!-- <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a> -->

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-footer">
									<a href="#">
										Xem công việc
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="purple dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								
							</ul>
						</li>

						<li class="green dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							
		
								
							</ul>
						</li>

						<li class="light-blue dropdown-modal">
		
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>Welcome,</small>
								${user.displayName}
								</span>

							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Cài đặt
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Thông tin
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href='<c:url value="/logout"/>'>
										<i class="ace-icon fa fa-power-off"></i>
										Thoát
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>