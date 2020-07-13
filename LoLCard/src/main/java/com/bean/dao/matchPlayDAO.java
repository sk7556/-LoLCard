package com.bean.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;

@Repository
public class matchPlayDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(matchPlayDAO.class);
	
	@Inject	// MyBatis 실행을 위한 SqlSession 객체를 주입받는다.
	private SqlSession sqlSession;	
	
	private static final String Namespace = "com.bean.mapper.matchMapper";
	
	public int insertMatch(matchPlayInfoDTO match) {
		
		// SQL을 활용하여 데이터를 입력하는 준비를 합시다. 
		logger.info("*************matchPlayDAO에 도착했습니다.");
		
		return sqlSession.insert(Namespace + ".matchPlayInfo", match);
	}

	public matchInfoDTO selectRanking(String matchId, int championId) {
		
		logger.info("**************DAO-selectRanking");
		// 2개의 변수를 보내기 위해 해당 형태를 사용
		Map<String, Object> matchChamp = new HashMap<String, Object>();
		
		matchChamp.put("matchId", matchId);
		matchChamp.put("championId", championId);
		
		return sqlSession.selectOne(Namespace + ".selectRanking", matchChamp);
	}
	
	
	
}
