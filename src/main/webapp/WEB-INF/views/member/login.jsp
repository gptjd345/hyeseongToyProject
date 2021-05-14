<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
    <!-- 기본적으로 사용하는 css 내용들  -->
	<%@include file="../include/baseCss.jsp" %>
        
    <!-- Toy Project CSS-->    
        <link rel="stylesheet" href="/resources/assets/css/member/login.css">
</head>
<body>
        <!-- Header Start -->
       <%@ include file="../include/header.jsp" %>
        <!-- Header End -->
    
    <main>
        <!-- Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>Login</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!--================login_part Area =================-->
        <section class="login_part section_padding ">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>New to our Shop?</h2>
                                <p>There are advances being made in science and technology
                                    everyday, and a good example of this is the</p>
                                <a href="signUp" class="btn_3">Create an Account</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>Welcome Back ! <br>
                                    Please Sign in now</h3>
                                <form class="row contact_form" id="login-form" action="login.do" method="post">
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="userid" name="userid" value=""
                                            placeholder="User ID">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password" name="password" value=""
                                            placeholder="Password">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <div class="creat_account d-flex align-items-center">
                                            <!-- <input type="checkbox" id="f-option" name="selector">
                                            <label for="f-option">Remember me</label> -->
                                        </div>
                                         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                                        <button type="button" class="btn_3" id="login">
                                            log in 
                                        </button>
                                        <!-- 로그인 실패시 출력할 메세지 -->
                                        <span class="fail">${requestScope.loginFailMsg}</span>
                                        <!-- <a class="lost_pass" href="#">forget password?</a> -->
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
    </main>    <!--? Search model Begin -->
    <div class="search-model-box">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-btn">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Searching key.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->
    
   <!-- 기본적으로 사용하는 JS 내용들  -->
	<%@include file="../include/baseJS.jsp" %>
	
	<!-- Toy Project JS -->
    <!--유효성 검사 -->
    <script src="/resources/assets/js/toyProject/member/login.js?ver1.0"></script>

</body>
    
</html>