package com.bean.dto;

public class staticPlayerDataDTO {
	
	int MostChampion_1 	= 0;
	int MostChampion_2 	= 0;
	int MostChampion_3 	= 0;
	int MostRune 		= 0;
	int MostItem		= 0;	
	String MostPosition	= "";
	
	public staticPlayerDataDTO() {};
	
	public staticPlayerDataDTO(int MostChampion_1, int MostChampion_2, int MostChampion_3, 
								int MostRune, int MostItem, String MostPosition) {
		super();
		this.MostChampion_1 = MostChampion_1;
		this.MostChampion_2 = MostChampion_2;
		this.MostChampion_3 = MostChampion_3;
		this.MostRune 		= MostRune;
		this.MostItem		= MostItem;
		this.MostPosition	= MostPosition;
	}

	public int getMostChampion_1() {
		return MostChampion_1;
	}

	public void setMostChampion_1(int mostChampion_1) {
		MostChampion_1 = mostChampion_1;
	}

	public int getMostChampion_2() {
		return MostChampion_2;
	}

	public void setMostChampion_2(int mostChampion_2) {
		MostChampion_2 = mostChampion_2;
	}

	public int getMostChampion_3() {
		return MostChampion_3;
	}

	public void setMostChampion_3(int mostChampion_3) {
		MostChampion_3 = mostChampion_3;
	}

	public int getMostRune() {
		return MostRune;
	}

	public void setMostRune(int mostRune) {
		MostRune = mostRune;
	}

	public int getMostItem() {
		return MostItem;
	}

	public void setMostItem(int mostItem) {
		MostItem = mostItem;
	}

	public String getMostPosition() {
		return MostPosition;
	}

	public void setMostPosition(String mostPosition) {
		MostPosition = mostPosition;
	}

	@Override
	public String toString() {
		return "staticPlayerDataDTO [MostChampion_1=" + MostChampion_1 + ", MostChampion_2=" + MostChampion_2
				+ ", MostChampion_3=" + MostChampion_3 + ", MostRune=" + MostRune + ", MostItem=" + MostItem
				+ ", MostPosition=" + MostPosition + "]";
	}
	
	
	
	
}
