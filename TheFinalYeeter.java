package LehnerJan;
import robocode.*;

public class TheFinalYeeter extends JuniorRobot
{
		int wallFinder = 0;
		int stage = 1;
		int distToWall;
		int firePermission = 0;
		int roboPosition;
		int midleHeight = fieldHeight / 2;
		
	public void run() 
	{
		setColors(green, blue, green, green, green);
	
		while(true) 
		{
			if (stage == 1)
			{
				turnTo(180);
				ahead(5000);
				stage++;
			}
			if (stage == 2)
			{
				turnLeft(90);
				turnGunLeft(180);
				ahead(250);
				turnGunLeft(180);
				turnLeft(90);
				turnGunLeft(180);
				ahead(120);
				turnGunLeft(180);
				if (others < 20)
				{
				stage++;
				}
			}
			if(stage == 3)
			{   
				turnTo(0);
				ahead(midleHeight);
				stage++;
			}
			if(stage == 4)
			{
				turnAheadLeft(20,10);
			}
		}
	}

	public void onScannedRobot() 
	{
		if (stage == 1)
		{
			fire(0.5);
		}
		else
		{
			int distance = scannedDistance;
			turnGunTo(scannedAngle);
			tacticalFire(distance);
			if (others < 20)
			{
				stage++;
			}
	  	}
	}


	public void onHitByBullet() 
	{
		ahead(150);
		back(100);
		ahead(200);
	}
	

	public void onHitWall() 
	{
		if(wallFinder == 0)
		{	
			stage = 2;
			wallFinder = 1;
		}
		back(10);
		turnAheadLeft(20,10);	
		
	}	
	
	public void tacticalFire(int distance)
	{
		if(gunReady)
        {
			if(distance > 350 || energy < 15)
			{
				fire(1);
				out.println("Hope this shot is going to hit you");
			}
			else if(distance > 50)
			{
				fire(2);
			}
			else
			{
				fire(3);
			}
		}	
	}
}
