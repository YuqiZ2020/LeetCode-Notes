/**
 * Problem 733: Flood Fill
 * Prompt: An image is represented by a 2-D array of integers, each integer
 * representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, 
 * plus any pixels connected 4-directionally to the starting pixel of the same 
 * color as the starting pixel, plus any pixels connected 4-directionally to 
 * those pixels (also with the same color as the starting pixel), and so on. 
 * Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) 
            dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) 
        {
            image[r][c] = newColor;
            if (r >= 1) 
                dfs(image, r - 1, c, color, newColor);
            if (c >= 1) 
                dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) 
                dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) 
                dfs(image, r, c + 1, color, newColor);
        }
    }
}

/**
 * Notes: This is a recursive dfs search. For each color, if the color
 * is the same as the original color, perform the new coloring and 
 * perform search for the four directions. 
 * Notice that it is important to check if the original color
 * is the same as new color, otherwise it would causes infinite recursion. 
 */