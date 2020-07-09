package com.bean.dto;

public class matchPlayInfoDTO {
	
	// From ParticipantDTO / stats
	// ParticipantTimelineDto 시간별 유저의 딜 -골드 -받은딜 등
	// 참가자의 정보들을 찾아낸다. 
	// 플레이어와 같은 championId를 가진 플레이어를 찾는다. ( 
	// 정보 참조 : https://developer.riotgames.com/apis#match-v4/GET_getMatch
	
	// 플레이데이터  - 팀원들과 비교해서 등수를 가립시다. 10명의 데이터를 받아서  SQL에 넣고 순위 데이터를 받읍시다. 
	// DAO를 만들어서 비교해봅시다.
	private int		championId;
	private long	matchId;
	private String	primaryCode;
	private boolean	myPlayData;		
	private int		kills;
	private int		deaths;
	private int		assists;
	private int		largestKillingSpree;
	private int		largestMultiKill;
	private int		killingSprees;
	private int		longestTimeSpentLiving;
	private int		doubleKills;
	private int		tripleKills;
	private int		quadraKills;
	private int		pentaKills;
	private long	totalDamageDealt;
	private long	magicDamageDealt;
	private long	physicalDamageDealt;
	private long	trueDamageDealt;
	private int		largestCriticalStrike;
	private long	totalDamageDealtToChampions;
	private long	magicDamageDealtToChampions;
	private long	physicalDamageDealtToChampions;
	private long	trueDamageDealtToChampions;
	private long	totalHeal;
	private int		totalUnitsHealed;
	private long	damageSelfMitigated;
	private long	damageDealtToObjectives;
	private long	damageDealtToTurrets;
	private int		visionScore;
	private int		timeCCingOthers;
	private long	totalDamageTaken;
	private long	magicalDamageTaken;
	private long	physicalDamageTaken;
	private long	trueDamageTaken;
	private long	goldEarned;
	private int		turretKills;
	private int		inhibitorKills;
	private int		totalMinionsKilled;
	private int		neutralMinionsKilledEnemyJungle;
	private int		champLevel;
	private int		visionWardsBoughtInGame;
	private int		wardsPlaced;
	private int		wardsKilled;
	private boolean	firstBloodKill;
	private boolean	firstTowerKill;
	
	
	
