<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav style="height:40px" class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

	<div class="collapse navbar-collapse" id="navbarScroll">
		<ul style="width: 100%; display: flex; justify-content: flex-end;"
			class="navbar-nav mr-auto my-2-lg-0 narbar-nav-scroll"
			style="max-height: 100px;">

			<c:choose>
				<c:when test="${sessionScope.acc == null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/login"> Đăng Nhập</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/login">HI: ${sessionScope.acc.user}</a>
					</li>
					<li><a class="nav-link" href="logoutController">Đăng Xuất</a>
					</li>
				</c:otherwise>
			</c:choose>

		</ul>

	</div>
</nav>

<nav style="margin-top: 39px"
	class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<img href="home" style="width: 40px; border-radius: 5px;"
		class="img-fluid"
		src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwJmzjP7uPyiz2EyO04QC32LILrkP48iymqA&usqp=CAU" />
	<a class="navbar-brand" href="home"> VivaRonaldo MangShop</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarScroll">
		<ul style="display: flex; justify-content: center; width: 100%;"
			class="navbar-nav mr-auto my-2-lg-0 narbar-nav-scroll"
			style="max-height: 100px;">
			<li class="nav-item active"><a class="nav-link" href="home">Trang
					Chủ <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarScrollingDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Danh Mục </a>
				<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
					<c:forEach items="${listcate}" var="o">
						<li><a class="dropdown-item ${tagactive == o.cate_id ? "
							active":""}" href="product?cid=${o.cate_id}">${o.icons}${o.cname}</a></li>
					</c:forEach>
				</ul></li>

			<li class="nav-item"><a class="nav-link disabled"
				href="product?cid=0">Sản Phẩm</a></li>

		</ul>
		<form style="min-width: 320px" action="search"
			class="form-inline my-2 my-lg-0">
			<div class="input-group input-group-sm">
				<input type="text" name="txt" value="${txtS }" class="form-control"
					placeholder="Search...">
				<div class="input-group-append">
					<button type="submit" class="btn btn-secondary btn-number">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<a class="btn btn-success btn-sm ml-3"
				href="${pageContext.request.contextPath}/views/cart-list.jsp"> <i>
				<c:set var = "count" value="${0 }"/>
				<c:forEach items ="${sessionScope.cart}" var ="map">
				<c:set var ="count" value="${count + map.value.quantity }"/>
				</c:forEach>
				<class="fa fa-shopping-cart"></i> Giỏ Hàng <span
				class="badge badge-light">${count }</span>
			</a>
		</form>
	</div>
</nav>

<section class="jumbotron text-center">
	<div  style="margin-top: 100px" class="container">
	<!--  <img  class="img-fluid" style="width: 500px ;quality:60px, height:100px; float ="left"; border-radius: 5px;" src="https://thumbs.gfycat.com/LikelySkeletalAchillestang-size_restricted.gif" /> -->
		<h1 class="jumbotron-heading">CR7 is GOAT</h1>
		<p class="lead text-muted mb-0">Form Is Temporary, But Class Is Permanent</p>
	</div>
</section>