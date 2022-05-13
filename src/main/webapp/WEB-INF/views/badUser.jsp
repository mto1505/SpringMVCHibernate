<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Confirmation Failed</title>
</head>
<body>
	<h1>${message}</h1>
	<c:if test="${expired==true}">
	<h1>Expired</h1>
	</c:if>
	<h1>${token}</h1>
</body>
</html>