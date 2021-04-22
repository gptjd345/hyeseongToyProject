<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Watch shop | eCommers</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/assets/img/favicon.ico">

    <!-- CSS here -->
        <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="/resources/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/resources/assets/css/flaticon.css">
        <link rel="stylesheet" href="/resources/assets/css/slicknav.css">
        <link rel="stylesheet" href="/resources/assets/css/animate.min.css">
        <link rel="stylesheet" href="/resources/assets/css/magnific-popup.css">
        <link rel="stylesheet" href="/resources/assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="/resources/assets/css/themify-icons.css">
        <link rel="stylesheet" href="/resources/assets/css/slick.css">
        <link rel="stylesheet" href="/resources/assets/css/nice-select.css">
        <link rel="stylesheet" href="/resources/assets/css/style.css">
     
    <!-- ToyProject CSS 추후에 -->
        <link rel="stylesheet" href="/resources/assets/css/member/registration.css">        
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
                                <h2>Registrion</h2>
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
                                <form class="row contact_form" action="#" method="post" novalidate="novalidate" id= "registration-form">
                                    
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="userid" name="userid" value="" placeholder="User ID">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password" name="password" value="" placeholder="Password">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password2" name="password2" value="" placeholder="Password Check">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="name" name="name" value="" placeholder="Name">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="" placeholder="PhoneNumber">
                                    </div>


                                    <div class="col-md-12 form-group">
                                        <button type="submit" value="submit" class="btn_3" id="registration">
                                            Registraion
                                        </button>
                                        <a class="registraion_cancle" href="#">���</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>Welcome !</h2>
                                <a href="login.do" class="btn_3">Go Login</a>
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

    <script src="/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="/resources/assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="/resources/assets/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/slick.min.js"></script>

    <!-- One Page, Animated-HeadLin -->
    <script src="/resources/assets/js/wow.min.js"></script>
    <script src="/resources/assets/js/animated.headline.js"></script>
    
    <!-- Scroll up, nice-select, sticky -->
    <script src="/resources/assets/js/jquery.scrollUp.min.js"></script>
    <script src="/resources/assets/js/jquery.nice-select.min.js"></script>
    <script src="/resources/assets/js/jquery.sticky.js"></script>
    <script src="/resources/assets/js/jquery.magnific-popup.js"></script>

    <!-- contact js -->
    <script src="/resources/assets/js/contact.js"></script>
    <script src="/resources/assets/js/jquery.form.js"></script>
    <script src="/resources/assets/js/jquery.validate.min.js"></script>
    <script src="/resources/assets/js/mail-script.js"></script>
    <script src="/resources/assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->	
    <script src="/resources/assets/js/plugins.js"></script>
    <script src="/resources/assets/js/main.js"></script>

    <!-- toyProject -->
    <script src="/resources/assets/js/toyProject/member/registration.js"></script>

</body>
    
</html>