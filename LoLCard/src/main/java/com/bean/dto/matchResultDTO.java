package com.bean.dto;

public class matchResultDTO {
	
	// From ParticipantDTO / stats
	// ParticipantTimelineDto 시간별 유저의 딜 -골드 -받은딜 등
	// 플레이어와 같은 championId를 가진 플레이어를 찾는다. ( 
	// 정보 참조 : https://developer.riotgames.com/apis#match-v4/GET_getMatch
	
	private int		participantId;
	private int		championId;
	private int		spell1Id;
	private int		spell2Id;
	
	// participantDTO 에서 stats 안의 내용을 추출
	// 개인정보이므로 유저만 추출하자.
	private int		item0;
	private int 	item1;
	private int 	item2;
	private int 	item3;
	private int 	item4;
	private int 	item5;
	private int		item6;
	
	// 룬
	private int		perk0;	
	private int		perk1;
	private int		perk2;	
	private int		perk3;	
	
	// 보조룬
	private int		perk4;	
	private int		perk5;	
	
	// 플레이데이터  - 팀원 비교 순위 정보
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
	private int		totalDamageDealt;
	private int		magicDamageDealt;
	private int		physicalDamageDealt;
	private int		trueDamageDealt;
	private int		largestCriticalStrike;
	private int		totalDamageDealtToChampions;
	private int		magicDamageDealtToChampions;
	private int		physicalDamageDealtToChampions;
	private int		trueDamageDealtToChampions;
	private int		totalHeal;
	private int		totalUnitsHealed;
	private int		damageSelfMitigated;
	private int		damageDealtToObjectives;
	private int		damageDealtToTurrets;
	private int		visionScore;
	private int		timeCCingOthers;
	private int		totalDamageTaken;
	private int		magicalDamageTaken;
	private int		physicalDamageTaken;
	private int		trueDamageTaken;
	private int		goldEarned;
	private int		turretKills;
	private int		inhibitorKills;
	private int		totalMinionsKilled;
	private int		neutralMinionsKilledEnemyJungle;
	private int		champLevel;
	private int		visionWardsBoughtInGame;
	private int		wardsPlaced;
	private int		wardsKilled;
	private int		firstBloodKill;// 퍼블이 있을 경우 5점 없을 경우 0점
	private int		firstTowerKill;// 포탑 퍼블이 있을 경우 5점 없을 경우 0점
	
