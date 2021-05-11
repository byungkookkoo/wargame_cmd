package wargame;
import java.util.*;
class method
{
	public static void ShowMap(MapInfo mapData[][])
	{
		System.out.print("  ");
		for(int i=0;i<mapData.length;i++)
		{
			if(i==10)
			{
				System.out.print("   "+(i+1)+"    ");
			}
			else
			{System.out.print("    "+(i+1)+"    ");}
		}
			System.out.println("");
		
		for(int i=0;i<mapData.length;i++)
		{
			System.out.print("  ");
			for(int j=0; j<mapData.length;j++)
			{
				System.out.print("+--------");
			}
			System.out.println("+");
			System.out.print("  ");
			for(int j=0; j<mapData.length;j++) //윗가로줄
			{
				if(mapData[i][j].spaceForUnit.live)
				{
					System.out.print("|player"+mapData[j][i].spaceForUnit.player+" ");
				}
			else
			{
				System.out.print("|        ");
			}
			}
			System.out.println("|");
			if(i>=9)
			{
				System.out.print((i+1));
			}
			else
			{
				System.out.print((i+1)+" ");
			}
			for(int j=0; j<mapData.length;j++) //중간 가로줄
			{
				System.out.print("|        ");
			}
			System.out.println("|");
			System.out.print("  ");
			for(int j=0; j<mapData.length;j++) //아랫가로줄
			{
				if(mapData[i][j].spaceForUnit.live)
					{
					System.out.print("|"+mapData[j][i].spaceForUnit.myclass);
					}
				else
				{
					System.out.print("|        ");
				}
			}
			System.out.println("|");
		}
		System.out.print("  ");
		for(int j=0; j<mapData.length;j++)
		{
			System.out.print("+--------");
		}
		System.out.println("+");
	}
}

public class Main{
	public static void main(String[] args)
	{
		Scanner ipt=new Scanner(System.in);
		MapInfo mapData[][]= new MapInfo[11][11];
		for(int i=0;i<mapData.length;i++)
		{
			for(int j=0;j<mapData[i].length;j++)
			{
				mapData[i][j]= new MapInfo();
				mapData[i][j].spaceForUnit.row=i;
				mapData[i][j].spaceForUnit.col=j; //좌표초기화 
			}
		}
		System.out.println("플레이어 1의 문명을 선택 해주세요.");
		System.out.print("1. 한국\n2. 일본\n>>");
		int countrycode1=ipt.nextInt();
		System.out.println("플레이어 2의 문명을 선택 해주세요.");
		System.out.print("1. 한국\n2. 일본\n>>");
		int countrycode2=ipt.nextInt();
		Country player1;
		Country player2;
		if(countrycode1==1)
		{
			player1=new Korea();
			((Korea) player1).classify(1);  //캐스팅
		}
		else
		{
			player1=new Japan();
			((Japan) player1).classify(1); //캐스팅
		}
		if(countrycode2==1)
		{
			player2=new Korea();
			((Korea) player2).classify(2); //캐스팅
		}
		else
		{
			player2=new Japan();
			((Japan) player2).classify(2); //캐스팅
		}

		mapData[player1.A1.row][player1.A1.col].spaceForUnit.live=true;
		
		while(player1.K.live||player2.K.live)
		{
			for(int i=1;i<=2;i++)
			{
				if(i==1)
				{
					method.ShowMap(mapData);
					System.out.print("플레이어 1의 턴입니다.\n1. 이동\n2. 공격\n3.턴넘기기\n>>");
					int cmd=ipt.nextInt();
					switch(cmd)
					{
					case(1):
					{
						
					}
					case(2):
					{
						
					}
					case(3):
					{
						
					}
					}
				
				}
			}
			
		}
	}
}