<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <li class="breadcrumb-item"><a href="product?cid=0">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                <c:forEach items="${listcate}" var ="o">
                    <li class="list-group-item  ${tagactive == o.cate_id ? "active":""}"><a href="product?cid=${o.cate_id}">${o.icons}${o.cname}</a></li>
                </c:forEach>  
                  
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Signature Product</div>
                <div class="card-body">
                       <img class="img-fluid border-0" src="https://media.vneconomy.vn/w800/images/upload/2021/09/11/z2752453342888-7965b76e156825e2602c45ff67541de7.jpg" alt="https://media.vneconomy.vn/w800/images/upload/2021/09/11/z2752453342888-7965b76e156825e2602c45ff67541de7.jpg">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="productdetail?pid=2" title="View Product">Áo Đấu Cristiano Ronaldo</a></h4>
                    <div class="row">
                       
                        <div class="col">
                            <a href="productdetail?pid=2" class="btn btn-success btn-block">View</a>
                        </div>
                    </div>
                </div>	
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row">
            
            <c:forEach items="${listAllproduct}" var="p">
                <div class="col-12 col-md-6 col-lg-4">
                
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
                <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                        <c:if test="${tag>1}">
                            <li class="page-item ">
                                <a class="page-link" href="product?index=${tag-1}" >Previous</a>
                            </li>
                            </c:if>
                           <c:forEach begin="1" end="${endP }" var="i">
                            <li class="page-item ${tag==i? "active":""}"><a class="page-link" href="product?cid=${tagactive }&index=${i }">${i }</a></li>
                           </c:forEach>
                                <c:if test="${tag < endP }" >
                            <li class="page-item">
                                <a class="page-link" href="product?cid=${tagactive }&index=${tag+1 }">Next</a>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- end footer-->

<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