	public matchResultDTO(
		int participantId, int championId, int spell1Id, int spell2Id,
		int item0, int item1, int item2, int item3, int item4, int item5, int item6,
		int perk0, int perk1, int perk2, int perk3, int perk4, int perk5,
		int	kills, int deaths, int assists, int	largestKillingSpree, int largestMultiKill,
		int	killingSprees, int longestTimeSpentLiving, int doubleKills, int tripleKills,
		int	quadraKills, int pentaKills, int totalDamageDealt, int magicDamageDealt,
		int	physicalDamageDealt, int trueDamageDealt, int largestCriticalStrike, 
		int	totalDamageDealtToChampions, int magicDamageDealtToChampions, int physicalDamageDealtToChampions,
		int	trueDamageDealtToChampions, int totalHeal, int totalUnitsHealed, int damageSelfMitigated,
		int	damageDealtToObjectives, int damageDealtToTurrets, int visionScore, int timeCCingOthers,
		int	totalDamageTaken, int magicalDamageTaken, int physicalDamageTaken, int trueDamageTaken,
		int	goldEarned, int turretKills, int inhibitorKills, int totalMinionsKilled,
		int	neutralMinionsKilledEnemyJungle, int champLevel, int visionWardsBoughtInGame,
		int	wardsPlaced, int wardsKilled, int firstBloodKill, int firstTowerKill) {
		
		super();
		this.participantId = participantId;
		this.championId = championId;
		this.spell1Id = spell1Id;
		this.spell2Id = spell2Id;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.perk0 = perk0;		
		this.perk1 = perk1;		
		this.perk2 = perk2;		
		this.perk3 = perk3;		
		this.perk4 = perk4;		
		this.perk5 = perk5;		
		
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.largestKillingSpree = largestKillingSpree;
		this.largestMultiKill= largestMultiKill;
		this.killingSprees = killingSprees;
		this.longestTimeSpentLiving = longestTimeSpentLiving;
		this.doubleKills = doubleKills;
		this.tripleKills = tripleKills;
		this.quadraKills = quadraKills;
		this.pentaKills = pentaKills;
		this.totalDamageDealt = totalDamageDealt;
		this.magicDamageDealt = magicDamageDealt;
		this.physicalDamageDealt = physicalDamageDealt;
		this.trueDamageDealt = trueDamageDealt;
		this.largestCriticalStrike = largestCriticalStrike;
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
		this.totalHeal = totalHeal;
		this.totalUnitsHealed = totalUnitsHealed;
		this.damageSelfMitigated = damageSelfMitigated;
		this.damageDealtToObjectives = damageDealtToObjectives;
		this.damageDealtToTurrets = damageDealtToTurrets;
		this.visionScore = visionScore;
		this.timeCCingOthers = timeCCingOthers;
		this.totalDamageTaken = totalDamageTaken;
		this.magicalDamageTaken = magicalDamageTaken;
		this.physicalDamageTaken = physicalDamageTaken;
		this.trueDamageTaken = trueDamageTaken;
		this.goldEarned = goldEarned;
		this.turretKills = turretKills;
		this.inhibitorKills = inhibitorKills;
		this.totalMinionsKilled = totalMinionsKilled;
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
		this.champLevel = champLevel;
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
		this.wardsPlaced = wardsPlaced;
		this.wardsKilled = wardsKilled;
		this.firstBloodKill = firstBloodKill; // 퍼블이 있을 경우 5점 없을 경우 0점
		this.firstTowerKill = firstTowerKill; // 포탑 퍼블이 있을 경우 5점 없을 경우 0점
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	public int getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(int spell1Id) {
		this.spell1Id = spell1Id;
	}

	public int getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(int spell2Id) {
		this.spell2Id = spell2Id;
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

	public int getItem3() {
		return item3;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
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

	public int getPerk0() {
		return perk0;
	}

	public void setPerk0(int perk0) {
		this.perk0 = perk0;
	}

	public int getPerk1() {
		return perk1;
	}

	public void setPerk1(int perk1) {
		this.perk1 = perk1;
	}

	public int getPerk2() {
		return perk2;
	}

	public void setPerk2(int perk2) {
		this.perk2 = perk2;
	}

	public int getPerk3() {
		return perk3;
	}

	public void setPerk3(int perk3) {
		this.perk3 = perk3;
	}

	public int getPerk4() {
		return perk4;
	}

	public void setPerk4(int perk4) {
		this.perk4 = perk4;
	}

	public int getPerk5() {
		return perk5;
	}

	public void setPerk5(int perk5) {
		this.perk5 = perk5;
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

	public int getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(int totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public int getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(int magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public int getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(int physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public int getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(int trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public int getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(int largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public int getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public int getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public int getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public int getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public int getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(int totalHeal) {
		this.totalHeal = totalHeal;
	}

	public int getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(int totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public int getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public void setDamageSelfMitigated(int damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}

	public int getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public void setDamageDealtToObjectives(int damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}

	public int getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public void setDamageDealtToTurrets(int damageDealtToTurrets) {
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

	public int getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(int totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public int getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public void setMagicalDamageTaken(int magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}

	public int getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(int physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public int getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(int trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
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

	public int getFirstBloodKill() {
		return firstBloodKill;
	}

	public void setFirstBloodKill(int firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public int getFirstTowerKill() {
		return firstTowerKill;
	}

	public void setFirstTowerKill(int firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	@Override
	public String toString() {
		return "matchInfoDTO [participantId=" + participantId + ", championId=" + championId + ", spell1Id=" + spell1Id
				+ ", spell2Id=" + spell2Id + ", item0=" + item0 + ", item1=" + item1 + ", item2=" + item2 + ", item3="
				+ item3 + ", item4=" + item4 + ", item5=" + item5 + ", item6=" + item6 + ", perk0=" + perk0 + ", perk1="
				+ perk1 + ", perk2=" + perk2 + ", perk3=" + perk3 + ", perk4=" + perk4 + ", perk5=" + perk5 + ", kills="
				+ kills + ", deaths=" + deaths + ", assists=" + assists + ", largestKillingSpree=" + largestKillingSpree
				+ ", largestMultiKill=" + largestMultiKill + ", killingSprees=" + killingSprees
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
				+ firstTowerKill + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
