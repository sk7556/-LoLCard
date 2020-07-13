package com.bean.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bean.dao.matchPlayDAO;
import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;

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
	
	
}
