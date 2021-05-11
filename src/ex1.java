package wargame;

public class ex1 {
public static void main(String[] args)
{
		int randomrow[]=new int[9];
		for(int i=0;i<randomrow.length;i++)
		{
			randomrow[i]=(int)(Math.random()*10);
			for(int j=0;j<i;j++)
			{
				if((randomrow[i]==randomrow[j]))
				{
					i--;
					break;
				}
			}
		}
		System.out.println(randomrow[1]);
	}
	
}
