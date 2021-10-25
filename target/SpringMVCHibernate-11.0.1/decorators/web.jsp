<%-- 
    Document   : newjsp
    Created on : Feb 27, 2021, 10:25:19 PM
    Author     : MinhTo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trang Chủ</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css' > </c:url>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value='/template/web/css/small-business.css' > </c:url>" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><!-- font awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <body>
            <!-- Navigation -->
        <%@include file="/common/web/header.jsp" %>

        <!-- Page Content -->
        <dec:body>

        </dec:body>
        <!-- /.container -->

        <!-- Footer -->
        <%@include file="/common/web/footer.jsp" %>

        <!-- Bootstrap core JavaScript -->

        <script src="<c:url value='template/web/vendor/jquery/jquery.min.js'></c:url>" ></script>

            <script src="<c:url value='template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'></c:url>" ></script>
    </body>
</html>
