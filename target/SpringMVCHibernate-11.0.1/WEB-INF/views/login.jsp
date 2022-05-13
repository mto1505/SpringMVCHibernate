
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Đăng nhập</title>
    </head>
    <body>
        <div class="container">
          
            <div class="login-form">
                <div class="main-div">
                    <c:if test="${param.incorrectAccount!=null}">
		<div class="alert alert-danger"><spring:message code="invalidAuthenticate"/></div>
                </c:if>
				<c:if test="${param.accessDenied!=null}">
					<div class="alert alert-danger">you Not authorize</div>
				</c:if>
                     <form action="j_spring_security_check" id="formLogin" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" id="userName" name="j_username"
                                   placeholder="Tên đăng nhập">
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="j_password"
                                   placeholder="Mật khẩu">
                        </div>
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
                        <button type="submit" class="btn btn-primary" >Đăng nhập 2</button>
			    
			       
			       <input type="checkbox" name="remember-me" value="remember" />
			  
                    </form> 
                    <%-- <div class="col-md-12">
                      <form action="j_spring_security_check" id="formLogin" method="post">
                        <div class="form-group row">
                        	<label class="col-form-label" for="userName"> <spring:message code="app.username"/> </label>
                            <input type="text" class="form-control" id="userName" name="j_username"
                                   placeholder='' />
                      
						</div>
						
                        <div class="form-group row">
                        	<label class="col-form-label"  for="password"> <spring:message code="app.password"/></label>
                            <input type="password" class="form-control" id="password" name="j_password"
                                   placeholder=''/>
                        
                		</div>
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>

                    </form>
                    </div> --%>
                </div>
            </div>
        </div>
    </body>
</html>