<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
	<!-- 기본적으로 사용하는 css 내용들  -->
	<%@include file="../include/baseCss.jsp" %>
	
	<!-- Toy Project CSS -->
    <link rel="stylesheet" href="/resources/assets/css/member/list.css?version=1.1">
    
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
            
		      <!--================ 검색 폼  ====================-->
		      <form action="list.do" method="get">
		      	<input type="hidden" name="curBlock" value="${pageDTO.curBlock}"/>
			      <section id="search-section">
			      <!-- =========== 검색 정보 유지================= -->
			      <c:choose>
			      	<c:when test="${pageDTO.searchOption == 'none'}">	
			            <select name="searchOption">
			                <option value="none" selected>=== 선택 ===</option>
			                <option value="all">멤버번호+아이디+이름</option>
			                <option value="membernum">멤버번호</option>
			                <option value="userid">아이디</option>
			                <option value="name">이름</option>
			            </select>
			         </c:when>  
			         <c:when test="${pageDTO.searchOption == 'all'}">	
			            <select name="searchOption">
			                <option value="none">=== 선택 ===</option>
			                <option value="all" selected>멤버번호+아이디+이름</option>
			                <option value="membernum">멤버번호</option>
			                <option value="userid">아이디</option>
			                <option value="name">이름</option>
			            </select>
			         </c:when> 
			         <c:when test="${pageDTO.searchOption == 'membernum'}">	
			            <select name="searchOption">
			                <option value="none">=== 선택 ===</option>
			                <option value="all">멤버번호+아이디+이름</option>
			                <option value="membernum" selected>멤버번호</option>
			                <option value="userid">아이디</option>
			                <option value="name">이름</option>
			            </select>
			         </c:when> 
			         <c:when test="${pageDTO.searchOption == 'userid'}">	
			            <select name="searchOption">
			                <option value="none">=== 선택 ===</option>
			                <option value="all">멤버번호+아이디+이름</option>
			                <option value="membernum">멤버번호</option>
			                <option value="userid" selected>아이디</option>
			                <option value="name">이름</option>
			            </select>
			         </c:when>  
			         <c:when test="${pageDTO.searchOption == 'name'}">	
			            <select name="searchOption">
			                <option value="none">=== 선택 ===</option>
			                <option value="all">멤버번호+아이디+이름</option>
			                <option value="membernum">멤버번호</option>
			                <option value="userid">아이디</option>
			                <option value="name" selected>이름</option>
			            </select>
			         </c:when> 
			      </c:choose>      
			            <div class="col-lg-2">
			                <input type="text" class="form-control" name="searchKey" value="${pageDTO.searchKey}">
			            </div>
			            <button type="submit" class="btn-secondary">검색</button>
			       </section>
		       </form>
		       
		       
              <table class="table">
                <thead>
                	<th>선택</th>
                    <th>번호</th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>가입일자</th>
                </thead>
                <tbody>
	                <c:forEach var="row" items="${list}">
	                    <tr>
	                    	<td><input type="checkbox" name="checkbox" value="${row.userid}"></td>
	                        <td>${row.membernum}</td>
	                        <td><a href="./modify?userid=${row.userid}&curBlock=${pageDTO.curBlock}&searchOption=${pageDTO.searchOption}&searchKey=${pageDTO.searchKey}">${row.userid}</a></td>
	                        <td>${row.name}</td>
	                        <td>${row.phonenum}</td>
	                        <td><fmt:formatDate value = "${row.joindate}" pattern="yyyy-MM-dd HH:mm" /></td> <!-- 날짜의 출력형식을 변경 -->
	                    </tr>
	                </c:forEach>  
                </tbody>
              </table>
              
	              <nav id="pager">
	          		<c:set var="startBlock" value="${pageDTO.curBlock - (pageDTO.curBlock - 1) % 10}" />
	    			<!-- ${totalPage/10} 16.3 소수가 나옴 올림처리해야 함-->
	          		<c:set var="lastBlock" value="${fn:substringBefore(Math.ceil(totalPage/10),'.')}" />
	              	<!-- startBlock이 1보다 작거나 같으면 이전 버튼을 보여주지 않는다. -->	
	              	<c:choose>
	              		<c:when test="${startBlock > 1}">
			                <a href="list.do?curBlock=${startBlock - 1}&searchOption=${pageDTO.searchOption}&searchKey=${pageDTO.searchKey}">
			                	<span><i class="fas fa-angle-left" title="이전"></i><span>
			                </a>
		                </c:when>
		                <c:otherwise>
		              	
		                </c:otherwise>
	                </c:choose>
	                
              			<c:forEach var="block" begin="${startBlock}" end="${(startBlock+9 > lastBlock)? lastBlock : startBlock+9}">
              				<c:choose>
              					<c:when test="${block == pageDTO.curBlock}">  
	                				<a href="#"><span style="color: red;">${block}</span></a>
	                			</c:when>
	                			<c:otherwise>
	                				<a href="list.do?curBlock=${block}&searchOption=${pageDTO.searchOption}&searchKey=${pageDTO.searchKey}"><span>${block}</span></a>
	                			</c:otherwise>
	                		
	                		</c:choose>
              			</c:forEach>
              			
              		<!-- startBlock + 10 이 마지막 블록보다 크면 다음 버튼을 보여주지않는다. -->
              		<c:choose>
              			<c:when test="${startBlock + 10 <= lastBlock}">	
	                		<a href="list.do?curBlock=${startBlock + 10}&searchOption=${pageDTO.searchOption}&searchKey=${pageDTO.searchKey}"><span><i class="fas fa-angle-right" title="다음"></i><span></a>
	                	</c:when>
	                	<c:otherwise>
	                		
	                	</c:otherwise>
	                </c:choose>	
	              </nav>
	           
	           <!-- 현재 페이지 블록값을 저장 -->   
	           <input type="hidden" class="curBlock" name="curBlock" value="${pageDTO.curBlock}"/>
	           
              
              <div class="btn_Container">
              
                  <a href="./registration?curBlock=${pageDTO.curBlock}" class="btn_1" id="register-form">등록</a>
                  <button type="button" class="btn_1" id="delete">삭제</button>
          
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
	
	<!-- Toy Project JS -->

	<script src="/resources/assets/js/toyProject/member/list.js?ver1.5"></script>
	


</body>
</html>