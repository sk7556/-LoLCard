package com.bean.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bean.dao.matchPlayDAO;
import com.bean.dto.matchPlayInfoDTO;

@Service
public class matchService {
	
	private static final Logger logger = LoggerFactory.getLogger(matchService.class);
	
	@Inject
	private matchPlayDAO matchPlay;

	public int insertMatchPlay(matchPlayInfoDTO match) {
		
		logger.info("인서트매치플레이DAO에 도착");
		
		return matchPlay.insertMatch(match);
	}
	
	
	
}
