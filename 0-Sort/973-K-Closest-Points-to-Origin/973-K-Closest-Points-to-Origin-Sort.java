class Solution {
	private int calculateDistance(int[] point) 
    {
		return point[0] * point[0] + point[1] * point[1];
	}
	public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
		int[] distance = new int[len];
		for(int i = 0; i < len; i++) 
            distance[i] = calculateDistance(points[i]);
 
		Arrays.sort(distance);
		int kthDistance = distance[K - 1];
		int[][] kClosestPoints = new int[K][2];
 
		for(int i = 0, j = 0; i < len && j < K; i++) 
			if(calculateDistance(points[i]) <= kthDistance)
				kClosestPoints[j++] = points[i];
 
		return kClosestPoints;
	}
}

/**
 * Notes: Sort the distance and find the cut off
 * of the distance for the kth point
 * then find the distance smaller than or equal to this 
 * cut off for the output. 
 */