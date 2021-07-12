<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<c:choose>
    <c:when test="${empty tokey}">
        <c:redirect url="/index.jsp"/>
    </c:when>
</c:choose>

