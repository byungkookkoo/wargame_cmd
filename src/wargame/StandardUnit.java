package wargame;


class BasicStatus
{
	int row;
	int col;
	int attack;
	int hitpoint;
	int attackRange;
	int moveRange;
	int player;
	String myclass;
	boolean live;
	
	BasicStatus(){};
	
	BasicStatus(int attack, int hitpoint, int attackRange, int moveRange)
	{
		this.attack=attack; this.hitpoint=hitpoint; this.attackRange=attackRange; this.moveRange=moveRange;
		this.live=true;
	}
	public void Attacked(int attack)
	{
		this.hitpoint-=attack;
	}
	public void death()
	{
		if(this.hitpoint<=0)  	this.live=false;
	}

	public void Attack(BasicStatus attacked)
	{
		if(this.player==attacked.player)
		{
			System.out.println("아군은 공격할 수 없습니다.");
		}
		else
		{
		attacked.Attacked(this.attack);
		attacked.death();
		}
	} //공통 
	
	public void Move (MapInfo map[][],int a,int b)
	{
		BasicStatus space=map[a][b].spaceForUnit;
		BasicStatus spaceBefore=map[row][col].spaceForUnit;
		if(!space.live)
		{ //스페이스 좌표 건들이지말것 
			//기존맵에서 받아와야될것 	
			this.row=space.row;
			this.col=space.col;
	//		map[temp1][temp2].spaceForUnit.live=false;
			
			space.attack=this.attack;
			space.hitpoint=this.hitpoint;
			space.attackRange=this.attackRange;
			space.moveRange=this.moveRange;
			space.myclass=this.myclass;
			space.player=this.player;
			space.live=this.live; 
			spaceBefore.live=false; // 이동했었던 자리 비움 
			//플레이어 데이터에 관한 이동  
		
		}
		else
		{
			System.out.println("이동하려는곳에 유닛이 있습니다.");
		}
		
	}
	public void AttackSelect(MapInfo map[][], int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=attackRange&&rangeRow>=-attackRange)&&(rangeCol<=attackRange&&rangeCol>=attackRange)) //범위내에 있으면  
		{
			Attack(map[a][b].spaceForUnit);
		}
		else
		{
			System.out.println("잘못된 공격 좌표입니다.");	
		}
	}
	public void MoveSelect(MapInfo map[][],int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=moveRange&&rangeRow>=-moveRange)&&(rangeCol<=moveRange&&rangeCol>=-moveRange)) //범위내에 있으면  
		{
			Move(map,a,b);
		}
		else
		{
			System.out.println("잘못된 이동 좌표입니다.");	
		}
	}
}

class King extends BasicStatus
{
	King(int col, int player) //생성
	{
		super(0,15,0,1);//킹 능력치 대입 
		myclass="  king  ";
		this.row=5; this.col=col;this.player=player;  //킹은 무조건 생성되는 좌표가 있다.
	};
	public void AttackSelect(MapInfo map[][],int a, int b) // 메소드 오버라이딩 
	{
		System.out.println("왕은 공격할 수 없습니다.");
	}
} //킹 클래스

class Knight extends BasicStatus
{
	Knight(int row,int col, int player) //생성
	{
		super(6,15,1,3);  // 기병 능력치 대입  
		myclass=" knight ";
		this.row= row; this.col=col; this.player=player; // 좌표 생성은나중에 
	};
} // 기병 데이터
class Infantry extends BasicStatus
{
	Infantry(int row, int col, int player) //생성
	{
		super(4,24,1,1);  // 보병 능력치 대입  
		myclass="infantry";
		this.row=row; this.col=col; this.player=player;
	};
} //보병 클래스 
class Archer extends BasicStatus
{
	Archer(int row, int col, int player) //생성
	{
		super(3,12,4,2);  // 궁병 능력치 대입  
		myclass=" archer ";
		this.row=row; this.col=col;  this.player=player;
	};
	
	public void AttackSelect(MapInfo map[][], int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=4||rangeRow>=-4)&&rangeCol==0)
		{
			Attack(map[a][b].spaceForUnit);
		}
		else if((rangeCol<=4||rangeCol>=-4)&&rangeRow==0)
		{
			Attack(map[a][b].spaceForUnit);
		}
		else
		{
			System.out.println("잘못된 공격 좌표입니다.");
		}
	}// 메소드 오버라이딩(특수 유닛)
	
	public void MoveSelect(MapInfo map[][],int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=moveRange&&rangeRow>=-moveRange)&&rangeCol==0)
		{
			Move(map,a,b);
		}
		else if((rangeCol<=moveRange&&rangeCol>=-moveRange)&&rangeRow==0)
		{
			Move(map,a,b);
		}
		else
		{
			System.out.println("잘못된 이동 좌표입니다.");
		}
	} // 메소드 오버라이딩(특수유닛) 
} //궁병 클래스  

public class StandardUnit
{
	
}