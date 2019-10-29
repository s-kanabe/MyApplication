<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.RegisterMustWater" %>
<%
//リクエストスコープに保存されたインスタンスを取得
RegisterMustWater registerMustWater =(RegisterMustWater) request.getAttribute("registerMustWater");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>リザルト画面</title>　
</head>
<body>
<h1>水を最低でも</h1>
<p><%= registerMustWater.getMustWater() %>ml飲みましょう</p>
<a href="*">HOME</a>
<a href="*">コラム</a>
</body>
</html>