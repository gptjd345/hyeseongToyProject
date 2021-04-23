<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="zxx">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Watch shop | eCommers</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="manifest" href="site.webmanifest">
  <link rel="shortcut icon" type="image/x-icon" href="/resources/assets//img/favicon.ico">

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
</head>

<body>
  <header>
    <!-- Header Start -->
    <%@ include file="include/header.jsp" %>
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
          <div class="cart_inner">
            <div class="table-responsive">
              <table class="table">
                <tbody>
                  <tr class="bottom_button">
                    <td>
                      <a class="btn_1" href="./member/list.do">회원관리</a>
                    </td>
                    <td>
                        <a class="btn_1" href="#">게시판</a>
                    </td>
                    <td>
                      <div class="cupon_text float-right">
                        <a class="btn_1" href="#">상품관리</a>
                      </div>
                      
                    </td>
                  </tr>
                </tbody>
              </table>
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
  
  <!-- Scrollup, nice-select, sticky -->
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

</body>
</html>