<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dao.DrinkDAO,dao.GlassDAO,model.DrinkEntity,model.GlassEntity,java.util.List,java.util.ArrayList" %>

<% List<DrinkEntity> drinkList = (List<DrinkEntity>) application.getAttribute("drinkList"); %>
<% List<GlassEntity> glassList = (List<GlassEntity>) application.getAttribute("glassList"); %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>セレクト画面</title>
</head>
<body>

<h1>飲むお酒と量、杯数を選択してください。</h1>

<form action="/sakeManagement/CalculationServlet" method="post">
<!-- ドリンクの名前とアルコール濃度をレコードごとに表示。POSTする値はレコードのID -->
<select name="selectedDrink">
<% for(int i=0 ; i<drinkList.length(); i++){ %>	
	<option value="<% drinkList.get(i).getId(); %>">
	<%= drinkList.get(i).getDrinkName() + "：" + drinkList.get(i).getAlcoholRate() %>
	</option>
<% } %>
</select>>

<!-- グラスの名前と容量をレコードごとに表示。POSTする値はレコードのID -->
<select name="selectedGlass">
<% for(int i=0 ; i<glassList.length(); i++){ %>	
	<option value="<% glassList.get(i).getId(); %>">
	<%= glassList.get(i).getGlassName() + "：" + glassList.get(i).getAmount() %>
	</option>
<% } %>
</select>>

<select name="number">
<% for(int i=1 ; i<=15 ; i++){ %>	
	<option value="<%= i %>">
	<%= i %>
	</option>
<% } %>
</select>>

<input type="submit" value="計算"> 
</form>
</body>
</html>