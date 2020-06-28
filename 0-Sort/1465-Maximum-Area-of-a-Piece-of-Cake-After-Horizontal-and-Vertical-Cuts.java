/**
 * Problem 1465: Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * Given a rectangular cake with height h and width w, and two arrays 
 * of integers horizontalCuts and verticalCuts where horizontalCuts[i]
 * is the distance from the top of the rectangular cake to the ith 
 * horizontal cut and similarly, verticalCuts[j] is the distance from 
 * the left of the rectangular cake to the jth vertical cut.
 * Return the maximum area of a piece of cake after you cut at each 
 * horizontal and vertical position provided in the arrays 
 * horizontalCuts and verticalCuts. Since the answer can be a huge 
 * number, return this modulo 10^9 + 7.
 * Date: 05/30/2020
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hor = 0;
        long ver = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length - 1; ++i)
        {
            int t = horizontalCuts[i + 1] - horizontalCuts[i];
            if (t > hor)
                hor = t;
        }
        for (int i = 0; i < verticalCuts.length - 1; ++i)
        {
            int t = verticalCuts[i + 1] - verticalCuts[i];
            if (t > ver)
                ver = t;
        }
        int t = h - horizontalCuts[horizontalCuts.length - 1];
        if (t > hor)
            hor = t;
        t = horizontalCuts[0];
        if (t > hor)
            hor = t;
        
        t = w - verticalCuts[verticalCuts.length - 1];
        if (t > ver)
            ver = t;
        t = verticalCuts[0];
        if (t > ver)
            ver = t;
        int m = 1000000007;
        hor = hor % m;
        ver = ver % m;
        long ans = hor * ver;
        ans = ans % m;
        return (int) ans;
    }
}

/**
 * Notes: Get the maximum gap between cuts by sorting
 * the array of cut and loop through the array to 
 * find the maximum gap. 
 * When doing the multiplication, need to mod 10^9 + 7
 * seperately for each number and then do the final mod, 
 * otherwise would overflow. 
 */