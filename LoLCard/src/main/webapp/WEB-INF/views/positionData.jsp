<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 포지션 데이터 </title>
	<!-- 데이터리스트 -->
	<!-- model.addAttribute("laneData", ChampDTO);	-->
	<!-- model.addAttribute("mostPosition", mostPosition); // 포지션이름전송	-->
	<!-- String laneImg =  "resources/img/" + mostPosition + ".png";	-->
	<!-- model.addAttribute("langImg", laneImg);	-->
</head>
<body>
	<h1> 확인차 </h1>
	
	<h3> laneData.markFirstNum </h3>
	<h3> ${laneData.markFirstNum }</h3>
	<h3> rankResult_4 </h3>
	<h3> ${laneData.rankResult_4 }</h3>
	
	<h3> laneImg </h3>
	<h3> ${laneImg }</h3>
	
</body>
</html>