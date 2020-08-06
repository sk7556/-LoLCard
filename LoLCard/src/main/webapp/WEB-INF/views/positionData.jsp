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
	
	<!-- JS / chart.js -->
	<script src = "resources/js/main.js" defer></script>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>	
	
	
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
				<li class="navbar__menu__item" > Home </li>
				<li class="navbar__menu__item" > LoLCard </li>
				<li class="navbar__menu__item" > 포지션 <br> 카드 </li>
				<li class="navbar__menu__item" > 챔피언 <br> 카드 </li>
			</ul>
		</div>
	</nav>
	
	<div class = "position__Card">
		<div class = "position__Data">
			<div class = "nameAndSelect">
				<div class = "summonerName">
					<!-- 해당 포지션 정보의 경우 반드시 대문자로 받아야한다. -->
					<h4>${summonerName } - ${mostPosition }</h4> 
				</div>
				<div class = "position__select">
					<select name="position">
					    <option class = "topPosition" value="TOP"> TOP </option>
					    <option class = "junglePosition" value="JUNGLE"> JUNGLE </option>
					    <option class = "midPosition" value="MID"> MID </option>
					    <option class = "bottomPosition" value="BOTTOM"> BOTTOM </option>
					</select>
				</div>
			</div> 
			
			<div class="centerAlign">
				<img src = "${laneImg }" class = "positionImg">
			</div>
			<div class = "position__Status">	
				<!-- ChartJS : RadarChart -->
				<div class="RadarChart">
					<canvas id="marksChart"></canvas>
					<!-- ChartJS : RadarChart : Script -->
					<script>
						var marksCanvas = document.getElementById("marksChart");
	
						var marksData = {
						  labels: ["성장", "킬관여율", "시야점수", "오브젝트", "전투력", "CC"],
						  datasets: [{
						    label: "게임 내 순위 점수",
						    borderColor: "rgba(52,34,252,1)",
						    backgroundColor: "rgba(52,34,252,0.5)",
						    data: [${laneData.rankResult_4 }, 
						    	${laneData.rankResult_5 }, 
						    	${laneData.rankResult_6 }, 
						    	${laneData.rankResult_7 }, 
						    	${laneData.rankResult_8 }, 
						    	${laneData.rankResult_9 }]
						  }, ]
						};

						var options = {
								scale: {
					        	ticks : {
					          	suggestedMin : 0,
					            suggestedMax : 10,
					            maxTicksLimit : 6
					          }
					        }
					    };
						
						var radarChart = new Chart(marksCanvas, {
						  type: 'radar',
						  data: marksData,
						  options: options
						});

					</script>
				</div>
				
				<div class = "position__Content">
					<h4> 함께 플레이한 유저들과의 비교 순위를 기준으로 통계를 낸 데이터입니다. </h4>
				</div>
			
				<div class = "tableDiv">
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
				</div>
			</div> <!-- End Position Status -->
		</div> <!-- End Position Data -->
	</div> <!-- End position Card -->
	<div class = "footer">
		<div>
			<h3 class = "centerAlign"> 개발자 정보</h3>
		</div>
		<div>
			<h3 class = "centerAlign"> 남정식 / sk7556@naver.com </h3>
		</div>
	</div> <!-- End Footer -->
</body>
</html>