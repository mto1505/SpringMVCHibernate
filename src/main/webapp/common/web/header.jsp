<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 11:19:23 PM
    Author     : MinhTo
--%>
<%--<%@page import="com.mycompany.springmvctest.utils.SecurityUtils"%>--%>
<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
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
               <%-- 
               <security:authorize access="isAuthenticated()">
                     <li class="nav-item">
                         <a class="nav-link" href="#">Welcome<%= SecurityUtils.getPrincipal().getFullName()%></a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a>
                </li>
                </security:authorize>
               --%>
               
            </ul>
        </div>
    </div>
</nav>