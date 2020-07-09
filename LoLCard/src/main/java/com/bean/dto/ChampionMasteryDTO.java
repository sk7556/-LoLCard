package com.bean.dto;

public class ChampionMasteryDTO {
	//----------------------------------------------------------------
	// Champion-MasteryV4에서 받는 데이터
	//  List[ChampionMasteryDTO]
	//  championPointsUntilNextLevel	long	
	//	chestGranted	boolean	
	//	championId	long	
	//	lastPlayTime	long	
	//	championLevel	int	
	//	summonerId	string	
	//	championPoints	int	
	//	championPointsSinceLastLevel	long	
	//	tokensEarned	int	
	//  ChampionName String
	//  ChampionImg  String
	//  활용 주소 : /lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}
	//----------------------------------------------------------------
	
	private long 	championPointsUntilNextLevel;
	private boolean	chestGranted;
	private long	championId;
	private String	lastPlayTime;
	private int		championLevel;
	private String	summonerId;
	private int		championPoints;
	private long	championPointsSinceLastLevel;
	private int		tokensEarned;
	private String	championName;
	private String  championImg;
	
	public ChampionMasteryDTO() {}
	
	public ChampionMasteryDTO(long 	championPointsUntilNextLevel,
	boolean	chestGranted,
	long	championId,
	String	lastPlayTime,
	int		championLevel,
	String	summonerId,
	int		championPoints,
	long	championPointsSinceLastLevel,
	int		tokensEarned,
	String	championName,
	String	championImg) {
		super();
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
		this.chestGranted = chestGranted;
		this.championId = championId;
		this.lastPlayTime = lastPlayTime;
		this.championLevel = championLevel;
		this.summonerId = summonerId;
		this.championPoints = championPoints;
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
		this.tokensEarned = tokensEarned;
		this.championName = championName;
		this.championImg = championImg;
	}
	
	public String getChampionName() {
		return championName;
	}

	public void setChampionName(String championName) {
		this.championName = championName;
	}

	public String getChampionImg() {
		return championImg;
	}

	public void setChampionImg(String championImg) {
		this.championImg = championImg;
	}

	public long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}
	public void setChampionPointsUntilNextLevel(long championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}
	public boolean isChestGranted() {
		return chestGranted;
	}
	public void setChestGranted(boolean chestGranted) {
		this.chestGranted = chestGranted;
	}
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	public String getLastPlayTime() {
		return lastPlayTime;
	}
	public void setLastPlayTime(String lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}
	public int getChampionLevel() {
		return championLevel;
	}
	public void setChampionLevel(int championLevel) {
		this.championLevel = championLevel;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public int getChampionPoints() {
		return championPoints;
	}
	public void setChampionPoints(int championPoints) {
		this.championPoints = championPoints;
	}
	public long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}
	public void setChampionPointsSinceLastLevel(long championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}
	public int getTokensEarned() {
		return tokensEarned;
	}
	public void setTokensEarned(int tokensEarned) {
		this.tokensEarned = tokensEarned;
	}

	@Override
	public String toString() {
		return "ChampionMasteryDTO [championPointsUntilNextLevel=" + championPointsUntilNextLevel + ", chestGranted="
				+ chestGranted + ", championId=" + championId + ", lastPlayTime=" + lastPlayTime + ", championLevel="
				+ championLevel + ", summonerId=" + summonerId + ", championPoints=" + championPoints
				+ ", championPointsSinceLastLevel=" + championPointsSinceLastLevel + ", tokensEarned=" + tokensEarned
				+ ", championName=" + championName + ", championImg=" + championImg + "]";
	}
	
}
