<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list" style="display:block">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý sản phẩm
             <!--    <b class="arrow fa fa-angle-down"></b> -->
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
<!--             /quan-tri/xe-may/danh-sach?type=list&page=1&limit=10&sortName=title&sortBy=desc-->
                <li>	
                    <a href='<c:url value="/quan-tri/product/danh-sach?page=1&limit=10"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách sản phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
         <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Quản lý đơn đặt hàng
               <!--  <b class="arrow fa fa-angle-down"></b> -->
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
<!--             /quan-tri/xe-may/danh-sach?type=list&page=1&limit=10&sortName=title&sortBy=desc -->
                <li>	
                    <a href='<c:url value="/quan-tri/order/danh-sach?page=1"/>'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách đơn đặt hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>