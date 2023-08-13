package dsa;
import java.util.*;

class UnweightedUndirectedGraphMatrix {
	int matrix[][];
	int vertexCount;
	int edgeCount;
	
	private void getGraphFromUser() {
		Scanner sc = new Scanner(System.in);
		if(this.edgeCount==-1) {
			System.out.print("Enter the Number of Edges");
			this.edgeCount=sc.nextInt();
			System.out.println();
		}
		for(int i=0; i<this.edgeCount; i++) {
			System.out.print("Enter Edge "+(i+1)+": ");
			int v1=sc.nextInt(), v2=sc.nextInt();
			System.out.println();
			if(v1<0 || v2<0 || v1>=this.vertexCount || v2>=this.vertexCount) {
				System.out.println("Invalid Edge, Please Enter Again");
				i--;
			} else {
				this.matrix[v1][v2]=1;
				this.matrix[v1][v2]=1;
			}
		}
	}
	
	
	// constructors
	UnweightedUndirectedGraphMatrix(int vertexCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=-1;
	}
	UnweightedUndirectedGraphMatrix(int vertexCount, int edgeCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=edgeCount;
	}
}

class Graph_List {
	
}

public class GraphDSA {
	public static void main(String args[]) {
		
	}
}
