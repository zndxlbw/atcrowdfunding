<%--
  Created by IntelliJ IDEA.
  User: NGX
  Date: 2020/5/2
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<%--提取公共head--%>
<%@include file="include-head.jsp" %>
<body>

<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-sidebar.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">控制面板</h1>
            <div class="row placeholders">
                <%@include file="include-rolecode.jsp"%>
            </div>
        </div>
    </div>
</div>
</body>
</html>


