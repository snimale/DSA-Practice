package easyQ;


public class StockBuyAndSell1 {
	public static void main(String args[]) {
		int[] stockprices1 = {2,5,3,7,1,4,5,3,8};
		int[] ans = maxProfit(stockprices1);
		System.out.println("Buy on day -> "+ans[0]+"\nSell on day -> "+ans[1]+"\nMaximum Profit -> "+ans[2]);
		
	}
	
	public static int[] maxProfit(int[] prices) {
		int buy =1;
		int sell = 1;
		int profit = 0;
		int currMin=0;
		
		for (int i=0; i<prices.length; i++) {
			if (prices[currMin]>prices[i]) {
				currMin=i;
			}
			int currProfit = prices[i]-prices[currMin];
			if(profit < currProfit ) {
				profit = currProfit;
				sell=i+1;
				buy=currMin+1;
			}
			
		}
		
		int[] answer = {buy, sell, profit};
		return answer;
	}
}
