<%--
  Created by IntelliJ IDEA.
  User: zndxl
  Date: 2021/8/20
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script>
        $(function () {

            $("#btn4").click(function () {
                var student = {
                    "stuId":5,
                    "stuName":"tom",
                    "address":{
                        "province":"广东省",
                        "city":"深圳市",
                        "street":"后瑞"
                    },
                    "subjectList":[
                        {
                            "subjectName":"JaveSE",
                            "subjectScore":100
                        },
                        {
                            "subjectName":"SSM",
                            "subjectScore":99
                        }
                        ],
                    "map":{
                        "k1":"v1",
                        "k2":"v2"
                    }

                };
                //将json对象转换为json字符串
                var requestBody = JSON.stringify(student);
                $.ajax({
                    "url":"send/compose/object.json",
                    "type":"post",
                    "data":requestBody,
                    "contentType":"application/json;charset=UTF-8",
                    "dataType":"json",
                    "success":function (response) {
                        alert(response);
                    },
                    "error":function (response) {
                        alert(response);
                    }
                });
            });


            $("#btn2").click(function () {
                $.ajax({
                    "url":"send/array/two.html",
                    "type":"post",
                    "data":{
                        "array":[5,8,12]
                    },
                    "dataType":"text",
                    "success":function (response) {
                        alert(response);
                    },
                    "error":function (response) {
                        alert(response);
                    }
                });
            });

            $("#btn1").click(function () {
                $.ajax({
                    "url":"send/array/one.html",
                    "type":"post",
                    "data":{
                        "array":[5,8,12]
                    },
                    "dataType":"text",
                    "success":function (response) {
                        alert(response);
                    },
                    "error":function (response) {
                        alert(response);
                    }
                });
            });

            $("#btn5").click(function () {
                layer.msg("layer弹窗");
            });
        });
    </script>
</head>
<body>
    <a href="test/ssm.html">测试SSM整合环境</a>

    <br>

    <button id="btn1">Send [5,8,12] #1</button>
    <br>
    <button id="btn2">Send [5,8,12] #2</button>
    <br>
    <button id="btn3">Send [5,8,12] #3</button>
    <br>
    <button id="btn4">Send compose object</button>
    <br>
    <button id="btn5">点我弹窗</button>
</body>
</html>
