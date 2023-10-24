package dsa;
import java.util.*;

/*
	Matrix form of graph : Adjacency Matrix
	List form of graph : Adjacency List
*/


class UnweightedUndirectedGraphMatrix {
	int matrix[][];
	int vertexCount;
	int edgeCount;
	
	public void getGraphFromUser() {
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
				this.matrix[v2][v1]=1;
			}
		}
	}
	
	// overrides
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Matrix :\n");
		for(int i=0; i<this.vertexCount; i++) {
			output.append("V"+i+": ");
			for(int j=0; j<this.vertexCount; j++) {
				output.append(this.matrix[i][j]+" ");
			} output.append('\n');
		}
		return output.toString();
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

class WeightedUndirectedGraphMatrix {
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
			System.out.print("Enter Edge "+(i+1)+" with weight: ");
			int v1=sc.nextInt(), v2=sc.nextInt(), w=sc.nextInt();
			System.out.println();
			if(v1<0 || v2<0 || v1>=this.vertexCount || v2>=this.vertexCount || w<0) {
				System.out.println("Invalid Edge, Please Enter Again");
				i--;
			} else {
				this.matrix[v1][v2]=w;
				this.matrix[v2][v1]=w;
			}
		}
	}
	
	
	// constructors
	WeightedUndirectedGraphMatrix(int vertexCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=-1;
	}
	WeightedUndirectedGraphMatrix(int vertexCount, int edgeCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=edgeCount;
	}
}

class UnweightedDirectedGraphMatrix {
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
			}
		}
	}
	
	
	// constructors
	UnweightedDirectedGraphMatrix(int vertexCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=-1;
	}
	UnweightedDirectedGraphMatrix(int vertexCount, int edgeCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=edgeCount;
	}
}

class WeightedDirectedGraphMatrix {
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
			System.out.print("Enter Edge "+(i+1)+" with weight: ");
			int v1=sc.nextInt(), v2=sc.nextInt(), w=sc.nextInt();
			System.out.println();
			if(v1<0 || v2<0 || v1>=this.vertexCount || v2>=this.vertexCount) {
				System.out.println("Invalid Edge, Please Enter Again");
				i--;
			} else {
				this.matrix[v1][v2]=w;
			}
		}
	}
	
	
	// constructors
	WeightedDirectedGraphMatrix(int vertexCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=-1;
	}
	WeightedDirectedGraphMatrix(int vertexCount, int edgeCount) {
		this.matrix=new int[vertexCount][vertexCount];
		this.vertexCount=vertexCount;
		this.edgeCount=edgeCount;
	}
}

public class GraphDSA {
	public static void main(String args[]) {
		/*
		 * Input UW_UD_M:
		 * 5 0 2 0 4 2 3 2 4 1 4
		 */
		UnweightedUndirectedGraphMatrix UW_UD_M = new UnweightedUndirectedGraphMatrix(5);
		UW_UD_M.getGraphFromUser();
		System.out.println(UW_UD_M);
	}
}
