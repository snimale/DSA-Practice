package hardQ;

class Suduko {
	int[][] board;
	
	public void createBoard() {
		board = new int[9][9];
	}
	
	public void set(int a, int b, int n) {
		board[a][b] = n;
	}

	@Override
	public String toString() {
		String str="";
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				str+=board[i][j];
				if(j==2 || j==5) {
					str+=" ";
				}
			}
			if(i<8) {
				str+="\n";
			}
			if(i==2 || i==5) {
				str+="\n";
			}
		}
		return str;
	}
	
	
}
public class SudukoSolver {
	// TIME COMPLEXITY -> N^M WHERE N=POSSIBLE SOLUYIONS FROM 1 TO 9, M=NUMBER OF BLANK SPACES IN BOARD
	public static void main(String args[]) {
		Suduko s = new Suduko();
		s.createBoard();
		s.set(0, 0, 3);
		s.set(0, 2, 6);
		s.set(0, 3, 5);
		s.set(0, 5, 8);
		s.set(0, 6, 4);
		s.set(1, 0, 5);
		s.set(1, 1, 2);
		s.set(2, 1, 8);
		s.set(2, 2, 7);
		s.set(2, 7, 3);
		s.set(2, 8, 1);
		s.set(3, 2, 3);
		s.set(3, 4, 1);
		s.set(3, 7, 8);
		s.set(4, 0, 9);
		s.set(4, 3, 8);
		s.set(4, 4, 6);
		s.set(4, 5, 3);
		s.set(4, 8, 5);
		s.set(5, 1, 5);
		s.set(5, 4, 9);
		s.set(5, 6, 6);
		s.set(6, 0, 1);
		s.set(6, 1, 3);
		s.set(6, 6, 2);
		s.set(6, 7, 5);
		s.set(7, 7, 7);
		s.set(7, 8, 4);
		s.set(8, 2, 5);
		s.set(8, 3, 2);
		s.set(8, 5, 6);
		s.set(8, 6, 3);
		solution(s, 0, 0);
		System.out.print(s);
	}
	public static boolean isSafe(Suduko s, int num, int row, int col) {
		for(int i=0; i<9; i++) {
			if(s.board[row][i]==num) {
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(s.board[i][col]==num) {
				return false;
			}
		}
		row=(row/3)*3;
		col=(col/3)*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(s.board[row+i][col+j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean solution(Suduko s, int row, int col) {
		if(col>=9) {
			row++;
			col=0;
		}
		if(row>=9) {
			return true;
		}
		
		if(s.board[row][col]!=0) {
			return solution(s, row, col+1);
		} else {
			for(int i=1; i<10; i++) {
				if(isSafe(s, i, row, col)) {
					s.board[row][col]=i;
					if(solution(s, row, col+1)) {
						return true;
					}
					s.board[row][col]=0;
					
				}
			}
		}
		return false;
		
		
	}
}