	public String getPrimaryCode() {
		return primaryCode;
	}
	public void setPrimaryCode(String primaryCode) {
		this.primaryCode = primaryCode;
	}
	public boolean isMyPlayData() {
		return myPlayData;
	}
	public void setMyPlayData(boolean myPlayData) {
		this.myPlayData = myPlayData;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public long getMatchId() {
		return matchId;
	}
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getLargestKillingSpree() {
		return largestKillingSpree;
	}
	public void setLargestKillingSpree(int largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}
	public int getLargestMultiKill() {
		return largestMultiKill;
	}
	public void setLargestMultiKill(int largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}
	public int getKillingSprees() {
		return killingSprees;
	}
	public void setKillingSprees(int killingSprees) {
		this.killingSprees = killingSprees;
	}
	public int getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}
	public void setLongestTimeSpentLiving(int longestTimeSpentLiving) {
		this.longestTimeSpentLiving = longestTimeSpentLiving;
	}
	public int getDoubleKills() {
		return doubleKills;
	}
	public void setDoubleKills(int doubleKills) {
		this.doubleKills = doubleKills;
	}
	public int getTripleKills() {
		return tripleKills;
	}
	public void setTripleKills(int tripleKills) {
		this.tripleKills = tripleKills;
	}
	public int getQuadraKills() {
		return quadraKills;
	}
	public void setQuadraKills(int quadraKills) {
		this.quadraKills = quadraKills;
	}
	public int getPentaKills() {
		return pentaKills;
	}
	public void setPentaKills(int pentaKills) {
		this.pentaKills = pentaKills;
	}
	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}
	public void setTotalDamageDealt(long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}
	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}
	public void setMagicDamageDealt(long magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}
	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}
	public void setPhysicalDamageDealt(long physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}
	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}
	public void setTrueDamageDealt(long trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}
	public int getLargestCriticalStrike() {
		return largestCriticalStrike;
	}
	public void setLargestCriticalStrike(int largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}
	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}
	public void setTotalDamageDealtToChampions(long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}
	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}
	public void setMagicDamageDealtToChampions(long magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}
	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}
	public void setPhysicalDamageDealtToChampions(long physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}
	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}
	public void setTrueDamageDealtToChampions(long trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}
	public long getTotalHeal() {
		return totalHeal;
	}
	public void setTotalHeal(long totalHeal) {
		this.totalHeal = totalHeal;
	}
	public int getTotalUnitsHealed() {
		return totalUnitsHealed;
	}
	public void setTotalUnitsHealed(int totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}
	public long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}
	public void setDamageSelfMitigated(long damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}
	public long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}
	public void setDamageDealtToObjectives(long damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}
	public long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}
	public void setDamageDealtToTurrets(long damageDealtToTurrets) {
		this.damageDealtToTurrets = damageDealtToTurrets;
	}
	public int getVisionScore() {
		return visionScore;
	}
	public void setVisionScore(int visionScore) {
		this.visionScore = visionScore;
	}
	public int getTimeCCingOthers() {
		return timeCCingOthers;
	}
	public void setTimeCCingOthers(int timeCCingOthers) {
		this.timeCCingOthers = timeCCingOthers;
	}
	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}
	public void setTotalDamageTaken(long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}
	public long getMagicalDamageTaken() {
		return magicalDamageTaken;
	}
	public void setMagicalDamageTaken(long magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}
	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}
	public void setPhysicalDamageTaken(long physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}
	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}
	public void setTrueDamageTaken(long trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}
	public long getGoldEarned() {
		return goldEarned;
	}
	public void setGoldEarned(long goldEarned) {
		this.goldEarned = goldEarned;
	}
	public int getTurretKills() {
		return turretKills;
	}
	public void setTurretKills(int turretKills) {
		this.turretKills = turretKills;
	}
	public int getInhibitorKills() {
		return inhibitorKills;
	}
	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}
	public int getTotalMinionsKilled() {
		return totalMinionsKilled;
	}
	public void setTotalMinionsKilled(int totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}
	public int getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}
	public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}
	public int getChampLevel() {
		return champLevel;
	}
	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}
	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}
	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}
	public int getWardsPlaced() {
		return wardsPlaced;
	}
	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}
	public int getWardsKilled() {
		return wardsKilled;
	}
	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}
	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}
	public void setFirstBloodKill(boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}
	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}
	public void setFirstTowerKill(boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}
	@Override
	public String toString() {
		return "matchPlayInfoDTO [championId=" + championId + ", matchId=" + matchId + ", myPlayData=" + myPlayData
				+ ", kills=" + kills + ", deaths=" + deaths + ", assists=" + assists + ", largestKillingSpree="
				+ largestKillingSpree + ", largestMultiKill=" + largestMultiKill + ", killingSprees=" + killingSprees
				+ ", longestTimeSpentLiving=" + longestTimeSpentLiving + ", doubleKills=" + doubleKills
				+ ", tripleKills=" + tripleKills + ", quadraKills=" + quadraKills + ", pentaKills=" + pentaKills
				+ ", totalDamageDealt=" + totalDamageDealt + ", magicDamageDealt=" + magicDamageDealt
				+ ", physicalDamageDealt=" + physicalDamageDealt + ", trueDamageDealt=" + trueDamageDealt
				+ ", largestCriticalStrike=" + largestCriticalStrike + ", totalDamageDealtToChampions="
				+ totalDamageDealtToChampions + ", magicDamageDealtToChampions=" + magicDamageDealtToChampions
				+ ", physicalDamageDealtToChampions=" + physicalDamageDealtToChampions + ", trueDamageDealtToChampions="
				+ trueDamageDealtToChampions + ", totalHeal=" + totalHeal + ", totalUnitsHealed=" + totalUnitsHealed
				+ ", damageSelfMitigated=" + damageSelfMitigated + ", damageDealtToObjectives="
				+ damageDealtToObjectives + ", damageDealtToTurrets=" + damageDealtToTurrets + ", visionScore="
				+ visionScore + ", timeCCingOthers=" + timeCCingOthers + ", totalDamageTaken=" + totalDamageTaken
				+ ", magicalDamageTaken=" + magicalDamageTaken + ", physicalDamageTaken=" + physicalDamageTaken
				+ ", trueDamageTaken=" + trueDamageTaken + ", goldEarned=" + goldEarned + ", turretKills=" + turretKills
				+ ", inhibitorKills=" + inhibitorKills + ", totalMinionsKilled=" + totalMinionsKilled
				+ ", neutralMinionsKilledEnemyJungle=" + neutralMinionsKilledEnemyJungle + ", champLevel=" + champLevel
				+ ", visionWardsBoughtInGame=" + visionWardsBoughtInGame + ", wardsPlaced=" + wardsPlaced
				+ ", wardsKilled=" + wardsKilled + ", firstBloodKill=" + firstBloodKill + ", firstTowerKill="
				+ firstTowerKill + ", isMyPlayData()=" + isMyPlayData() + ", getChampionId()=" + getChampionId()
				+ ", getMatchId()=" + getMatchId() + ", getKills()=" + getKills() + ", getDeaths()=" + getDeaths()
				+ ", getAssists()=" + getAssists() + ", getLargestKillingSpree()=" + getLargestKillingSpree()
				+ ", getLargestMultiKill()=" + getLargestMultiKill() + ", getKillingSprees()=" + getKillingSprees()
				+ ", getLongestTimeSpentLiving()=" + getLongestTimeSpentLiving() + ", getDoubleKills()="
				+ getDoubleKills() + ", getTripleKills()=" + getTripleKills() + ", getQuadraKills()=" + getQuadraKills()
				+ ", getPentaKills()=" + getPentaKills() + ", getTotalDamageDealt()=" + getTotalDamageDealt()
				+ ", getMagicDamageDealt()=" + getMagicDamageDealt() + ", getPhysicalDamageDealt()="
				+ getPhysicalDamageDealt() + ", getTrueDamageDealt()=" + getTrueDamageDealt()
				+ ", getLargestCriticalStrike()=" + getLargestCriticalStrike() + ", getTotalDamageDealtToChampions()="
				+ getTotalDamageDealtToChampions() + ", getMagicDamageDealtToChampions()="
				+ getMagicDamageDealtToChampions() + ", getPhysicalDamageDealtToChampions()="
				+ getPhysicalDamageDealtToChampions() + ", getTrueDamageDealtToChampions()="
				+ getTrueDamageDealtToChampions() + ", getTotalHeal()=" + getTotalHeal() + ", getTotalUnitsHealed()="
				+ getTotalUnitsHealed() + ", getDamageSelfMitigated()=" + getDamageSelfMitigated()
				+ ", getDamageDealtToObjectives()=" + getDamageDealtToObjectives() + ", getDamageDealtToTurrets()="
				+ getDamageDealtToTurrets() + ", getVisionScore()=" + getVisionScore() + ", getTimeCCingOthers()="
				+ getTimeCCingOthers() + ", getTotalDamageTaken()=" + getTotalDamageTaken()
				+ ", getMagicalDamageTaken()=" + getMagicalDamageTaken() + ", getPhysicalDamageTaken()="
				+ getPhysicalDamageTaken() + ", getTrueDamageTaken()=" + getTrueDamageTaken() + ", getGoldEarned()="
				+ getGoldEarned() + ", getTurretKills()=" + getTurretKills() + ", getInhibitorKills()="
				+ getInhibitorKills() + ", getTotalMinionsKilled()=" + getTotalMinionsKilled()
				+ ", getNeutralMinionsKilledEnemyJungle()=" + getNeutralMinionsKilledEnemyJungle()
				+ ", getChampLevel()=" + getChampLevel() + ", getVisionWardsBoughtInGame()="
				+ getVisionWardsBoughtInGame() + ", getWardsPlaced()=" + getWardsPlaced() + ", getWardsKilled()="
				+ getWardsKilled() + ", isFirstBloodKill()=" + isFirstBloodKill() + ", isFirstTowerKill()="
				+ isFirstTowerKill() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
