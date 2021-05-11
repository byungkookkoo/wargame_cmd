package wargame;
public class Korea extends Country
{
	
	
	public void classify(int team)
	{
		int randomrow[]=new int[9];
		int randomcol[]=new int[9];
		for(int i=0;i<randomrow.length;i++)
		{
			randomrow[i]=(int)(Math.random()*10);
			randomcol[i]=(int)(Math.random()*3);
			for(int j=0;j<i;j++)
			{
				if((team==1)&&(randomrow[i]==randomrow[j])&&(randomrow[j]==5&&randomcol[j]==0))
				{ //같은 쌍이 나오거나 킹 좌표가 나오면 빠꾸 
					i--;
					break;
				}
				if((team==2)&&(randomrow[i]==randomrow[j])&&(randomrow[j]==5&&randomcol[j]==3))
				{
					i--;
					break;
				}
			}
		}
		if (team==1)
		{
			A1.row=randomrow[0]; A1.col=randomcol[0];
			A2.row=randomrow[1]; A2.col=randomcol[1];
			A3.row=randomrow[2]; A3.col=randomcol[2];
			A4.row=randomrow[3]; A4.col=randomcol[3];
			A5.row=randomrow[4]; A5.col=randomcol[4];
			I1.row=randomrow[5]; I1.col=randomcol[5];
			I2.row=randomrow[6]; I1.col=randomcol[6];
			K1.row=randomrow[7]; K1.col=randomcol[7];
			K2.row=randomrow[8]; K1.col=randomcol[8];
		}
		else if(team==2)
		{
			K.col=10;
			A1.row=randomrow[0]; A1.col=randomcol[0]+7; A1.player=2;
			A2.row=randomrow[1]; A2.col=randomcol[1]+7; A2.player=2;
			A3.row=randomrow[2]; A3.col=randomcol[2]+7; A3.player=2;
			A4.row=randomrow[3]; A4.col=randomcol[3]+7; A4.player=2;
			A5.row=randomrow[4]; A5.col=randomcol[4]+7; A5.player=2;
			I1.row=randomrow[5]; I1.col=randomcol[5]+7; I1.player=2;
			I2.row=randomrow[6]; I1.col=randomcol[6]+7; I2.player=2;
			K1.row=randomrow[7]; K1.col=randomcol[7]+7; K1.player=2;
			K2.row=randomrow[8]; K1.col=randomcol[8]+7; K2.player=2;
		}
	}
	
}

	
