<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title> Test Table View </title>
	<!-- font-awesome -->
	<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  	/>
  	
  	<!-- font -->
  	<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
  	
  	<!-- bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<style>
		.ellipsis {
			width : 30px;
			white-space: nowrap;
    		text-overflow: ellipsis;
		}
		
		#championImg {
			width: auto; 
			height: auto;
		    max-width: 100px;
		    max-height: 300px;
		}
		
	</style>

</head>
<body>
	<h1 align="center"> 테스트 테이블의 뷰 입니다. </h1>
	
	<br><br><br>
	
	<table class = "table">
		<thead>
			<tr>
				<th> 소환사이름 </th>
				<!-- <th> puuid </th> -->
				<th> 소환사레벨 </th>
				<th> 소환사인장 </th>
				<!--<th> 어카운트아이디 </th>-->
				<!--<th> 아이디 </th>-->
				<th> 리그 네임 </th>
				<!-- 리그 인포 ( queueType, wins, losses, leagueId, rank,tier, leaguePoints ) -->
				<th> 리그인포 : 큐타입 </th>
				<th> 승수 </th>
				<th> 패수 </th>
				<th> 리그아이디 </th>
				<th> 랭크 </th>
				<th> 티어 </th>
				<th> 리그포인트 </th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td> ${summoner.name}</td>
				<!-- 안보여줘도 되는 데이터 <th> ${summoner.puuid}</th>  -->
				<td> ${summoner.summonerLevel}</td>
				<td> <img src=${profileImgURL} style="max-width: 10%;"> </td>
				<!--<th> ${summoner.accountId }</th>-->
				<!--<th> ${summoner.id }</th>-->
				<td> ${leagueName }</td>
				<!-- 리그 인포 ( queueType, wins, losses, leagueId, rank,tier, leaguePoints ) -->
				<td> ${leagueInfo.queueType }</td>
				<td> ${leagueInfo.wins }</td>
				<td> ${leagueInfo.losses }</td>
				<td> ${leagueInfo.leagueId }</td>
				<td> ${leagueInfo.rank }</td>
				<td> ${leagueInfo.tier }</td>
				<td> ${leagueInfo.leaguePoints }</td>
			</tr>		
		</tbody>
	</table>
	
	<hr> <br><br>
	<h1 align="center"> 테스트 테이블 </h1>
	<table class = "table">
		<thead>
			<!--  matchRef[i] = new matchDTO(platformId, gameId, champion, 
											queue, season, timestamp, role, lane); -->
			<tr>
				<th> 번호 </th>
				<th> platformId </th>
				<th> gameId </th>
				<th> champion </th>
				<th> champion face </th>
				<th> queue </th>
				<th> season </th>
				<th> timestamp </th>
				<th> role </th>
				<th> lane </th>
			</tr>
		</thead>
		<tbody>
			<!--  matchRef[i] = new matchDTO(platformId, gameId, champion, 
											queue, season, timestamp, role, lane); -->
			 
			<c:forEach items="${matchRef}" var="match" 
						begin="0" end="9" varStatus = "status">
			 
			<tr>
				<td> ${status.count } </td>
				<td> ${match.platformId } </td>
				<td> ${match.gameId } </td>
				<td> ${match.champion } </td>
				<td > <img src = ${match.championImg } id="championImg"> </td>
				<td> ${match.queue } </td>
				<td> ${match.season } </td>
				<td> ${match.timestamp } </td>
				<td> ${match.role } </td>
				<td> ${match.lane } </td>
			</tr>
			</c:forEach>
			
			
		</tbody>
		
	</table>
	
	
</body>
	
	
</html>
