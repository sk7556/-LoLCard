package com.bean.dto;

public class champResultDTO {
	
	//----------------------------------------------------------------
	// DTO 설명
	// 챔피언 정보 JSP에 출력되게 될 정보를 저장 및 가공하는 DTO
	// MatchController에서 받은 Num를 통해서 JSP에서 유효하게 출력할 데이터를 선택 및 저장
	//----------------------------------------------------------------
	
	int		markFirstNum;			// 변환용으로 받은 숫자
	String	markFirstImg;			// 첫번째 마크 이미지
	String	markFirstExplain;		// 첫번째 마크 설명
	String 	markFirstName;			// 첫번째 마크 이름
	int		markSecondNum;			// 변환용으로 받은 숫자
	String 	markSecondImg;			// 두번째 마크 이미지
	String 	markSecondExplain;		// 두번째 마크 설명
	String 	markSecondName;			// 두번째 마크 이름
	int		markThirdNum;			// 변환용으로 받은 숫자
	String 	markThirdImg;			// 세번째 마크 이미지
	String 	markThirdExplain;		// 세번째 마크 설명
	String 	markThirdName;			// 세번째 마크 이름
	
	int		rankResult_4;			// "성장" 	= rankResult[4]
	int		rankResult_5;			// "킬관여" 	= rankResult[5]
	int		rankResult_6;			// "시야점수"	= rankResult[6] 
	int		rankResult_7;			// "오브젝트"	= rankResult[7] 
	int		rankResult_8;			// "전투력"	= rankResult[8] 
	int		rankResult_9;			// "CC"		= rankResult[9]
		
	// 기본 생성자
	champResultDTO() {
		
	}
	
	// matchController - DTO 입력용 생성자
	public champResultDTO(int markFirstNum, int markSecondNum, int markThirdNum,
				   int rankResult_4, int rankResult_5,  int rankResult_6,
				   int rankResult_7, int rankResult_8,  int	rankResult_9) 
	{
		super();
		this.markFirstNum = markFirstNum;
		this.markSecondNum = markSecondNum;
		this.markThirdNum = markThirdNum;
		this.rankResult_4 = rankResult_4;
		this.rankResult_5 = rankResult_5;
		this.rankResult_6 = rankResult_6;
		this.rankResult_7 = rankResult_7;
		this.rankResult_8 = rankResult_8;
		this.rankResult_9 = rankResult_9;
		setMarkData();
	}

	// 챔피언 Num에 따라서 출력해줄 Img, Explain, Name을 결정한다.
	
	void setMarkData(){
		
		switch(markFirstNum) {
			case 1:
				markFirstName = "협곡의 살인마";
				markFirstImg  = "";
				markFirstExplain = "뛰어난 집중력으로 적을 숨통은 끊어냈어요!";
				break;
			case 2:
				markFirstName = "또 죽었어!";
				markFirstImg  = "";
				markFirstExplain = "혹시 카서스 유저이신가요? 데스가 너무 많아요!";
				break;
			case 3:
				markFirstName = "발빠른 조력자";
				markFirstImg  = "";
				markFirstExplain = "협곡을 돌아다니며 가장 많은 어시스트를 챙기셨어요!";
				break;
			case 4:
				markFirstName = "영광의 순간";
				markFirstImg  = "";
				markFirstExplain = "한번에 많은 적을 쓸어담으셨군요!";
				break;
			case 5:
				markFirstName = "죽이고 또 죽이고";
				markFirstImg  = "";
				markFirstExplain = "죽지 않고 연속킬을 기록하셨어요!";
				break;
			case 6:
				markFirstName = "날카로운 칼날";
				markFirstImg  = "";
				markFirstExplain = "여러번의 멀티킬을 기록하셨어요!";
				break;
			case 7:
				markFirstName = "삼천갑자";
				markFirstImg  = "";
				markFirstExplain = "협곡에서 가장 오랫동안 살아남으셨어요!";
				break;
			case 8:
				markFirstName = "더블킬 매니아";
				markFirstImg  = "";
				markFirstExplain = "전투를 했다하면 더블킬이군요!";
				break;
			case 9:
				markFirstName = "트리플킬은 기본";
				markFirstImg  = "";
				markFirstExplain = "트리플킬이 너무도 손쉬웠습니다."; 
				break;
			case 10:
				markFirstName = "아깝다. 쿼드라킬";
				markFirstImg  = "";
				markFirstExplain = "4명의 목숨이 당신 손에 한 순간에 떨어졌습니다.";
				break;
			case 11:
				markFirstName = "펜타킬 유저";
				markFirstImg  = "";
				markFirstExplain = "축하합니다. LOL의 정점에 당신이 서있습니다.";
				break;
			case 12:
				markFirstName = "아무나 때려";
				markFirstImg  = "";
				markFirstExplain = "미니언, 오브젝트, 챔피언 가리지 않고 열심히 때리셨네요";
				break;
			case 13:
				markFirstName = "강력한 마법사";
				markFirstImg  = "";
				markFirstExplain = "협곡의 모든 것들을 마법으로 열심히 때리셨습니다.";
				break;
			case 14:
				markFirstName = "강력한 힘캐";
				markFirstImg  = "";
				markFirstExplain = "협곡의 모든 것들에게 물리적 공격을 가했습니다.";
				break;
			case 15:
				markFirstName = "트루 데미지란 ";
				markFirstImg  = "";
				markFirstExplain = "당신이 가한 데미지는 트루데미지입니다.";
				break;
			case 16:
				markFirstName = "강력한 치명타";
				markFirstImg  = "";
				markFirstExplain = "얼마전에 팀에서 가장 강력한 크리티컬 데미지를 가하셨군요";
				break;
			case 17:
				markFirstName = "챔피언 때리기 챔피언";
				markFirstImg  = "";
				markFirstExplain = "협곡에서 챔피언에게 가장 큰 데미지를 준 건 당신입니다!";
				break;
			case 18:
				markFirstName = "최강의 마법사";
				markFirstImg  = "";
				markFirstExplain = "챔피언들에게 강력한 마법 딜링을 하셨어요!";
				break;
			case 19:
				markFirstName = "최강의 물리 딜러";
				markFirstImg  = "";
				markFirstExplain = "상대 챔피언에게 당신은 가장 무서운 물리딜러입니다.";
				break;
			case 20:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 21:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 22:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 23:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 24:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 25:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 26:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 27:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 28:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 29:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 30:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 31:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 32:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 33:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 34:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 35:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 36:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 37:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 38:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 39:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 40:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 41:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
			case 42:
				markFirstName = "";
				markFirstImg  = "";
				markFirstExplain = "";
				break;
		}
		
		switch(markSecondNum) {
		case 1:
			markSecondName = "";
			markSecondImg  = "";
			markSecondExplain = "";
			break;
		case 2:
		}
	} // End Void setMarkData
		
	
	
	
	
	
	public int getMarkFirstNum() {
		return markFirstNum;
	}

