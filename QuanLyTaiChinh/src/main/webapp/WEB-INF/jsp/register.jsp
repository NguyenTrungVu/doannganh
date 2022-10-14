<%-- 
    Document   : register
    Created on : Aug 13, 2022, 7:45:20 PM
    Author     : inmac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">Dang ky nguoi dung</h1>


<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>
                            <c:url value="/register" var="action"></c:url>
                            <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">
                                <form:errors path="*" element="div" cssClass="alert alert-danger" />
                                <div class="form-outline mb-4">
                                    <form:input type="text" id="username" path="username" class="form-control form-control-lg" />
                                    <label class="form-label" for="username">Your Name</label>
                                    <form:errors path="username" element="div" cssClass="text-danger"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="email" id="email" path="email" class="form-control form-control-lg" />
                                    <label class="form-label" for="email">Your Email</label>
                                    <form:errors path="email" element="div" cssClass="alert alert-danger"/>
                                    
                                </div>
                                <div class="form-outline mb-4">
                                    <form:input type="number" id="phone" path="phone" class="form-control form-control-lg" />
                                    <label class="form-label" for="phone">Your Phone Number</label>
                                    <form:errors path="phone" element="div" cssClass="alert alert-danger"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="password" id="password" path="password" class="form-control form-control-lg" />
                                    <label class="form-label" for="password">Password</label>
                                    <form:errors path="password" element="div" cssClass="alert alert-danger" />
                                </div>

                                <div class="form-outline mb-4">
                                    <form:input type="password" id="comfirmPassword" path="comfirmPassword" class="form-control form-control-lg" />
                                    <label class="form-label" for="comfirmPassword">Repeat your password</label>

                                </div>
                                <div class="form-outline mb-4">
                                    <form:input type="file" id="avatar" path="file" class="form-control form-control-lg" />
                                    <label class="form-label" for="avatar">Avatar</label>
                                </div>
                                <!--                <div class="form-check d-flex justify-content-center mb-5">
                                                  <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />
                                                  <label class="form-check-label" for="form2Example3g">
                                                    I agree all statements in <a href="#!" class="text-body"><u>Terms of service</u></a>
                                                  </label>
                                                </div>-->

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="#!"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>

                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>