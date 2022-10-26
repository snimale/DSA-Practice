package mediumQ;


// find the rain water blocks trapped between buildings of height buildings[i] blocks
public class PreProcessingArrayQ {
	public static void main(String args[]) {
		int[] buildings = {3,2,1,2,3};
		System.out.println(rainWater(buildings));
	}
	
	public static int rainWater(int[] buildings) {
		int size = buildings.length;
		int[] left = new int[size];
		int[] right = new int[size];
		int[] rainWater = new int[size];
		int leftMax =0;
		int rightMax=0;
		
		for(int i=0; i<size; i++) {
			if(leftMax<buildings[i]) {
				leftMax=buildings[i];
			}
			left[i]=leftMax;
		}
		
		for(int i=size-1; i>=0; i--) {
			if(rightMax<buildings[i]) {
				rightMax=buildings[i];
			}
			right[i]=rightMax;
		}
		
		for(int i=0; i<size; i++) {
			int currWithWaterHeight = Math.min(right[i], left[i]);
			rainWater[i]+=currWithWaterHeight-buildings[i];
		}
		
		int rainWaterBlocks = 0;
		for(int e: rainWater) {
			rainWaterBlocks+=e;
		}
		return rainWaterBlocks;
	}
}
