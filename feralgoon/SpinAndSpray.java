package feralgoon;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;

public class SpinAndSpray extends Robot
{
    public void run()
    {
        while (true)
        {
            turnRight(5);
            fire(1);
        }
    }

    public void onHitRobot(HitRobotEvent e)
    {
        ahead(50);
    }

    public void onHitByBullet(HitByBulletEvent e)
    {
        ahead(50);
    }
}
