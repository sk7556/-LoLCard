package com.bean.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
import com.bean.dto.champResultDTO;
import com.bean.dto.matchInfoDTO;
import com.bean.dto.matchPlayInfoDTO;
import com.bean.service.matchService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class MatchController {
		
	@Inject
	private matchService service;
	
	@Inject
	private champResultDTO ChampDTO;
	
	String API_KEY = api_key.API_KEY;
	
	// championId, summonerName을 받으면 챔피언의 데이터 9개를 출력합니다.
	//----------------------------------------------------------------
	// summonerName을 통해 최근 최대 30판 matchID를 추출합니다. 
	// matchID별로 championId에 해당하는 데이터를 뽑아냅니다. 
	// matchPlayerData n판을 합산하여 가장 높은 순서로 3개를 추출하여
	// 변수를 3개 지정해줍니다.
	// String rankResult[1] 	= "첫번째 평가항목" 
	// String rankResult[2] 	= "두번째 평가항목"
	// String rankResult[3] 	= "세번째 평가항목"
	// 일부 항목들을 합산하여 
	// "성장" 	= rankResult[4]
	// "킬관여" 	= rankResult[5]
	// "시야점수"	= rankResult[6] 
	// "오브젝트"	= rankResult[7] 
	// "전투력"	= rankResult[8] 
	// "CC"		= rankResult[9]
	//----------------------------------------------------------------
	@RequestMapping(value="/championData", method=RequestMethod.GET)
	public String matchDetail(Model model, HttpServletRequest httpServletRequest) {
	
		VersionCheck.checkVersion();
		BufferedReader br = null;
		
		String summonerName = httpServletRequest.getParameter("summonerName");
		int	championId 	= Integer.parseInt(httpServletRequest.getParameter("championId"));
		
		//----------------------------------------------------------------
		// MatchV4 에서 받는 데이터
		// matchDetail - playInformation
		// 검색한 유저의 매치 30판의 데이터를 입력 받습니다. 
		//----------------------------------------------------------------
						
		//------------------------------------------
		// Name 으로 accountId 찾기
		//------------------------------------------
		String accountId = nameToAccount(summonerName);
		//------------------------------------------
		// Name 으로  matchId 찾기
		//------------------------------------------		
		String gameId = null; // gameId리스트가 들어갈 배열 생성
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
		 
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
							 +accountId+"?api_key="+API_KEY;
			
			//-----------------------------------------------------JsonParse
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			
			String result = "";
			String line;
			
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			
			JsonParser jsonObj = new JsonParser();
			JsonObject arr = (JsonObject)jsonObj.parse(result);
			JsonArray jsonArr = (JsonArray)arr.get("matches");
			
			System.out.println("*************************소환사 이름 : " + summonerName +"\n" 
								+ "매칭 정보 : " + jsonArr.toString());
			
			for(int i=0; i<jsonArr.size(); i++) {
				JsonObject k =  (JsonObject)jsonArr.get(0); 
				gameId	= k.get("gameId").getAsString();
				
				System.out.println("*************게임아이디 출력 : " + gameId);
				
				// gameId마다 SQL에 데이터를 입력하기 
				matchDetail(gameId, championId);
			
				// 입력된 데이터를 기반으로 championStatic을 통해 matchPlayInfoDTO를 뽑아내서 순위 데이터 보기
				MID = championStatic(gameId, championId);
				
				System.out.println("***********************MID기본정보" + MID.toString());
				
		 		kills 				+= MID.getKills();
		 		deaths 				+= MID.getDeaths();
		 		assists 			+= MID.getAssists();
		 		largestKillingSpree += MID.getLargestKillingSpree();
		 		largestMultiKill 	+= MID.getLargestMultiKill();
		 		killingSprees 		+= MID.getKillingSprees();
		 		longestTimeSpentLiving += MID.getLongestTimeSpentLiving();
		 		doubleKills			+= MID.getDoubleKills();
		 		tripleKills			+= MID.getTripleKills();	
		 		quadraKills			+= MID.getQuadraKills();
		 		pentaKills			+= MID.getPentaKills();
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
		 		totalUnitsHealed	+= MID.getTotalUnitsHealed();
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
		 		visionWardsBoughtInGame += MID.getVisionWardsBoughtInGame(); 
		 		wardsPlaced += MID.getWardsPlaced();
		 		wardsKilled += MID.getWardsKilled();
		 		firstBloodKill += MID.getFirstBloodKill();// 퍼블이 있을 경우 1점 없을 경우 5점
		 		firstTowerKill += MID.getFirstTowerKill();// 포탑 퍼블이 있을 경우 1점 없을 경우 5점
		 		
		 		System.out.println("****킬 수 : " + kills);
			
		 	} // End For
			
			//--------------------------------------------------------
			// 데이터를 랭크 매기기 위해 배열로 작성
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
			 System.out.println("야야야야야요요요요요");
			 rankData[42] =		firstTowerKill;// 포탑 퍼블이 있을 경우 1점 없을 경우 5점
			 
			//--------------------------------------------------------
			
			
			 
			// 출력이 되는 변수 3개 지정
			// rankResult[1], rankResult[2], rankResult[3]
			// 제일 작은 값부터 1,2,3을 지정한다 ( 순위 데이터이므로 낮은게 더 우월한 수치 ) 
			 
			for(int i=1; i < rankData.length; i++) {
				for(int j=0; j < rankData.length-i; j++) {
					if(rankData[i] < rankData[i+j]) {
						rankResult[1] = i;
					} else {
						rankResult[1] = i+j;
					}
				}
			}
			
			rankData[rankResult[1]] = 0;
			 
			for(int i=0; i < rankData.length; i++) {
				for(int j=0; j < rankData.length-i; j++) {
					if(rankData[i] > rankData[i+j]) {
						rankResult[2] = i;
					} else {
						rankResult[2] = i+j;
					}
				}
			}
			
			rankData[rankResult[2]] = 0;
			 
			for(int i=0; i < rankData.length; i++) {
				for(int j=0; j < rankData.length-i; j++) {
					if(rankData[i] > rankData[i+j]) {
						rankResult[3] = i;
					} else {
						rankResult[3] = i+j;
					}
				}
			}
			
			// rankResult[4~9]를 마련하자.
			// 10에서 뺀 값을 주어 값을 확인해보자. 
			// 성장		
			rankResult[4] = (int)(10 - (champLevel + goldEarned)/ (2 * jsonArr.size()));
			// 킬관여
			rankResult[5] = (int)(10 - (kills + assists + killingSprees) / (3 * jsonArr.size()));
			// 시야 점수
			rankResult[6] = (int)(10 - (visionScore + visionWardsBoughtInGame + wardsPlaced + wardsKilled)/(4*jsonArr.size()));
			// 오브젝트
			rankResult[7] = (int)(10 - (damageDealtToObjectives + 
							damageDealtToTurrets + 
							turretKills + 
							inhibitorKills + firstTowerKill) / (5*jsonArr.size()));
			// 전투력
			rankResult[8] = (int)(10 - (kills 
							+ assists 
							+ killingSprees 
							+ totalDamageDealt 
							+ totalHeal 
							+ damageSelfMitigated 
							+ totalDamageTaken) / (7*jsonArr.size())) ;
			// CC
			rankResult[9] = (int)(10 - timeCCingOthers / jsonArr.size());
				
			//***************************************************************		
			// DTO에 정보를 넣어서 모델로 보내버립시다.
			// DTO : ChampDTO ( rankResult의 변수 9개 ) 
			//***************************************************************		
			
			
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		} // End TryCatch
		
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<매치정보리스트
		model.addAttribute("championData", ChampDTO);
		
		return "championData";
	} // End matchDetail Controller
	
	//----------------------------------------------------------------
	// MatchV4 에서 받는 데이터
	// matchDetail - playInformation
	// 검색한 유저의 매치 1판의 모든 유저의 결과 데이터를 입력 받습니다. 
	//----------------------------------------------------------------
	public void matchDetail(String matchId, int	championId) {
		
	VersionCheck.checkVersion();
	BufferedReader br = null;
	
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
		
		System.out.println("********matchInfoParticipants : " + arr2.toString());
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
			
		} // End for 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	} // End SearchData
	
	//----------------------------------------------------------------
	// SQL
	// 추출 테이블 : matchPartyData
	// 출력 테이블 : matchInfoDTO 순위정보
	// matchPlayInfoDTO --> matchInfoDTO(순위)
	//----------------------------------------------------------------
	public matchInfoDTO championStatic(String matchId, int championId) {
			
	// 랭킹의 데이터를 matchInfoDTO 형태로 구함. 해당 데이터는 챔피언의 경우 사용하게 됨.
	return service.selectRanking(matchId, championId);
	
	} // End public void championStatic
	
	String nameToAccount(String summonerName) {
		BufferedReader br = null;
		String SummonerName = summonerName;
		String accountId = "";	
		
		try{
			// summonerV4에서 필요한 데이터는 레벨  - ICON 정도인듯.
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
					SummonerName.replace(" ", "")+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			} // End while
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			
			// 데이터 나누기
			accountId = k.get("accountId").getAsString();
					
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return accountId;
	} // End Name to Account
	
}
