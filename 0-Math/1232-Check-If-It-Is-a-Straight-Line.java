/**
 * Problem 1232: Check if it is a Straight Line
 * Prompt: You are given an array coordinates, coordinates[i] = [x, y],
 * where [x, y] represents the coordinate of a point. Check if these 
 * points make a straight line in the XY plane.
 * Date: 05/08/2020
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x_ini = coordinates[0][0];
        int y_ini = coordinates[0][1];
        //<v1, v2> is the vector created by the first two points
        int v1 = coordinates[1][0] - x_ini;
        int v2 = coordinates[1][1] - y_ini;
        for (int i = 2; i < coordinates.length; ++i)
        {
            //<u1, u2> is the vector created by the 
            //current point and the first point
            int u1 = coordinates[i][0] - x_ini;
            int u2 = coordinates[i][1] - y_ini;
            if (v1 * u2 - u1 * v2 != 0)
                return false;
        }
        return true;
    }
}

/**
 * Notes: record each points' relationship with the starting 
 * point as a vector, and check if two vectors are parallel
 * using the pseudo cross product. 
 */