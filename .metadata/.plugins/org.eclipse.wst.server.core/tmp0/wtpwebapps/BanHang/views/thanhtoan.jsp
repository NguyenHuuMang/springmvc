<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> <!-- scan nhỏ trang web -->
    <title>Cristiano Ronaldo Shop</title>
    <link rel="icon" type="image/x-icon" href="https://cdn.shopify.com/s/files/1/0249/5892/6941/products/cristiano_ronaldo_cr7_sticker_iron_on_550x.jpg?v=1583663502">
    
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/templates/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<!-- header -->
<%@ include file="header.jsp" %>
<!-- end header -->
<!-- content -->


    <main role="main">
        <div class="container mt-4">
            <form class="needs-validation" name="thanhtoan" method="post"
                action="" href="/views/cart-list"> 
                <input type="hidden" name="username" value="${username}">

                <div class="py-5 text-center">
                    <i class="fa fa-credit-card fa-4x" aria-hidden="true"></i>                    
                    <p class="lead">Vui lòng kiểm tra thông tin Khách hàng, thông tin Giỏ hàng trước khi Đặt hàng.</p>
                </div>

                <div class="row">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-right mb-3">
                            <span class="text-muted">Giỏ hàng</span>
                            <span class="badge badge-secondary badge-pill">0</span>
                        </h4>
                      


                        </div>

                    </div>
                    <div class="col-md-8 order-md-1">
                        <h4 class="mb-3">Thông tin khách hàng</h4>

                        <div class="row">
                            <div class="col-md-12">
                                <label for="">Họ tên</label>
                                <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                    value="Nguyễn Hữu Mãng" readonly="">
                            </div>
                          
                            </div>
                            <div class="col-md-12">
                                <label for="">Địa chỉ</label>
                                <input type="text" class="form-control" name="" id=""
                                    value="" readonly="">
                            </div>
                            <div class="col-md-12">
                                <label for="">Điện thoại</label>
                                <input type="text" class="form-control" name="" id=""
                                    value="0336950023" readonly="">
                            </div>
                            <div class="col-md-12">
                                <label for="">Email</label>
                                <input type="text" class="form-control" name="" id=""
                                    value="" readonly="">
                            </div>
                            <div class="col-md-12">
                                <label for="">Ngày sinh</label>
                                <input type="text" class="form-control" name="" id=""
                                    value="" readonly="">
                            </div>
                            <div class="col-md-12">
                                <label for="kh_cmnd">CMND</label>
                                <input type="text" class="form-control" name="" id="" value=""
                                    readonly="">
                            </div>
                        </div>

                        <h4 class="mb-3">Hình thức thanh toán</h4>

                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="httt-1" name="httt_ma" type="radio" class="custom-control-input" required=""
                                    value="1">
                                <label class="custom-control-label" for="httt-1">Thanh Toán Khi Nhận Hàng</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="httt-2" name="httt_ma" type="radio" class="custom-control-input" required=""
                                    value="2">
                                <label class="custom-control-label" for="httt-2">Chuyển khoản</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="httt-3" name="httt_ma" type="radio" class="custom-control-input" required=""
                                    value="3">
                                <label class="custom-control-label" for="httt-3">Ship COD</label>
                            </div>
                        </div>
                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="btnDatHang">Đặt
                            hàng</button>
                    </div>
                </div>
            </form>
	</div>
        </div>
        <!-- End block content -->
    </main>
<p></p>
<p></p>

<!-- end content -->

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- end footer-->
<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
