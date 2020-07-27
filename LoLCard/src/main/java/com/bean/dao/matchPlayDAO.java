package com.bean.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bean.controller.LoLCardController;
import com.bean.dto.matchDTO;
import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;
import com.bean.dto.staticPlayerDataDTO;

@Repository
public class matchPlayDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(matchPlayDAO.class);
	
	@Inject	// MyBatis 실행을 위한 SqlSession 객체를 주입받는다.
	private SqlSession sqlSession;	
	
	private static final String Namespace = "com.bean.mapper.matchMapper";
	
	public int insertMatch(matchPlayInfoDTO match) {
		
		return sqlSession.insert(Namespace + ".matchPlayInfo", match);
	}

	public matchInfoDTO selectRanking(String matchId, int championId) {
		
		// 2개의 변수를 보내기 위해 해당 형태를 사용
		Map<String, Object> matchChamp = new HashMap<String, Object>();
		
		matchChamp.put("matchId", matchId);
		matchChamp.put("championId", championId);
		
		return sqlSession.selectOne(Namespace + ".selectRanking", matchChamp);
	}

	public int insertMatchList(matchDTO matchRef) {

		
		return sqlSession.insert(Namespace + ".insertMatchList", matchRef);
	}

	public staticPlayerDataDTO selectMatchData(String summonerName) {

		logger.info("DAO-셀렉트매치데이타");
		
		return sqlSession.selectOne(Namespace + ".selectMatchData", summonerName);
	}

	public List<String> selectMatchIdList(String summonerName, String mostPosition) {
		
		logger.info("DAO-셀렉트 매치아이디 리스트");
		
		Map<String, Object> summonerPosition = new HashMap<String, Object>();
		
		summonerPosition.put("summonerName", summonerName);
		summonerPosition.put("mostPosition", mostPosition);
		
		return sqlSession.selectList(Namespace + ".selectMatchIdList", summonerPosition);
	}

	public matchInfoDTO selectLaneRanking(String matchId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".selectLaneRanking", matchId);
	}
	
	
	
}
