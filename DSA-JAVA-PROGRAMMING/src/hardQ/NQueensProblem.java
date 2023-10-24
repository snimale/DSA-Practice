package hardQ;


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
	//TIME COMPLEXITY -> N!
	public static void main(String args[]) {
		Board b1 = new Board();
		b1.createBoard(10);
		solution(b1, 0);
	}
	
	public static boolean isSafe(boolean[][] board, int iq, int jq) {
        for(int i=0; i<board.length; i++) {
            if(board[i][jq]==true) return false;
        }

        for(int i=0; i<board.length; i++) {
            int ic=iq-i, jc=jq-i;
            if(!(ic>=board.length || jc>=board.length || ic<0 || jc<0)) {
            	if(board[ic][jc]==true) return false;
            }

            ic=iq-i; jc=jq+i;
            if(!(ic>=board.length || jc>=board.length || ic<0 || jc<0)) {
                if(board[ic][jc]==true) return false;
            }
            
            ic=iq+i; jc=jq-i;
            if(!(ic>=board.length || jc>=board.length || ic<0 || jc<0)) {
            	if(board[ic][jc]==true) return false;
            }
            
            ic=iq+i; jc=jq+i;
            if(!(ic>=board.length || jc>=board.length || ic<0 || jc<0)) {
            	if(board[ic][jc]==true) return false;
            }
        } return true;
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