	public void setMarkFirstNum(int markFirstNum) {
		this.markFirstNum = markFirstNum;
	}

	public String getMarkFirstImg() {
		return markFirstImg;
	}

	public void setMarkFirstImg(String markFirstImg) {
		this.markFirstImg = markFirstImg;
	}

	public String getMarkFirstExplain() {
		return markFirstExplain;
	}

	public void setMarkFirstExplain(String markFirstExplain) {
		this.markFirstExplain = markFirstExplain;
	}

	public String getMarkFirstName() {
		return markFirstName;
	}

	public void setMarkFirstName(String markFirstName) {
		this.markFirstName = markFirstName;
	}

	public int getMarkSecondNum() {
		return markSecondNum;
	}

	public void setMarkSecondNum(int markSecondNum) {
		this.markSecondNum = markSecondNum;
	}

	public String getMarkSecondImg() {
		return markSecondImg;
	}

	public void setMarkSecondImg(String markSecondImg) {
		this.markSecondImg = markSecondImg;
	}

	public String getMarkSecondExplain() {
		return markSecondExplain;
	}

	public void setMarkSecondExplain(String markSecondExplain) {
		this.markSecondExplain = markSecondExplain;
	}

	public String getMarkSecondName() {
		return markSecondName;
	}

	public void setMarkSecondName(String markSecondName) {
		this.markSecondName = markSecondName;
	}

	public int getMarkThirdNum() {
		return markThirdNum;
	}

	public void setMarkThirdNum(int markThirdNum) {
		this.markThirdNum = markThirdNum;
	}

	public String getMarkThirdImg() {
		return markThirdImg;
	}

	public void setMarkThirdImg(String markThirdImg) {
		this.markThirdImg = markThirdImg;
	}

	public String getMarkThirdExplain() {
		return markThirdExplain;
	}

	public void setMarkThirdExplain(String markThirdExplain) {
		this.markThirdExplain = markThirdExplain;
	}

	public String getMarkThirdName() {
		return markThirdName;
	}

	public void setMarkThirdName(String markThirdName) {
		this.markThirdName = markThirdName;
	}

	public int getRankResult_4() {
		return rankResult_4;
	}

	public void setRankResult_4(int rankResult_4) {
		this.rankResult_4 = rankResult_4;
	}

	public int getRankResult_5() {
		return rankResult_5;
	}

	public void setRankResult_5(int rankResult_5) {
		this.rankResult_5 = rankResult_5;
	}

	public int getRankResult_6() {
		return rankResult_6;
	}

	public void setRankResult_6(int rankResult_6) {
		this.rankResult_6 = rankResult_6;
	}

	public int getRankResult_7() {
		return rankResult_7;
	}

	public void setRankResult_7(int rankResult_7) {
		this.rankResult_7 = rankResult_7;
	}

	public int getRankResult_8() {
		return rankResult_8;
	}

	public void setRankResult_8(int rankResult_8) {
		this.rankResult_8 = rankResult_8;
	}

	public int getRankResult_9() {
		return rankResult_9;
	}

	public void setRankResult_9(int rankResult_9) {
		this.rankResult_9 = rankResult_9;
	}
	
	// End GetterSetter
	
	@Override
	public String toString() {
		return "champResultDTO [markFirstNum=" + markFirstNum + ", markFirstImg=" + markFirstImg + ", markFirstExplain="
				+ markFirstExplain + ", markFirstName=" + markFirstName + ", markSecondNum=" + markSecondNum
				+ ", markSecondImg=" + markSecondImg + ", markSecondExplain=" + markSecondExplain + ", markSecondName="
				+ markSecondName + ", markThirdNum=" + markThirdNum + ", markThirdImg=" + markThirdImg
				+ ", markThirdExplain=" + markThirdExplain + ", markThirdName=" + markThirdName + ", rankResult_4="
				+ rankResult_4 + ", rankResult_5=" + rankResult_5 + ", rankResult_6=" + rankResult_6 + ", rankResult_7="
				+ rankResult_7 + ", rankResult_8=" + rankResult_8 + ", rankResult_9=" + rankResult_9 + "]";
	}
	
	
	
	
} // End Class
