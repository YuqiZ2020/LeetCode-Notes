/**
 * Problem 1344. Angle Between Hands of a Clock
 * Prompt: Given two numbers, hour and minutes. Return the smaller 
 * angle (in degrees) formed between the hour and the minute hand.
 * Date: 07/14/2020
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double fracM = 1.0 * minutes / 60;
        double degH = 1.0 * hour / 12 * 360 + fracM * 30;
        double degM = fracM * 360;
        double res = Math.abs(degH - degM);
        if (res <= 180)
            return res;
        return 360 - res;
    }
}

/**
 * Notes: First calculate the fraction for minutes, which will add
 * up for the fraction of the hour. Then compute the degrees and 
 * find the absolute difference. See if need adjustment for smaller
 * and bigger angle in the end. 
 */