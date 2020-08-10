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
	<link rel="stylesheet" href="resources/css/championDataStyle.css">
	<link rel="stylesheet" href="resources/css/championDataStyleMedia.css">
	
	<!-- JS -->
	<script src = "resources/js/main.js" defer></script>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.rawgit.com/eligrey/FileSaver.js/5ed507ef8aa53d8ecfea96d96bc7214cd2476fd2/FileSaver.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.js"></script>
	
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
			
			<div class = "blankMenu">
				<div>
			   		<button id="save">저장하기</button>
				</div>
			</div>
			
			<div class = "navbar_menu_div">
				<ul class="navbar__menu">
				<li class="navbar__menu__item" > <a href = "../" > Home </a> </li>
				<li class="navbar__menu__item" > <a href = "../LoLCard?summonerName=${summonerName }" > LoLCard </a> </li>
				<li class="navbar__menu__item" > <a href = "../positionData?summonerName=${summonerName }&mostPosition=${mostPosition }&mostChampion=${mostChampion}" > 포지션 </a> <br> 카드 </li>
				<li class="navbar__menu__item" > <a href = "../championData?summonerName=${summonerName }&mostChampion=${mostChampion }&mostPosition=${mostPosition }"> 챔피언 </a> <br> 카드 </li>
			</ul>
			</div>
			
		</nav>
		
		<!-- 보여질 데이터 : summonerName, championSelect, championImg, championName, 
		               mark123, markname, content, chart and score-->
		<div class = "championData" id = "championData">
			<div class = "champion__left">
				<div class = "nameAndSelect">
					<div class = "summonerName">
						<h4>${summonerName }</h4> 
					</div>
					<div class = "champion_select">
						<select name="championList" onchange="window.open(value,'_self');">
						    <option class = "champion1" selected 
						    value="../championData?summonerName=${summonerName }&championId=${champion1 }&mostPosition=${mostPosition }"> ${champion1 } </option>
						    <option class = "champion2" 
						    value="../championData?summonerName=${summonerName }&championId=${champion2 }&mostPosition=${mostPosition }"> ${champion2 } </option>
						    <option class = "champion3" 
						    value="../championData?summonerName=${summonerName }&championId=${champion3 }&mostPosition=${mostPosition }"> ${champion3 } </option>
						</select>
					</div>
				</div> 
				
				<div class="centerAlign">
					<img src = "${championImg }" class = "positionImg">
				</div>
				
				<div class = "centerAlign">
					<h3> ${championName }</h3>
				</div>
				
				<div class = "markTitle">
					<h3> 당신의 장점 BEST3</h3>
				</div>
				
				<div class = "mark__List">
					<div class = "mark__div">
						<img src = "${championData.markFirstImg }" title = "${championData.markFirstExplain }" class = "markImg">
						<h4 class = "markName"> ${championData.markFirstName } </h4>
					</div>
					<div class = "mark__div">
						<img src = "${championData.markSecondImg }" title = "${championData.markSecondExplain }" class = "markImg">
						<h4 class = "markName"> ${championData.markSecondName } </h4>
					</div>
					<div class = "mark__div">
						<img src = "${championData.markThirdImg }" title = "${championData.markThirdExplain }" class = "markImg" >
						<h4 class = "markName"> ${championData.markThirdName } </h4>
					</div>
				</div>
				
			</div>
			<div class = "champion__right">
				<!-- Radar chart -->
				<div class = "RadarChart">
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
						    data: [${championData.rankResult_4 }, 
						    	${championData.rankResult_5 }, 
						    	${championData.rankResult_6 }, 
						    	${championData.rankResult_7 }, 
						    	${championData.rankResult_8 }, 
						    	${championData.rankResult_9 }]
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
				
			
				<div class = "tableDiv">
					<table id = "champion__table">
						<tr>
							<th> 성장 </th>
							<th> 킬관여율 </th>
							<th> 시야점수 </th>
							<th> 오브젝트 </th>
							<th> 전투력 </th>
							<th> CC </th>
						</tr>
						<tr>
							<td> ${championData.rankResult_4 } </td>
							<td> ${championData.rankResult_5 } </td>
							<td> ${championData.rankResult_6 } </td>
							<td> ${championData.rankResult_7 } </td>
							<td> ${championData.rankResult_8 } </td>
							<td> ${championData.rankResult_9 } </td>
						</tr>
					</table>
				</div>
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
		<script type="text/javascript">
			$(function(){
			   $("#save").click(function() { 
			        html2canvas($("#championData"), {
			            onrendered: function(canvas) {
			                canvas.toBlob(function(blob) {
			                    saveAs(blob, 'championData.png');
			                });
			            }
			        });
			    });
			});
		</script>
	
	</html>