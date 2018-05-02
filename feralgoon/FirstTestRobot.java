package feralgoon;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class FirstTestRobot extends Robot
{
    private int turnDirection = 1;

    public void run()
    {
        while (true)
        {
            turnRight(15 * turnDirection);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e)
    {

        if (e.getDistance() < 100)
        {
            fire(25);
        }
        else
        {
            if (e.getBearing() >= 0)
            {
                turnDirection = 1;
            }
            else
            {
                turnDirection = -1;
            }
        }
        turnRight(e.getBearing());
        ahead(e.getDistance() / 1.67);
        scan();
    }
}
