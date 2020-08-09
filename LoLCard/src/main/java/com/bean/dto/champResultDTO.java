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
			case 1:		// kills
				markFirstName = "협곡의 살인마";
				markFirstImg  = "resources/img/mark/mark_1.png";
				markFirstExplain = "뛰어난 집중력으로 적을 숨통은 끊어냈어요!";
				break;
			case 2:		// deaths
				markFirstName = "또 죽었어!";
				markFirstImg  = "resources/img/mark/mark_2.png";
				markFirstExplain = "혹시 카서스 유저이신가요? 데스가 너무 많아요!";
				break;
			case 3:		// assists
				markFirstName = "발빠른 조력자";
				markFirstImg  = "resources/img/mark/mark_3.png";
				markFirstExplain = "협곡을 돌아다니며 가장 많은 어시스트를 챙기셨어요!";
				break;
			case 4:		// largestkillingspree
				markFirstName = "영광의 순간";
				markFirstImg  = "resources/img/mark/mark_4.png";
				markFirstExplain = "한번에 많은 적을 쓸어담으셨군요!";
				break;
			case 5:		// largestmultikill
				markFirstName = "죽이고 또 죽이고";
				markFirstImg  = "resources/img/mark/mark_5.png";
				markFirstExplain = "죽지 않고 연속킬을 기록하셨어요!";
				break;
			case 6:		// killingsprees
				markFirstName = "날카로운 칼날";
				markFirstImg  = "resources/img/mark/mark_6.png";
				markFirstExplain = "여러번의 멀티킬을 기록하셨어요!";
				break;
			case 7:		// longesttimespentliving
				markFirstName = "삼천갑자";
				markFirstImg  = "resources/img/mark/mark_7.png";
				markFirstExplain = "협곡에서 가장 오랫동안 살아남으셨어요!";
				break;
			case 8:		// doublekills
				markFirstName = "더블킬 매니아";
				markFirstImg  = "resources/img/mark/mark_8.png";
				markFirstExplain = "전투를 했다하면 더블킬이군요!";
				break;
			case 9:		// triplekills
				markFirstName = "트리플킬은 기본";
				markFirstImg  = "resources/img/mark/mark_9.png";
				markFirstExplain = "트리플킬이 너무도 손쉬웠습니다."; 
				break;
			case 10:	// quadrakills
				markFirstName = "아깝다. 쿼드라킬";
				markFirstImg  = "resources/img/mark/mark_10.png";
				markFirstExplain = "4명의 목숨이 당신 손에 한 순간에 떨어졌습니다.";
				break;
			case 11:	// pentakills
				markFirstName = "펜타킬 유저";
				markFirstImg  = "resources/img/mark/mark_11.png";
				markFirstExplain = "축하합니다. LOL의 정점에 당신이 서있습니다.";
				break;
			case 12:	// totaldamagedealt
				markFirstName = "아무나 때려";
				markFirstImg  = "resources/img/mark/mark_12.png";
				markFirstExplain = "미니언, 오브젝트, 챔피언 가리지 않고 열심히 때리셨네요";
				break;
			case 13:	// magicdamagedealt
				markFirstName = "강력한 마법사";
				markFirstImg  = "resources/img/mark/mark_13.png";
				markFirstExplain = "협곡의 모든 것들을 마법으로 열심히 때리셨습니다.";
				break;
			case 14:	// physicaldamagedealt
				markFirstName = "강력한 힘캐";
				markFirstImg  = "resources/img/mark/mark_14.png";
				markFirstExplain = "협곡의 모든 것들에게 물리적 공격을 가했습니다.";
				break;
			case 15:	// truedamagedealt
				markFirstName = "트루 데미지란 ";
				markFirstImg  = "resources/img/mark/mark_15.png";
				markFirstExplain = "당신이 가한 데미지는 트루데미지입니다.";
				break;
			case 16:	// largestcriticalstrike
				markFirstName = "강력한 치명타";
				markFirstImg  = "resources/img/mark/mark_16.png";
				markFirstExplain = "얼마전에 팀에서 가장 강력한 크리티컬 데미지를 가하셨군요";
				break;
			case 17:	// totaldamagedealttochampions
				markFirstName = "챔피언 때리기 챔피언";
				markFirstImg  = "resources/img/mark/mark_17.png";
				markFirstExplain = "협곡에서 챔피언에게 가장 큰 데미지를 준 건 당신입니다!";
				break;
			case 18:	// magicdamagedealttochampions
				markFirstName = "최강의 마법사";
				markFirstImg  = "resources/img/mark/mark_18.png";
				markFirstExplain = "챔피언들에게 강력한 마법 딜링을 하셨어요!";
				break;
			case 19:	// physicaldamagedealttochampions
				markFirstName = "최강의 물리 딜러";
				markFirstImg  = "resources/img/mark/mark_19.png";
				markFirstExplain = "상대 챔피언에게 당신은 가장 무서운 물리딜러입니다.";
				break;
			case 20:	// truedamagedealttochampions
				markFirstName = "방어구를 꿰뚫고";
				markFirstImg  = "resources/img/mark/mark_20.png";
				markFirstExplain = "고정 데미지로 상대를 관통하셨어요!";
				break;
			case 21:	// totalheal
				markFirstName = "치유하는 자";
				markFirstImg  = "resources/img/mark/mark_21.png";
				markFirstExplain = "게임에서의 치유량이 가장 높습니다";
				break;
			case 22:	// totalunitshealed
				markFirstName = "-----사용하지 않는 데이터";
				markFirstImg  = "resources/img/mark/mark_22.png";
				markFirstExplain = "-----사용하지 않는 데이터";
				break;
			case 23:	// damageselfmitigated
				markFirstName = "허허 시원하다";
				markFirstImg  = "resources/img/mark/mark_23.png";
				markFirstExplain = "방어구나 보호막을 통해 가장 많은 데미지를 받아내셨어요";			
			case 24:	// damagedealttoobjectives
				markFirstName = "화물 밀어요 화물";
				markFirstImg  = "resources/img/mark/mark_24.png";
				markFirstExplain = "오브젝트에 가장 많은 딜링을 하셨습니다";
				break;
			case 25:	// damagedealttoturrets
				markFirstName = "공성장인";
				markFirstImg  = "resources/img/mark/mark_25.png";
				markFirstExplain = "이 게임은 넥서스를 깨는 게임입니다.";
				break;
			case 26:	// visionscore
				markFirstName = "땅따먹기 장인";
				markFirstImg  = "resources/img/mark/mark_26.png";
				markFirstExplain = "시야 점수가 가장 높으세요!";
				break;
			case 27:	// timeccingothers
				markFirstName = "판을 만드는 자";
				markFirstImg  = "resources/img/mark/mark_27.png";
				markFirstExplain = "적에게 CC를 적용시킨 시간이 제일 길어요";
				break;
			case 28:	// totaldamagetaken
				markFirstName = "강철 방패";
				markFirstImg  = "resources/img/mark/mark_28.png";
				markFirstExplain = "적의 데미지를 받아낸 양이 가장 많습니다.";
				break;
			case 29:	// magicaldamagetaken
				markFirstName = "그만 좀 때려";
				markFirstImg  = "resources/img/mark/mark_29.png";
				markFirstExplain = "마법사를 만나셨나봐요. 마법 데미지를 맞은 양이 많습니다.";
				break;
			case 30:	// physicaldamagetaken
				markFirstName = "적은 물리 딜러";
				markFirstImg  = "resources/img/mark/mark_30.png";
				markFirstExplain = "물리 딜러를 만나셨나보네요. 물리 데미지를 맞은 양이 많습니다.";
				break;
			case 31:	// truedamagetaken
				markFirstName = "올라프와 레드";
				markFirstImg  = "resources/img/mark/mark_31.png";
				markFirstExplain = "괜찮으세요? 관통 데미지를 받은 양이 가장 많아요";
				break;
			case 32:	// goldearned
				markFirstName = "도내 최고 부자";
				markFirstImg  = "resources/img/mark/mark_32.png";
				markFirstExplain = "10명 중 가장 많은 골드를 버시네요! 조금만 나누어 주세요";
				break;
			case 33:	// turretkills
				markFirstName = "타워 파괴자";
				markFirstImg  = "resources/img/mark/mark_33.png";
				markFirstExplain = "당신은 게임의 타워를 가장 많이 파괴한 사람입니다";
				break;
			case 34:	// inhibitorkills
				markFirstName = "억제기 파괴자";
				markFirstImg  = "resources/img/mark/mark_34.png";
				markFirstExplain = "억제기를 부수셨네요! 승리까지 앞으로 한 발자국이에요";
				break;
			case 35:	// totalminionskilled
				markFirstName = "미니언 학살자";
				markFirstImg  = "resources/img/mark/mark_35.png";
				markFirstExplain = "10명 중 가장 많은 미니언을 잡으셨어요";
				break;
			case 36:	// neutralminionskilledenemyjungle
				markFirstName = "정글러";
				markFirstImg  = "resources/img/mark/mark_36.png";
				markFirstExplain = "가장 많은 정글 몬스터를 잡으셨어요!";
				break;
			case 37:	// champlevel
				markFirstName = "성장의 화신";
				markFirstImg  = "resources/img/mark/mark_37.png";
				markFirstExplain = "게임에서 가장 높은 레벨을 보유하셨어요";
				break;
			case 38:	// visionwardsboughtingame
				markFirstName = "--------사용하지 않는 데이터";
				markFirstImg  = "";
				markFirstExplain = "--------사용하지 않는 데이터";
				break;
			case 39:	// wardsplaced
				markFirstName = "--------사용하지 않는 데이터";
				markFirstImg  = "";
				markFirstExplain = "--------사용하지 않는 데이터";
				break;
			case 40:	// wardskilled
				markFirstName = "안개 숨기의 술";
				markFirstImg  = "resources/img/mark/mark_40.png";
				markFirstExplain = "상대의 시야를 가장 많이 지웠어요. 팀의 활동 가능성을 높이셨네요";
				break;				
			case 41:	// firstbloodkill
				markFirstName = "퍼스트 블러드";
				markFirstImg  = "resources/img/mark/mark_41.png";
				markFirstExplain = "분위기를 주도하고 계시네요! 퍼스트 블러드!";
				break;
			case 42:	// firsttowerkill
				markFirstName = "첫 타워 파괴 장인";
				markFirstImg  = "resources/img/mark/mark_42.png";
				markFirstExplain = "첫 타워는 당신에 의해 파괴되었습니다.";
				break;
		}
		
		switch(markSecondNum) {
		case 1:		// kills
			markSecondName = "협곡의 살인마";
			markSecondImg  = "resources/img/mark/mark_1.png";
			markSecondExplain = "뛰어난 집중력으로 적을 숨통은 끊어냈어요!";
			break;
		case 2:		// deaths
			markSecondName = "또 죽었어!";
			markSecondImg  = "resources/img/mark/mark_2.png";
			markSecondExplain = "혹시 카서스 유저이신가요? 데스가 너무 많아요!";
			break;
		case 3:		// assists
			markSecondName = "발빠른 조력자";
			markSecondImg  = "resources/img/mark/mark_3.png";
			markSecondExplain = "협곡을 돌아다니며 가장 많은 어시스트를 챙기셨어요!";
			break;
		case 4:		// largestkillingspree
			markSecondName = "영광의 순간";
			markSecondImg  = "resources/img/mark/mark_4.png";
			markSecondExplain = "한번에 많은 적을 쓸어담으셨군요!";
			break;
		case 5:		// largestmultikill
			markSecondName = "죽이고 또 죽이고";
			markSecondImg  = "resources/img/mark/mark_5.png";
			markSecondExplain = "죽지 않고 연속킬을 기록하셨어요!";
			break;
		case 6:		// killingsprees
			markSecondName = "날카로운 칼날";
			markSecondImg  = "resources/img/mark/mark_6.png";
			markSecondExplain = "여러번의 멀티킬을 기록하셨어요!";
			break;
		case 7:		// longesttimespentliving
			markSecondName = "삼천갑자";
			markSecondImg  = "resources/img/mark/mark_7.png";
			markSecondExplain = "협곡에서 가장 오랫동안 살아남으셨어요!";
			break;
		case 8:		// doublekills
			markSecondName = "더블킬 매니아";
			markSecondImg  = "resources/img/mark/mark_8.png";
			markSecondExplain = "전투를 했다하면 더블킬이군요!";
			break;
		case 9:		// triplekills
			markSecondName = "트리플킬은 기본";
			markSecondImg  = "resources/img/mark/mark_9.png";
			markSecondExplain = "트리플킬이 너무도 손쉬웠습니다."; 
			break;
		case 10:	// quadrakills
			markSecondName = "아깝다. 쿼드라킬";
			markSecondImg  = "resources/img/mark/mark_10.png";
			markSecondExplain = "4명의 목숨이 당신 손에 한 순간에 떨어졌습니다.";
			break;
		case 11:	// pentakills
			markSecondName = "펜타킬 유저";
			markSecondImg  = "resources/img/mark/mark_11.png";
			markSecondExplain = "축하합니다. LOL의 정점에 당신이 서있습니다.";
			break;
		case 12:	// totaldamagedealt
			markSecondName = "아무나 때려";
			markSecondImg  = "resources/img/mark/mark_12.png";
			markSecondExplain = "미니언, 오브젝트, 챔피언 가리지 않고 열심히 때리셨네요";
			break;
		case 13:	// magicdamagedealt
			markSecondName = "강력한 마법사";
			markSecondImg  = "resources/img/mark/mark_13.png";
			markSecondExplain = "협곡의 모든 것들을 마법으로 열심히 때리셨습니다.";
			break;
		case 14:	// physicaldamagedealt
			markSecondName = "강력한 힘캐";
			markSecondImg  = "resources/img/mark/mark_14.png";
			markSecondExplain = "협곡의 모든 것들에게 물리적 공격을 가했습니다.";
			break;
		case 15:	// truedamagedealt
			markSecondName = "트루 데미지란 ";
			markSecondImg  = "resources/img/mark/mark_15.png";
			markSecondExplain = "당신이 가한 데미지는 트루데미지입니다.";
			break;
		case 16:	// largestcriticalstrike
			markSecondName = "강력한 치명타";
			markSecondImg  = "resources/img/mark/mark_16.png";
			markSecondExplain = "얼마전에 팀에서 가장 강력한 크리티컬 데미지를 가하셨군요";
			break;
		case 17:	// totaldamagedealttochampions
			markSecondName = "챔피언 때리기 챔피언";
			markSecondImg  = "resources/img/mark/mark_17.png";
			markSecondExplain = "협곡에서 챔피언에게 가장 큰 데미지를 준 건 당신입니다!";
			break;
		case 18:	// magicdamagedealttochampions
			markSecondName = "최강의 마법사";
			markSecondImg  = "resources/img/mark/mark_18.png";
			markSecondExplain = "챔피언들에게 강력한 마법 딜링을 하셨어요!";
			break;
		case 19:	// physicaldamagedealttochampions
			markSecondName = "최강의 물리 딜러";
			markSecondImg  = "resources/img/mark/mark_19.png";
			markSecondExplain = "상대 챔피언에게 당신은 가장 무서운 물리딜러입니다.";
			break;
		case 20:	// truedamagedealttochampions
			markSecondName = "방어구를 꿰뚫고";
			markSecondImg  = "resources/img/mark/mark_20.png";
			markSecondExplain = "고정 데미지로 상대를 관통하셨어요!";
			break;
		case 21:	// totalheal
			markSecondName = "치유하는 자";
			markSecondImg  = "resources/img/mark/mark_21.png";
			markSecondExplain = "게임에서의 치유량이 가장 높습니다";
			break;
		case 22:	// totalunitshealed
			markSecondName = "-----사용하지 않는 데이터";
			markSecondImg  = "resources/img/mark/mark_22.png";
			markSecondExplain = "-----사용하지 않는 데이터";
			break;
		case 23:	// damageselfmitigated
			markSecondName = "허허 시원하다";
			markSecondImg  = "resources/img/mark/mark_23.png";
			markSecondExplain = "방어구나 보호막을 통해 가장 많은 데미지를 받아내셨어요";			
		case 24:	// damagedealttoobjectives
			markSecondName = "화물 밀어요 화물";
			markSecondImg  = "resources/img/mark/mark_24.png";
			markSecondExplain = "오브젝트에 가장 많은 딜링을 하셨습니다";
			break;
		case 25:	// damagedealttoturrets
			markSecondName = "공성장인";
			markSecondImg  = "resources/img/mark/mark_25.png";
			markSecondExplain = "이 게임은 넥서스를 깨는 게임입니다.";
			break;
		case 26:	// visionscore
			markSecondName = "땅따먹기 장인";
			markSecondImg  = "resources/img/mark/mark_26.png";
			markSecondExplain = "시야 점수가 가장 높으세요!";
			break;
		case 27:	// timeccingothers
			markSecondName = "판을 만드는 자";
			markSecondImg  = "resources/img/mark/mark_27.png";
			markSecondExplain = "적에게 CC를 적용시킨 시간이 제일 길어요";
			break;
		case 28:	// totaldamagetaken
			markSecondName = "강철 방패";
			markSecondImg  = "resources/img/mark/mark_28.png";
			markSecondExplain = "적의 데미지를 받아낸 양이 가장 많습니다.";
			break;
		case 29:	// magicaldamagetaken
			markSecondName = "그만 좀 때려";
			markSecondImg  = "resources/img/mark/mark_29.png";
			markSecondExplain = "마법사를 만나셨나봐요. 마법 데미지를 맞은 양이 많습니다.";
			break;
		case 30:	// physicaldamagetaken
			markSecondName = "적은 물리 딜러";
			markSecondImg  = "resources/img/mark/mark_30.png";
			markSecondExplain = "물리 딜러를 만나셨나보네요. 물리 데미지를 맞은 양이 많습니다.";
			break;
		case 31:	// truedamagetaken
			markSecondName = "올라프와 레드";
			markSecondImg  = "resources/img/mark/mark_31.png";
			markSecondExplain = "괜찮으세요? 관통 데미지를 받은 양이 가장 많아요";
			break;
		case 32:	// goldearned
			markSecondName = "도내 최고 부자";
			markSecondImg  = "resources/img/mark/mark_32.png";
			markSecondExplain = "10명 중 가장 많은 골드를 버시네요! 조금만 나누어 주세요";
			break;
		case 33:	// turretkills
			markSecondName = "타워 파괴자";
			markSecondImg  = "resources/img/mark/mark_33.png";
			markSecondExplain = "당신은 게임의 타워를 가장 많이 파괴한 사람입니다";
			break;
		case 34:	// inhibitorkills
			markSecondName = "억제기 파괴자";
			markSecondImg  = "resources/img/mark/mark_34.png";
			markSecondExplain = "억제기를 부수셨네요! 승리까지 앞으로 한 발자국이에요";
			break;
		case 35:	// totalminionskilled
			markSecondName = "미니언 학살자";
			markSecondImg  = "resources/img/mark/mark_35.png";
			markSecondExplain = "10명 중 가장 많은 미니언을 잡으셨어요";
			break;
		case 36:	// neutralminionskilledenemyjungle
			markSecondName = "정글러";
			markSecondImg  = "resources/img/mark/mark_36.png";
			markSecondExplain = "가장 많은 정글 몬스터를 잡으셨어요!";
			break;
		case 37:	// champlevel
			markSecondName = "성장의 화신";
			markSecondImg  = "resources/img/mark/mark_37.png";
			markSecondExplain = "게임에서 가장 높은 레벨을 보유하셨어요";
			break;
		case 38:	// visionwardsboughtingame
			markSecondName = "--------사용하지 않는 데이터";
			markSecondImg  = "";
			markSecondExplain = "--------사용하지 않는 데이터";
			break;
		case 39:	// wardsplaced
			markSecondName = "--------사용하지 않는 데이터";
			markSecondImg  = "";
			markSecondExplain = "--------사용하지 않는 데이터";
			break;
		case 40:	// wardskilled
			markSecondName = "안개 숨기의 술";
			markSecondImg  = "resources/img/mark/mark_40.png";
			markSecondExplain = "상대의 시야를 가장 많이 지웠어요. 팀의 활동 가능성을 높이셨네요";
			break;				
		case 41:	// Secondbloodkill
			markSecondName = "퍼스트 블러드";
			markSecondImg  = "resources/img/mark/mark_41.png";
			markSecondExplain = "분위기를 주도하고 계시네요! 퍼스트 블러드!";
			break;
		case 42:	// Secondtowerkill
			markSecondName = "첫 타워 파괴 장인";
			markSecondImg  = "resources/img/mark/mark_42.png";
			markSecondExplain = "첫 타워는 당신에 의해 파괴되었습니다.";
			break;
	}
		
		switch(markThirdNum) {
		case 1:		// kills
			markThirdName = "협곡의 살인마";
			markThirdImg  = "resources/img/mark/mark_1.png";
			markThirdExplain = "뛰어난 집중력으로 적을 숨통은 끊어냈어요!";
			break;
		case 2:		// deaths
			markThirdName = "또 죽었어!";
			markThirdImg  = "resources/img/mark/mark_2.png";
			markThirdExplain = "혹시 카서스 유저이신가요? 데스가 너무 많아요!";
			break;
		case 3:		// assists
			markThirdName = "발빠른 조력자";
			markThirdImg  = "resources/img/mark/mark_3.png";
			markThirdExplain = "협곡을 돌아다니며 가장 많은 어시스트를 챙기셨어요!";
			break;
		case 4:		// largestkillingspree
			markThirdName = "영광의 순간";
			markThirdImg  = "resources/img/mark/mark_4.png";
			markThirdExplain = "한번에 많은 적을 쓸어담으셨군요!";
			break;
		case 5:		// largestmultikill
			markThirdName = "죽이고 또 죽이고";
			markThirdImg  = "resources/img/mark/mark_5.png";
			markThirdExplain = "죽지 않고 연속킬을 기록하셨어요!";
			break;
		case 6:		// killingsprees
			markThirdName = "날카로운 칼날";
			markThirdImg  = "resources/img/mark/mark_6.png";
			markThirdExplain = "여러번의 멀티킬을 기록하셨어요!";
			break;
		case 7:		// longesttimespentliving
			markThirdName = "삼천갑자";
			markThirdImg  = "resources/img/mark/mark_7.png";
			markThirdExplain = "협곡에서 가장 오랫동안 살아남으셨어요!";
			break;
		case 8:		// doublekills
			markThirdName = "더블킬 매니아";
			markThirdImg  = "resources/img/mark/mark_8.png";
			markThirdExplain = "전투를 했다하면 더블킬이군요!";
			break;
		case 9:		// triplekills
			markThirdName = "트리플킬은 기본";
			markThirdImg  = "resources/img/mark/mark_9.png";
			markThirdExplain = "트리플킬이 너무도 손쉬웠습니다."; 
			break;
		case 10:	// quadrakills
			markThirdName = "아깝다. 쿼드라킬";
			markThirdImg  = "resources/img/mark/mark_10.png";
			markThirdExplain = "4명의 목숨이 당신 손에 한 순간에 떨어졌습니다.";
			break;
		case 11:	// pentakills
			markThirdName = "펜타킬 유저";
			markThirdImg  = "resources/img/mark/mark_11.png";
			markThirdExplain = "축하합니다. LOL의 정점에 당신이 서있습니다.";
			break;
		case 12:	// totaldamagedealt
			markThirdName = "아무나 때려";
			markThirdImg  = "resources/img/mark/mark_12.png";
			markThirdExplain = "미니언, 오브젝트, 챔피언 가리지 않고 열심히 때리셨네요";
			break;
		case 13:	// magicdamagedealt
			markThirdName = "강력한 마법사";
			markThirdImg  = "resources/img/mark/mark_13.png";
			markThirdExplain = "협곡의 모든 것들을 마법으로 열심히 때리셨습니다.";
			break;
		case 14:	// physicaldamagedealt
			markThirdName = "강력한 힘캐";
			markThirdImg  = "resources/img/mark/mark_14.png";
			markThirdExplain = "협곡의 모든 것들에게 물리적 공격을 가했습니다.";
			break;
		case 15:	// truedamagedealt
			markThirdName = "트루 데미지란 ";
			markThirdImg  = "resources/img/mark/mark_15.png";
			markThirdExplain = "당신이 가한 데미지는 트루데미지입니다.";
			break;
		case 16:	// largestcriticalstrike
			markThirdName = "강력한 치명타";
			markThirdImg  = "resources/img/mark/mark_16.png";
			markThirdExplain = "얼마전에 팀에서 가장 강력한 크리티컬 데미지를 가하셨군요";
			break;
		case 17:	// totaldamagedealttochampions
			markThirdName = "챔피언 때리기 챔피언";
			markThirdImg  = "resources/img/mark/mark_17.png";
			markThirdExplain = "협곡에서 챔피언에게 가장 큰 데미지를 준 건 당신입니다!";
			break;
		case 18:	// magicdamagedealttochampions
			markThirdName = "최강의 마법사";
			markThirdImg  = "resources/img/mark/mark_18.png";
			markThirdExplain = "챔피언들에게 강력한 마법 딜링을 하셨어요!";
			break;
		case 19:	// physicaldamagedealttochampions
			markThirdName = "최강의 물리 딜러";
			markThirdImg  = "resources/img/mark/mark_19.png";
			markThirdExplain = "상대 챔피언에게 당신은 가장 무서운 물리딜러입니다.";
			break;
		case 20:	// truedamagedealttochampions
			markThirdName = "방어구를 꿰뚫고";
			markThirdImg  = "resources/img/mark/mark_20.png";
			markThirdExplain = "고정 데미지로 상대를 관통하셨어요!";
			break;
		case 21:	// totalheal
			markThirdName = "치유하는 자";
			markThirdImg  = "resources/img/mark/mark_21.png";
			markThirdExplain = "게임에서의 치유량이 가장 높습니다";
			break;
		case 22:	// totalunitshealed
			markThirdName = "-----사용하지 않는 데이터";
			markThirdImg  = "resources/img/mark/mark_22.png";
			markThirdExplain = "-----사용하지 않는 데이터";
			break;
		case 23:	// damageselfmitigated
			markThirdName = "허허 시원하다";
			markThirdImg  = "resources/img/mark/mark_23.png";
			markThirdExplain = "방어구나 보호막을 통해 가장 많은 데미지를 받아내셨어요";			
		case 24:	// damagedealttoobjectives
			markThirdName = "화물 밀어요 화물";
			markThirdImg  = "resources/img/mark/mark_24.png";
			markThirdExplain = "오브젝트에 가장 많은 딜링을 하셨습니다";
			break;
		case 25:	// damagedealttoturrets
			markThirdName = "공성장인";
			markThirdImg  = "resources/img/mark/mark_25.png";
			markThirdExplain = "이 게임은 넥서스를 깨는 게임입니다.";
			break;
		case 26:	// visionscore
			markThirdName = "땅따먹기 장인";
			markThirdImg  = "resources/img/mark/mark_26.png";
			markThirdExplain = "시야 점수가 가장 높으세요!";
			break;
		case 27:	// timeccingothers
			markThirdName = "판을 만드는 자";
			markThirdImg  = "resources/img/mark/mark_27.png";
			markThirdExplain = "적에게 CC를 적용시킨 시간이 제일 길어요";
			break;
		case 28:	// totaldamagetaken
			markThirdName = "강철 방패";
			markThirdImg  = "resources/img/mark/mark_28.png";
			markThirdExplain = "적의 데미지를 받아낸 양이 가장 많습니다.";
			break;
		case 29:	// magicaldamagetaken
			markThirdName = "그만 좀 때려";
			markThirdImg  = "resources/img/mark/mark_29.png";
			markThirdExplain = "마법사를 만나셨나봐요. 마법 데미지를 맞은 양이 많습니다.";
			break;
		case 30:	// physicaldamagetaken
			markThirdName = "적은 물리 딜러";
			markThirdImg  = "resources/img/mark/mark_30.png";
			markThirdExplain = "물리 딜러를 만나셨나보네요. 물리 데미지를 맞은 양이 많습니다.";
			break;
		case 31:	// truedamagetaken
			markThirdName = "올라프와 레드";
			markThirdImg  = "resources/img/mark/mark_31.png";
			markThirdExplain = "괜찮으세요? 관통 데미지를 받은 양이 가장 많아요";
			break;
		case 32:	// goldearned
			markThirdName = "도내 최고 부자";
			markThirdImg  = "resources/img/mark/mark_32.png";
			markThirdExplain = "10명 중 가장 많은 골드를 버시네요! 조금만 나누어 주세요";
			break;
		case 33:	// turretkills
			markThirdName = "타워 파괴자";
			markThirdImg  = "resources/img/mark/mark_33.png";
			markThirdExplain = "당신은 게임의 타워를 가장 많이 파괴한 사람입니다";
			break;
		case 34:	// inhibitorkills
			markThirdName = "억제기 파괴자";
			markThirdImg  = "resources/img/mark/mark_34.png";
			markThirdExplain = "억제기를 부수셨네요! 승리까지 앞으로 한 발자국이에요";
			break;
		case 35:	// totalminionskilled
			markThirdName = "미니언 학살자";
			markThirdImg  = "resources/img/mark/mark_35.png";
			markThirdExplain = "10명 중 가장 많은 미니언을 잡으셨어요";
			break;
		case 36:	// neutralminionskilledenemyjungle
			markThirdName = "정글러";
			markThirdImg  = "resources/img/mark/mark_36.png";
			markThirdExplain = "가장 많은 정글 몬스터를 잡으셨어요!";
			break;
		case 37:	// champlevel
			markThirdName = "성장의 화신";
			markThirdImg  = "resources/img/mark/mark_37.png";
			markThirdExplain = "게임에서 가장 높은 레벨을 보유하셨어요";
			break;
		case 38:	// visionwardsboughtingame
			markThirdName = "--------사용하지 않는 데이터";
			markThirdImg  = "";
			markThirdExplain = "--------사용하지 않는 데이터";
			break;
		case 39:	// wardsplaced
			markThirdName = "--------사용하지 않는 데이터";
			markThirdImg  = "";
			markThirdExplain = "--------사용하지 않는 데이터";
			break;
		case 40:	// wardskilled
			markThirdName = "안개 숨기의 술";
			markThirdImg  = "resources/img/mark/mark_40.png";
			markThirdExplain = "상대의 시야를 가장 많이 지웠어요. 팀의 활동 가능성을 높이셨네요";
			break;				
		case 41:	// Thirdbloodkill
			markThirdName = "퍼스트 블러드";
			markThirdImg  = "resources/img/mark/mark_41.png";
			markThirdExplain = "분위기를 주도하고 계시네요! 퍼스트 블러드!";
			break;
		case 42:	// Thirdtowerkill
			markThirdName = "첫 타워 파괴 장인";
			markThirdImg  = "resources/img/mark/mark_42.png";
			markThirdExplain = "첫 타워는 당신에 의해 파괴되었습니다.";
			break;
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
