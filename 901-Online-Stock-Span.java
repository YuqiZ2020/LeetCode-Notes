/**
 * Problem 901: Online Stock Span
 * Prompt: Write a class StockSpanner which collects 
 * daily price quotes for some stock, and returns the 
 * span of that stock's price for the current day.
 * The span of the stock's price today is defined as 
 * the maximum number of consecutive days (starting 
 * from today and going backwards) for which the price
 * of the stock was less than or equal to today's price.
 * For example, if the price of a stock over the next 
 * 7 days were [100, 80, 60, 70, 60, 75, 85], then 
 * the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * Date: 0519
 */
class StockSpanner {

    public StockSpanner() {
        stk = new Stack<Integer> ();
        weights = new Stack<Integer> ();
    }
    Stack<Integer> stk;
    Stack<Integer> weights;
    
    public int next(int price) {
        int w = 1;
        while (!stk.isEmpty() && stk.peek() <= price)
        {
            w += weights.pop();
            stk.pop();
        }
        stk.push(price);
        weights.push(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Notes: Each time we only want to store those prices-weights values 
 * that contain prices in descending orders, because for each element
 * the weights that it contian will already contain those other previous
 * oneces that have value less than its own.
 * Once we get a price, we pop out those pairs that have prices
 * less than the current price and add up the weights to be the new weights. 
 */