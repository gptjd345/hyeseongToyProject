<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
	
	<!-- Toy Project CSS -->
    <link rel="stylesheet" href="/resources/assets/css/member/managebox.css?version=1.1">
    
</head>
<body>
                    
       <div class="login_part_form" id="manage-box">
            <div class="login_part_form_iner">
                <h3> <br>
                    Please fill your info up</h3>
                <form class="row contact_form" action="./regist.do" method="post" novalidate="novalidate" id="managebox-form">
                    
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
                        <input type="text" class="form-control" id="phonenum" name="phonenum" value="" placeholder="PhoneNumber : 010-1234-5678">
                    </div>
                    
	            
                </form>
                
                <button type="button" value="button" class="btn_3 float-right" id="close-managebox">
                   close
                </button>
               
                <button type="submit" value="submit" class="btn_3 float-right" id="registration">
                   Registration
              	</button>
               

                
            </div>
        </div>
         
         <script src="/resources/assets/js/toyProject/member/managebox.js?ver1.2"></script>
        
              	

</body>
</html>