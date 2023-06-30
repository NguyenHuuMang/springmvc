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


<div  class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://thumbs.gfycat.com/LikelySkeletalAchillestang-size_restricted.gif" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://giaydabongtot.com/wp-content/uploads/2020/10/Anh-ronaldo-dep-trai-1-scaled.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn-img.thethao247.vn//storage/files/camhm/2022/10/27/tin-chuyen-nhuong-27-10-tuong-lai-ronaldo-nga-ngu-zidane-tai-xuat-voi-ben-do-vi-dai-209314.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">
            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Đỉnh Nhất Shop
                </div>
                <img class="img-fluid border-0" src="https://media.vneconomy.vn/w800/images/upload/2021/09/11/z2752453342888-7965b76e156825e2602c45ff67541de7.jpg" alt="https://media.vneconomy.vn/w800/images/upload/2021/09/11/z2752453342888-7965b76e156825e2602c45ff67541de7.jpg">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="productdetail?pid=2" title="View Product">Áo Đấu Cristiano Ronaldo</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">200000</p>
                        </div>
                        <div class="col">
                            <a href="productdetail?pid=2" class="btn btn-success btn-block">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Sản Phẩm Giá Tốt
                </div>
                <div class="card-body">
                    <div class="row">
                    
                    	<c:forEach items="${list4product}" var ="p">
                        <div class="col-sm">
                            <div class="card">
                                <img class="card-img-top" src="${p.image}" alt="${p.name}">
                                <div class="card-body">
                                    <h4 class="card-title"><a href="productdetail?pid=${p.id}" title="View Product">${p.name}</a></h4>
                                    <p class="card-text">${p.description}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${p.price} </p>
                                        </div>
                                        <div class="col">
                                            <a href="<c:url value="cart-add?pId=${o.id}&quantity=1"></c:url>" class="btn btn-success btn-block">Thêm Vào Giỏ Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                       </c:forEach>
                       
                       </div>
                       </div>
                </div>
            </div>
        </div>
    </div>

<div class="container mt-3 mb-4">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-trophy"></i> Sản Phẩm Tốt Nhất
                </div>
                <div class="card-body">
                    <div class="row">
                    <c:forEach items="${list4product}" var ="p">
                        <div class="col-sm">
                            <div class="card">
                                <img class="card-img-top" src="${p.image}" alt="${p.name}">
                                <div class="card-body">
                                    <h4 class="card-title"><a href="productdetail?pid=${p.id}" title="View Product">${p.name}</a></h4>
                                    <p class="card-text">${p.description}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${p.price}</p>
                                        </div>
                                        <div class="col">
                                            <a href="cart-add" class="btn btn-success btn-block">Thêm Vào Giỏ Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>                       
                        </div>
                          </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
    