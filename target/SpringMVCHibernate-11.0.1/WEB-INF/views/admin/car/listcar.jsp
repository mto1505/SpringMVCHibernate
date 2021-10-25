<%-- 
    Document   : newjsp
    Created on : Jul 20, 2021, 2:48:14 PM
    Author     : MinhTo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="EditXeURL" value="/quan-tri/xe-may/" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách xe máy</title>
    </head>
    <body>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Home</a>
                        </li>
                    </ul><!-- /.breadcrumb -->
                </div>
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table id="simple-table" class="table table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th class="center">
                                                        <label class="pos-rel">
                                                            <input type="checkbox" class="ace" />
                                                            <span class="lbl"></span>
                                                        </label>
                                                    </th>
                                                    <th>Biển số</th>
                                                    <th>Tên xe</th>
                                                    <th class="hidden-480">Chủ sở hữu</th>
                                                    <th>
                                                        Loại xe
                                                    </th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="xe" items="${listXeMay}">
                                                    <tr>
                                                        <td class="center">
                                                            <label class="pos-rel">
                                                                <input type="checkbox" class="ace" />
                                                                <span class="lbl"></span>
                                                            </label>
                                                        </td>
                                                        <td>
                                                            ${xe.getBienSo()}  
                                                        </td>
                                                        <td>${xe.getTenXe()} </td>
                                                        <td class="hidden-480">${xe.getTenChuSoHuu()}</td>


                                                        <td class="hidden-480">
                                                            <span class="label label-sm label-warning">${xe.getLoaiXe()}</span>
                                                        </td>

                                                        <td>
                                                            <div class="hidden-sm hidden-xs btn-group">
                                                                <button class="btn btn-xs btn-success">
                                                                    <i class="ace-icon fa fa-check bigger-120">

                                                                    </i>
                                                                </button>

                                                                <button class="btn btn-xs btn-info" onclick="location.href='${EditXeURL}?bienSo=${xe.getBienSo()}&type=edit'"> 
                                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                                </button>

                                                                <button class="btn btn-xs btn-danger">
                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                </button>

                                                                <button class="btn btn-xs btn-warning">
                                                                    <i class="ace-icon fa fa-flag bigger-120"></i>
                                                                </button>
                                                            </div>

                                                            <div class="hidden-md hidden-lg">
                                                                <div class="inline pos-rel">
                                                                    <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                        <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                                    </button>

                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li>
                                                                            <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                                <span class="blue">
                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>

                                                                        <li>
                                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                                <span class="green">
                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>

                                                                        <li>
                                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                <span class="red">
                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                </span>
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table>
                                        <ul class="pagination" id="pagination"></ul>
                                        <form action="<c:url value='/quan-tri/xe-may/danh-sach'/>" id="formSubmit" method="get">
                                            <input type="hidden" value="" id="page" name="page"/>
                                            <input type="hidden" value="" id="maxPageItem" name="limit"/>
                                            <input type="hidden" value="" id="sortName" name="sortName"/>
                                            <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                            <input type="hidden" value="" id="type" name="type"/>
                                        </form>
                                    </div>

                                </div><!-- /.span -->
                            </div><!-- /.row -->



                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                </div>
            </div>
        </div>

        <script>
            var totalPages = ${totalPage};
            var currentPage = ${page};
            var limit = 4;
            $(function () {
                window.pagObj = $('#pagination').twbsPagination({
                    totalPages: totalPages,
                    visiblePages: 4,
                    startPage: currentPage,
                    onPageClick: function (event, page) {
                        if (currentPage != page) {
                            $('#maxPageItem').val(10);
                            $('#page').val(page);
                            $('#sortName').val('title');
                            $('#sortBy').val('desc');
                            $('#type').val('list');
                            $('#formSubmit').submit();
                        }
                    }
                });
            });
        </script>
    </body>
</html>

