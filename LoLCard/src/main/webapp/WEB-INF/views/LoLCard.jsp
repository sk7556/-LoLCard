<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LoLCard - ${LoLCard.summonerName } </title>
</head>
<body>
	<h1> 오우야 </h1>
	
	<h2> 소환사이름 </h2>
	<h3> ${LoLCard.summonerName } </h3>
	<img src = ${profileImgURL } >
	<hr>
	<h2> 승 / 패 </h2>
	<h3> ${LoLCard.wins } / ${LoLCard.losses } </h3>
	<h2> 랭크 티어 - 점수</h2>
	<h3> ${LoLCard.rank} 티어 : ${LoLCard.tier } 점수 : ${LoLCard.leaguePoints } </h3>
	
	<h2> 모스트 1 챔피언 </h2>
	<h3> ${LoLCard.mostChampName1 } </h3>
	<img src = ${LoLCard.mostChampion1Img }>
	<h2> 모스트 2 챔피언 </h2>
	<h3> ${LoLCard.mostChampName2 } </h3>
	<img src = ${LoLCard.mostChampion2Img }>
	<h2> 모스트 3 챔피언 </h2>
	<h3> ${LoLCard.mostChampName3 } </h3>
	<img src = ${LoLCard.mostChampion3Img }>
	
	
	<h2> 최애 룬 </h2>
	<h3> ${LoLCard.mostRuneName } </h3>
	<h2> 최애 룬 설명 </h2>
	<h3> ${LoLCard.mostRuneEx } </h3>
	<h2> 최애 아이템</h2>
	<h3> ${LoLCard.mostItemName } </h3>
	<h2> 최애 아이템 설명</h2>
	<h3> ${LoLCard.mostPosition } </h3>
	
	
</body>
</html>