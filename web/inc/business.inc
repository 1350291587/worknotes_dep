<c:choose>
    <c:when test="${tokey.level<0}">
        <c:redirect url="/index.jsp"/>
    </c:when>
</c:choose>