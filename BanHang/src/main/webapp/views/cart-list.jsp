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




<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                   
                        <tr>
                            <th scope="col">Ảnh</th>
                            <th scope="col">Sản Phẩm</th>
                            <th scope="col">Giá Tiền</th>
                            <th scope="col" class="text-center">Số Lượng</th>
                            <th scope="col" class="text-right">Thành Tiền</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items ="${sessionScope.cart}" var = "map">                    
                        <tr>                    
                         <c:url value ="${name.value.product.image }" var="imgUrl"/>
                            <td><img class="img-responsive" width="60px", height="60px" src="${imgUrl}" /> </td>
                            <td>${map.value.product.name }</td>
                           <td> ${map.value.quantity }
                            </td>
                            <td class="text-right shop-red"> ${map.value.product.price * map.value.quantity}</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                       </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td class="text-right"><h4></h4> <c:set var="total" value="${0}"/> 
                            <c:forEach items="${sessionScope.cart}" var ="map">
                            <c:set var="total" value="${total + map.value.quantity * map.value.product.price }"></c:set>                        
                            </c:forEach>                         
                            <div class= "total-result-in">
                            <span>${total}</span>
                            </div>
                             </td>
                        </tr>
                      <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Ship</td>
                            <td class="text-right">Freeship</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Cái Giá Phải Trả</strong></td>
                            <td class="text-right"><strong>${total}</strong></td>
                        </tr>
                    </tbody>
                
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <a href="product?cid=0" class="btn btn-success btn-block class=">Chọn Thêm Sản Phẩm</a>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <a href="thanhtoan" class="btn btn-success btn-block class=">Thanh Toán</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

    