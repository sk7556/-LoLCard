<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 포지션 카드 - ${mostPosition } </title>
	<!-- 데이터리스트 -->
	<!-- model.addAttribute("laneData", ChampDTO);	-->
	<!-- model.addAttribute("mostPosition", mostPosition); // 포지션이름전송	-->
	<!-- String laneImg =  "resources/img/" + mostPosition + ".png";	-->
	<!-- model.addAttribute("langImg", laneImg);	-->
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css?after"> 
	
	<!-- CSS -->
	<link rel="stylesheet" href="resources/css/root.css">
	<link rel="stylesheet" href="resources/css/positionDataStyle.css">
	<link rel="stylesheet" href="resources/css/positionDataStyleMedia.css">
	
	<!-- JS -->
	<script src = "resources/js/main.js" defer></script>	
	
	<!-- Font -->
	<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300;500;700&display=swap !important" rel="stylesheet">
	
	
</head>
<body>
	<nav id = "navbar">
		<div class="navbar__logo">
			포지션 카드 - ${mostPosition }
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
				<li class="navbar__menu__item" > 첫화면으로 </li>
				<li class="navbar__menu__item" > LoLCard </li>
				<li class="navbar__menu__item" > 포지션 카드 </li>
				<li class="navbar__menu__item" > 챔피언 카드 </li>
			</ul>
		</div>
	</nav>
	
	<div class = "position__Card">
		<div class = "position__Data">
			<div class = "nameAndSelect">
				<div class = "summonerName">
				
				</div>
				<div class = "position__select">
				
				
				</div>
			</div> 
			<div class = "position__ImgName">
				<img src = "" class = "positionImg">
				<h3 class = "position__Name"></h3>
			</div> 
			<div class = "position__Status">	
				<!-- ChartJS : RADaRChart -->
				<div class = "position__Content">
					<h4> 함께 플레이한 유저들과의 비교 순위를 기준으로 통계를 낸 데이터입니다. </h4>
				</div>
			
				<table id = "position__table">
					<tr>
						<th> 성장 </th>
						<th> 킬관여율 </th>
						<th> 시야점수 </th>
						<th> 오브젝트 </th>
						<th> 전투력 </th>
						<th> CC </th>
					</tr>
					<tr>
						<td> ${laneData.rankResult_4 } </td>
						<td> ${laneData.rankResult_5 } </td>
						<td> ${laneData.rankResult_6 } </td>
						<td> ${laneData.rankResult_7 } </td>
						<td> ${laneData.rankResult_8 } </td>
						<td> ${laneData.rankResult_9 } </td>
					</tr>
				</table>
			</div> <!-- End Position Status -->
		
		</div> <!-- End Position Card -->
		
		<div class = "footer">
			<div>
				<h3> 개발자 정보</h3>
			</div>
			<div>
				<h3> 남정식 / sk7556@naver.com </h3>
			</div>
		</div> <!-- End Footer -->
	</div> <!-- End position Card -->
	
	
	<h1> 확인차 </h1>
	
	<h3> laneData.markFirstNum </h3>
	<h3> ${laneData.markFirstNum }</h3>
	<h3> rankResult_4 </h3>
	<h3> ${laneData.rankResult_4 }</h3>
	
	<h3> laneImg </h3>
	<h3> ${laneImg }</h3>
	
</body>
</html>