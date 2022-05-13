
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/dang-ki" var="UrlRegister" />
<c:url value="/oauth2/authorization/google" var="loginGG"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">AP</span>
									<span class="white" id="id-text2">Shop</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; MT Technology</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
							
								<div id="login-box" class="login-box widget-box no-border ${signUpfailed==true ? '' :'visible'}">
									<div class="widget-body">
										<div class="widget-main">
										<!-- 	<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Please Enter Your Information
											</h4>
 -->
											<div class="space-6"></div>

											<form action="j_spring_security_check" id="formLogin" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															 <input type="text" class="form-control" id="userName" name="j_username"
                                   placeholder='Tài khoản' />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															 <input type="password" class="form-control" id="password" name="j_password"
                                   placeholder='Mật khẩu'/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Lưu thông tin</span>
														</label>
																
														<button type="submit" class="width-40 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Đăng nhập</span>
														</button>
													</div>
													
													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">Đăng nhập với</span>
											</div>

											<div class="space-6"></div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="ace-icon fa fa-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="ace-icon fa fa-twitter"></i>
												</a>

												<a class="btn btn-danger" href="${loginGG}">
													<i class="ace-icon fa fa-google-plus"></i>
												</a>
											</div>
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													Quên mật khẩu
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													Đăng kí
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i>
												Lấy lại mật khẩu
											</h4>

											<div class="space-6"></div>
											<p>
												Vùi lòng nhập địa chỉ Email của bạn
											</p>

										  <form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="ace-icon fa fa-lightbulb-o"></i>
															<span class="bigger-110">Gửi!</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												Trở lại đăng nhập
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border ${signUpfailed==true ? 'visible' :''}">
									<div class="widget-body">
										<div class="widget-main">
											<p class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												Đăng kí tài khoản mới
											</p>

											<div class="space-6"></div>
										

											<form:form action="${UrlRegister}" modelAttribute="khachHang" method="post" id="form-create-account" >
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="hoVaTenDem" type="text" class="form-control" placeholder="Họ" name="hoVaTenDem"/>
														
															<i class="ace-icon fa fa-envelope"></i>
															<form:errors path="hoVaTenDem" cssClass="text-danger"/>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="ten" type="text" class="form-control" placeholder="Tên" name="ten"/>
														
															<i class="ace-icon fa fa-envelope"></i>
															<form:errors path="ten" cssClass="text-danger"/>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="email" type="email" class="form-control" placeholder="Email" name="email"/>
														
															<i class="ace-icon fa fa-envelope"></i>
															<form:errors path="email" cssClass="text-danger"/>
															<span class="text-danger form-message">${not empty email_error_message ? email_error_message :''}</span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="taiKhoan.username" type="text" class="form-control" placeholder="Username" name="taiKhoan.username"/>
																
															<i class="ace-icon fa fa-user"></i>
																<form:errors path="taiKhoan.username" cssClass="text-danger"/>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="taiKhoan.password" type="password" class="form-control" placeholder="Mật khẩu" name="taiKhoan.password" />
															
															<i class="ace-icon fa fa-lock"></i>
															<form:errors path="taiKhoan.password" cssClass="text-danger"/>
															
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="taiKhoan.passwordConfirm" type="password" class="form-control" placeholder="Nhập lại mật khẩu" name="taiKhoan.passwordConfirm"/>
																
															<i class="ace-icon fa fa-retweet"></i>
															<form:errors  path="taiKhoan.passwordConfirm" cssClass="text-danger"/>
															<form:errors path="taiKhoan" cssClass="text-danger"/>
														</span>
													</label>
														<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="soDienThoai" type="text" class="form-control"  placeholder="Số điện thoại" name="soDienThoai" />
															<i class="ace-icon fa fa-phone"></i>
															<form:errors path="soDienThoai" cssClass="text-danger"/>
														</span>
													</label>
												
														 <div class="g-recaptcha"
		                                         				 data-sitekey="${captcha.key}"></div>
		                                         		<form:errors path="reCaptchaResponse" cssClass="text-danger"/>		 
		                                   			<%-- 	 <p class="error-message"	
		                                     				  th:each="error: ${#fields.errors('reCaptchaResponse')}"
		                                       					th:text="${error}">Validation error</p> --%>
		                                       			
													
												

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															Tôi đồng ý 
															<a href="#">chính sách</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-35 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">Khôi phục</span>
														</button>

														<button type="submit" class="width-45 pull-right btn btn-sm btn-success">
															<span class="bigger-110">Đăng ký</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form:form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												Trở lại đăng nhập
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->

							<div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">Dark</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">Blur</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">Light</a>
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		

		<!-- inline scripts related to this page -->
		<!--[if !IE]> -->
		 <script src="<c:url value='/template/admin/assets/js/jquery-2.1.4.min.js'/>"></script>

		<!-- <![endif]-->
    	   
 			<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value='/template/admin/assets/js/jquery.mobile.custom.min.js'/>'>"+"<"+"/script>");
		</script>  
		<script type="text/javascript">
		jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
		</script>
