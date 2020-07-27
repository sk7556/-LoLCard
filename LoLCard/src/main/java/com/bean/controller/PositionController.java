package com.bean.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.api.api_key;
import com.bean.config.VersionCheck;
import com.bean.dto.champResultDTO;
import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;
import com.bean.service.matchService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// 챔피언의 데이터를 받아 매치 여러판의 데이터를 분석하는 컨트롤러
@Controller
public class PositionController {
		
	@Inject
	private matchService service;
	
	String API_KEY = api_key.API_KEY;
	
	int AnlysisNum = 0; // 횟수 체크용 임시 변수
	
	// Position위치, SummonerName을 받으면 해당 유저의 포지션 Most정보를 출력합니다.
	//----------------------------------------------------------------
	// 데이터는 입력 받지 않습니다.
	// 1. LoLCardMatch , Lane = {position}인 matchId를 추출.
	// 2. matchId에 해당하는 데이터를 이용해서  순위 데이터 및 잘하는 역할 분석
	// http://localhost:8088/positionData?summonerName=Mother&mostPosition=BOTTOM
	//----------------------------------------------------------------
	@RequestMapping(value="/positionData", method=RequestMethod.GET)
	public String positionData(Model model, HttpServletRequest httpServletRequest) {
	
		champResultDTO ChampDTO = null;		
		String summonerName = httpServletRequest.getParameter("summonerName");
		String mostPosition	= httpServletRequest.getParameter("mostPosition");
		
	try {
		
		//-----------------------------------------------------------------
		//
		// 포지션에 해당하는 matchID를 확인하자.
		//
		//-----------------------------------------------------------------
		
		List<String> matchIdList = service.selectMatchId(summonerName, mostPosition);
		String[] matchIdStringList = matchIdList.toArray(new String[matchIdList.size()]);
		
		// System.out.println("매치아이디리스트 : " + matchIdList.toString());
		
		//-----------------------------------------------------------------
		//
		// matchIdList를 가지고 해당하는 매치의 플레이 점수를 매겨보자.
		//
		//-----------------------------------------------------------------
		
		VersionCheck.checkVersion();
		BufferedReader br = null;
		
		matchInfoDTO MID = null;
		int rankData[] = new int[43];
		int rankResult[] = new int[10];	// 결과가 되는 변수값 3개 지정
		
		
		//--------------------------------------------------------
		// 최대 30매치의 순위 점수를 합산하기 위한 변수 마련
		 int		kills = 0;						
		 int		deaths= 0;
		 int		assists= 0;
		 int		largestKillingSpree= 0;
		 int		largestMultiKill= 0;
		 int		killingSprees= 0;
		 int		longestTimeSpentLiving= 0;
		 int		doubleKills= 0;
		 int		tripleKills= 0;
		 int		quadraKills= 0;
		 int		pentaKills= 0;
		 int		totalDamageDealt= 0;
		 int		magicDamageDealt= 0;
		 int		physicalDamageDealt= 0;
		 int		trueDamageDealt= 0;
		 int		largestCriticalStrike= 0;
		 int		totalDamageDealtToChampions= 0;
		 int		magicDamageDealtToChampions= 0;
		 int		physicalDamageDealtToChampions= 0;
		 int		trueDamageDealtToChampions= 0;
		 int		totalHeal= 0;
		 int		totalUnitsHealed= 0;
		 int		damageSelfMitigated= 0;
		 int		damageDealtToObjectives= 0;
		 int		damageDealtToTurrets= 0;
		 int		visionScore= 0;
		 int		timeCCingOthers= 0;
		 int		totalDamageTaken= 0;
		 int		magicalDamageTaken= 0;
		 int		physicalDamageTaken= 0;
		 int		trueDamageTaken= 0;
		 int		goldEarned= 0;
		 int		turretKills= 0;
		 int		inhibitorKills= 0;
		 int		totalMinionsKilled= 0;
		 int		neutralMinionsKilledEnemyJungle= 0;
		 int		champLevel= 0;
		 int		visionWardsBoughtInGame= 0;
		 int		wardsPlaced= 0;
		 int		wardsKilled= 0;
		 int		firstBloodKill= 0;// 퍼블이 있을 경우 1점 없을 경우 5점
		 int		firstTowerKill= 0;// 포탑 퍼블이 있을 경우 1점 없을 경우 5점
		//--------------------------------------------------------
		 
		 for(int i = 0; i < matchIdStringList.length; i++) {
			 if(i < 30) { // 최대 30건까지만 검색. 입력하도록하자.
				matchDetailSummonerName(matchIdStringList[i], summonerName);
				 
				// myPlayData가 true인 데이터의 순위를 구하자.
				MID = laneStatic(matchIdStringList[i]);
				 
				System.out.println("***********************MID기본정보" + MID.toString());
					
		 		kills 				+= MID.getKills();
		 		deaths 				+= MID.getDeaths();
		 		assists 			+= MID.getAssists();
		 		largestKillingSpree += MID.getLargestKillingSpree();
		 		largestMultiKill 	+= MID.getLargestMultiKill();
		 		killingSprees 		+= MID.getKillingSprees();
		 		longestTimeSpentLiving += MID.getLongestTimeSpentLiving();
		 		
		 		// 더블킬-트리플킬-쿼드라킬-펜타킬은 등장하지 않는 경우가 발생할 수 있으므로 모두 0등이 될 수 있다. 
		 		// 10명 모두 0등일 경우 모두 10점을 부여하여 하지 않는 것으로 간주한다.
		 		if(MID.getDoubleKills() != 0)
		 		{
		 			doubleKills			+= MID.getDoubleKills();
		 		} else {
		 			doubleKills			+= 10; 
		 		}
		 		if(MID.getTripleKills() != 0)
		 		{
		 			tripleKills			+= MID.getTripleKills();
		 		} else {
		 			tripleKills			+= 10; 
		 		}
		 		if(MID.getQuadraKills() != 0)
		 		{
		 			quadraKills			+= MID.getQuadraKills();
		 		} else {
		 			quadraKills			+= 10; 
		 		}
		 		if(MID.getPentaKills() != 0)
		 		{
		 			pentaKills			+= MID.getPentaKills();
		 		} else {
		 			pentaKills			+= 10; 
		 		}
		 		
		 		totalDamageDealt	+= MID.getTotalDamageDealt();
		 		magicDamageDealt	+= MID.getMagicDamageDealt();	
		 		physicalDamageDealt	+= MID.getPhysicalDamageDealt();
		 		trueDamageDealt		+= MID.getTrueDamageDealt();
		 		largestCriticalStrike += MID.getLargestCriticalStrike();
		 		totalDamageDealtToChampions += MID.getTotalDamageDealtToChampions();
		 		magicDamageDealtToChampions += MID.getMagicDamageDealtToChampions();
		 		physicalDamageDealtToChampions += MID.getPhysicalDamageDealtToChampions();
		 		trueDamageDealtToChampions += MID.getTrueDamageDealtToChampions();
		 		totalHeal			+= MID.getTotalHeal();
		 		totalUnitsHealed	+= 10;						// ---사용하지 않는 데이터
		 		damageSelfMitigated += MID.getDamageSelfMitigated();
		 		damageDealtToObjectives += MID.getDamageDealtToObjectives();
		 		damageDealtToTurrets += MID.getDamageDealtToTurrets();
		 		visionScore += MID.getVisionScore();
		 		timeCCingOthers += MID.getTimeCCingOthers();
		 		totalDamageTaken += MID.getTotalDamageTaken();
		 		magicalDamageTaken += MID.getMagicalDamageTaken();
		 		physicalDamageTaken += MID.getPhysicalDamageTaken();
		 		trueDamageTaken += MID.getTrueDamageTaken();
		 		goldEarned += MID.getGoldEarned();
		 		turretKills += MID.getTurretKills();
		 		inhibitorKills += MID.getInhibitorKills();
		 		totalMinionsKilled += MID.getTotalMinionsKilled();
		 		neutralMinionsKilledEnemyJungle += MID.getNeutralMinionsKilledEnemyJungle();
		 		champLevel += MID.getChampLevel();
		 		visionWardsBoughtInGame += 10; 				// ---사용하지 않는 데이터
		 		wardsPlaced += 10;							// ---사용하지 않는 데이터
		 		wardsKilled += MID.getWardsKilled();
		 		firstBloodKill += MID.getFirstBloodKill();// 퍼블이 있을 경우 1점 없을 경우 5점
		 		firstTowerKill += MID.getFirstTowerKill();// 포탑 퍼블이 있을 경우 1점 없을 경우 5점
		 		
		 		AnlysisNum++;	
			 } 
		 }	// End For - 데이터 입력 및 분석 최대 30건
		 
		// **** 출력부
			
		//--------------------------------------------------------
		// 데이터를 랭크 매기기 위해 배열로 작성
		 rankData[0] =      99999; // 비교용 데이터
		 rankData[1] =		kills;		
		 rankData[2] =		deaths;
		 rankData[3] =		assists;
		 rankData[4] =		largestKillingSpree;
		 rankData[5] =		largestMultiKill;
		 rankData[6] =		killingSprees;
		 rankData[7] =		longestTimeSpentLiving;
		 rankData[8] =		doubleKills;
		 rankData[9] =		tripleKills;
		 rankData[10] =		quadraKills;
		 rankData[11] =		pentaKills;
		 rankData[12] =		totalDamageDealt;
		 rankData[13] =		magicDamageDealt;
		 rankData[14] =		physicalDamageDealt;
		 rankData[15] =		trueDamageDealt;
		 rankData[16] =		largestCriticalStrike;
		 rankData[17] =		totalDamageDealtToChampions;
		 rankData[18] =		magicDamageDealtToChampions;
		 rankData[19] =		physicalDamageDealtToChampions;
		 rankData[20] =		trueDamageDealtToChampions;
		 rankData[21] =		totalHeal;					 
		 rankData[22] =		totalUnitsHealed;
		 rankData[23] =		damageSelfMitigated;
		 rankData[24] =		damageDealtToObjectives;
		 rankData[25] =		damageDealtToTurrets;
		 rankData[26] =		visionScore; 
		 rankData[27] =		timeCCingOthers;
		 rankData[28] =		totalDamageTaken; 
		 rankData[29] =		magicalDamageTaken;
		 rankData[30] =		physicalDamageTaken;
		 rankData[31] =		trueDamageTaken;
		 rankData[32] =		goldEarned;
		 rankData[33] =		turretKills;
		 rankData[34] =		inhibitorKills;
		 rankData[35] =		totalMinionsKilled; 
		 rankData[36] =		neutralMinionsKilledEnemyJungle;
		 rankData[37] =		champLevel;
		 rankData[38] =		visionWardsBoughtInGame; 
		 rankData[39] =		wardsPlaced;
		 rankData[40] =		wardsKilled;
		 rankData[41] =		firstBloodKill;// 퍼블이 있을 경우 1점 없을 경우 5점
		 rankData[42] =		firstTowerKill;// 포탑 퍼블이 있을 경우 1점 없을 경우 5점

		//--------------------------------------------------------
		
		System.out.println("테스트테스트 " +
				rankData[1] + "    " +
				rankData[2] + "    " +
				rankData[3] + "    " +
				rankData[4] + "    " +
				rankData[5] + "    " +
				rankData[6] + "    " +
				rankData[7] + "    " +
				rankData[8] + "    " +
				rankData[9] + "    " +
				rankData[10] + "    " +
				rankData[11] + "    " +
				rankData[12] + "    " +
				rankData[13] + "    " +
				rankData[14] + "    "
				
				+ "추출한 횟수를 말해보렴" + AnlysisNum
				);
		
		 
		// 출력이 되는 변수 3개 지정
		// rankResult[1], rankResult[2], rankResult[3]
		// 제일 작은 값부터 1,2,3을 지정한다 ( 순위 데이터이므로 낮은게 더 우월한 수치 ) 
		 
		int min = 99999; // 최소값 기대치
		int minNum = 0; // 최소값의 번호
		 
		for(int i = 0 ; i < rankData.length; i++) {
			if(min > rankData[i]) {
				min = rankData[i];
				minNum = i;			// 최소값에 해당하는 rankData의 ID를 기록
			}
		}
		
		rankResult[1] = minNum; 	// 첫번째 성적을 min으로 지정
		min = 1000; 				// min 초기화
		minNum = 0;				// minNum 초기화
		rankData[rankResult[1]] = 100; // 기존 최소값을 최대 값으로 변경;
		 
		 for(int i = 0 ; i < rankData.length; i++) {
			if(min > rankData[i]) {
				min = rankData[i];
				minNum = i;			// 최소값에 해당하는 rankData의 ID를 기록
			}
		 }
		
		rankResult[2] = minNum; 	// 두번째 성적을 min으로 지정
		min = 1000; 					// min 초기화
		minNum = 0;					// minNum 초기화
		rankData[rankResult[2]] = 100; // 기존 최소값을 최대 값으로 변경;
		 
		for(int i = 0 ; i < rankData.length; i++) {
			if(min > rankData[i]) {
				min = rankData[i];
				minNum = i;			// 최소값에 해당하는 rankData의 ID를 기록
			}
		}
		
		rankResult[3] = minNum; 	// 세번째 성적을 min으로 지정
		
		// rankResult[4~9]를 마련하자.
		// 10에서 뺀 값을 주어 값을 확인해보자. 
		// 성장		
		rankResult[4] = (int)(10 - (champLevel + goldEarned)/(2 * AnlysisNum));
		// 킬관여
		rankResult[5] = (int)(10 - (kills + assists + killingSprees) / (3 * AnlysisNum));
		// 시야 점수
		rankResult[6] = (int)(10 - (visionScore + visionWardsBoughtInGame + wardsPlaced + wardsKilled)/(4*AnlysisNum));
		// 오브젝트
		rankResult[7] = (int)(10 - (damageDealtToObjectives + 
						damageDealtToTurrets + 
						turretKills + 
						inhibitorKills + firstTowerKill) / (5*AnlysisNum));
		// 전투력
		rankResult[8] = (int)(10 - (kills 
						+ assists 
						+ killingSprees 
						+ totalDamageDealt 
						+ totalHeal 
						+ damageSelfMitigated 
						+ totalDamageTaken) / (7*AnlysisNum)) ;
		// CC
		rankResult[9] = (int)(10 - timeCCingOthers / AnlysisNum);
			
		//***************************************************************		
		// DTO에 정보를 넣어서 모델로 보내버립시다.
		// DTO : ChampDTO ( rankResult의 변수 9개 ) 
		//***************************************************************		
		
		ChampDTO = new champResultDTO(rankResult[1], rankResult[2], rankResult[3],
							rankResult[4], rankResult[5], rankResult[6],
							rankResult[7], rankResult[8], rankResult[9]); 
		
		
		System.out.println("************DTO정보리스트 : " + ChampDTO.toString());
		model.addAttribute("laneData", ChampDTO);
		model.addAttribute("mostPosition", mostPosition); // 포지션이름전송
		String laneImg =  "resources/img/" + mostPosition + ".png";
		model.addAttribute("laneImg", laneImg);
	
		} catch(Exception e){
			System.out.println(e.getMessage());
	} // End TryCatch
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<매치정보리스트
		
		
		return "positionData";
	} // End champMatchDetail Controller
	
	
	
	
	
