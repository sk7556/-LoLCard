package com.bean.dto;



public class champTempDTO {
	
	private String champion_1 = "";
	private String champion_2 = "";
	private String champion_3 = "";
	
	public champTempDTO(String champion_1, String champion_2, String champion_3) {
		this.champion_1 = champion_1;
		this.champion_2 = champion_2;
		this.champion_3 = champion_3;
	}
	
	public champTempDTO(){}
	
	public String getChampion_1() {
		return champion_1;
	}

	public void setChampion_1(String champion_1) {
		this.champion_1 = champion_1;
	}

	public String getChampion_2() {
		return champion_2;
	}

	public void setChampion_2(String champion_2) {
		this.champion_2 = champion_2;
	}

	public String getChampion_3() {
		return champion_3;
	}

	public void setChampion_3(String champion_3) {
		this.champion_3 = champion_3;
	}

	@Override
	public String toString() {
		return "champTempDTO [champion_1=" + champion_1 + ", champion_2=" + champion_2 + ", champion_3=" + champion_3
				+ "]";
	}
	
	
	
}
