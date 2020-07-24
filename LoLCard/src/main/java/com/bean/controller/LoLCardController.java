package com.bean.controller;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.bean.config.VersionCheck;
import com.bean.data.Champion;
import com.bean.data.Item;
import com.bean.data.Rune;
import com.bean.dto.LoLCardDTO;
import com.bean.dto.Summoner;
import com.bean.dto.matchDTO;
import com.bean.dto.staticPlayerDataDTO;
import com.bean.service.matchService;
import com.bean.api.api_key;

@Controller
public class LoLCardController {
	
	String API_KEY = api_key.API_KEY;
	
	@Inject
	private matchService service;
	
	//-----------------------------------------------------------------------------------------
	// LoLCard 메인 컨트롤러
	// 입력 데이터 : summonerName
	// 출력 데이터 : 
	//        	- 소환사 이름, 프로필 이미지, 소환사 레벨 ( SummonerV4 )
	//        	- 랭크, 티어, 리그포인트 ( LeagueV4 ) 
	//        	- 아이템 0~6, 룬 리스트, 챔피언, 승, 패 ( matchID )   
	// 데이터 추출 과정 : 
	// 			1. SummonerV4에서 summonerName을 사용하여 accountId, profileIconId, id를 추출
	//          2. LeagueV4에서 위에서 받은 id를 활용하여 rank, tier, leaguePoint 추출
	//          3. matchV4에서 위에서 받은 accountId를 활용하여 [ matchId 리스트 ]를 추출
	//          4. matchV4에서 만든 matchId리스트를 활용하여  
	//                  DTO[소환사 이름, 아이템, 룬, 챔피언, 승, 패, 생성시간 ] 데이터를 SQL에 입력
	//          5. SQL에서 [ 자주 플레이한 챔피언 1,2,3, 자주가는 라인 ] 을 추출 
	//  		6. SQL에서 [ 아이템, 룬 ] 의 통계를 추출
	//          7. 최종 추출 : [ 소환사 이름, 랭크, 티어, 리그포인트, 승, 패, 
	//                챔피언1,2,3+승패 , 최다아이템(통계-3번제외), 룬리스트(통계), ]  
	//-----------------------------------------------------------------------------------------
	
