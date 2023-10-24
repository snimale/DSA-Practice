package easyQ;

public class StockBuyAndSell2 {
	public static void main(String args[]) {
		int[] stockprices1 = {2,5,3,7,1,4,5,3,8};
		int ans[] = maxProfit(stockprices1);
		System.out.println("Maximum Profit -> "+ans[0]+"\nNumber Of Stocks Bought and Sold -> "+ans[1]);
	}
	
	public static int[] maxProfit(int[] prices) {
		int[] ans = new int[2];
		int maxProfit=0;
		int noOfStocksBought=0;
		for(int i=0; i<prices.length-1; i++) {
			int today = prices[i];
			int tomorrow = prices[i+1];
			if(today<tomorrow) {
				maxProfit+=tomorrow-today;
				noOfStocksBought++;
			}
		}
		ans[0]=maxProfit;
		ans[1]=noOfStocksBought;
		return ans;
	}
}
