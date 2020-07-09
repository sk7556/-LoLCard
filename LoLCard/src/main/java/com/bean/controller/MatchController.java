package com.bean.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.api.api_key;
import com.bean.config.VersionCheck;
import com.bean.dao.matchPlayDAO;
import com.bean.dto.matchPlayInfoDTO;
import com.bean.service.matchService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class MatchController {
		
	@Inject
	private matchService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	String API_KEY = api_key.API_KEY;
	
	@RequestMapping(value="/match", method=RequestMethod.GET)
	public String matchDetail(Model model, HttpServletRequest httpServletRequest) {
	
		VersionCheck.checkVersion();
		BufferedReader br = null;
		
		String matchId 	= httpServletRequest.getParameter("matchId");
		int	championId 	= Integer.parseInt(httpServletRequest.getParameter("championId"));
		
		//----------------------------------------------------------------
		// MatchV4 에서 받는 데이터
		// matchDetail - playInformation
		// 
		//----------------------------------------------------------------
		
		matchPlayInfoDTO[] matchPlayInfoList = null;
		try {
			// 데이터를 받아오는 url 설정  + API키
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matches/" +
					matchId +"?api_key="+API_KEY;
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			
			String result = "";
			String line;
			
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			} 
			
			JsonParser jsonParser = new JsonParser();
			JsonObject arr1 = (JsonObject) jsonParser.parse(result);
			JsonArray arr2 = (JsonArray)arr1.get("participants");
			
			// System.out.println("********matchInfoParticipants : " + arr2.toString());
			// System.out.println("**********matchInfo의 JSON값 : " + k.toString());
			
			// matchPlayInfoDTO를 통해 플레이어 수치 데이터를 입력받아 DAO - SQL에 전송하여 비교 데이터를 다시 넘겨받는다.
			for(int i=0; i<arr2.size(); i++) {
				JsonObject arr3 =  (JsonObject)arr2.get(i);
				JsonObject k	=  (JsonObject)arr3.get("stats");
				
				// System.out.println("*************stats분리테스트 : " + k.toString());
				
				matchPlayInfoDTO match = new matchPlayInfoDTO();
				
				boolean myPlayData = false;
				
				// 플레이어의 데이터인지를 구분하는 코드
				if(championId == arr3.get("championId").getAsInt()) {
					myPlayData = true;
				}
				
				match.setChampionId(arr3.get("championId").getAsInt());
				match.setMatchId(Long.parseLong(matchId));
				match.setPrimaryCode(arr3.get("championId").getAsString()+matchId);
				match.setMyPlayData(myPlayData);
				match.setKills(k.get("kills").getAsInt());	
				match.setDeaths(k.get("deaths").getAsInt());
				match.setAssists(k.get("assists").getAsInt());
				match.setLargestKillingSpree(k.get("largestKillingSpree").getAsInt());
				match.setLargestMultiKill(k.get("largestMultiKill").getAsInt());
				match.setKillingSprees(k.get("killingSprees").getAsInt());
				match.setLongestTimeSpentLiving(k.get("longestTimeSpentLiving").getAsInt());
				match.setDoubleKills(k.get("doubleKills").getAsInt());
				match.setTripleKills(k.get("tripleKills").getAsInt());
				match.setQuadraKills(k.get("quadraKills").getAsInt());
				match.setPentaKills(k.get("pentaKills").getAsInt());
				match.setTotalDamageDealt(k.get("totalDamageDealt").getAsLong());
				match.setMagicDamageDealt(k.get("magicDamageDealt").getAsLong());
				match.setPhysicalDamageDealt(k.get("physicalDamageDealt").getAsLong());
				match.setTrueDamageDealt(k.get("trueDamageDealt").getAsLong());
				match.setLargestCriticalStrike(k.get("largestCriticalStrike").getAsInt());
				match.setTotalDamageDealtToChampions(k.get("totalDamageDealtToChampions").getAsLong());
				match.setMagicDamageDealtToChampions(k.get("magicDamageDealtToChampions").getAsLong());
				match.setPhysicalDamageDealtToChampions(k.get("physicalDamageDealtToChampions").getAsLong());
				match.setTrueDamageDealtToChampions(k.get("trueDamageDealtToChampions").getAsLong());
				match.setTotalHeal(k.get("totalHeal").getAsLong());
				match.setTotalUnitsHealed(k.get("totalUnitsHealed").getAsInt());
				match.setDamageSelfMitigated(k.get("damageSelfMitigated").getAsInt());
				match.setDamageDealtToObjectives(k.get("damageDealtToObjectives").getAsLong());
				match.setDamageDealtToTurrets(k.get("damageDealtToTurrets").getAsLong());
				match.setVisionScore(k.get("visionScore").getAsInt());
				match.setTimeCCingOthers(k.get("timeCCingOthers").getAsInt());
				match.setTotalDamageTaken(k.get("totalDamageTaken").getAsLong());
				match.setMagicalDamageTaken(k.get("magicalDamageTaken").getAsLong());
				match.setPhysicalDamageTaken(k.get("physicalDamageTaken").getAsLong());
				match.setTrueDamageTaken(k.get("trueDamageTaken").getAsLong());	
				match.setGoldEarned(k.get("goldEarned").getAsLong());
				match.setTurretKills(k.get("turretKills").getAsInt());
				match.setInhibitorKills(k.get("inhibitorKills").getAsInt());
				match.setTotalMinionsKilled(k.get("totalMinionsKilled").getAsInt());
				match.setNeutralMinionsKilledEnemyJungle(k.get("neutralMinionsKilledEnemyJungle").getAsInt());
				match.setChampLevel(k.get("champLevel").getAsInt());
				match.setVisionWardsBoughtInGame(k.get("visionWardsBoughtInGame").getAsInt());
				match.setWardsPlaced(k.get("wardsPlaced").getAsInt());
				match.setWardsKilled(k.get("wardsKilled").getAsInt());
				match.setFirstBloodKill(k.get("firstBloodKill").getAsBoolean());
				match.setFirstTowerKill(k.get("firstTowerKill").getAsBoolean());
				
				service.insertMatchPlay(match); // DAO에 담아서 SQL에 기록.
				// duplicate on 을 사용하여 현재 중복된 데이터는 primaryCode로 구분하여 들어가지 않는 상태
			}
			
			// 아래 matchInfoDTO 에서 데이터를 입력받기 위해 변수를 준비.
			int		participantId 	= 0;
			int		spell1Id 		= 0;
			int		spell2Id		= 0;	
			int		item0			= 0;
			int 	item1			= 0;
			int 	item2			= 0;
			int 	item3			= 0;
			int 	item4			= 0;
			int 	item5			= 0;
			int		item6			= 0;
			int		perk0			= 0;	
			int		perk1			= 0;
			int		perk2			= 0;	
			int		perk3			= 0;
			int		perk4			= 0;	
			int		perk5			= 0;
			
			for(int i=0; i<arr2.size(); i++) {
				JsonObject k =  (JsonObject)arr2.get(i);
				if(championId == k.get("championId").getAsInt()) { 
					// 참여자의 championId가 유저의 championId와 같을 때, 추출을 실시한다. 
					// System.out.println("접근성공 : " + k.get("championId").getAsInt());
					
					participantId 	= k.get("participantId").getAsInt();
					spell1Id 		= k.get("spell1Id").getAsInt();
					spell2Id		= k.get("spell2Id").getAsInt();	
					item0			= k.get("item0").getAsInt();
					item1			= k.get("item1").getAsInt();
					item2			= k.get("item2").getAsInt();
					item3			= k.get("item3").getAsInt();
					item4			= k.get("item4").getAsInt();
					item5			= k.get("item5").getAsInt();
					item6			= k.get("item6").getAsInt();
					perk0			= k.get("perk0").getAsInt();	
					perk1			= k.get("perk1").getAsInt();
					perk2			= k.get("perk2").getAsInt();	
					perk3			= k.get("perk3").getAsInt();
					perk4			= k.get("perk4").getAsInt();	
					perk5			= k.get("perk5").getAsInt();
					
					//matchInfoDTO와 연동하여 데이터를 전송 받을 준비.
				}				
			} // End For 
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//----------------------------------------------------------------
		// MatchV4 에서 받는 데이터
		// matchDetail - timeline
		//
		//----------------------------------------------------------------
		
		
		try {
			// 데이터를 받아오는 url 설정  + API키
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/timelines/by-match/" +
					matchId +"?api_key="+API_KEY;
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			
			String result = "";
			String line;
			
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			} 
			
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			
			//System.out.println("**********matchDetail의 JSON값 : " + k.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return "matchDetail";
	} // End matchDetail Controller
}