	public matchInfoDTO laneStatic(String matchId) {
		
		// 랭킹의 데이터를 matchInfoDTO 형태로 구함. 해당 데이터는 포지션별 데이터를 구할 때 사용하게 됨.
		return service.selectLaneRanking(matchId);
	}
	
	//----------------------------------------------------------------
	// MatchV4 에서 받는 데이터
	// matchDetail - playInformation
	// 검색한 유저의 매치 1판의 모든 유저의 결과 데이터를 입력 받습니다. 
	//----------------------------------------------------------------
	public void matchDetailSummonerName(String matchId, String summonerName) {
		
	VersionCheck.checkVersion();
	BufferedReader br = null;
	
	try {
		String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matches/" +
				matchId +"?api_key="+API_KEY;
		
		URL url = new URL(urlstr);
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
		
		String nameTemp = "";
		String result = "";
		String line;
		
		while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
			result = result + line;
		} 
		
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonResult = (JsonObject) jsonParser.parse(result);
		JsonArray jsonParticipants = (JsonArray)jsonResult.get("participants");
		
		// position에 의해서 summonerName을 추출하는 부분
		JsonArray jsonParticipantIdentities = (JsonArray)jsonResult.get("participantIdentities");
		for(int i = 0; i < jsonParticipantIdentities.size(); i++) {
			JsonObject playerSearch =  (JsonObject)jsonParticipantIdentities.get(i);
			JsonObject p	=  (JsonObject)playerSearch.get("player");
			
			boolean myPlayData = false;
			
			nameTemp = p.get("summonerName").getAsString();
			if(nameTemp.equals(summonerName)) {
				myPlayData = true;
			}
			JsonObject arr3 =  (JsonObject)jsonParticipants.get(i);
			JsonObject k	=  (JsonObject)arr3.get("stats");
			
			System.out.println("*************stats분리테스트 : " + k.toString());
			
			matchPlayInfoDTO match = new matchPlayInfoDTO();
			
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
			
		} // End - For ( participants ) 
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
	} // End SearchData
	
	
	
}
