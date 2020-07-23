package com.bean.dto;

public class matchDTO {

	String 	platformId  ;
	long	gameId		;
	int		champion	;
	String	championImg ;
	int		queue		;
	int		season		;
	int		timestamp	;
	String	role		;
	String	lane		;
	String  summonerName;
	
	int item0;
	int item1;
	int item2;
	int item4;
	int item5;
	int item6;
	int runeMain;
	int runeSub;
	int rune_0;
	int rune_1;
	int rune_2;
	int rune_3;
	int rune_4;
	int rune_5;
	
	public matchDTO() {}
	
	public matchDTO(String summonerName, long gameId, int champion, String lane, int item0, int item1, int item2,
			int item4,int item5,int item6, int runeMain, int runeSub, 
			int rune_0, int rune_1, int rune_2, int rune_3, int rune_4, int rune_5) {
		
		super();
		this.summonerName = summonerName;
		this.gameId = gameId;
		this.champion = champion;
		this.lane = lane;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.runeMain = runeMain;
		this.runeSub = runeSub;
		this.rune_0 = rune_0;
		this.rune_1 = rune_1;
		this.rune_2 = rune_2;
		this.rune_3 = rune_3;
		this.rune_4 = rune_4;
		this.rune_5 = rune_5;
	}

	public matchDTO(String summonerName, String platformId, long gameId, int champion, String championImg, int queue, int season, int timestamp,
			String role, String lane) {
		
		this.platformId = platformId;
		this.gameId = gameId;
		this.champion = champion;
		this.championImg = championImg;
		this.queue = queue;
		this.season = season;
		this.timestamp = timestamp;
		this.role = role;
		this.lane = lane;
		this.summonerName = summonerName;
	}

	
	
	
	
	@Override
	public String toString() {
		return "matchDTO [platformId=" + platformId + ", gameId=" + gameId + ", champion=" + champion + ", championImg="
				+ championImg + ", queue=" + queue + ", season=" + season + ", timestamp=" + timestamp + ", role="
				+ role + ", lane=" + lane + ", summonerName=" + summonerName + ", item0=" + item0 + ", item1=" + item1
				+ ", item2=" + item2 + ", item4=" + item4 + ", item5=" + item5 + ", item6=" + item6 + ", runeMain="
				+ runeMain + ", runeSub=" + runeSub + ", rune_0=" + rune_0 + ", rune_1=" + rune_1 + ", rune_2=" + rune_2
				+ ", rune_3=" + rune_3 + ", rune_4=" + rune_4 + ", rune_5=" + rune_5 + "]";
	}

	public int getRune_0() {
		return rune_0;
	}

	public void setRune_0(int rune_0) {
		this.rune_0 = rune_0;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public int getChampion() {
		return champion;
	}

	public void setChampion(int champion) {
		this.champion = champion;
	}

	public String getChampionImg() {
		return championImg;
	}

	public void setChampionImg(String championImg) {
		this.championImg = championImg;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public int getItem0() {
		return item0;
	}

	public void setItem0(int item0) {
		this.item0 = item0;
	}

	public int getItem1() {
		return item1;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	public int getItem2() {
		return item2;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}

	public int getItem4() {
		return item4;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public int getItem5() {
		return item5;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}

	public int getItem6() {
		return item6;
	}

	public void setItem6(int item6) {
		this.item6 = item6;
	}

	public int getRuneMain() {
		return runeMain;
	}

	public void setRuneMain(int runeMain) {
		this.runeMain = runeMain;
	}

	public int getRuneSub() {
		return runeSub;
	}

	public void setRuneSub(int runeSub) {
		this.runeSub = runeSub;
	}

	public int getRune_1() {
		return rune_1;
	}

	public void setRune_1(int rune_1) {
		this.rune_1 = rune_1;
	}

	public int getRune_2() {
		return rune_2;
	}

	public void setRune_2(int rune_2) {
		this.rune_2 = rune_2;
	}

	public int getRune_3() {
		return rune_3;
	}

	public void setRune_3(int rune_3) {
		this.rune_3 = rune_3;
	}

	public int getRune_4() {
		return rune_4;
	}

	public void setRune_4(int rune_4) {
		this.rune_4 = rune_4;
	}

	public int getRune_5() {
		return rune_5;
	}

	public void setRune_5(int rune_5) {
		this.rune_5 = rune_5;
	}

	
	


	
	
	
	
	
}
