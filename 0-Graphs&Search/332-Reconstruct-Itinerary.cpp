class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        map<string, vector<string>> graph;
        int len = tickets.size();
        for (int i = 0; i < len; ++i)
            graph[tickets[i][0]].push_back(tickets[i][1]);
        for (map<string, vector<string>>::iterator itr = graph.begin(); 
            itr != graph.end(); ++itr)
        {
            sort(itr->second.begin(), itr->second.end());
        }
        vector<string> ans;
        bool flag = false;
        dfs(graph, "JFK", len, ans, flag);
        return ans;
    }
    
    void dfs(map<string, vector<string>>& g, string src, int steps, vector<string>& ans, bool & flag)
    {
        ans.push_back(src);
        if (steps == 0 || flag)
        {
            flag = true;
            return;
        }
        int tempLen = g[src].size();
        for (int i = 0; i < tempLen; ++i)
        {
            string temp = g[src][i];
            g[src].erase(g[src].begin() + i);
            dfs(g, temp, steps - 1, ans, flag);
            if (flag)
                return;
            g[src].insert(g[src].begin() + i, temp);
        }
        ans.pop_back();
    }
};

/**
 * Notes: We could construct a direct graph and just use dfs to find the correct path. 
 * Since the graph doesn't contain any cycle, we don't need to record whether we have 
 * visited the node. We just record the possible answer track. However we need to delete
 * a path because we don't want to reuse any ticket. 
 * If we end up in a wrong path we just move back and get rid of the wrong choice. 
 * The answer vectors essentially acts as a stack. 
 * */