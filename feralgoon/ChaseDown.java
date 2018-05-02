package feralgoon;

import robocode.*;
import robocode.Robot;

import java.awt.Color;


public class ChaseDown extends Robot
{
    private int turnDirection = 1;

    //String name ... find out how to track what the last robot you scanned was, and focus them instead of hopping around.

    public void run()
    {
        Color purple = new Color(0x721299);

        setBodyColor(purple);
        setGunColor(purple);
        setBulletColor(Color.ORANGE);

        while(true)
        {
            turnRight(20 * turnDirection);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e)
    {

        if (e.getDistance() < 100)
        {
            if (e.getEnergy() > 40)
            {
                fire(10);
            }
            else if (e.getEnergy() > 20)
            {
                fire(7.5);
            }
            else if (e.getEnergy() > 10)
            {
                fire(5);
            }
            else if (e.getEnergy() > 5)
            {
                fire(1);
            }
            else
            {
                ahead(200);
            }
        }

        if (e.getBearing() < 1)
        {
            turnDirection = -1;
        }
        else
        {
            turnDirection = 1;
        }

        ahead(e.getDistance()/1.667);
        scan();
    }

    public void onHitByBullet(HitByBulletEvent e)
    {
        fire(5);
        back(25);
    }

    public void onHitRobot(HitRobotEvent e)
    {
        if (e.isMyFault())
        {
            back(1);
            ahead(5);
        }
        else
        {
            back(25);
        }
    }

    public void onWin(WinEvent e)
    {
        ahead(5);
        turnRight(5);
    }
}
