/**
 * Problem 997: Find the Town Judge
 * Prompt: In a town, there are N people labelled from 1 to N.  
 * There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge. 
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] 
 * representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of 
 * the town judge. Otherwise, return -1.
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Key = a people; value = whoever trust him
        for (int i = 0; i < trust.length; ++i)
        {
            if (map.get(trust[i][1]) == null)
                map.put(trust[i][1], new ArrayList<Integer>(Arrays.asList(trust[i][0])));
            else
                map.get(trust[i][1]).add(trust[i][0]);
        }
        for (int i = 1; i <= N; ++i)
        {
            if (map.get(i) != null && map.get(i).size() == N - 1)
            {
                int flag = 1;
                for (int j = 1; j <= N; ++j)
                {
                    if (map.get(j) != null && map.get(j).indexOf(i) != -1)
                    {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1)
                    return i;
            }
        }
        if (N == 1)
            return 1;
        return -1;
    }
}

/**
 * Notes: Create a map with Key = a people; value = whoever trust him
 */