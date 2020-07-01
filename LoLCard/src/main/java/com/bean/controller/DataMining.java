package com.bean.controller;

// import static com.bean.dao.ApiKeyValue.API_KEY;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.dao.SearchLogDao;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.bean.config.VersionCheck;
import com.bean.dto.LeagueEntrydto;
import com.bean.dto.Summoner;
import com.bean.dto.matchDTO;

@Controller
public class DataMining {
	
	private static final Logger logger = LoggerFactory.getLogger(DataMining.class);
	static String API_KEY = "RGAPI-5bfa142a-5e2a-478b-9867-ddb8eb5973e1";
	
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public String searchData(Model model, HttpServletRequest httpServletRequest) {
		
		VersionCheck.checkVersion();
		BufferedReader br = null;
		// get방식으로 받는 데이터 
		String SummonerName = httpServletRequest.getParameter("title");
		
		//----------------------------------------------------------------
		// SummonerV4 에서 받는 데이터
		// summoner(profileIconId, name, puuid, summonerLevel, revisionDate, id, accountId)
		//----------------------------------------------------------------
		
		Summoner temp= null;
		
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
			
			// 뽑아내고 싶은 데이터는 반드시 DTO와 1:1 매칭을 시켜줘야한다.
			temp = new Summoner(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId);
			// DTO형태로 내보내기 
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		model.addAttribute("summoner", temp);
		model.addAttribute("profileImgURL", "http://ddragon.leagueoflegends.com/cdn/"+VersionCheck.profileiconVersion+"/img/profileicon/"+temp.getProfileIconId()+".png");
		
		//----------------------------------------------------------------
		// LeagueV4 에서 받는 데이터
		// 리그 인포 ( queueType, wins, losses, leagueId, rank,tier, leaguePoints ) 
		// 리그 네임
		//----------------------------------------------------------------
		
		LeagueEntrydto leagueInfo = null;
		String leagueName = null;
		
		try{
			//여기에서 리그ID/큐타입/승패 등의 정보를 가져옴. LeagueV4
			
			// 이전 Summoner에서 getID 를 통해 ID를 가져온다. 
			// LeagueV4 - entries
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+
					temp.getId()+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			
			// HttpURLConnection의 형태 조사
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			// 왜 버퍼드리더를 쓰는걸까. 왜 인풋스트림리더를 쓰는걸까
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			
			String result = "";
			String line;
			// json의 라인을 result에 추가시킨다.
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			// json을 parse한다. arr에 배열 형태로 저장한다.
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			
			JsonObject k =  (JsonObject) arr.get(0);
			int wins = k.get("wins").getAsInt();
			int losses = k.get("losses").getAsInt();
			String rank = k.get("rank").getAsString();
			String tier = k.get("tier").getAsString();
			String queueType = k.get("queueType").getAsString();
			int leaguePoints = k.get("leaguePoints").getAsInt();
			String leagueId = k.get("leagueId").getAsString();
			
			leagueInfo = new LeagueEntrydto(queueType, wins, losses, leagueId, rank,tier, leaguePoints);
			
			// 리그 아이디를 info에서 얻어서 사용
			urlstr = "https://kr.api.riotgames.com/lol/league/v4/leagues/"+
					leagueInfo.getLeagueId()		+"?api_key="+API_KEY;
			
			
			// leagueName 만들기
			url = new URL(urlstr);
			urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			
			result = "";
			line ="";
			
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			jsonParser = new JsonParser();
			k = (JsonObject) jsonParser.parse(result);
			
			leagueName = k.get("name").getAsString();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		// 리그 네임 ( 모르가나의 추종자들.. )
		model.addAttribute("leagueName", leagueName);
		// 리그 인포 ( queueType, wins, losses, leagueId, rank,tier, leaguePoints ) 
		model.addAttribute("leagueInfo", leagueInfo);
		
		//----------------------------------------------------------------
		// Match V4 에서 받는 데이터
		// matchDTO( matches, platformId, gameId, role, season, 
		//           champion, queue, lane, timestamp ) 
		// 활용 주소 : /lol/match/v4/matchlists/by-account/{encryptedAccountId}
		//----------------------------------------------------------------
			
		matchDTO[] matchRef = null;
		try {
			String urlstr = "https://kr.api.riotgames.com//lol/match/v4/matchlists/by-account/"
							 +temp.getAccountId()+"?api_key="+API_KEY;
			
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
			// DTO가 어떤식으로 나오는지 보자
			// System.out.println("JSON-DTO출력방식*************************" + result);
			
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			//-----------------------------------------------------JsonParse
			
			
			//matchRef = new matchDTO[arr.size()];
			/*
			for(int i=0; i<arr.size(); i++) {
				JsonObject k =  (JsonObject) arr.get(i); // 하나씩 가르기 .. ? 
				
				// matchDTO( matches, platformId, gameId, role, season, 
				//           champion, queue, lane, timestamp ) 
				
				String 	platformId 	= k.get("platformId").getAsString();
				long	gameId		= k.get("gameId").getAsLong();
				int		champion	= k.get("champion").getAsInt();
				int		queue		= k.get("queue").getAsInt();
				int		season		= k.get("season").getAsInt();
				int		timestamp	= k.get("timestamp").getAsInt();
				String	role		= k.get("role").getAsString();
				String	lane		= k.get("lane").getAsString();
				
				// matchRef[i] = new matchDTO(platformId, gameId, champion, 
				//							queue, season, timestamp, role, lane);
			}
			*/
			//int cham = matchRef[0].getChampion();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		// 매치정보리스트
		model.addAttribute("matchRef", matchRef);

		
		
		return "DataTest";
	} // End - public searchData
	
}