	@RequestMapping(value="/LoLCard", method=RequestMethod.GET)
	public String searchData(Model model, HttpServletRequest httpServletRequest) {
		
		VersionCheck.checkVersion();
		BufferedReader br = null;
		String SummonerName = httpServletRequest.getParameter("summonerName");
		
		//----------------------------------------------------------------
		// SummonerV4 에서 받는 데이터
		// summoner(profileIconId, name, puuid, summonerLevel, revisionDate, id, accountId)
		// 최종 추출 데이터 : 프로필 아이콘
		// 전달 데이터 : id, accountId
		//----------------------------------------------------------------
		
		Summoner nameCard = null;
		
		try{
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
					SummonerName.replace(" ", "")+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); 
			String result = "";
			String line;
			while((line = br.readLine()) != null) { 
				result = result + line;
			} 
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			
			// 데이터 나누기
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			String accountId = k.get("accountId").getAsString();
			
			nameCard = new Summoner(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId);
			
			model.addAttribute("profileImgURL", "http://ddragon.leagueoflegends.com/cdn/"+VersionCheck.profileiconVersion+"/img/profileicon/"+nameCard.getProfileIconId()+".png");

			System.out.println("네임카드" + nameCard.toString());
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//----------------------------------------------------------------
		// LeagueV4 에서 받는 데이터
		// 리그 인포 (queueType, wins, losses, leagueId, rank,tier, leaguePoints, Bunning)
		// 최종 추출 데이터 : 승, 패, 랭크, 티어, 리그포인트
		//----------------------------------------------------------------
		int wins = 0;
		int losses = 0;
		String rank = null;
		String tier = null;
		int leaguePoints = 0;
		
		try{
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+
					nameCard.getId()+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); 
			
			String result = "";
			String line;
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			JsonObject k =  (JsonObject) arr.get(0);
			
			wins = k.get("wins").getAsInt();
			losses = k.get("losses").getAsInt();
			rank = k.get("rank").getAsString();
			tier = k.get("tier").getAsString();
			leaguePoints = k.get("leaguePoints").getAsInt();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//----------------------------------------------------------------
		// Match V4 에서 받는 데이터
		// 		3. matchV4에서 위에서 받은 accountId를 활용하여 [ matchId 리스트 ]를 추출
		//      4. matchV4에서 만든 matchId리스트를 활용하여  
		//           DTO[소환사 이름, 아이템, 룬, 챔피언, 승, 패, 생성시간 ] 데이터를 SQL에 입력
		//      5. SQL에서 [ 자주 플레이한 챔피언 1,2,3, 자주가는 라인 ] 을 추출 
		// 		6. SQL에서 [ 아이템, 룬 ] 의 통계를 추출
		//----------------------------------------------------------------
		
		// 결과값 입력을 위한 변수 마련 
		// 분석 데이터를 받기 위한 DTO
		staticPlayerDataDTO SPDto = new staticPlayerDataDTO();
		
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
							 +nameCard.getAccountId()+"?api_key="+API_KEY;
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			
			String result = "";
			String line;
			
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			
			JsonParser jsonObj = new JsonParser();
			JsonObject arr = (JsonObject)jsonObj.parse(result);
			JsonArray jsonArr = (JsonArray)arr.get("matches");
			
			for(int i=0; i<jsonArr.size(); i++) {
				JsonObject k =  (JsonObject)jsonArr.get(i); 
				
				long	gameId		= k.get("gameId").getAsLong();  // 매치 ID
				int		champion	= k.get("champion").getAsInt(); // 챔피언 ID
				String	lane		= k.get("lane").getAsString(); // 포지션
				
				//-------------------------------------------------------------
				// matchV4에서 gameId를 통해 detail데이터 받아내기
				// SQL입력까지진행				
				matchDetailForMe(gameId, champion, SummonerName, lane);	
			} // End for - 최근 100판 자료 추출 및 저장 완료 
			
			/* 통계 --------------------------------------------------------------------
			 DAO에 요청하여 데이터의 평균 데이터를 추출, matchDTO형식으로 받음
			 	챔피언 1,2,3 - 룬 - 아이템 - 포지션. 이렇게 정보를 뽑음
			 	챔피언 1,2,3 : 가장 많이 플레이한 챔피언
			 	룬 : 매판 5개의 룬 중 가장 많이 사용한 룬
			 	아이템 : 매판 아이템 중 가장 많이 사용한 아이템
			 	포지션 : 가장 많이 플레이한 라인
			-------------------------------------------------------------------------*/
			
			// MySQL - LoLCardMatch로 부터 통계 받아내기
			SPDto = service.selectMatchData(SummonerName); 
			System.out.println("분석 데이터를 뽑아낸다. : " + SPDto.toString());
			
			// 통계 데이터를 변수에 지정해서 출력부로 전송
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		} // End MatchV4 
		
		//----------------------------------------------------------------
		// 출력부 
		// 최종 추출 : [ 소환사 이름, 랭크, 티어, 리그포인트, 승, 패, 
      	//                챔피언1,2,3+승패 , 최다아이템(통계-3번제외), 룬리스트(통계), ] 
		//----------------------------------------------------------------
		
		LoLCardDTO LoLCard = new LoLCardDTO();
		
		LoLCard.setSummonerName(SummonerName);	// SummonerName : get
		
		LoLCard.setWins(wins);					// wins      	: LeagueV4
		LoLCard.setLosses(losses);				// losses 		: LeagueV4
		LoLCard.setRank(rank);					// rank 		: LeagueV4
		LoLCard.setTier(tier);					// tier 		: LeagueV4
		LoLCard.setLeaguePoints(leaguePoints);	// leaguePoints : LeagueV4
		
		LoLCard.setMostChampion1(SPDto.getMostChampion_1());
		LoLCard.setMostChampion2(SPDto.getMostChampion_2());
		LoLCard.setMostChampion3(SPDto.getMostChampion_3());
		LoLCard.setMostRune(SPDto.getMostRune());
		LoLCard.setMostItem(SPDto.getMostItem());
		LoLCard.setMostPosition(SPDto.getMostPosition());
		
