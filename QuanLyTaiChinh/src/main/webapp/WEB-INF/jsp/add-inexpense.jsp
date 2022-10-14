<%-- 
    Document   : add-expense
    Created on : Aug 18, 2022, 8:33:55 PM
    Author     : inmac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container" style="width:50%;">

    <h1 class="text-center text-info">Add Expense</h1>
    <c:url value="/expense" var="action" />
    <sec:authorize access="!isAuthenticated()">
        <strong>Vui long <a href="<c:url value="/" />">dang nhap</a> de them phieu chi!!!</strong>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="main">
            <form class="add-expense">
                <div class="field" tabindex="1">
                    <label for="username">
                        <i class="far fa-user"></i>Your Name
                    </label>
                    <input name="username" type="text" placeholder="e.g. john doe" required>
                </div>
                <div class="field" tabindex="2">
                    <label for="email">
                        <i class="far fa-envelope"></i>Your Email
                    </label>
                    <input name="email" type="text" placeholder="email@domain.com" required>
                </div>
                <div class="field" tabindex="3">
                    <label for="message">
                        <i class="far fa-edit"></i>Your Message
                    </label>
                    <textarea name="message" placeholder="type here" required></textarea>
                </div>
                <button type="reset">Send Me Message</button>

            </form>
        </div>

        <!-- This is not part of Pen -->
        <a class="me" href="https://codepen.io/uzcho_/pens/popular/?grid_type=list" target="_blank" style="color:#000"></a>
    </sec:authorize>

</div>
