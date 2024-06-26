package com.bean.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bean.dao.matchPlayDAO;
import com.bean.dto.matchDTO;
import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;
import com.bean.dto.staticPlayerDataDTO;

@Service
public class matchService {
	
	private static final Logger logger = LoggerFactory.getLogger(matchService.class);
	
	@Inject
	private matchPlayDAO matchPlay;

	public int insertMatchPlay(matchPlayInfoDTO match) {
		
		logger.info("서비스-인서트매치");
		
		return matchPlay.insertMatch(match);
	}
	
	public matchInfoDTO selectRanking(String matchId, int championId) {
		logger.info("서비스-셀렉트랭킹");
		
		return matchPlay.selectRanking(matchId, championId);
	}

	public int insertMatchList(matchDTO matchRef) {
		logger.info("서비스-인서트매치리스트");
		
		return matchPlay.insertMatchList(matchRef);
	}

	public staticPlayerDataDTO selectMatchData(String summonerName) {
		
		logger.info("서비스-셀렉트매치데이타" );
		
		return matchPlay.selectMatchData(summonerName);
	}

	public List<String> selectMatchId(String summonerName, String mostPosition) {
		
		
		return matchPlay.selectMatchIdList(summonerName, mostPosition);
	}

	public matchInfoDTO selectLaneRanking(String matchId) {
		
		return matchPlay.selectLaneRanking(matchId);
	}
	
	
}
