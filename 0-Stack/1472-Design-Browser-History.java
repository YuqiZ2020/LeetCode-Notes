/**
 * Problem 1472: Design Browser History
 * Prompt: You have a browser of one tab where you start 
 * on the homepage and you can visit another url, get back 
 * in the history number of steps or move forward in the 
 * history number of steps.
 * Implement the BrowserHistory class:
 * BrowserHistory(string homepage) Initializes the object 
 * with the homepage of the browser.
 * void visit(string url) visits url from the current page. 
 * It clears up all the forward history. 
 * string back(int steps) Move steps back in history. 
 * If you can only return x steps in the history and 
 * steps > x, you will return only x steps. Return the 
 * current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. 
 * If you can only forward x steps in the history and 
 * steps > x, you will forward only x steps. Return the 
 * current url after forwarding in history at most steps.
 * Date: 06/06/2020
 */
class BrowserHistory {
    private Stack<String> back = new Stack<String>();
    private Stack<String> forward = new Stack<String>();
    private String curPage;
    
    public BrowserHistory(String homepage) {
        curPage = homepage;
    }
    
    public void visit(String url) {
        forward.clear();
        back.push(curPage);
        curPage = url;
    }
    
    public String back(int steps) {
        int counter = steps;
        forward.push(curPage);
        while (!back.isEmpty() && counter != 0)
        {
            forward.push(back.pop());
            counter--;
        }
        curPage = forward.pop();
        return curPage;
    }
    
    public String forward(int steps) {
        int counter = steps;
        back.push(curPage);
        while (!forward.isEmpty() && counter != 0)
        {
            back.push(forward.pop());
            counter--;
        }
        curPage = back.pop();
        return curPage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

 /**
  * Notes: Use two stacks to store webpages. Need another string
  * to store the current webpage. When forwarding, push the webpages
  * to back stack and when going back, push the webpages to forward
  * stack. Push 1 more so we retrieve 1 from the stack. 
  */