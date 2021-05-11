package wargame;

public class MapInfo {
	 BasicStatus spaceForUnit= new BasicStatus(); // 유닛 넣는 공간 (죽었는지 여부로 빈 공간 판)
	 int player=0;
	 public MapInfo()
	 {
		 spaceForUnit.live=false;
	 };
	
	
}