		LoLCard.setMostChampName1(Champion.searchChampion(SPDto.getMostChampion_1()));
		LoLCard.setMostChampName2(Champion.searchChampion(SPDto.getMostChampion_2()));
		LoLCard.setMostChampName3(Champion.searchChampion(SPDto.getMostChampion_3()));
		LoLCard.setMostChampion1Img("http://ddragon.leagueoflegends.com/cdn/10.14.1/img/champion/" + Champion.searchChampion(SPDto.getMostChampion_1()) + ".png");
		LoLCard.setMostChampion2Img("http://ddragon.leagueoflegends.com/cdn/10.14.1/img/champion/" + Champion.searchChampion(SPDto.getMostChampion_2()) + ".png");
		LoLCard.setMostChampion3Img("http://ddragon.leagueoflegends.com/cdn/10.14.1/img/champion/" + Champion.searchChampion(SPDto.getMostChampion_3()) + ".png");
		
		Rune rune = new Rune();
		rune.setRuneVal(SPDto.getMostRune());
		LoLCard.setMostRuneName(rune.MostRuneName);
		LoLCard.setMostRuneEx(rune.MostRuneEx);
		
		Item item = new Item();
		LoLCard.setMostItemName(item.setItemVal(LoLCard.getMostItem()));
		
		
		System.out.println("롤카드상태보기 ************ : \n" + LoLCard.toString());
		
		model.addAttribute("LoLCard", LoLCard);
		// 프로필 아이콘
		// model.addAttribute - profileImgURL	
		
		model.addAttribute("RuneImg", "");
		model.addAttribute("ItemImg", "http://ddragon.leagueoflegends.com/cdn/10.14.1/img/item/" + LoLCard.getMostItem() + ".png");
		model.addAttribute("RuneImg", "resources/img/Rune/" + LoLCard.getMostRune() +".png");
		model.addAttribute("PositionImg", "resources/img/Position/" + LoLCard.getMostPosition() + ".png");
		
		return "LoLCard";
	} // End - public searchData
	
	public void matchDetailForMe(long matchId, int championId, String SummonerName, String lane) {
		
		VersionCheck.checkVersion();
		BufferedReader br = null;
		matchDTO match = new matchDTO();
		
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matches/" +
					matchId +"?api_key="+API_KEY;
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			
			String result = "";
			String line;
			
			while((line = br.readLine()) != null) { 
				result = result + line;
			} 
			
			JsonParser jsonParser = new JsonParser();
			JsonObject resultJson = (JsonObject) jsonParser.parse(result);
			JsonArray participants = (JsonArray)resultJson.get("participants");
			
			//System.out.println( "나와라" + participants.toString());
			
			// matchPlayInfoDTO를 통해 플레이어 수치 데이터를 입력받아 DAO - SQL에 전송하여 비교 데이터를 다시 넘겨받는다.
			for(int i=0; i < participants.size(); i++) {
				JsonObject arr3 =  (JsonObject)participants.get(i);
				
				if(championId == arr3.get("championId").getAsInt()) {
					JsonObject stats	=  (JsonObject)arr3.get("stats");
					
					System.out.println("스탯테스트 : " + stats.toString());
					
					String summonerName = SummonerName;
					int item0 = stats.get("item0").getAsInt();
					int item1 = stats.get("item1").getAsInt();
					int item2 = stats.get("item2").getAsInt();
					// 3번은 와드이기 때문에 제외 
					int item4 = stats.get("item4").getAsInt();
					int item5 = stats.get("item5").getAsInt();
					int item6 = stats.get("item3").getAsInt();
					
					int runeMain = stats.get("perkPrimaryStyle").getAsInt();
					int runeSub	 = stats.get("perkSubStyle").getAsInt();
					int rune_0 = stats.get("perk0").getAsInt();
					int rune_1 = stats.get("perk1").getAsInt();
					int rune_2 = stats.get("perk2").getAsInt();
					int rune_3 = stats.get("perk3").getAsInt();
					int rune_4 = stats.get("perk4").getAsInt();
					int rune_5 = stats.get("perk5").getAsInt();
					
					match = new matchDTO(summonerName, matchId, championId, lane, item0, item1, item2,
							item4,item5,item6, runeMain, runeSub, rune_0, rune_1, 
							rune_2, rune_3, rune_4, rune_5);
					
					System.out.println("match체크" + match.toString());
					
					// matchDTO의 데이터를 SQL에 보내자.
					service.insertMatchList(match);
					
				} // End if ( check championId ) 
			} // End for 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} // matchDetail for mychampion
	
	
}
