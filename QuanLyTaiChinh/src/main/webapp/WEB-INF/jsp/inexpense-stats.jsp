<%-- 
    Document   : Expense-stats
    Created on : Aug 17, 2022, 9:05:56 AM
    Author     : inmac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div  class="container-fluid" style="align-items: center">
    <section style="margin: 30px">
        <h2 style="text-align: center; color: green">Thong ke theo danh muc</h2>
        <div class="row" >
            <div class="col-md-3" style="margin-top: 50px">
                <div id="accordion">


                    <c:url value="/stats" var="action" />
                    <form  action="${action}" >
                        <div class="mb-3 mt-3">
                            <label class="form-label">Trong nam:</label>
                            <input class="form-control" type="number" placeholder="Enter year" id="Year" name="Year"/>
                        </div>
                        <!--                            <div class="mb-3 mt-3">
                                                        <label class="form-label">Trong nam:</label>
                                                        <input class="form-control" type="number" placeholder="Enter year" id="Year" name="Year"/>
                                                    </div>-->

                        <input type="submit" value="Bao Cao" class="btn btn-success"/>
                    </form>


                </div>
            </div>
            <div class="col-md-9">
                <div class="container">
                    <section>

                        <div class="container mt-3">

                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr class="table-success">
                                        <th>Ma</th>
                                        <th>Ten</th>
                                        <th>Tong tien</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${exStats}" var="e">
                                        <tr>
                                            <td>${e[0]}</td>
                                            <td>${e[1]}</td>
                                            <td>
                                                <fmt:formatNumber type="number" value="${e[2]}" maxFractionDigits="3" /> VND
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>

                        <div style="width:500px; height: 500px; margin: 0 auto" >
                            <canvas id="myExpStaChart" ></canvas>
                        </div>
                    </section>


                </div>

            </div>
        </div>
    </section>
    <section style="margin: 30px">
        <h2 style="text-align: center; color: green">Thong ke  theo thoi gian</h2>
        <div class="row">
            <div class="col-md-3">
                <c:url value="/stats" var="action" />
                <form  action="${action}" >


                    <div class="mb-3 mt-3"
                         <label class="form-label">Loai:</label>
                        <select type="email" class="form-control" id="item"  name="item" path="item">
                            <c:forEach items="${category}" var="i">
                                <option value="${i.id}">${i.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3 mt-3">
                        <label class="form-label">Chi trong thang:</label>
                        <input class="form-control" type="number" placeholder="Enter month" id="month" name="month"/>
                    </div>
                    <div class="mb-3 mt-3">
                        <label class="form-label">Chi trong nam:</label>
                        <input class="form-control" type="number" placeholder="Enter year" id="year" name="year"/>
                    </div>

                    <input type="submit" value="Bao Cao" class="btn btn-success"/>
                </form>
            </div>
            <div class="col-md-9">

                <div class="container mt-3">
                    <table class="table table-hover table-striped">
                        <thead>
                            <tr class="table-success">
                                <th>Ma</th>
                                <th>Ten</th>
                                <th>Tong tien</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${timeStats}" var="e">
                                <tr>
                                    <td>${e[0]}</td>
                                    <td>${e[1]}</td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${e[2]}" maxFractionDigits="3" /> VND
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

                <div style=" height: 700px; margin: 0 auto" >
                    <canvas id="myExpStaChart2" ></canvas>
                </div>
            </div>
        </div>

    </section>
</div>



<script src="<c:url value="/resources/js/toggle-button.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/resources/js/exStats.js"/>"></script>
<script>

    let exLabels = [];
    let exInfo = [];
    let exLabels2 = [];
    let exInfo2 = [];
    let exTime2 = [];
    <c:forEach items="${exStats}" var="e">
    exLabels.push('${e[1]}');
    exInfo.push(${e[2]});
    </c:forEach>

    <c:forEach items="${timeStats}" var="c">
    exLabels2.push('${c[0]}');
    exInfo2.push(${c[1]});
    </c:forEach>

    window.onload = function () {
        exChart(exLabels, exInfo);
        expenseChart(exLabels2, exInfo2, exTime2);
    }
</script>
