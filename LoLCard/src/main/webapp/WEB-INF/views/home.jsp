<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<!Doctype html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title> 착한정식이의 홈페이지에 오신걸 환영합니다. </title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css?after">
	
	<!-- CSS -->
	<link rel="stylesheet" href="resources/css/root.css">
	<link rel="stylesheet" href="resources/css/homeStyle.css">
	<link rel="stylesheet" href="resources/css/homeStyleMedia.css">
	
	<!-- JS -->
	<script src = "resources/js/main.js" defer></script>	
	
	<!-- Font -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300;500;700&display=swap" rel="stylesheet">
	
</head>
<body>
	<div class = "container">
		<!-- logo -->
		<div id = "logoDiv">
			<img src="resources/img/LoLCard_logo.png" class = "logo">
		</div>
	    
	    <!-- DATALIST 검색 -->
		<div class = "searchBarData">
			<h3> 최근 유저의 계정정보를 검색해보세요! </h3>
			<form id="searchWindow" action="/data" method="GET">
				<div class="embed-submit-field">
					<input type="text" placeholder="당신의 아이디를 검색하세요!" name="title">
					<button type="submit">검색!</button>
				</div>
			</form>
		</div>
		<!-- END DATALIST 검색 --><br><br>		
	    <!-- ID를 이용한 LoLCard 검색 -->
	    <div class = "searchBar">
			<h3> 자신의 전적을 LoLCard로 발급받으세요! </h3>
			<form id="searchWindow" action="/LoLCard" method="GET">
				<div class="embed-submit-field">
					<input type="text" placeholder="당신의 아이디를 검색하세요!" name="summonerName" class = "textPlace">
					<button class = "searchButton" type="submit">검색!</button>
					<img src="resources/img/loading.gif" class = "logoo">
				</div>
			</form>
		</div>
		<br><br>
		<div>
			<div>
				<h3> 개발자 정보</h3>
			</div>
			<div>
				<h3> 남정식 / sk7556@naver.com </h3>
			</div>
		</div>
		
	</div>	 
    
    <script>
		
		/* t(); */ 
	</script>	
</body>
</html>
