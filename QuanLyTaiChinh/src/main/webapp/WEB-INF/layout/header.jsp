<%-- 
    Document   : header
    Created on : Aug 6, 2022, 2:57:49 PM
    Author     : inmac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark" style="position: fixed; top: 0; z-index: 10; width: 100%">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a class="nav-link" href="<c:url value="/home"/>">Home</a>
                    </c:if>

                </li>



                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register" />">
                            <i class="fa-solid fa-user-plus"></i> Dang Ky
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="<c:url value="/" />">
                            <i class="fa fa-user-check"></i> Dang Nhap</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/"/>">
                            <c:if test="${currentUser.avatar != null}">
                                <img src="${currentUser.avatar}" style="width:20px;" class="rounded-circle"/>
                            </c:if>
                            <c:if test="${currentUser.avatar  == null}">
                                <i class="fa fa-user-check" ></i>
                            </c:if>


                            ${pageContext.request.userPrincipal.name}
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="<c:url value="/warning" />">Warning <span class="badge bg-success">${countWarning}</span></a>
                    </li>
                </c:if>


            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search" name="kw">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
