<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Controller : DataMining -->
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
		
		.summonerMark{
			width:100px;
		}
		
	</style>

</head>
<body>
	<h1 align="center"> 소환사 정보 도출 </h1>
	
	<table class = "table">
		<thead>
			<tr>
				<th> 소환사이름 </th>
				<!-- <th> puuid </th> -->
				<th> 소환사레벨 </th>
				<th class = "summonerMark"> 소환사인장 </th>
				<!--<th> 어카운트아이디 </th>-->
				<th> summonerId </th>
				<th> 리그 네임 </th>
				<th> 리그인포 : 큐타입 </th>
				<th> 승수 </th>
				<th> 패수 </th>
				<!-- <th> 리그아이디 </th> -->
				<th> 랭크 </th>
				<th> 티어 </th>
				<th> 리그포인트 </th>
				<th> 베테랑여부 </th>
				<th> 버닝여부 </th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td> ${summoner.name}</td>
				<!-- 안보여줘도 되는 데이터 <th> ${summoner.puuid}</th>  -->
				<td> ${summoner.summonerLevel}</td>
				<td class = "summonerMark"> <img src=${profileImgURL} style="max-width: 100%;"> </td>
				<!--<th> ${summoner.accountId }</th>-->
				<th> ${summoner.id }</th>
				<td> ${leagueName }</td>
				<!-- LeagueEntrydto(String queueType,  int wins, int losses, String leagueId, String rank,
				String tier, int leaguePoints, boolean veteran, boolean hotStreak) -->
				<td> ${leagueInfo.queueType }</td>
				<td> ${leagueInfo.wins }</td>
				<td> ${leagueInfo.losses }</td>
				<!-- <td> ${leagueInfo.leagueId }</td> -->
				<td> ${leagueInfo.rank }</td>
				<td> ${leagueInfo.tier }</td>
				<td> ${leagueInfo.leaguePoints }</td>
				<td> ${leagueInfo.veteran } </td>
				<td> ${leagueInfo.hotStreak }</td>
			</tr>		
		</tbody>
	</table>
	
	<hr> <br>
	<h1 align="center"> 유저 플레이 정보 테스트 (10판) </h1>
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
	
	<hr> <br>
	<h1 align="center"> 유저 플레이 챔피언 리스트 (챔피언포인트 순 10명) </h1>
	<table class = "table">
		<thead>
			<!--  ChampionPlayList[i] = new ChampionMasteryDTO
						(championPointsUntilNextLevel, chestGranted, 
						championId, lastPlayTime, championLevel, 
						summonerId, championPoints, championPointsSinceLastLevel,
						tokensEarned); -->
			<tr>
				<th> 번호  </th>
				<th> 다음레벨까지챔피언경험치 </th>
				<th> chestGranted </th>
				<th> 챔피언명 </th>
				<th> 사진  </th>
				<th> 최근 플레이타임 </th>
				<th> 챔피언레벨 </th>
				<!--<th> summonerId </th> -->
				<th> 챔피언숙련도 </th>
				<!-- <th> 현재레벨의경험치 </th>  -->
				<!-- <th> tokensEarned </th>  -->
			</tr>
		</thead>
		<tbody>
			<!--  ChampionPlayList[i] = new ChampionMasteryDTO
						(championPointsUntilNextLevel, chestGranted, 
						championId, lastPlayTime, championLevel, 
						summonerId, championPoints, championPointsSinceLastLevel,
						tokensEarned); -->
			 
			<c:forEach items="${ChampionList}" var="Champion" 
						begin="0" end="9" varStatus = "status">
			<tr>
				<td> ${status.count } </td>
				<td> ${Champion.championPointsUntilNextLevel } </td>
				<td> ${Champion.chestGranted } </td>
				<td> ${Champion.championName } </td>
				<td> <img src = ${Champion.championImg }></td>
				<td> ${Champion.lastPlayTime } </td>
				<td> ${Champion.championLevel } </td>
				<!-- <td> ${Champion.summonerId } </td> -->
				<td> ${Champion.championPoints } </td>
				<!-- <td> ${Champion.championPointsSinceLastLevel } </td>  -->
				<!-- <td> ${Champion.tokensEarned } </td>  -->
			</tr>
			
			</c:forEach>
			
		</tbody>
		
	</table>
	
	
</body>
	
	
</html>
