<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>챔피언 카드 - ${championName } </title>
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css?after"> 
	
	<!-- CSS -->
	<link rel="stylesheet" href="resources/css/root.css">
	<link rel="stylesheet" href="resources/css/LoLCardStyle.css">
	<link rel="stylesheet" href="resources/css/LoLCardStyleMedia.css">
	
	<!-- JS -->
	<script src = "resources/js/main.js" defer></script>	
	
	<!-- Font -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300;500;700&display=swap !important" rel="stylesheet">
</head>
<body>
	<nav id = "navbar">
		<div class="navbar__logo">
			챔피언 카드 - ${championName }
			<div class = "searchMenu">
			<form id="searchWindow" action="/LoLCard" method="GET">
				<div class="embed-submit-field">
					<input type="text" placeholder="소환사이름" name="summonerName">
					<button type="submit">검색!</button>
				</div>
			</form>
			</div>
		</div>
		
		<div class = "blankMenu"></div>
		
		<div class = "navbar_menu_div">
			<ul class="navbar__menu">
				<li class="navbar__menu__item" > Home </li>
				<li class="navbar__menu__item" > LoLCard </li>
				<li class="navbar__menu__item" > 포지션 <br> 카드 </li>
				<li class="navbar__menu__item" > 챔피언 <br> 카드 </li>
			</ul>
		</div>
		
	</nav>
	
	<!-- 보여질 데이터 : summonerName, championSelect, championImg, championName, 
	               mark123, markname, content, chart and score-->
	<div class = "championData">
		<div class = "champion__left">
			<div class = "nameAndSelect">
				<div class = "summonerName">
					<h4>${summonerName }</h4> 
				</div>
				<div class = "champion_select">
					<select name="position">
					    <option class = "topPosition" value="TOP"> TOP </option>
					    <option class = "junglePosition" value="JUNGLE"> JUNGLE </option>
					    <option class = "midPosition" value="MID"> MID </option>
					    <option class = "bottomPosition" value="BOTTOM"> BOTTOM </option>
					</select>
				</div>
			</div> 
			
			<div class="centerAlign">
				<img src = "${championImg }" class = "positionImg">
			</div>
			
			<div class = "centerAlign">
				<h4> ${championName }</h4>
			</div>
			
		</div>
		<div class = "champion__right">
		
		</div>
			
	</div> <!-- End championData -->
			
	<div class = "footer">
		<div>
			<h3> 개발자 정보</h3>
		</div>
		<div>
			<h3> 남정식 / sk7556@naver.com </h3>
		</div>
	</div>
</body>
</html>