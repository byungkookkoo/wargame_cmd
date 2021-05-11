package wargame;
import java.util.*;
class method1
{
	public static void ShowMap(MapInfo mapData[][])
	{
		
		for(int j=0;j<mapData.length;j++)
		{
			for(int i=0; i<mapData.length;i++)
			{
				System.out.print("+--------");
			}
			System.out.println("+");
			for(int i=0; i<mapData.length;i++)
			{
				if(mapData[j][i].spaceForUnit.live)
				{
					System.out.print("|player"+mapData[j][i].spaceForUnit.player+" ");
				}
			else
			{
				System.out.print("|        ");
			}
			}
			System.out.println("|");
			for(int i=0; i<mapData.length;i++)
			{
				if(mapData[j][i].spaceForUnit.live)
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
		for(int i=0; i<mapData.length;i++)
		{
			System.out.print("+--------");
		}
		System.out.println("+");
	}
}

public class ex{
	public static void main(String[] args)
	{
		MapInfo mapData[][]= new MapInfo[11][11];
		for(int i=0;i<mapData.length;i++)
		{
			for(int j=0;j<mapData[i].length;j++)
			{
				mapData[i][j]= new MapInfo();
				mapData[i][j].spaceForUnit.row=i;
				mapData[i][j].spaceForUnit.col=j; //ÁÂÇ¥ÃÊ±âÈ­ 
			}
		}
	
		
		
		method1.ShowMap(mapData);
	}
}