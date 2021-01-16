/*
 * Problem 773. Sliding Puzzle
 * Prompt: On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, 
 * and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of 
 * the board is solved. If it is impossible for the state of the board to be solved, 
 * return -1.
 * Date: 01/16/2021
 */ 
class Solution 
{
private:
    string boardToStr(vector<vector<int>>& board)
    {
        int lenM = board.size();
        int lenN = board[0].size();
        stringstream curSS;
        for (int i = 0; i < lenM; ++i)
        {
            for (int j = 0; j < lenN; ++j)
                curSS << board[i][j] << ' ';
        }
        return curSS.str();
    }
    
    void searchZero(vector<vector<int>>& cur, int& x, int& y)
    {
        int lenM = cur.size();
        int lenN = cur[0].size();
        for (int i = 0; i < lenM; ++i)
        {
            for (int j = 0; j < lenN; ++j)
            {
                if (cur[i][j] == 0)
                {
                    x = i;
                    y = j;
                    return;
                }
            }
        }
    }
    
    int dirs[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    void buildNewBoard(vector<vector<int>>& newBoard, vector<vector<int>>& board, int x, int y, 
                      int newX, int newY, string& newStr)
    {
        int lenM = board.size();
        int lenN = board[0].size();
        for (int i = 0; i < lenM; ++i)
        {
            vector<int> v;
            for (int j = 0; j < lenN; ++j)
                v.push_back(board[i][j]);
            newBoard.push_back(v);
        }
        newBoard[x][y] = newBoard[newX][newY];
        newBoard[newX][newY] = 0;
        newStr = boardToStr(newBoard);
    }
    
public:
    int slidingPuzzle(vector<vector<int>>& board) 
    {
        int lenM = board.size();
        int lenN = board[0].size();
        int ans = 0;
        stringstream targetSS;
        for (int i = 1; i < lenM * lenN; ++i)
            targetSS << i << ' ';
        targetSS << 0 << ' ';
        string target = targetSS.str();
        queue<vector<vector<int>>> boardStates;
        unordered_set<string> visited;
        boardStates.push(board);
        string start = boardToStr(board);
        visited.insert(start);
        while (!boardStates.empty())
        {
            int size = boardStates.size();
            for (int i = 0; i < size; ++i)
            {
                vector<vector<int>> cur = boardStates.front();
                boardStates.pop();
                string curStr = boardToStr(cur);
                if (curStr == target)
                    return ans;
                int x = 0; int y = 0;
                searchZero(cur, x, y);
                for (int j = 0; j < 4; ++j)
                {
                    int newX = x + dirs[j][0];
                    int newY = y + dirs[j][1];
                    vector<vector<int>> newBoard;
                    string newStr;
                    if (newX >= 0 && newX < lenM && newY >= 0 && newY < lenN)
                    {
                        buildNewBoard(newBoard, cur, x, y, newX, newY, newStr);
                        if(visited.find(newStr) == visited.end())
                        {
                            boardStates.push(newBoard);
                            visited.insert(newStr);
                        }
                    }
                        
                }
            }
            ans++;
        }
        return -1;
    }
};

/* 
 * Notes: This is the generalized version of m * n puzzle. 
 * We use BFS to search the possible moves. Any stage can be represented by a 2D 
 * vector or a string that stores all the numbers seperated by spaces. We can use 
 * string version to compare two stages. We store any visited conditions in an unordered
 * set to prevent going back to the same stage. Each time we get all the stages from the queue, 
 * we search through the possible moves and see if they have be visited, if not, that move
 * is added to the queue. This is one level (move) in the game. Then we count until
 * we meet the desired stage.  
 */ 