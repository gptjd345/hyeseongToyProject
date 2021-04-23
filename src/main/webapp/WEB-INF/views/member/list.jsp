<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
	<!-- 기본적으로 사용하는 css 내용들  -->
	<%@include file="../include/baseCss.jsp" %>
	
	<!-- Toy Project CSS -->
    <link rel="stylesheet" href="/resources/assets/css/member/list.css">
</head>
<body>
  <header>
    <!-- Header Start -->
   <%@ include file="../include/header.jsp" %>
    <!-- Header End -->
  </header>
  <main>
      <!-- Hero Area Start-->
      <div class="slider-area ">
          <div class="single-slider slider-height2 d-flex align-items-center">
              <div class="container">
                  <div class="row">
                      <div class="col-xl-12">
                          <div class="hero-cap text-center">
                              <h2>Main</h2>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <!--================Cart Area =================-->
      <section class="cart_area section_padding">
        <div class="container">
            <div class="table-responsive">
              <table class="table">
                <thead>
                    <th>번호</th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>가입일자</th>
                </thead>
                <tbody>
	                <c:forEach var="row" items="${map.list}">
	                    <tr>
	                        <td>${row.membernum}</td>
	                        <td>${row.userid}</td>
	                        <td>${row.name}</td>
	                        <td>${row.phoneNum}</td>
	                        <td><fmt:formatDate value = "${row.joindate}" pattern="yyyy-MM-dd HH:mm" /></td> <!-- 날짜의 출력형식을 변경 -->
	                    </tr>
	                </c:forEach>  
                </tbody>
              </table>
              
	              <nav id="pager">
	                <a href="list.do?curBlock=${map.pager.prevBlock}"><span><i class="fas fa-angle-left" title="이전"></i><span></a>
              			<c:forEach var="row" begin="${map.pager.startBlock}" end="${map.pager.endBlock}">
              				<c:choose>
              					<c:when test="${row == map.pager.curBlock}">  
	                				<a href="#"><span style="color: red;">${row}</span></a>
	                			</c:when>
	                			<c:otherwise>
	                				<a href="list.do?curBlock=${row}"><span>${row}</span></a>
	                			</c:otherwise>
	                		
	                		</c:choose>
              			</c:forEach>
	                <a href="list.do?curBlock=${map.pager.nextBlock}"><span><i class="fas fa-angle-right" title="다음"></i><span></a>
	              </nav>
              
              <div class="btn_Container">
                <div>
                  <a class="btn_1" href="#">등록</a>
                </div>
                <div>
                    <a class="btn_1" href="#">수정</a>
                </div>
                <div>
                    <a class="btn_1" href="#">삭제</a>
                 </div> 
               </div>
            </div>  
         
          </div>
      </section>
      <!--================End Cart Area =================-->
  </main>
   <!--? Search model Begin -->
  <div class="search-model-box">
      <div class="h-100 d-flex align-items-center justify-content-center">
          <div class="search-close-btn">+</div>
          <form class="search-model-form">
              <input type="text" id="search-input" placeholder="Searching key.....">
          </form>
      </div>
  </div>
  <!-- Search model end -->

  <!-- JS here -->
  
	<!-- 기본적으로 사용하는 JS 내용들  -->
	<%@include file="../include/baseJS.jsp" %>
	
	
 

</body>
</html>