<%-- 
    Document   : login
    Created on : Aug 11, 2022, 7:31:11 PM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/" var="action"/>
<div class="arround"style="background: linear-gradient(90deg, #C7C5F4, #776BCC)" >
    <div class="screen">
        <div class="screen__content">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">Da co loi xay ra</div>
            </c:if>
            <c:if test="${param.accessDenied!=null}">
                <div class="alert alert-danger">Ban khong co quyen truy cap!!</div>
            </c:if>
            <form class="login" method="post" action="${action}">
                <div class="login__field">
                    <i class="login__icon fas fa-user"></i>
                    <input type="text" class="login__input" placeholder="User name / Email" name="username">
                </div>
                <div class="login__field">
                    <i class="login__icon fas fa-lock"></i>
                    <input type="password" class="login__input" id="password" placeholder="Enter password" name="password">
                </div>
                <button class="button login__submit">
                    <span class="button__text">Log In Now</span>
                    <i class="button__icon fas fa-chevron-right"></i>
                </button>				
            </form>
            <div class="social-login">
                <h3>log in via</h3>
                <div class="social-icons">
                    <a href="#" class="social-login__icon fab fa-instagram"></a>
                    <a href="#" class="social-login__icon fab fa-facebook"></a>
                    <a href="#" class="social-login__icon fab fa-twitter"></a>
                </div>
            </div>
        </div>
        <div class="screen__background">
            <span class="screen__background__shape screen__background__shape4"></span>
            <span class="screen__background__shape screen__background__shape3"></span>		
            <span class="screen__background__shape screen__background__shape2"></span>
            <span class="screen__background__shape screen__background__shape1"></span>
        </div>		
    </div>
</div>
<!--<div class="container">
    <h1 class="text-info text-center">Dang Nhap</h1>

    <%--<c:if test="${param.error != null}">--%>
        <div class="alert alert-danger">Da co loi xay ra</div>
    <%--</c:if>--%>
    <%--<c:if test="${param.accessDenied!=null}">--%>
        <div class="alert alert-danger">Ban khong co quyen truy cap!!</div>
    <%--</c:if>--%>


    <form method="post" action="${action}">
        <div class="mb-3 mt-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-check mb-3">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Dang Nhap</button>
    </form> comment 
</div>-->
