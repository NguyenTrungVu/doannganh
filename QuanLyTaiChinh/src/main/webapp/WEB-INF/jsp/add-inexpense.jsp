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
    <c:url value="/inexpense" var="action" />
    <sec:authorize access="!isAuthenticated()">
        <strong>Vui long <a href="<c:url value="/" />">dang nhap</a> de them phieu chi!!!</strong>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <!--        <div class="main">
                    <form class="add-expense">
                        <div class="field" tabindex="1">
                            <label for="username">
                                <i class="far fa-user"></i>Your Name
                            </label>
                            <input  name="username" type="text" placeholder="Nhập giá tiền..." required>
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
                </div>-->
        <div class="main">
            <form:form method="post" action="${action}" modelAttribute="inexpense">
                <div class="mb-3 mt-3">
                   <label for="" class="expenseCost">Price</label>
                    <form:input type="number" id="price" placeholder="Enter the amount"  path="price" />

                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="mb-3">
                    <label for="pwd" class="expenseItem">Type</label>
                    <form:select path="type" class="form-select" id="type" >
                        <c:forEach items="${category}" var="item">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </form:select>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="mb-3 mt-3">
                    <label for="" class="expenseCost">Purpose</label>
                    <form:textarea type="text" class="form-control" id="purpose" placeholder="Enter your note"  path="purpose" />

                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
            </form:form>
        </div>
        <!-- This is not part of Pen -->
        <a class="me" href="https://codepen.io/uzcho_/pens/popular/?grid_type=list" target="_blank" style="color:#000"></a>
    </sec:authorize>

</div>
