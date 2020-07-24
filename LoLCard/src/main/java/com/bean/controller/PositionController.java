package com.bean.controller;

import java.io.BufferedReader;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.api.api_key;
import com.bean.config.VersionCheck;
import com.bean.service.matchService;

// 챔피언의 데이터를 받아 매치 여러판의 데이터를 분석하는 컨트롤러
@Controller
public class PositionController {
		
	@Inject
	private matchService service;
	
	String API_KEY = api_key.API_KEY;
	
	// Position위치, SummonerName을 받으면 해당 유저의 포지션 Most정보를 출력합니다.
	//----------------------------------------------------------------
	// 데이터는 입력 받지 않습니다.
	// 기본 LoLCardMatch 테이블에서  Position(LANE) 및  SummonerName 기반으로 최대 30판의 MatchID출력합니다.
	// 해당하는 matchID의 순위 데이터를 종합하여 점수를 산출합니다.
	//----------------------------------------------------------------
	@RequestMapping(value="/positionData", method=RequestMethod.GET)
	public String positionData(Model model, HttpServletRequest httpServletRequest) {
	
		VersionCheck.checkVersion();
		BufferedReader br = null;
		
		String summonerName = httpServletRequest.getParameter("summonerName");
		String mostPosition	= httpServletRequest.getParameter("mostPosition");
		
		
		return "positionData";
	} // End champMatchDetail Controller
	
	
	
}
