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
			System.out.println("�Ʊ��� ������ �� �����ϴ�.");
		}
		else
		{
		attacked.Attacked(this.attack);
		attacked.death();
		}
	} //���� 
	
	public void Move (MapInfo map[][],int a,int b)
	{
		BasicStatus space=map[a][b].spaceForUnit;
		BasicStatus spaceBefore=map[row][col].spaceForUnit;
		if(!space.live)
		{ //�����̽� ��ǥ �ǵ��������� 
			//�����ʿ��� �޾ƿ;ߵɰ� 	
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
			spaceBefore.live=false; // �̵��߾��� �ڸ� ��� 
			//�÷��̾� �����Ϳ� ���� �̵�  
		
		}
		else
		{
			System.out.println("�̵��Ϸ��°��� ������ �ֽ��ϴ�.");
		}
		
	}
	public void AttackSelect(MapInfo map[][], int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=attackRange&&rangeRow>=-attackRange)&&(rangeCol<=attackRange&&rangeCol>=attackRange)) //�������� ������  
		{
			Attack(map[a][b].spaceForUnit);
		}
		else
		{
			System.out.println("�߸��� ���� ��ǥ�Դϴ�.");	
		}
	}
	public void MoveSelect(MapInfo map[][],int a, int b)
	{
		int rangeRow=row-a;
		int rangeCol=col-b;
		if((rangeRow<=moveRange&&rangeRow>=-moveRange)&&(rangeCol<=moveRange&&rangeCol>=-moveRange)) //�������� ������  
		{
			Move(map,a,b);
		}
		else
		{
			System.out.println("�߸��� �̵� ��ǥ�Դϴ�.");	
		}
	}
}

class King extends BasicStatus
{
	King(int col, int player) //����
	{
		super(0,15,0,1);//ŷ �ɷ�ġ ���� 
		myclass="  king  ";
		this.row=5; this.col=col;this.player=player;  //ŷ�� ������ �����Ǵ� ��ǥ�� �ִ�.
	};
	public void AttackSelect(MapInfo map[][],int a, int b) // �޼ҵ� �������̵� 
	{
		System.out.println("���� ������ �� �����ϴ�.");
	}
} //ŷ Ŭ����

class Knight extends BasicStatus
{
	Knight(int row,int col, int player) //����
	{
		super(6,15,1,3);  // �⺴ �ɷ�ġ ����  
		myclass=" knight ";
		this.row= row; this.col=col; this.player=player; // ��ǥ ���������߿� 
	};
} // �⺴ ������
class Infantry extends BasicStatus
{
	Infantry(int row, int col, int player) //����
	{
		super(4,24,1,1);  // ���� �ɷ�ġ ����  
		myclass="infantry";
		this.row=row; this.col=col; this.player=player;
	};
} //���� Ŭ���� 
class Archer extends BasicStatus
{
	Archer(int row, int col, int player) //����
	{
		super(3,12,4,2);  // �ú� �ɷ�ġ ����  
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
			System.out.println("�߸��� ���� ��ǥ�Դϴ�.");
		}
	}// �޼ҵ� �������̵�(Ư�� ����)
	
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
			System.out.println("�߸��� �̵� ��ǥ�Դϴ�.");
		}
	} // �޼ҵ� �������̵�(Ư������) 
} //�ú� Ŭ����  

public class StandardUnit
{
	
}