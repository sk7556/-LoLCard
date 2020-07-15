<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1> 참피온데타 </h1>
	
	<h2> 당신이 플레이한 챔피언 </h2>
	<img src = "${championImg }">
	<h2> ${championName }</h2>
	<h2> 당신의 첫번째 업적 </h2>
	<img src="resources/${championData.markFirstImg }">
	<h3> ${championData.markFirstName }</h3>
	<h3> ${championData.markFirstExplain }</h3>
	<h2> 당신의 두번째 업적 </h2>
	<img src="resources/${championData.markSecondImg }">
	<h3> ${championData.markSecondName }</h3>
	<h3> ${championData.markSecondExplain }</h3>
	<h2> 당신의 세번째 업적 </h2>
	<img src="resources/${championData.markThirdImg }">
	<h3> ${championData.markThirdName }</h3>
	<h3> ${championData.markThirdExplain }</h3>
	
	<h2> 당신의 성과 </h2>
	<h3> 성장 </h3>
	<h3> ${championData.rankResult_4 }	</h3>
	<h3> 킬관여 	</h3>
	<h3> ${championData.rankResult_5 }	</h3>
	<h3> 시야점수	</h3>
	<h3> ${championData.rankResult_6 }	</h3>
	<h3> 오브젝트	</h3>
	<h3> ${championData.rankResult_7 }	</h3>
	<h3> 전투력	</h3>
	<h3> ${championData.rankResult_8 }	</h3>
	<h3> CC </h3>
	<h3> ${championData.rankResult_9 } </h3>
	
	
</body>
</html>