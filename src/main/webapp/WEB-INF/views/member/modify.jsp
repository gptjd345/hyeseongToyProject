<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
    <!-- 기본적으로 사용하는 css 내용들  -->
	<%@include file="../include/baseCss.jsp" %>
     
    <!-- ToyProject CSS 추후에 -->
    <link rel="stylesheet" href="/resources/assets/css/member/signUp.css?version=1.0">        
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
                    <div class="row justify-content-center">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Manage - Modify</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!--================registration_part Area =================-->
        <section class="login_part section_padding ">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3> <br>
                                    Please fill your info up</h3>
                                                                 
                                  	<form class="row contact_form" action="./modify.do" method="post" id="registration-form">
	                                  		 <div class="col-md-12 form-group p_star">
	                                        <input type="text" class="form-control" id="userid" name="userid" value="${dto.userid}" readonly>
	                                    </div>
	                                    <div class="col-md-12 form-group p_star">
	                                        <input type="password" class="form-control" id="password" name="password" value="" placeholder="Password">
	                                    </div>
	                                    <div class="col-md-12 form-group p_star">
	                                        <input type="password" class="form-control" id="password2" name="password2" value="" placeholder="Password Check">
	                                    </div>
	                                    <div class="col-md-12 form-group p_star">
	                                        <input type="text" class="form-control" id="name" name="name" value="${dto.name}" placeholder="Name">
	                                    </div>
	                                    <div class="col-md-12 form-group p_star">
	                                        <input type="text" class="form-control" id="phonenum" name="phonenum" value="${dto.phonenum}" placeholder="PhoneNumber : 010-1234-5678">
	                                    </div>
											<!-- 수정완료시 페이지 관련 정보들을 그대로 전달하여 원래 페이지로 이동할 수 있게 한다.   -->
											<input type="hidden" name="curBlock" value="${pageDTO.curBlock}"/>
											<input type="hidden" name="searchOption" value="${pageDTO.searchOption}"/>
											<input type="hidden" name="searchKey" value="${pageDTO.searchKey}"/>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
											
	                                    <div class="col-md-12 form-group">
	                                        <button type="submit" value="submit" class="btn_3" id="signUp">
	                                            Submit
	                                        </button>
	                                    </div>
	                                </form>
	                                
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>Welcome !!</h2>
                                <a href="./list.do?curBlock=${pageDTO.curBlock}&searchOption=${pageDTO.searchOption}&searchKey=${pageDTO.searchKey}" class="btn_3">Go List Page</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
    </main><!--? Search model Begin -->
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

    <!-- toyProject -->
    <script src="/resources/assets/js/toyProject/member/modify.js?version=1.0"></script>

</body>
    
</html>