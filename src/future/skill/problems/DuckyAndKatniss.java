package future.skill.problems;

public class DuckyAndKatniss {
    /**
     * Input:
     * - 'duck degrees': a float between 0 and 360 degrees representing
     * Ducky's current position in terms of angle from the pond's center.
     * - 'duck distance': a float between 0 and 50 denoting Ducky's distance
     * from the pond center.
     * - 'cat degrees': a float between 0 and 360 degrees, indicating
     * Katniss' current location on the pond's edge.
     * Output:
     * - Return the direction for Ducky to move for the next second (always 1
     * metre). The direction should be a float between 0 and 360 degrees.
     * Note: All degrees have 0 / 360 degrees pointing to the right, see the
     * canvas reference.
     */
    public double level1MakeMove(double duckDegrees, double duckDistance, double catDegrees) {
        // Write your code here

        double deltaDegrees = Math.abs(duckDegrees - catDegrees);
        if (deltaDegrees > 180) {
            deltaDegrees = 360 - deltaDegrees;
        }

        double catTime = 100 * Math.PI * deltaDegrees / 360 / 3;
        double duckTime = 50 - duckDistance;

        if (duckTime < catTime) {
            return duckDegrees;
        }

        return duckDegrees < 180 ? duckDegrees + 180.0 : duckDegrees - 180.0;
    }

    /**
     * Input:
     * - 'duck degrees': a float between 0 and 360 degrees representing
     * Ducky's current position in terms of angle from the pond's center.
     * - 'duck distance': a float between 0 and 50 denoting Ducky's distance
     * from the pond center.
     * - 'cat degrees': a float between 0 and 360 degrees, indicating
     * Katniss' current location on the pond's edge.
     * Output:
     * - Return the direction for Ducky to move for the next second (always 1
     * metre). The direction should be a float between 0 and 360 degrees.
     * Note: All degrees have 0 / 360 degrees pointing to the right, see the
     * canvas reference.
     */
    public double level2MakeMove(double duckDegrees, double duckDistance, double catDegrees) {
        // Write your code here
        double deltaDegrees = duckDegrees - catDegrees;
        if (deltaDegrees > 180) {
            deltaDegrees -= 360;
        } else if (deltaDegrees < -180) {
            deltaDegrees += 360;
        }

        int catTime = (int) Math.floor((100 * Math.PI * Math.abs(deltaDegrees) / 360 / 4));
        int duckTime = (int) Math.floor(50 - duckDistance);

        if (duckTime < catTime) {
            return duckDegrees;
        }

        double moveDegrees;

        if(deltaDegrees>90) {
            moveDegrees = duckDegrees + 45;
        } else if (deltaDegrees > 0) {
            moveDegrees = duckDegrees + 90;
        } else if (deltaDegrees < -90) {
            moveDegrees = duckDegrees - 45;
        } else {
            moveDegrees = duckDegrees - 90;
        }

        if (moveDegrees > 360) {
            moveDegrees-= 360;
        } else if (moveDegrees < 0) {
            moveDegrees+= 360;
        }

        return moveDegrees;

    }
}
