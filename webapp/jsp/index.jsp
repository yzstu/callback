<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta content="text/html;  http-equiv=Content-Type">
    <title>Send Info</title>
    <link href="../css/zzsc.css" media="screen" rel="stylesheet"/>
</head>
<body>
<form action="/sendInfo" id="msform" method="get">

    <h2 class="fs-title">Send Info</h2>
    <p><input name="date" placeholder="date" type="text"/></p>
    <p><input name="keyword" placeholder="keyword" type="text"/></p>
    <p><input name="feePoint" placeholder="feePoint" type="text"/></p>
    <p><input name="successMo" placeholder="successMo" type="text"/></p>
    <p><input name="paySuccessOrder" placeholder="paySuccessOrder" type="text"/></p>
    <p><input name="revenueToCP" placeholder="revenueToCP" type="text"/></p>
    <p><input name="revenueType" placeholder="revenueType" type="text"/></p>
    <p><input name="MOSuccessRate" placeholder="MOSuccessRate" type="text"/></p>
    <p><input name="paySuccessRate" placeholder="paySuccessRate" type="text"/></p>
    <p><input name="payMoSuccessRate" placeholder="payMoSuccessRate" type="text"/></p>
    <p><input class="submit action-button" name="submit" type="submit" value="Submit"/></p>
    <p><c:if test="${requestScope.msg != null}"><%=request.getAttribute("msg")%>
    </c:if></p>
</form>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="../js/zzsc.js" type="text/javascript"></script>
<!-- <br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br> -->
<div style="text-align:center;clear:both">
</div>
</body>

</html>