<%-- 
    Document   : header
    Created on : Jan 29, 2021, 9:25:47 PM
    Author     : MinhTo
--%>

<%--<%@page import="com.mycompany.springmvctest.utils.SecurityUtils"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
               
                     <li class="nav-item">
                       <%--
<a class="nav-link" href="#">Welcome<%= SecurityUtils.getPrincipal().getFullName()%></a>
                       --%>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="/thoat">Thoát</a>
                </li>
              
            </ul>
        </div>
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        
    </div>
</div>
