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
	
	public matchDTO() {
		
	}

	public matchDTO(String platformId, long gameId, int champion, String championImg, int queue, int season, int timestamp,
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

	@Override
	public String toString() {
		return "matchDTO [platformId=" + platformId + ", gameId=" + gameId + ", champion=" + champion + ", championImg="
				+ championImg + ", queue=" + queue + ", season=" + season + ", timestamp=" + timestamp + ", role="
				+ role + ", lane=" + lane + "]";
	}

	
	
	
	
}
