<%-- 
    Document   : editCar
    Created on : Aug 8, 2021, 3:04:19 PM
    Author     : MinhTo
--%>
<
<%@include file="/common/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/api/xe-may" var="XeAPI"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Chỉnh sửa xe máy</title>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
                                        <div class="row">
                                            <div class="container bootstrap-iso">
                                                <form action="#" method="PUT" id="formSunmit">
                                                    <div class="row form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="inputPlateNum">Biển Số</label>
                                                            <input type="text" class="form-control" id="inputPlateNum" name="bienSo" value="${xeMay.bienSo}"
                                                               <c:if test="${not empty xeMay.bienSo}"> disabled="true" </c:if> > 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="inputCarName">Tên xe</label>
                                                        <input type="text" class="form-control" id="inputCarName" name="tenxe" value="${xeMay.tenxe}">
                                                    </div>
                                                </div>
                                                <div class="row form-row">
                                                    <div class="form-group col-md-8">
                                                        <input type="hidden" name="khachHang.id" value="${xeMay.getKhachHang().id}" />
                                                        <label for="inputCustumer">Tên chủ sở hữu</label>
                                                        <input type="text" class="form-control" id="inputCustomer" name="khachHang.ten" value="${xeMay.getKhachHang().getTen()}">
                                                    </div>

                                                </div>

                                                <div class="row form-row">
                                                    <div class="col-md-6 form-group">
                                                        <label class="form-check-label" for="checkGenderDefault">Giới tính</label>
                                                        <div class="form-check">
                                                            
                                                                <div class="form-check-inline">
                                                                    <input class="form-check-input"  <c:if test="${xeMay.getKhachHang().gioitinh=='Nam'}"> checked="checked"</c:if> type="radio" checked value="Nam" id="checkGenderDefault" name="khachHang.gioitinh">
                                                                    <label class="form-check-label" for="checkGenderDefault"> Nam</label>
                                                                </div> 

                                                             <div class="form-check-inline">
                                                                <input class="form-check-input" type="radio" value="Nữ" id="checkGenderFemale" name="khachHang.gioitinh">
                                                                <label class="form-check-label" for="checkGenderFemale"> Nữ</label>
                                                            </div>
                                                           

                                                        </div>
                                                    </div>



                                                </div>
                                                <div class="row form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="inputPhone">Số điện thoại</label>
                                                        <input type="text" class="form-control" id="inputPhone" name="khachHang.sdt" value="${xeMay.getKhachHang().sdt}">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="date">Ngày sinh</label>

                                                        <c:set  var="ngaySinh" value="${xeMay.getKhachHang().ngaySinh}" />
                                                        
                                                        <fmt:formatDate var="ngaySinhFormated" type="date" dateStyle="short" pattern="yyyy-MM-dd" value="${ngaySinh}"/> 

                                                        <input type="text" class="form-control" id="date" name="khachHang.ngaySinh" placeholder="yyyy-mm-dd" value="${ngaySinhFormated}">
                                                    </div>

                                                </div>
                                                <div class="row form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="inputLoaiXe">Tên loại xe</label>

                                                        <select name="loaiXe.id" id="inputLoaiXe">
                                                            <c:forEach  var="loaiXe" items="${listLoaiXe}">
                                                                <option value="${loaiXe.id}"
                                                                        <c:if test="${loaiXe.tenloai==xeMay.getLoaiXe().tenloai}"> selected="selected" </c:if> >
                                                                    ${loaiXe.tenloai} 
                                                                </option>

                                                            </c:forEach>


                                                        </select>
                                                    </div>


                                                </div>


                                                     <c:if test="${not empty xeMay.bienSo}">
                                                     <button type="button" class="btn btn-primary" id="btnAddOrUpdate">Sửa</button> 
                                                     </c:if>
                                                     <c:if test="${empty xeMay.bienSo}" >
                                                     <button type="button" class="btn btn-primary" id="btnAddOrUpdate">Thêm</button>
                                                     </c:if>
                                                     
                                                </form>
                                        </div>

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
            $(document).ready(function () {
                var date_input = $('input[name="khachHang.ngaySinh"]');
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form .form-row')[5] : "body";

                var options = {
                    format: "yyyy-mm-dd",
                    container: container,
                    todayHighlight: true,
                    autoclose: true
                };
                date_input.datepicker(options);
            });


            //Handel data before send
            $("#btnAddOrUpdate").click(function (e) {
                e.preventDefault();
                var data = {};
                var $formArrayDataInput = $('#formSunmit').serializeArray();
                console.log($formArrayDataInput);
                var jsonString = JSON.stringify($formArrayDataInput);
                console.log(jsonString);
                serialize();
                var inputHide=$('input:hidden');
                console.log(inputHide);

            });

            function serialize() {
                var elements = $('#formSunmit').children().toArray();
                console.log(elements);
                var inputAndSelectArray = $(elements).find(':input').toArray();
                console.log(inputAndSelectArray);
                var data = {};
                inputAndSelectArray.forEach(element => {
                    var val = $(element).val();

                    var fullName = element.getAttribute("name");

                    var fullNameParts = fullName.split('.');

                    var prefix = '';
                    var stack = data;
                    var s = {};

                    for (let index = 0; index < fullNameParts.length - 1; index++) {
                        prefix = fullNameParts[index];
                        // console.log(prefix);
                        if (!stack[prefix])
                        {
                            stack[prefix] = {};
                        }
                        stack = stack[prefix]; //THAY ĐỔI STACK, lấy ra prefix cuối
                        //  console.log("sssss",s)              
                    }

                    //     thêm dữ liệu cho prefix cuối 

                    var prefix2 = fullNameParts[fullNameParts.length - 1];
                    if (stack[prefix2]) {
                        var newVal = stack[prefix2] + ',' + val;
                        stack[prefix2] += newVal;
                    } else {
                        stack[prefix2] = val;
                    }
                });
                console.log(JSON.stringify(data).substring(1,JSON.stringify(data).length-1));
                edit(data);
            }


            function edit(data)
            {
                $.ajax({
                    url: '${XeAPI}/${xeMay.bienSo}',
                    type: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    dataType: 'json',
                    susscess: function (result)
                    {
                        console.log(result); //json
                    },
                    error: function (error)
                    {
                        console.log(error);
                    }

                });

            }

        </script>

    </body>
</html>
