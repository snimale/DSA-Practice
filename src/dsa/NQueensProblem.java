package dsa;


class Board {
	boolean[][] board;
	int size;
	
	public void createBoard(int n) {
		board = new boolean[n][n];
		size=n;
	}
	

	@Override
	public String toString() {
		String str = "";
	
		for (int j=0; j<size; j++) {
			for(int k=0; k<size; k++) {
				if (board[j][k]) {
					str+=" Q ";
				} else {
					str+=" . ";
				}
			}
			str+="\n";
		}

		return str;
	}
	
}

public class NQueensProblem {
	public static void main(String args[]) {
		Board b1 = new Board();
		b1.createBoard(10);
		solution(b1, 0);
	}
	
	public static boolean isSafe(boolean[][] board, int r, int c) {
		int size = board.length;
		int col = c;
		int row = r;
		
		//row check
		for(int i=0; i<size; i++) {
			if(board[r][i]) {
				return false;
			}
		}
		
		//column check
		for(int i=0; i<size; i++) {
			if(board[i][c]) {
				return false;
			}
		}
		
		//lower-right check
		while(row<size && col<size) {
			if(board[row++][col++]) {
				return false;
			}
		}
		col=c;
		row=r;
		
		//lower-left check
		while(col>0 && row<size) {
			if(board[row++][col--]) {
				return false;
			}
		}
		col=c;
		row=r;
		
		//upper-right check
		while(row>0 && col<size) {
			if(board[row--][col++]) {
				return false;
			}
		}
		col=c;
		row=r;
		
		//upper-left check
		while(row>0 && col>0) {
			if(board[row--][col--]) {
				return false;
			}
		}
		col=c;
		row=r;
		
		return true;
	}
	
	public static boolean solution(Board b, int r) {
		if (r>=b.size) {
			System.out.println(b);
			return true;
		}
		for (int c=0; c<b.size; c++) {
			if(isSafe(b.board, r, c)) {
				b.board[r][c]=true;
				if(solution(b, r+1)) {
					return true;
				}
				b.board[r][c]=false;
			}
		}
		return false;
	}
}
