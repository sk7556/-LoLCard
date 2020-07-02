package com.bean.controller;

// import static com.bean.dao.ApiKeyValue.API_KEY;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
import com.bean.api.api_key;
import com.bean.config.VersionCheck;
import com.bean.dto.LeagueEntrydto;
import com.bean.dto.Summoner;

@Controller
public class SearchSummoner {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchSummoner.class);
	
	// API_KEY를 추가시켜봅시다. (현재 Developer API_KEY)
	String API_KEY = api_key.API_KEY;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchSummoner(Model model, HttpServletRequest httpServletRequest) {
		VersionCheck.checkVersion();
		BufferedReader br = null;
		String SummonerName = httpServletRequest.getParameter("title");
		Summoner temp= null;
		LeagueEntrydto[] leagueInfo = null;
		try{
			// puuid는 쓸모없는데 가져옴
			// summonerV4에서 필요한 데이터는 레벨  - ICON 정도인듯.
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+
					SummonerName.replace(" ", "")		+"?api_key="+API_KEY;
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
			temp = new Summoner(profileIconId,name,puuid,summonerLevel,revisionDate,id,accountId);
			// DTO형태로 내보내기 
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		// SQL에 자료를 기록하기 위함
		SearchLogDao dao = new SearchLogDao();
		dao.addSearchLog(temp);
		
		String[] leagueName = null;
		try{
			//여기에서 리그ID/큐타입/승패 등의 정보를 가져옴. LeagueV4
			
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+
					temp.getId()		+"?api_key="+API_KEY;
			URL url = new URL(urlstr);
			// 
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			// 왜 버퍼드리더를 쓰는걸까. 왜 인풋스트림리더를 쓰는걸까
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.
			logger.info("*************************br의 형태를 살펴보자\n" + br);
			
			String result = "";
			String line;
			// json의 라인을 result에 추가시킨다.
			while((line = br.readLine()) != null) { // 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			// json을 parse한다. arr에 배열 형태로 저장한다.
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			
			leagueInfo = new LeagueEntrydto[arr.size()];
			leagueName = new String[arr.size()];
			
			// 이런 방식으로 파싱
			for(int i=0; i<arr.size(); i++) { 
			// 굳이 배열로 할 필요가 없었어보인다.
				JsonObject k =  (JsonObject) arr.get(i);
				int wins = k.get("wins").getAsInt();
				int losses = k.get("losses").getAsInt();
				String rank = k.get("rank").getAsString();
				String tier = k.get("tier").getAsString();
				String queueType = k.get("queueType").getAsString();
				int leaguePoints = k.get("leaguePoints").getAsInt();
				String leagueId = k.get("leagueId").getAsString();
				
				leagueInfo[i] = new LeagueEntrydto(queueType, wins, losses, leagueId, rank,tier, leaguePoints);
				urlstr = "https://kr.api.riotgames.com/lol/league/v4/leagues/"+
						leagueInfo[i].getLeagueId()		+"?api_key="+API_KEY;
				
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
				// 리그 네임이 여러개 되는건가
				leagueName[i] = k.get("name").getAsString();
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.print(leagueInfo[0]);
		
		// 서모너:소환사DTO
		// 프로필이미지:서모너이미지를 ProfileIconId에서 추출 
		// 리그 정보 승수 - 패수 - 랭크 - 티어 - 큐타입 -리그포인트
		model.addAttribute("summoner", temp);
		model.addAttribute("profileImgURL", "http://ddragon.leagueoflegends.com/cdn/"+VersionCheck.profileiconVersion+"/img/profileicon/"+temp.getProfileIconId()+".png");
		model.addAttribute("leagueInfo", leagueInfo);
		model.addAttribute("tierImgURL", "img/emblems/Emblem_"+leagueInfo[0].getTier()+".png");
		model.addAttribute("leagueName", leagueName);
		return "result";
	}
	
}
