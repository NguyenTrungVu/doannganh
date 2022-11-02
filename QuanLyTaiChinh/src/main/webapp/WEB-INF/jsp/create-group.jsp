

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/create-group" var="action" />

<div class=" h-[1000px] ">
    <h1 class="text-center text-[48px] font-bold mb-[100px] pt-[100px]">CREATE GROUP</h1>
    <c:if test="${groups != null}">
        <c:forEach items="${groups}" var="g">
            <h1>${g}</h1>
        </c:forEach>
    </c:if>

    <c:if test="${err != null}">
        <div class="alert alert-danger alert-dismissible">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>Failed</strong>${err}
        </div>
    </c:if>

    <form:form method="post" action="${action}" modelAttribute="group">
        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="groupname" class="font-bold text-[20px] text-black0 mr-auto ml-[400px] ">Group name: </label>                
            <form:input type="text" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="groupname" path="groupname" placeholder="enter groupname" />
            <form:errors path="groupname"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>
        
        <div class="flex flex-wrap justify-center gap-x-[45px] mb-[50px]">
            <label for="purpose" class="font-bold text-[20px] text-black0 mr-auto ml-[400px] ">Purpose: </label>                
            <form:input type="text" class="w-[400px] rounded-[25px] mr-[600px] bg-transparent border-[1.5px] border-green-500 text-black hover:scale-105 " id="purpose" path="purpose" placeholder="enter groupname" />
            <form:errors path="purpose"  class="text-red-500 font-bold mx-[0px] ml-[100px]"  />
        </div>
        
        
        

        <div class="flex justify-center">
            <button type="submit" class="w-[140px] h-[50px] bg-green-500 rounded-[25px] text-black font-bold hover:bg-pink-500 hover:duration-[1s] ">Create</button>
        </div>
    </form:form>
    
</div>
