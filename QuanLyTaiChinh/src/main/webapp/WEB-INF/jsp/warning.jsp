<%-- 
    Document   : warning
    Created on : Nov 8, 2022, 8:11:11 PM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center">WARNING</h1>

<div class>
    <c:forEach items="${warnings}" var="w">
        <div class="card d-flex">
            <svg xmlns="http://www.w3.org/2000/svg" style="width: 10%; height: auto" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M8.257 3.099c.765-1.36 2.722-1.36 3.486 0l5.58 9.92c.75 1.334-.213 2.98-1.742 2.98H4.42c-1.53 0-2.493-1.646-1.743-2.98l5.58-9.92zM11 13a1 1 0 11-2 0 1 1 0 012 0zm-1-8a1 1 0 00-1 1v3a1 1 0 002 0V6a1 1 0 00-1-1z" clip-rule="evenodd" />
            </svg>
            <div class="my-auto ml-[100px]" style="width: 90%;">
                <h1 class="font-bold text-[17px]">${w.content}</h1>

            </div>

        </div>
    </c:forEach>
</div>
